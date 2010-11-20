/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Participantdetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ParticipantdetailsFacadeLocal {

    void create(Participantdetails participantdetails);

    void edit(Participantdetails participantdetails);

    void remove(Participantdetails participantdetails);

    Participantdetails find(Object id);

    List<Participantdetails> findAll();

    boolean validateParticipation(Participantdetails partid);

}
