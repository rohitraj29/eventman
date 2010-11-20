
import com.equinox.ejb.entity.ResultGroup;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.EventgroupFacadeRemote;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import com.equinox.ejb.session.facade.ResultGroupFacadeRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class GrpResAddBean {
    @EJB
    private ResultGroupFacadeRemote resultGroupFacade1;
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    @EJB
    private ResultGroupFacadeRemote resultGroupFacade;
    @EJB
    private GroupsFacadeRemote groupsFacade;
    @EJB
    private EventgroupFacadeRemote eventgroupFacade;
private String eventname;
private Long groupid;
private int position;
private List<SelectItem> grouplist;

    public List<SelectItem> getGrouplist() {
        if(grouplist!=null)
        return grouplist;
        else return new ArrayList<SelectItem>();
    }

    public void setGrouplist(List<SelectItem> grouplist) {
        this.grouplist = grouplist;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    /** Creates a new instance of GrpResAddBean */
    public GrpResAddBean() {
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.eventname=(String)cmb1.getValue();
    }

    public void GroupChanged(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.groupid=(Long)cmb1.getValue();
    }
    public void PosChanged(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.position=((Integer)cmb1.getValue()).intValue();
                
    }
    public String GetGroup()
    {
        this.grouplist=this.eventgroupFacade.findGroups(this.eventdetailsFacade.findByName(eventname));
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(),"#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("addgroupresult.jsp");
        return null;
    }
    public String register()
    {
        ResultGroup resgrp=new ResultGroup();
        resgrp.setEventid(this.eventdetailsFacade.findByName(eventname));
        resgrp.setGroupid(this.groupsFacade.find(groupid));
        resgrp.setPosition(position);
        this.resultGroupFacade.create(resgrp);
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(),"#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("conf.jsp");
        
        
        return null;
    }
}
