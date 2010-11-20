
import com.equinox.ejb.entity.Groups;
import com.equinox.ejb.session.facade.GroupsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */

public class GroupBean {
    @EJB
    private GroupsFacadeRemote groupsFacade;

    List<SelectItem> grouplist;

    public List<SelectItem> getGrouplist() {
        List<Groups> temp=this.groupsFacade.findAll();
        Iterator itr=temp.iterator();
        ArrayList<SelectItem> list=new ArrayList<SelectItem>();
        while(itr.hasNext())
        {   Groups grp=(Groups)itr.next();
            SelectItem sel=new SelectItem();
            sel.setLabel(grp.getGroupid().toString());
            sel.setValue(grp.getGroupid());
            list.add(sel);
        }
        this.grouplist=list;
        
        
        return grouplist;
    }

    public void setGrouplist(List<SelectItem> grouplist) {
        this.grouplist = grouplist;
    }
    
    /** Creates a new instance of GroupBean */
    public GroupBean() {
    }

}
