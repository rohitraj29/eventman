
import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ResultPositionsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class IndEventResBean {
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    @EJB
    private ResultPositionsFacadeRemote resultPositionsFacade;
private List<ResultPositions> reslist;
private String eventname;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public List<ResultPositions> getReslist() {
        return reslist;
    }

    public void setReslist(List<ResultPositions> reslist) {
        this.reslist = reslist;
    }

    /** Creates a new instance of IndEventResBean */
    public IndEventResBean() {
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.eventname=(String) cmb1.getValue();
    }
    
    public String RetrieveData()
    {
        try {
            List<ResultPositions> list = this.resultPositionsFacade.findAll();
            ArrayList<ResultPositions> temp = new ArrayList<ResultPositions>();
            Iterator itr = list.iterator();
            while (itr.hasNext()) {
                ResultPositions tempres = (ResultPositions) itr.next();
                if (tempres.getEventdetails().equals(this.eventdetailsFacade.findByName(eventname))) {
                    temp.add(tempres);
                }
            }
            this.reslist = temp;
            return null;

        } catch (Exception exception) {exception.printStackTrace(); return null;
        }

    }

}
