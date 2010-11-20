
import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Membercomm;
import com.equinox.ejb.entity.Members;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import com.equinox.ejb.session.facade.MembercommFacadeRemote;
import com.equinox.ejb.session.facade.MembersFacadeRemote;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class AddMemBean {
    @EJB
    private MembercommFacadeRemote membercommFacade;
    @EJB
    private MembersFacadeRemote membersFacade;
    @EJB(name = "CommitteeFacade3")
    private CommitteeFacadeRemote committeeFacade3;
private String commname;
private String memname;
private String memdes;
private String memregno;
private Committee committee;
private Members members;
private Membercomm memcom;

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public String getMemdes() {
        return memdes;
    }

    public void setMemdes(String memdes) {
        this.memdes = memdes;
    }

    public String getMemname() {
        return memname;
    }

    public void setMemname(String memname) {
        this.memname = memname;
    }

    public String getMemregno() {
        return memregno;
    }

    public void setMemregno(String memregno) {
        this.memregno = memregno;
    }
    /** Creates a new instance of AddMemBean */
    public AddMemBean() {
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb=(HtmlComboBox)e.getComponent();
        this.commname=(String) cmb.getValue();
        
    }
    
    public void DesFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.memdes=(String)cmb1.getValue();
    }
    
    
    public String register()
    {
        this.committee=this.committeeFacade3.findByCommName(this.commname);
        Members mem=new Members();
        mem.setMemberdes(memdes);
        mem.setMemberregno(memregno);
        mem.setMembername(memname);
        this.membersFacade.create(mem);
        this.members=this.membersFacade.findByRegNo(this.memregno);
        Membercomm temp=new Membercomm();
        temp.setCommid(committee);
        temp.setMemberid(members);
        this.membercommFacade.create(temp);
        FacesContext fc=FacesContext.getCurrentInstance();
        url url=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        url.setPageid("conf.jsp");
        return null;
    }

}
