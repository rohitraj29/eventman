
import com.equinox.ejb.entity.ResultGroup;
import com.equinox.ejb.session.facade.EventdetailsFacadeRemote;
import com.equinox.ejb.session.facade.ResultGroupFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class GrpEventResBean {
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade1;
    @EJB
    private ResultGroupFacadeRemote resultGroupFacade;
    @EJB
    private EventdetailsFacadeRemote eventdetailsFacade;
private String eventname;
private List<ResultGroup> reslist;

    /** Creates a new instance of GrpEventResBean */
    public GrpEventResBean() {
    }
public void ChangeFired(ValueChangeEvent e)
{
    HtmlComboBox cmb1=(HtmlComboBox) e.getComponent();
    this.eventname=(String)cmb1.getValue();
}

public String RetrieveData()
{
    List<ResultGroup> temp=this.resultGroupFacade.findAll();
    ArrayList<ResultGroup> list=new ArrayList<ResultGroup>();
    Iterator itr=temp.iterator();
    while(itr.hasNext())
    {
        ResultGroup grp=(ResultGroup)itr.next();
        if(grp.getEventid().equals(this.eventdetailsFacade.findByName(eventname)))
        {
            list.add(grp);
        }
    }
    this.reslist=list;
    return null;
}

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public List<ResultGroup> getReslist() {
        if(reslist!=null)
        return reslist;
        else return new ArrayList<ResultGroup>();
    }

    public void setReslist(List<ResultGroup> reslist) {
        this.reslist = reslist;
    }
}
