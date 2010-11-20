
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Eventgroup;
import com.equinox.ejb.entity.Groups;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.EventgroupFacadeRemote;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class EventpartGroupBean {
    @EJB(name = "EventdetailsFacade9")
    private EventdetailsFacadeRemote eventdetailsFacade9;
    @EJB
    private EventgroupFacadeRemote eventgroupFacade;
    @EJB
    private GroupsFacadeRemote groupsFacade;

    private Groups group;
    private Long groupid;
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

    public void setEventname(String evntname) {
        this.eventname = evntname;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }
    private String eventname;
    /** Creates a new instance of EventpartGorupBean */
    public EventpartGroupBean() {
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
    public String participate()
    {
        try {
            this.event = this.eventdetailsFacade9.findByName(eventname);
            this.group = this.groupsFacade.find(groupid);
            Eventgroup eventgroup = new Eventgroup();
            eventgroup.setEventid(event);
            eventgroup.setGroupid(group);
            this.eventgroupFacade.create(eventgroup);
            
            return null;

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

    }
            
}
