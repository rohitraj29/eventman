/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Participantdetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface EventGroupTaskLocal {

    List<Participantdetails> getParticipants(Long groupid);
    
}
