/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */


import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Eventdetails;
import com.equinox.ejb.entity.Membercomm;
import com.equinox.ejb.entity.Members;
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.MembercommFacadeRemote;
import com.equinox.ejb.session.facade.MembersFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

public class ComDetailsBean1 {
    @EJB
    private MembersFacadeRemote membersFacade;
    @EJB(name = "EventdetailsFacade7")
    private EventdetailsFacadeRemote eventdetailsFacade7;
    @EJB(name = "MembercommFacade1")
    private MembercommFacadeRemote membercommFacade1;
    @EJB(name = "CommitteeFacade2")
    private CommitteeFacadeRemote committeeFacade2;
    
private String comname;
    private List<Eventdetails> eventlist;

    public List<Eventdetails> getEventlist() {
        return eventlist;
    }

    public void setEventlist(List<Eventdetails> eventlist) {
        this.eventlist = eventlist;
    }
    public List<Members> getCol() {
        return col;
    }

    public void setCol(List<Members> col) {
        this.col = col;
    }

    public Committee getCom() {
        return com;
    }

    public void setCom(Committee com) {
        this.com = com;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }
private Committee com;
private List<Members> col;
    /** Creates a new instance of ComDetailsBean */
    public ComDetailsBean1() {
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1= (HtmlComboBox)e.getComponent();
        this.comname=(String)cmb1.getValue();
        
    }
    public String details()
    {
        try {
            this.com=this.committeeFacade2.findByCommName(comname);
            ArrayList<Members> listtemp = new ArrayList<Members>();
            List<Membercomm> listtemp1=this.membercommFacade1.findAll();
            Iterator itr=listtemp1.iterator();
            
            while (itr.hasNext()) {
                Membercomm temporary=(Membercomm)itr.next();
                if(temporary.getCommid().equals(this.com))
                listtemp.add(temporary.getMemberid());
            }
            this.col = listtemp;
            FacesContext fc = FacesContext.getCurrentInstance();
            url url = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url.setPageid("deletemembers.jsp");
            return null;

        } catch (Exception exception) {exception.printStackTrace(); return null;
        }
        
      

    }
    public String renderevents()
    {
        List<Eventdetails> temp=this.eventdetailsFacade7.findAll();
        ArrayList<Eventdetails> listevents=new ArrayList<Eventdetails>();
        Iterator itr= temp.iterator();
        
        while(itr.hasNext())
        {
            Eventdetails ev=(Eventdetails)itr.next();
            if(ev.getCommitteeid().getCommname().equals(this.comname))
            {
                listevents.add(ev);
            }
            
        }
        this.eventlist=listevents;
        FacesContext fc = FacesContext.getCurrentInstance();
            url url = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            url.setPageid("deletemembers.jsp");
        return null;
    }
    
    public void delete(ActionEvent e)
    {
        HtmlAjaxCommandButton cmd1=(HtmlAjaxCommandButton) e.getComponent();
        String regno=(String)cmd1.getData();
        Members mem=this.membersFacade.findByRegNo(regno);
        Membercomm memcom=this.membercommFacade1.findByMemberComm(com, mem);
        this.membercommFacade1.remove(memcom);
        this.membersFacade.remove(mem);
        String dummy=this.details();
    }

}
