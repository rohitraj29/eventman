
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.buslogic.EventTaskRemote;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class EventDetailsBean2 {

    /** Creates a new instance of EventDetailsBean2 */
    public EventDetailsBean2() {
    }
    @EJB
    private EventTaskRemote eventTaskBean;
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
private String eventname;
private String commname;
private Date eventdate;
private Date eventtime;
private Eventdetails event;
private Long eventid;
private List<Participantdetails> partlist;

    public List<Participantdetails> getPartlist() {
        this.partlist=this.eventTaskBean.viewParticipants(eventid);
        return partlist;
    }

    public void setPartlist(List<Participantdetails> partlist) {
        this.partlist = partlist;
    }

    public Eventdetails getEvent() {
        return event;
    }

    public void setEvent(Eventdetails event) {
        this.event = event;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getEventtime() {
        return eventtime;
    }

    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
    }
    /** Creates a new instance of EventDetailsBean */
   
    public String Details()
    {
        try {
            this.event = (Eventdetails) this.eventdetailsFacade.findByName(this.eventname);
            this.eventid = event.getEventid();
            this.commname = this.event.getCommitteeid().getCommname();
            this.eventdate = this.event.getEventdate();
            this.eventtime = this.event.getEventtime();
            FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("eventdetails.jsp");
            return null;

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        
    }
    public void changefired(ValueChangeEvent e)
    {
        try {
            HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
            this.eventname = (String) cmb1.getValue();

        } catch (Exception exception) {
        }

    }


}
