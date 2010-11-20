/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ParticipateLocal {

    void participate(String eventname, Long partid);
    
}
