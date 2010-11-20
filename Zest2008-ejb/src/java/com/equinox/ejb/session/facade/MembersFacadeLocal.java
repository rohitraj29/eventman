/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Members;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface MembersFacadeLocal {

    public Members findByRegNo(String regno);

    void create(Members members);

    void edit(Members members);

    void remove(Members members);

    Members find(Object id);

    List<Members> findAll();

}
