
import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.session.facade.CommitteeFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class CommitteeBean {
    @EJB
    private CommitteeFacadeRemote committeeFacade;
private List<SelectItem> committeelist;

    public List getCommitteelist() 
    {
        try {
            List<Committee> templist = this.committeeFacade.findAll();
            Iterator itr = templist.iterator();
            ArrayList<SelectItem> list = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Committee com = (Committee) itr.next();
                SelectItem sel = new SelectItem();
                sel.setLabel(com.getCommname());
                sel.setValue(com.getCommname());
                list.add(sel);
            }
            this.committeelist = list;
            return committeelist;

        } catch (Exception exception) 
        {
            return null;
        }

    }

    
    public void setCommitteelist(List committeelist) {
        this.committeelist = committeelist;
    }

    
    /** Creates a new instance of CommitteeBean */
    public CommitteeBean() {
    }

    public Committee findByName(String str)
    {
        return this.committeeFacade.findByCommName(str);
    }
    
}
