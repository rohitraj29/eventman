
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.session.buslogic.ScheduleRemote;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;

/**
 *
 * @author root
 */

public class ScheduleBean {
    @EJB
    private ScheduleRemote scheduleBean;
private List<Eventdetails> eventlist;

    public List<Eventdetails> getEventlist() {
        this.eventlist=this.scheduleBean.getSchedule();
               
        return eventlist;
    }

    public void setEventlist(List<Eventdetails> eventlist) {
        this.eventlist = eventlist;
    }
        
    /** Creates a new instance of ScheduleBean */
    public ScheduleBean() {
    }

}
