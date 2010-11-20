/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.ResultGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ResultGroupFacadeLocal {

    void create(ResultGroup resultGroup);

    void edit(ResultGroup resultGroup);

    void remove(ResultGroup resultGroup);

    ResultGroup find(Object id);

    List<ResultGroup> findAll();

}
