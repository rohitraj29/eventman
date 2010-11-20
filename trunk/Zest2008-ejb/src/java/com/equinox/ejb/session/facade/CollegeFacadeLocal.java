/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.College;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface CollegeFacadeLocal {

    void create(College college);

    void edit(College college);

    void remove(College college);

    College find(Object id);

    List<College> findAll();

   

    public com.equinox.ejb.entity.College findByName(java.lang.String str);

}
