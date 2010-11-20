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
public interface MemberTaskLocal {
public void removeMember(java.lang.String regno);
    void createCommittee(String comname);

    void addMember(String name, String des, String regno);

    public void associateMember(java.lang.String regno, com.equinox.ejb.entity.Committee com);
    
}
