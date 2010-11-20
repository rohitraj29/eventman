
import com.equinox.ejb.entity.Committee;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class AddComBean {
    @EJB(name = "CommitteeFacade1")
    private CommitteeFacadeRemote committeeFacade1;
    

    private String comname;
    private Committee comm;

    public Committee getComm() {
        return comm;
    }

    public void setComm(Committee comm) {
        this.comm = comm;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }
    
    /** Creates a new instance of AddComBean */
    public AddComBean() {
    }

    public String register()
    {
        try {
            Committee temp = new Committee();
            temp.setCommname(comname);
            this.committeeFacade1.create(temp);
            this.comm = this.committeeFacade1.findByCommName(comname);
            FacesContext fc = FacesContext.getCurrentInstance();
            url url1 = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            if(comm!=null)
            url1.setPageid("confcom.jsp");
            return null;

        } catch (Exception exception) {exception.printStackTrace(); return null;
        }

    }
}
