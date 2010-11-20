/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Membercomm;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface MembercommFacadeRemote {

    void create(Membercomm membercomm);

    void edit(Membercomm membercomm);

    void remove(Membercomm membercomm);

    Membercomm find(Object id);

    List<Membercomm> findAll();

    public com.equinox.ejb.entity.Membercomm findByMemberComm(com.equinox.ejb.entity.Committee com, com.equinox.ejb.entity.Members mem);

}
