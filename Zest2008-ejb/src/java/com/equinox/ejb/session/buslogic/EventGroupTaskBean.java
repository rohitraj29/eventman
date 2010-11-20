/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Grouppart;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.facade.GrouppartFacadeLocal;
import com.equinox.ejb.session.facade.GrouppartFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class EventGroupTaskBean implements EventGroupTaskRemote, EventGroupTaskLocal {
    @EJB
    private GrouppartFacadeRemote grouppartFacade;
    
   
    

    public List<Participantdetails> getParticipants(Long groupid) {
        try {
            List<Grouppart> list = this.grouppartFacade.findAll();
            Iterator itr = list.iterator();
            ArrayList<Participantdetails> temp = new ArrayList<Participantdetails>();
            while (itr.hasNext()) {
                Grouppart tempgrp = (Grouppart) itr.next();
                if (tempgrp.getGroupid().getGroupid().equals(groupid)) {
                    temp.add(tempgrp.getPartid());
                }
            }
            return temp;


        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }
        
        

    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
