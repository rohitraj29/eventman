/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Eventgroup;
import java.util.List;
import javax.ejb.Remote;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
@Remote
public interface EventgroupFacadeRemote {

    void create(Eventgroup eventgroup) throws Exception;

    void edit(Eventgroup eventgroup);

    void remove(Eventgroup eventgroup);

    Eventgroup find(Object id);

    List<Eventgroup> findAll();

    List<SelectItem> findGroups(Eventdetails event);

}
