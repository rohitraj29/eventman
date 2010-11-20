/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Grouppart;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class GrouppartFacade implements GrouppartFacadeLocal, GrouppartFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Grouppart grouppart) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM Grouppart o WHERE o.groupid=:groupid AND o.partid=:partid");
            q1.setParameter("groupid", grouppart.getGroupid());
            q1.setParameter("partid", grouppart.getPartid());
            Grouppart part = (Grouppart) q1.getSingleResult();
            if (part == null) {
                em.persist(grouppart);
            }

        } catch (Exception exception) {
            em.persist(grouppart);
            exception.printStackTrace();
        }

    }

    public void edit(Grouppart grouppart) {
        em.merge(grouppart);
    }

    public void remove(Grouppart grouppart) {
        em.remove(em.merge(grouppart));
    }

    public Grouppart find(Object id) {
        return em.find(com.equinox.ejb.entity.Grouppart.class, id);
    }

    public List<Grouppart> findAll() {
        return em.createQuery("select object(o) from Grouppart as o").getResultList();
    }

}
