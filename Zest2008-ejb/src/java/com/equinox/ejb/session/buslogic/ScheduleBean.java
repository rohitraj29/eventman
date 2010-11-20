/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Eventdetails;
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
public class ScheduleBean implements ScheduleRemote, ScheduleLocal {
    @PersistenceContext
    private EntityManager em;

    public List<Eventdetails> getSchedule() {
   Query q1=em.createQuery("SELECT Object(o) FROM Eventdetails o ORDER BY o.eventtime");
   return q1.getResultList();
    }

   
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
