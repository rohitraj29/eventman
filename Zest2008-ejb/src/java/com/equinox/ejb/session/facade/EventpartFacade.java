/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventpart;
import com.equinox.ejb.entity.ParticipationMaster;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EventpartFacade implements EventpartFacadeLocal, EventpartFacadeRemote {
    @EJB
    private ParticipantdetailsFacadeRemote participantdetailsFacade;
    @PersistenceContext
    private EntityManager em;

    public void create(Eventpart eventpart) {
        ParticipationMaster partmaster=new ParticipationMaster();
        partmaster.setPartid(eventpart.getPartid());
        partmaster.setEventid(eventpart.getEventid());
        partmaster.setEventtype(eventpart.getEventid().getEventtype());
        partmaster.setCollegeid(eventpart.getPartid().getCollegeid());
        if(this.participantdetailsFacade.validateParticipation(eventpart.getPartid()))
        {
        em.persist(partmaster);
        em.persist(eventpart);
        }
    }

    public void edit(Eventpart eventpart) {
        em.merge(eventpart);
    }

    public void remove(Eventpart eventpart) {
        em.remove(em.merge(eventpart));
    }

    public Eventpart find(Object id) {
        return em.find(com.equinox.ejb.entity.Eventpart.class, id);
    }

    public List<Eventpart> findAll() {
        return em.createQuery("select object(o) from Eventpart as o").getResultList();
    }

}
