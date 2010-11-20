/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventdetails;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface EventdetailsFacadeRemote {

    void create(Eventdetails eventdetails);

    void edit(Eventdetails eventdetails);

    void remove(Eventdetails eventdetails);

    Eventdetails find(Object id);

    List<Eventdetails> findAll();

    public com.equinox.ejb.entity.Eventdetails findByName(java.lang.String str);

}
