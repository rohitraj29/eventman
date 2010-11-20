/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventpart;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface EventpartFacadeRemote {

    void create(Eventpart eventpart);

    void edit(Eventpart eventpart);

    void remove(Eventpart eventpart);

    Eventpart find(Object id);

    List<Eventpart> findAll();

}
