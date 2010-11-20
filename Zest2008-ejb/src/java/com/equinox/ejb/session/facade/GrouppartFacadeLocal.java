/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Grouppart;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface GrouppartFacadeLocal {

    void create(Grouppart grouppart);

    void edit(Grouppart grouppart);

    void remove(Grouppart grouppart);

    Grouppart find(Object id);

    List<Grouppart> findAll();

}
