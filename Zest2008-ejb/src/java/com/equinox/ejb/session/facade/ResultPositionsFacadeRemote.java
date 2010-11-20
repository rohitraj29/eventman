/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.ResultPositions;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface ResultPositionsFacadeRemote {

    void create(ResultPositions resultPositions);

    void edit(ResultPositions resultPositions);

    void remove(ResultPositions resultPositions);

    ResultPositions find(Object id);

    List<ResultPositions> findAll();

}
