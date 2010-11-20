
import com.equinox.ejb.entity.Participantdetails;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */

public class ParticipantBean {
    @EJB
    private ParticipantdetailsFacadeRemote participantdetailsFacade;
    private List<SelectItem> partlist;

    public List<SelectItem> getPartlist() {
        try {
            List<Participantdetails> part = this.participantdetailsFacade.findAll();
            Iterator itr = part.iterator();
            ArrayList<SelectItem> temp = new ArrayList<SelectItem>();
            while (itr.hasNext()) {
                Participantdetails partic = (Participantdetails) itr.next();
                SelectItem sel = new SelectItem();
                sel.setValue(partic.getPartid());
                sel.setLabel(partic.getPartid().toString());
                temp.add(sel);
            }
            this.partlist = temp;
            return partlist;

        } catch (Exception exception) {return null;
        }

    }

    public void setPartlist(List<SelectItem> partlist) {
        this.partlist = partlist;
    }
    
    /** Creates a new instance of ParticipantBean */
    public ParticipantBean() {
        
    }

}
