/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.facade.EventdetailsFacadeLocal;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class EventTaskBean implements EventTaskRemote, EventTaskLocal {
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    

    @PersistenceContext
    private EntityManager em;
    

    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    public void addEvent(String evname, Integer evtype, Date date, Date date1, Committee com) {
        Eventdetails event = new Eventdetails();
        event.setCommitteeid(com);

        event.setEventdate(date);
        event.setEventtime(date1);
        event.setEventname(evname);
        event.setEventtype(evtype);
        this.eventdetailsFacade.create(event);

    }

    public void modifyEvent(Long evid, String evname, Integer evtype, Date date, Date date1, Committee com) {
        Eventdetails event = em.find(Eventdetails.class, evid);
        event.setCommitteeid(com);
     
        event.setEventdate(date);
        event.setEventtime(date1);
        event.setEventname(evname);
        event.setEventtype(evtype);
        em.merge(event);
    }

    public void deleteEvents(Long eventid) {
        em.remove(em.find(Eventdetails.class, eventid));

    }

    public List<Participantdetails> viewParticipants(Long eventid) {
        try {
            Query q1 = em.createQuery("SELECT o.partid FROM Eventpart o WHERE o.eventid=:eventid");
            q1.setParameter("eventid", em.find(Eventdetails.class,eventid));
            List temp = q1.getResultList();
            if(temp==null)
            {return null;}
            else
                return temp;

        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList();
        }

        
    }
    
}
