/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */


import com.equinox.ejb.entity.Eventdetails;

import com.equinox.ejb.entity.Eventgroup;
import com.equinox.ejb.entity.Groups;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.EventgroupFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class EvenWiseRegGroup {
    @EJB
    private EventgroupFacadeRemote eventgroupFacade;
    @EJB(name = "EventdetailsFacade8")
    private EventdetailsFacadeRemote eventdetailsFacade8;
    private List<Groups> grouplist;

    public List<Groups> getGrouplist() {
        this.event=this.eventdetailsFacade8.findByName(this.eventname);
        List<Eventgroup> list=this.eventgroupFacade.findAll();
        Iterator itr=list.iterator();
        ArrayList<Groups> temp=new ArrayList<Groups>();
        while(itr.hasNext())
        {
            Eventgroup eventgrp=(Eventgroup)itr.next();
            if(eventgrp.getEventid().equals(this.event))
                temp.add(eventgrp.getGroupid());
        }
        this.grouplist=temp;
        return grouplist;
    }

    public void setGrouplist(List<Groups> grouplist) {
        this.grouplist = grouplist;
    }
    

private String eventname;
private Eventdetails event;

    public Eventdetails getEvent() {
        return event;
    }

    public void setEvent(Eventdetails event) {
        this.event = event;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

   

   
    /** Creates a new instance of EventWiseReg */
    public EvenWiseRegGroup() {
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        String str=(String)cmb1.getValue();
        this.eventname=str;
        FacesContext fc=FacesContext.getCurrentInstance();
        url url=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}",url.class).getValue(fc.getELContext());
        url.setPageid("eventwisereg.jsp");
        
    }
    public String Trigger()
    {
        FacesContext fc=FacesContext.getCurrentInstance();
        url url=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}",url.class).getValue(fc.getELContext());
        url.setPageid("eventwisereg.jsp");
        return null;
    }
    

}
