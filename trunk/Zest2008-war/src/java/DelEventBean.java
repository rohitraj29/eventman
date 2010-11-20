
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
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

public class DelEventBean {
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
    private String comname;
    private List<Eventdetails> eventlist;
   
    
    /** Creates a new instance of DelEventBean */
    public DelEventBean() {
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public List<Eventdetails> getEventlist() {
        return eventlist;
    }

    public void setEventlist(List<Eventdetails> eventlist) {
        this.eventlist = eventlist;
    }
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox) e.getComponent();
        this.comname=(String) cmb1.getValue();
    }
    
    private void updateList()
    {
      List<Eventdetails> list=this.eventdetailsFacade.findAll();  
      ArrayList<Eventdetails> temp=new ArrayList<Eventdetails>();
      Iterator itr=list.iterator();
      while(itr.hasNext())
      {
          Eventdetails ev=(Eventdetails) itr.next();
          if(ev.getCommitteeid().getCommname().equals(this.comname))
          {
              temp.add(ev);
          }
      }
      this.eventlist=temp;
    }
    public String RetrieveDetails()
    {
        this.updateList();
        FacesContext fc=FacesContext.getCurrentInstance();
        url ur=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        ur.setPageid("deleteevents.jsp");
        return null;
    }
    public void delete(ActionEvent e)
    {
        HtmlAjaxCommandButton cmd=(HtmlAjaxCommandButton) e.getComponent();
        Long evid=(Long) cmd.getData();
        
        this.eventdetailsFacade.remove(this.eventdetailsFacade.find(evid));
        String dummy=this.RetrieveDetails();
    }

}
