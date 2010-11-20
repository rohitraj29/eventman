
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class EventBean {
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
private List<SelectItem> eventlist;
private List<SelectItem> eventgrouplist;
private List<SelectItem> alleventlist;

    public List<SelectItem> getAlleventlist() {
         try {
            List<Eventdetails> list = this.eventdetailsFacade.findAll();
            Iterator itr = list.iterator();
            ArrayList<SelectItem> temp = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Eventdetails event = (Eventdetails) itr.next();
                
                SelectItem sel = new SelectItem();
                sel.setValue(event.getEventname());
                sel.setLabel(event.getEventname());
                temp.add(sel);
                
            }
            this.eventgrouplist=temp;
        return eventgrouplist;
        }catch(Exception ex){ex.printStackTrace(); return null;}
      
    }

    public void setAlleventlist(List<SelectItem> alleventlist) {
        this.alleventlist = alleventlist;
    }

    public List<SelectItem> getEventgrouplist() {
        try {
            List<Eventdetails> list = this.eventdetailsFacade.findAll();
            Iterator itr = list.iterator();
            ArrayList<SelectItem> temp = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Eventdetails event = (Eventdetails) itr.next();
                if(event.getEventtype().equals(new Integer(2)))
                {
                SelectItem sel = new SelectItem();
                sel.setValue(event.getEventname());
                sel.setLabel(event.getEventname());
                temp.add(sel);
                }
            }
            this.eventgrouplist=temp;
        return eventgrouplist;
        }catch(Exception ex){ex.printStackTrace(); return null;}
    }

    public void setEventgrouplist(List<SelectItem> eventgrouplist) {
        this.eventgrouplist = eventgrouplist;
    }

    /** Creates a new instance of EventBean */
    public EventBean() {
    }

    public List<SelectItem> getEventlist() {
        try {
            List<Eventdetails> list = this.eventdetailsFacade.findAll();
            Iterator itr = list.iterator();
            ArrayList<SelectItem> temp = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Eventdetails event = (Eventdetails) itr.next();
                if(event.getEventtype().equals(new Integer(1)))
                {
                SelectItem sel = new SelectItem();
                sel.setValue(event.getEventname());
                sel.setLabel(event.getEventname());
                temp.add(sel);
                }
            }
            this.eventlist = temp;
            return eventlist;

        } catch (Exception exception) {return null;
        }

    }

    public void setEventlist(List<SelectItem> eventlist) {
        this.eventlist = eventlist;
    }
    public Eventdetails findByName(String str)
    {
        return this.eventdetailsFacade.findByName(str);
    }

}
