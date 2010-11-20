
import com.equinox.ejb.entity.Grouppart;
import com.equinox.ejb.session.facade.GrouppartFacadeRemote;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.richfaces.component.html.HtmlComboBox;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class AddToGrpBean {
private Long groupid;
private Long partid;
    /** Creates a new instance of AddToGrpBean */
    public AddToGrpBean() {
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.groupid=(Long) cmb1.getValue();
    }

    public void PartFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.partid=(Long) cmb1.getValue();
    }
    public String register()
    {
        Grouppart part=new Grouppart();
        part.setGroupid(this.lookupGroupsFacade().find(groupid));
        part.setPartid(this.lookupParticipantdetailsFacade().find(partid));
        this.lookupGrouppartFacade().create(part);
        this.groupid=null;
        this.partid=null;
         FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("conf.jsp");
        
        return null;
    }

    private GroupsFacadeRemote lookupGroupsFacade() {
        try {
            Context c = new InitialContext();
            return (GroupsFacadeRemote) c.lookup("java:comp/env/GroupsFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ParticipantdetailsFacadeRemote lookupParticipantdetailsFacade() {
        try {
            Context c = new InitialContext();
            return (ParticipantdetailsFacadeRemote) c.lookup("java:comp/env/ParticipantdetailsFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GrouppartFacadeRemote lookupGrouppartFacade() {
        try {
            Context c = new InitialContext();
            return (GrouppartFacadeRemote) c.lookup("java:comp/env/GrouppartFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getPartid() {
        return partid;
    }

    public void setPartid(Long partid) {
        this.partid = partid;
    }
}
