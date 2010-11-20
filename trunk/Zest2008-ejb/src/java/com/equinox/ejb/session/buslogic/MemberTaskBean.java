/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Membercomm;
import com.equinox.ejb.entity.Members;
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import com.equinox.ejb.session.facade.MembercommFacadeRemote;
import com.equinox.ejb.session.facade.MembersFacadeRemote;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author root
 */
@Stateless
public class MemberTaskBean implements MemberTaskRemote, MemberTaskLocal {
    @EJB
    private CommitteeFacadeRemote committeeFacade;
    @EJB
    private MembersFacadeRemote membersFacade;
    @EJB
    private MembercommFacadeRemote membercommFacade;
    
    
   


    public void createCommittee(String comname) {
        Committee com=new Committee();
        com.setCommname(comname);
        this.committeeFacade.create(com);
        
    }

    public void addMember(String name, String des, String regno) {
        Members mem=new Members();
        mem.setMembername(name);
        mem.setMemberregno(regno);
        mem.setMemberdes(des);
        this.membersFacade.create(mem);
    }
    
    public void associateMember(String regno, Committee com)
    {
        Members temp=this.membersFacade.findByRegNo(regno);
        Membercomm ass=new Membercomm();
        ass.setMemberid(temp);
        
        ass.setCommid(com);
        ass.setCommid(com);
        this.membercommFacade.create(ass);
        
        
    }
    
    public void removeMember(String regno)
    {
        Members temp=this.membersFacade.findByRegNo(regno);
        this.membersFacade.remove(temp);
    }
    
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
