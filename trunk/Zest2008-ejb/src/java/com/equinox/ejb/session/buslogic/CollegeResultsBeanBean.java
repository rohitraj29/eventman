/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.session.facade.ResultPositionsFacadeLocal;
import com.equinox.ejb.session.facade.ResultPositionsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class CollegeResultsBeanBean implements CollegeResultsBeanRemote, CollegeResultsBeanLocal {
    @EJB
    private ResultPositionsFacadeRemote resultPositionsFacade;
    
    


    public List<ResultPositions> getIndResults(String collegename) {
        List<ResultPositions> temp=this.resultPositionsFacade.findAll();
        ArrayList<ResultPositions> list=new ArrayList<ResultPositions>();
        Iterator itr=temp.iterator();
        while(itr.hasNext())
        {
            ResultPositions res=(ResultPositions)itr.next();
            if(res.getParticipant().getCollegeid().getCollegename().equals(collegename))
            {
                list.add(res);
            }
        }
        return list;
    }
    
    public List<ResultPositions> getGroupResults(String collegename)
    {
        
        return null;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
