/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.ResultPositions;
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
public class ResultPositionsFacade implements ResultPositionsFacadeLocal, ResultPositionsFacadeRemote {
    @PersistenceContext
    private EntityManager em;
    

    public void create(ResultPositions resultPositions) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM ResultPositions o WHERE o.eventdetails=:eventdetails AND o.participant=:participant");
            q1.setParameter("eventdetails", resultPositions.getEventdetails());
            q1.setParameter("participant", resultPositions.getParticipant());
            ResultPositions pos = (ResultPositions) q1.getSingleResult();
            
            if (pos == null) {
                em.persist(resultPositions);
            } else {
                pos.setPosition(resultPositions.getPosition());
                em.merge(pos);
            }

        } catch (NoResultException exception) {
            exception.printStackTrace();
           em.persist(resultPositions);
        }
        

    }

    public void edit(ResultPositions resultPositions) {
        em.merge(resultPositions);
    }

    public void remove(ResultPositions resultPositions) {
        em.remove(em.merge(resultPositions));
    }

    public ResultPositions find(Object id) {
        return em.find(com.equinox.ejb.entity.ResultPositions.class, id);
    }

    public List<ResultPositions> findAll() {
        return em.createQuery("select object(o) from ResultPositions as o").getResultList();
    }

}
