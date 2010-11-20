/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CommitteeTaskLocal {

    List<com.equinox.ejb.entity.Members> getCommitteeDetails(Committee com);
    
}
