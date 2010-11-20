
import com.equinox.ejb.entity.Committee;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */
public class EventModBean {

    @EJB(name = "EventdetailsFacade5")
    private EventdetailsFacadeRemote eventdetailsFacade5;
    private String comname;
    private Committee committee;
    private int hour;
    private int minute;
    private Date eventdate;
    private Eventdetails event;
    private String eventname;
    private String eventvenue;

    public String getEventvenue() {
        return eventvenue;
    }

    public void setEventvenue(String eventvenue) {
        this.eventvenue = eventvenue;
    }
    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Eventdetails getEvent() {
        return event;
    }

    public void setEvent(Eventdetails event) {
        this.event = event;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
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

    /** Creates a new instance of EventModBean */
    public EventModBean() 
    {
    }

    public void ChangeFired(ValueChangeEvent e) 
    {
        try
        {
            HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
            String str = (String) cmb1.getValue();
            this.eventname = str;
           
        } 
        catch (Exception exception) 
        {
               exception.printStackTrace();
        }

    }

    public String register() {
        try 
        {
            this.event = this.eventdetailsFacade5.findByName(this.eventname);
            event.setEventdate(eventdate);
            Date datetemp = new Date();
            datetemp = (Date) eventdate.clone();
            datetemp.setHours(hour);
            datetemp.setMinutes(minute);
            event.setEventtime(datetemp);
            event.setEventname(this.eventname);
            event.setEventvenue(eventvenue);
            this.eventdetailsFacade5.edit(event);
                        FacesContext fc = FacesContext.getCurrentInstance();
            url url1 = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url1.setPageid("conf.jsp");
            return null;

        }
        catch (Exception exception)
        {
            exception.printStackTrace(); return null;
        }

    }
    
    public String TriggerDetails()
    {
        this.event=this.eventdetailsFacade5.findByName(eventname);
        this.eventname=event.getEventname();
        this.hour=event.getEventtime().getHours();
        this.minute=event.getEventtime().getMinutes();
        this.eventdate=event.getEventdate();
        this.eventvenue=event.getEventvenue();
        
        FacesContext fc=FacesContext.getCurrentInstance();
        tyrourl url=(tyrourl)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{tyrourl}", tyrourl.class).getValue(fc.getELContext());
        url.setPageid("modifyevent.jsp");
        return null;
    }
}
