
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.entity.ParticipationMaster;
import com.equinox.ejb.session.facade.CollegeFacadeRemote;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ParticipationMasterFacadeRemote;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class ViewColRegBean {
    @EJB
    private ParticipantdetailsFacadeRemote participantdetailsFacade;
    @EJB
    private ParticipationMasterFacadeRemote participationMasterFacade;
    @EJB
    private CollegeFacadeRemote collegeFacade;
private String colname;
private List<Participantdetails> partlist;


    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    public List<Participantdetails> getPartlist() {
        return partlist;
    }

    public void setPartlist(List<Participantdetails> partlist) {
        this.partlist = partlist;
    }
    /** Creates a new instance of ViewColRegBean */
    public ViewColRegBean() {
    }
public void ChangeFired(ValueChangeEvent e)
{
    HtmlComboBox cmb1=(HtmlComboBox) e.getComponent();
    this.colname=(String) cmb1.getValue();
}

public String RetrieveData()
{
    List<ParticipationMaster> list=this.participationMasterFacade.findAll();
    ArrayList<Participantdetails> temp=new ArrayList<Participantdetails>();
    Iterator itr=list.iterator();
    while(itr.hasNext())
    {
        Participantdetails part=((ParticipationMaster)itr.next()).getPartid();
        if(!temp.contains(part)&&(part.getCollegeid().getCollegename().equals(this.colname)))
        {
            temp.add(part);
            
        }
    } 
    this.partlist=temp;
    FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("collegewisereg.jsp");
    return null;
}
private List<ParticipationMaster> eventlist;

    public List<ParticipationMaster> getEventlist() {
        
        return eventlist;
    }

    public void setEventlist(List<ParticipationMaster> eventlist) {
        this.eventlist = eventlist;
    }

public void RetrieveEvents(ActionEvent e)
{
    
    this.eventlist=new ArrayList<ParticipationMaster>();
    HtmlAjaxCommandButton cmd1=(HtmlAjaxCommandButton) e.getComponent();
    Long partid1=(Long)cmd1.getData();
    Participantdetails partdet=this.participantdetailsFacade.find(partid1);
    List<ParticipationMaster> partmaslist=this.participationMasterFacade.findAll();
    Iterator itr=partmaslist.iterator();
    while(itr.hasNext())
    {
        ParticipationMaster partmas=(ParticipationMaster) itr.next();
        if(partmas.getPartid().equals(partdet))
        {
            this.eventlist.add(partmas);
        }
    }
    FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("vieweventpart.jsp");
    
}
}
