
import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.buslogic.ParticipateRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class EventPartBean {
    @EJB
    private ParticipateRemote participateBean;

    private Committee committee;
    private Participantdetails part;
    private Eventdetails details;
    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

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
private String commname;
private Long partid;
private String eventname;

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public Participantdetails getPart() {
        return part;
    }

    public void setPart(Participantdetails part) {
        this.part = part;
    }
    /** Creates a new instance of EventPartBean */
    public EventPartBean() {
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        try {
            HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
            this.eventname = (String) cmb1.getValue();
            getcommittee();


        } catch (Exception exception) {exception.printStackTrace();
        }

                
    }

    private void getcommittee() 
    {
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            EventBean eventbean = (EventBean) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{EventBean}", EventBean.class).getValue(fc.getELContext());
            Eventdetails event = eventbean.findByName(eventname);
            this.committee = event.getCommitteeid();
            this.commname = event.getCommitteeid().getCommname();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("participate.jsp");

        } catch (Exception exception) {exception.printStackTrace();
        }

        
        
        
    }
    
    public void PartChanged(ValueChangeEvent e)
    {
        try {
            HtmlComboBox cmb1 = (HtmlComboBox) e.getComponent();
            this.partid = (Long) cmb1.getValue();
            getParticipant();

        } catch (Exception exception) {exception.printStackTrace();
        }

    }
    
    private void getParticipant()
    {
        try {
            EJBAdapter adapter = new EJBAdapter();
            this.part = adapter.getParticipantdetailsFacade().find(partid);
           

        } catch (Exception exception) {exception.printStackTrace();
        
        }

    }  
    public String participate()
    {
        try {
            
                this.participateBean.participate(this.eventname, this.partid);
            FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("confeventpart.jsp");
            return null;

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

    }

}
