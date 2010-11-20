
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

public class ModPartBean implements java.io.Serializable{
private Long serialid;
private String regno;
private Long collegeid;
private String name;
private Participantdetails participant;

    public Participantdetails getParticipant() {
        return participant;
    }

    public void setParticipant(Participantdetails participant) {
        this.participant = participant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Long collegeid) {
        this.collegeid = collegeid;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public Long getSerialid() {
        return serialid;
    }

    public void setSerialid(Long serialid) {
        this.serialid = serialid;
    }

    /** Creates a new instance of ModPartBean */
    public ModPartBean() {
    }
    
    public String populate()
    {
        try {
            EJBAdapter adapter = new EJBAdapter();
            Participantdetails part = adapter.getParticipantdetailsFacade().find(this.serialid);
            if (part == null) {
                this.participant = new Participantdetails();
                return null;
            }
            this.setParticipant(part);
            this.setCollegeid(part.getCollegeid().getCollegeid());
            this.setName(part.getPartname());
            this.setRegno(part.getPartregno());
            FacesContext fc = FacesContext.getCurrentInstance();
            url url1 = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url1.setPageid("modpart.jsp");
            adapter = null;
            return null;

        } catch (Exception exception) {return null;
        }

    }
    public void changeFired(ValueChangeEvent e)
    {try{
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.setSerialid((Long)cmb1.getValue());
        
     }catch(Exception ex) 
     {ex.printStackTrace();}
    }
    
    public String persistChanges()
    {
        try {
            EJBAdapter adapter = new EJBAdapter();
            Participantdetails temppart = adapter.getParticipantdetailsFacade().find(this.serialid);
            temppart.setPartname(name);
            temppart.setPartregno(regno);
            adapter.getParticipantdetailsFacade().edit(temppart);
            this.participant = temppart;
            FacesContext fc = FacesContext.getCurrentInstance();
            url url1 = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url1.setPageid("confmod.jsp");
            return null;

        } catch (Exception exception) {return null;
        }

    }

}
