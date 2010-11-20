/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Participantdetails;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface ParticipantdetailsFacadeRemote {

    void create(Participantdetails participantdetails);

    void edit(Participantdetails participantdetails);

    void remove(Participantdetails participantdetails);

    Participantdetails find(Object id);

    List<Participantdetails> findAll();

    public com.equinox.ejb.entity.Participantdetails findByRegNo(java.lang.String regno);

    boolean validateParticipation(Participantdetails partid);

}
