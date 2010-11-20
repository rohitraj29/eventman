/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.entity.ParticipationMaster;
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
public class ParticipationMasterFacade implements ParticipationMasterFacadeLocal, ParticipationMasterFacadeRemote {

    @PersistenceContext
    private EntityManager em;

    public void create(ParticipationMaster participationMaster) {
        em.persist(participationMaster);
    }

    public void edit(ParticipationMaster participationMaster) {
        em.merge(participationMaster);
    }

    public void remove(ParticipationMaster participationMaster) {
        em.remove(em.merge(participationMaster));
    }

    public ParticipationMaster find(Object id) {
        return em.find(com.equinox.ejb.entity.ParticipationMaster.class, id);
    }

    public List<ParticipationMaster> findAll() {
        return em.createQuery("select object(o) from ParticipationMaster as o").getResultList();
    }

    public List<ParticipationMaster> findByPart(Participantdetails part) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM ParticipationMaster o WHERE o.partid=:partid");
            q1.setParameter("partid", part);
            return q1.getResultList();


        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
