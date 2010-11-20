/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.entity.ParticipationMaster;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface ParticipationMasterFacadeRemote {

    void create(ParticipationMaster participationMaster);

    void edit(ParticipationMaster participationMaster);

    void remove(ParticipationMaster participationMaster);

    ParticipationMaster find(Object id);

    List<ParticipationMaster> findAll();

   

    List<ParticipationMaster> findByPart(Participantdetails part);

}
