/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.ResultGroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ResultGroupFacade implements ResultGroupFacadeLocal, ResultGroupFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(ResultGroup resultGroup) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM ResultGroup o WHERE o.eventid=:eventid AND o.groupid=:groupid");
            q1.setParameter("eventid", resultGroup.getEventid());
            q1.setParameter("groupid", resultGroup.getGroupid());
            ResultGroup res = (ResultGroup) q1.getSingleResult();
            if (res == null) {
                em.persist(resultGroup);
            } else {
                res.setPosition(resultGroup.getPosition());
                em.merge(res);
            }

        } catch (NoResultException noResultException) {em.persist(resultGroup);
        noResultException.printStackTrace();
        }

        
    }

    public void edit(ResultGroup resultGroup) {
        em.merge(resultGroup);
    }

    public void remove(ResultGroup resultGroup) {
        em.remove(em.merge(resultGroup));
    }

    public ResultGroup find(Object id) {
        return em.find(com.equinox.ejb.entity.ResultGroup.class, id);
    }

    public List<ResultGroup> findAll() {
        return em.createQuery("select object(o) from ResultGroup as o").getResultList();
    }

}
