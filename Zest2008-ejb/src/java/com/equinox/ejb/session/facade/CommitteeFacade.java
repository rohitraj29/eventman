/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Committee;
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
public class CommitteeFacade implements CommitteeFacadeLocal, CommitteeFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Committee committee) {
        Committee com=this.findByCommName(committee.getCommname());
        if(com==null)
        em.persist(committee);
        
            
    }

    public void edit(Committee committee) {
        em.merge(committee);
    }

    public void remove(Committee committee) {
        em.remove(em.merge(committee));
    }

    public Committee find(Object id) {
        return em.find(com.equinox.ejb.entity.Committee.class, id);
    }

    public List<Committee> findAll() {
        return em.createQuery("select object(o) from Committee as o").getResultList();
    }
    
    public Committee findByCommName(String str)
    {
        try {
            Query q1 = em.createNamedQuery("Committee.findByCommname");
            q1.setParameter("commname", str);
            return (Committee) q1.getSingleResult();

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

        
    }

}
