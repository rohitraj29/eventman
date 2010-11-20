/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Eventpart;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.EventpartFacadeRemote;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
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
public class ParticipateBean implements ParticipateRemote, ParticipateLocal {
    @EJB
    private EventpartFacadeRemote eventpartFacade;
    @EJB
    private ParticipantdetailsFacadeRemote participantdetailsFacade;
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    
   
    
    
    
  
    
    @PersistenceContext
    private EntityManager em;
    

    public void participate(String eventname, Long partid) {
        Eventdetails event=this.eventdetailsFacade.findByName(eventname);
        Participantdetails part=this.participantdetailsFacade.find(partid);
        if(validateConcurrency(event,part))
        {
        Eventpart eventpart=new Eventpart();
        eventpart.setEventid(event);
        eventpart.setPartid(part);
        this.eventpartFacade.create(eventpart);
        }
        
    }

    private boolean validateConcurrency(Eventdetails event, Participantdetails part) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM Eventpart o WHERE o.eventid=:eventid AND o.partid=:partid");
            q1.setParameter("eventid", event);
            q1.setParameter("partid", part);
            Eventpart participation = (Eventpart) q1.getSingleResult();
            if (participation == null) {
                return true;
            } else {
                return false;
            }

        } 
        catch (Exception exception) 
        {
        exception.printStackTrace();
        return true;
        }

        
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
