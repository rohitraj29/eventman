
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.entity.ParticipationMaster;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ParticipationMasterFacadeRemote;
import java.util.List;
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

public class PartDetailBean {
    @EJB(name = "ParticipantdetailsFacade2")
    private ParticipantdetailsFacadeRemote participantdetailsFacade2;
    @EJB
    private ParticipationMasterFacadeRemote participationMasterFacade;

    private String partname;
    private String regno;
    private String collegename;
    private Long partid;
    private List<ParticipationMaster> particlist;

    public List getParticlist() {
        try {
            this.particlist = this.participationMasterFacade.findByPart(this.participantdetailsFacade2.findByRegNo(regno));
            return particlist;

        } catch (Exception exception) {exception.printStackTrace(); return null;
        }

    }

    public void setParticlist(List particlist) {
        this.particlist = particlist;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public Long getPartid() {
        return partid;
    }

    public void setPartid(Long partid) {
        this.partid = partid;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
    
            
    /** Creates a new instance of PartDetailBean */
    public PartDetailBean() {
        
    }
    public String updateDetails()
    {         try {
            EJBAdapter adapter = new EJBAdapter();
            Participantdetails part = adapter.getParticipantdetailsFacade().find(this.partid);
            this.partname = part.getPartname();
            this.regno = part.getPartregno();
            this.collegename = part.getCollegeid().getCollegename();
            FacesContext fc = FacesContext.getCurrentInstance();
            url url1 = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url1.setPageid("partdetail.jsp");
            return null;

        } catch (Exception exception) {return null;
        }

    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.partid=(Long)cmb1.getValue();
        
        
    }

}
