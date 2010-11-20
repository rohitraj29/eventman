
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class EventWrapper {
    private String eventname;
    private Date eventdate;
    private Time time;
    private String venue;

    public EventWrapper(String eventname, Date eventdate, Time time, String venue) {
        this.eventname = eventname;
        this.eventdate = eventdate;
        this.time = time;
        this.venue = venue;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

}
