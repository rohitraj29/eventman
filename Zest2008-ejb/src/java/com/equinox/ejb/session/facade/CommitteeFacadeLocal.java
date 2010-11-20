/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Committee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CommitteeFacadeLocal {

    void create(Committee committee);

    void edit(Committee committee);

    void remove(Committee committee);

    Committee find(Object id);

    List<Committee> findAll();
    public Committee findByCommName(String str);

}
