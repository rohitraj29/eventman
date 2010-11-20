
import com.equinox.ejb.entity.College;
import com.equinox.ejb.entity.Groups;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.equinox.ejb.session.facade.CollegeFacadeRemote;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;


/**
 *
 * @author root
 */

public class AddGroupBean {
    @EJB
    private CollegeFacadeRemote collegeFacade;
    @EJB
    private GroupsFacadeRemote groupsFacade;
private String groupname;
private Groups group;
private College college;
private String collegename;

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    /** Creates a new instance of AddGroupBean */
    public AddGroupBean() {
       
    }
    public String register()
    {
        try {
            Groups temp = new Groups();
            temp.setGroupname(this.groupname);
            this.college=this.collegeFacade.findByName(collegename);
            temp.setCollege(this.college);
            this.groupsFacade.create(temp);
            this.group = this.groupsFacade.findByName(this.groupname);
            FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("groupconf.jsp");
            return null;

        } catch (Exception exception) {return null;
        }

    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }
    
    public void CollegeChanged(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.collegename=(String) cmb1.getValue();
    }

}
