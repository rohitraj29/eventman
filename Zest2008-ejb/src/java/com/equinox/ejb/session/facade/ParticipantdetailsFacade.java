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
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ParticipantdetailsFacade implements ParticipantdetailsFacadeLocal, ParticipantdetailsFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Participantdetails participantdetails) {
        em.persist(participantdetails);
    }

    public void edit(Participantdetails participantdetails) {
        em.merge(participantdetails);
    }

    public void remove(Participantdetails participantdetails) {
        em.remove(em.merge(participantdetails));
    }

    public Participantdetails find(Object id) {
        return em.find(com.equinox.ejb.entity.Participantdetails.class, id);
    }

    public List<Participantdetails> findAll() {
        return em.createQuery("select object(o) from Participantdetails as o").getResultList();
    }
    public Participantdetails findByRegNo(String regno)
    {
        Query q1=em.createNamedQuery("Participantdetails.findByPartregno");
        q1.setParameter("partregno", regno);
        return (Participantdetails)q1.getSingleResult();
    }

    public boolean validateParticipation(Participantdetails partid) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM ParticipationMaster o WHERE o.partid=:partid ");
            q1.setParameter("partid", partid);
            List<ParticipationMaster> partlist = q1.getResultList();
            int num = partlist.size();
            if (num <= 5) {
                return true;
            } else {
                return false;
            }

        } catch (NoResultException exception) {exception.printStackTrace();
        return true;
        }
        

    }

}
