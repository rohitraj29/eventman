/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Eventgroup;
import com.equinox.ejb.entity.Grouppart;
import com.equinox.ejb.entity.Groups;
import com.equinox.ejb.entity.ParticipationMaster;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EventgroupFacade implements EventgroupFacadeLocal, EventgroupFacadeRemote {
    @EJB
    private GrouppartFacadeRemote grouppartFacade;
    @EJB
    private ParticipationMasterFacadeRemote participationMasterFacade;
    
    
    @PersistenceContext
    
    private EntityManager em;

    public void create(Eventgroup eventgroup) throws Exception {
        Eventdetails event=eventgroup.getEventid();
        Groups groups=eventgroup.getGroupid();
        List<Grouppart> list=this.grouppartFacade.findAll();
        Iterator itr=list.iterator();
        while(itr.hasNext())
        {   
            Grouppart grppart=(Grouppart)itr.next();
            if(grppart.getGroupid().equals(groups)){
            ParticipationMaster partmaster=new ParticipationMaster();
            partmaster.setEventid(event);
            partmaster.setPartid(grppart.getPartid());
            partmaster.setGroupid(grppart.getGroupid());
            partmaster.setCollegeid(grppart.getPartid().getCollegeid());
            partmaster.setEventtype(event.getEventtype());
            em.persist(partmaster);
            }
        }
        
        em.persist(eventgroup);
    }

    public void edit(Eventgroup eventgroup) {
        em.merge(eventgroup);
    }

    public void remove(Eventgroup eventgroup) {
        em.remove(em.merge(eventgroup));
    }

    public Eventgroup find(Object id) {
        return em.find(com.equinox.ejb.entity.Eventgroup.class, id);
    }

    public List<Eventgroup> findAll() {
        return em.createQuery("select object(o) from Eventgroup as o").getResultList();
    }

    public List<SelectItem> findGroups(Eventdetails event) {
        List<Eventgroup> list=this.findAll();
        ArrayList<SelectItem> templist=new ArrayList<SelectItem>();
        Iterator itr=list.iterator();
        while(itr.hasNext())
        {Eventgroup comp=(Eventgroup)itr.next();
            if(comp.getEventid().equals(event))
            {
                SelectItem sel=new SelectItem();
                sel.setValue(comp.getGroupid().getGroupid());
                sel.setValue(comp.getGroupid().getGroupid().toString());
                templist.add(sel);
            }
        }
        
        
        return templist;
    }

}
