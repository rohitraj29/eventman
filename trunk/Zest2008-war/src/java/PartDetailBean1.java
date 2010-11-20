
import com.equinox.ejb.entity.Participantdetails;
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

public class PartDetailBean1 {

    private String partname;
    private String regno;
    private String collegename;
    private Long partid;

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
    public PartDetailBean1() {
        
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
            url1.setPageid("participantdetails.jsp");
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
