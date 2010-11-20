/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.ResultPositions;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface CollegeResultsBeanRemote {

    List<ResultPositions> getIndResults(String collegename);

    public java.util.List<com.equinox.ejb.entity.ResultPositions> getGroupResults(java.lang.String collegename);
    
}
