
import com.equinox.ejb.entity.Grouppart;
import com.equinox.ejb.entity.Groups;
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.facade.GrouppartFacadeRemote;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class ViewGroupBean {
    @EJB
    private GrouppartFacadeRemote grouppartFacade;
    @EJB
    private GroupsFacadeRemote groupsFacade;

    private Long groupid;
    private String collegename;
    private String groupname;
    private List<Participantdetails> partlist;
    /** Creates a new instance of ViewGroupBean */
    public ViewGroupBean() {
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<Participantdetails> getPartlist() {
        return partlist;
    }

    public void setPartlist(List<Participantdetails> partlist) {
        this.partlist = partlist;
    }

    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.groupid=(Long)cmb1.getValue();
    }
    
    public String GetDetails()
    {
        Groups temp=this.groupsFacade.find(groupid);
        this.collegename=temp.getCollege().getCollegename();
        this.groupname=temp.getGroupname();
        List<Grouppart> templist=this.grouppartFacade.findAll();
        ArrayList<Participantdetails> part=new ArrayList<Participantdetails>();
        Iterator itr=templist.iterator();
        while(itr.hasNext())
        {
            Grouppart tgp=(Grouppart) itr.next();
            if(tgp.getGroupid().getGroupid().equals(this.groupid))
            {
                part.add(tgp.getPartid());
            }
        }
        this.partlist=part;
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("viewgroup.jsp");
        return null;
        
    }
}
