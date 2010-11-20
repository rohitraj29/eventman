
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

/**
 *
 * @author root
 */

public class ComDelBean {
    @EJB
    private CommitteeFacadeRemote committeeFacade;

    /** Creates a new instance of ComDelBean */
    public ComDelBean() {
    }
    
    public void delcom(ActionEvent e)
    {
        try {
            HtmlAjaxCommandButton cmd1 = (HtmlAjaxCommandButton) e.getComponent();
            this.committeeFacade.remove(this.committeeFacade.findByCommName((String) cmd1.getData()));
             FacesContext fc=FacesContext.getCurrentInstance();
        tyrourl url=(tyrourl)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{tyrourl}", tyrourl.class).getValue(fc.getELContext());
        url.setPageid("comdel.jsp");

        } catch (Exception exception) {exception.printStackTrace();
        }

        
    }

}
