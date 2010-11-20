
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.session.buslogic.EventTaskRemote;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ResultPositionsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */
public class IndResAddBean {

    @EJB
    private ResultPositionsFacadeRemote resultPositionsFacade;
    @EJB
    private ParticipantdetailsFacadeRemote participantdetailsFacade;
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    @EJB
    private EventTaskRemote eventTaskBean;
    private String eventname;

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Long getPartid() {
        return partid;
    }

    public void setPartid(Long partid) {
        this.partid = partid;
    }

    public List<SelectItem> getPartlist() {

        if (partlist != null) {
            return partlist;
        } else {
            return new ArrayList<SelectItem>();
        }
    }

    public void setPartlist(List<SelectItem> partlist) {
        this.partlist = partlist;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    private Long partid;
    private int position;
    private List<SelectItem> partlist;

    /** Creates a new instance of IndResAddBean */
    public IndResAddBean() {
    }

    public void ChangeFired(ValueChangeEvent e) {
        HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
        this.eventname = (String) cmb1.getValue();
    }

    public void PartChanged(ValueChangeEvent e) {
        HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
        this.partid = (Long) cmb1.getValue();
    }

    public void PosChanged(ValueChangeEvent e) {
        HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
        this.position = ((Integer) cmb1.getValue()).intValue();
    }

    public String GetPart() {
        try {
            List<Participantdetails> temp = this.eventTaskBean.viewParticipants(this.eventdetailsFacade.findByName(eventname).getEventid());
            Iterator itr = temp.iterator();
            ArrayList<SelectItem> templist = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Participantdetails temppart = (Participantdetails) itr.next();
                SelectItem sel = new SelectItem();
                sel.setLabel(temppart.getPartid().toString());
                sel.setValue(temppart.getPartid());
                templist.add(sel);
            }
            this.partlist = templist;

            FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("addindividualresult.jsp");

            return null;

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

    }

    public String register() {
        ResultPositions pos = new ResultPositions();
        pos.setParticipant(this.participantdetailsFacade.find(this.partid));
        pos.setEventdetails(this.eventdetailsFacade.findByName(eventname));
        pos.setPosition(this.position);
        this.resultPositionsFacade.create(pos);
        this.partid = null;
        this.eventname = null;
        this.position = 0;
        FacesContext fc = FacesContext.getCurrentInstance();
        url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("conf.jsp");
        return null;
    }
}
