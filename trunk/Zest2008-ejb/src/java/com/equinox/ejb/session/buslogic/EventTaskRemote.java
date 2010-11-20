/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Participantdetails;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface EventTaskRemote {
    public void addEvent(String evname,Integer evtype,Date date,Date date1,Committee com);

public void modifyEvent(Long evid,String evname,Integer evtype,Date date,Date date1,Committee com);
public void deleteEvents(java.lang.Long eventid);

    List<Participantdetails> viewParticipants(Long eventid);
} 
