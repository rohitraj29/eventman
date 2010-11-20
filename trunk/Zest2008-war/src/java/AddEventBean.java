
import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import java.util.Date;

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

public class AddEventBean 
{
@EJB
private EventdetailsFacadeRemote eventdetailsFacade;
@EJB(name = "CommitteeFacade4")
private CommitteeFacadeRemote committeeFacade4;
private String eventname;
private Date eventdate;
private int hour;
private int minute;
private Date eventtime;
private String eventcom;
private Committee com;
private int evnttype;
private String eventvenue;

    public String getEventvenue() {
        return eventvenue;
    }

    public void setEventvenue(String eventvenue) {
        this.eventvenue = eventvenue;
    }

    public Committee getCom() {
        return com;
    }

    public void setCom(Committee com) {
        this.com = com;
    }

    public String getEventcom() {
        return eventcom;
    }

    public void setEventcom(String eventcom) {
        this.eventcom = eventcom;
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

    public int getEvnttype() {
        return evnttype;
    }

    public void setEvnttype(int evnttype) {
        this.evnttype = evnttype;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    /** Creates a new instance of AddEventBean */
    public AddEventBean() {
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.eventcom=(String) cmb1.getValue();
        
    }
    public void TypeChanged(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.evnttype=(Integer)cmb1.getValue();
    }
    public String register()
    {
        try {
           this.com= this.committeeFacade4.findByCommName(this.eventcom);
            Eventdetails eventdet = new Eventdetails();
            this.eventtime = this.eventdate;
            this.eventtime.setHours(hour);
            this.eventtime.setMinutes(minute);
            eventdet.setCommitteeid(com);
            eventdet.setEventdate(eventdate);
            eventdet.setEventname(eventname);
            eventdet.setEventtime(eventtime);
            eventdet.setEventtype(evnttype);
            eventdet.setEventvenue(this.eventvenue);
            this.eventdetailsFacade.create(eventdet);
            Eventdetails test=this.eventdetailsFacade.findByName(eventname);
            if(test!=null)
            {
            FacesContext fc=FacesContext.getCurrentInstance();
            url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("conf.jsp");
            }
            return null;

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

    }
    
    

}
