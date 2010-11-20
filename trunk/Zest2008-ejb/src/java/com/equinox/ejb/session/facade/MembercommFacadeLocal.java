/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Membercomm;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MembercommFacadeLocal {

    void create(Membercomm membercomm);

    void edit(Membercomm membercomm);

    void remove(Membercomm membercomm);

    Membercomm find(Object id);

    List<Membercomm> findAll();

}
