/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Participantdetails;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface EventGroupTaskRemote {
     List<Participantdetails> getParticipants(Long groupid);
}
