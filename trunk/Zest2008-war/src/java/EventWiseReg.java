
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Eventpart;
import com.equinox.ejb.entity.Participantdetails;

import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.EventpartFacadeRemote;
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

public class EventWiseReg {
    @EJB(name = "EventdetailsFacade8")
    private EventdetailsFacadeRemote eventdetailsFacade8;
    @EJB
    private EventpartFacadeRemote eventpartFacade;
private List<Participantdetails> partlist;
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

    public List<Participantdetails> getPartlist() {
        try {
            this.event = this.eventdetailsFacade8.findByName(this.eventname);
            List<Eventpart> list = this.eventpartFacade.findAll();
            Iterator itr = list.iterator();
            ArrayList<Participantdetails> partl = new ArrayList<Participantdetails>();

            while (itr.hasNext()) {
                Eventpart partevent = (Eventpart) itr.next();
                if (partevent.getEventid().equals(this.event)) {
                    partl.add(partevent.getPartid());
                }
            }
            this.partlist = partl;
            return partlist;

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

    }

    public void setPartlist(List<Participantdetails> partlist) {
        this.partlist = partlist;
    }
    /** Creates a new instance of EventWiseReg */
    public EventWiseReg() {
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        String str=(String)cmb1.getValue();
        this.eventname=str;
        FacesContext fc=FacesContext.getCurrentInstance();
      url url1=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}",url.class).getValue(fc.getELContext());
        url1.setPageid("eventwisereg.jsp");
        
    }
    public String Trigger()
    {
        FacesContext fc=FacesContext.getCurrentInstance();
        url url1=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}",url.class).getValue(fc.getELContext());
        url1.setPageid("eventwisereg.jsp");
        return null;
    }
    

}
