/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Members;
import com.equinox.ejb.session.facade.MembersFacadeLocal;
import com.equinox.ejb.session.facade.MembersFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class CommitteeTaskBean implements CommitteeTaskRemote, CommitteeTaskLocal {
    @EJB
    private MembersFacadeRemote membersFacade;
    
   
    
    
    @PersistenceContext
    private EntityManager em;

    public List<com.equinox.ejb.entity.Members> getCommitteeDetails(Committee com) {
      try{
      Query q1= em.createQuery("SELECT Object(o) FROM Membercomm o WHERE o.commid=:commid");
      q1.setParameter("commid",com);
      List l1=q1.getResultList();
      Iterator itr=l1.iterator();
      ArrayList l2= new ArrayList();
      while(itr.hasNext())
      {
          Members mem=(Members)itr.next();
       l2.add(em.find(Members.class,mem.getMemberid()));   
      }
      
      return l2;
      }catch(Exception e){return null;}
    }   

    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
