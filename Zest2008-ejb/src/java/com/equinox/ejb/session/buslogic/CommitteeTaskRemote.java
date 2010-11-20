/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface CommitteeTaskRemote {

    List<com.equinox.ejb.entity.Members> getCommitteeDetails(Committee com);
    
}
