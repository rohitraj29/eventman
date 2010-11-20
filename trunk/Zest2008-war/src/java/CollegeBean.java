
import com.equinox.ejb.entity.College;
import com.equinox.ejb.session.facade.CollegeFacadeLocal;
import com.equinox.ejb.session.facade.CollegeFacadeRemote;
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
public class CollegeBean {
    @EJB(name = "CollegeFacade1")
    private CollegeFacadeRemote collegeFacade1;
    
 
   
    /** Creates a new instance of CollegeBean */
    private List<SelectItem> collegelist;

    public List<SelectItem> getCollegelist() {
        try {
            List<College> l1 = this.collegeFacade1.findAll();
            Iterator itr = l1.iterator();
            ArrayList<SelectItem> list = new ArrayList<SelectItem>();

            while (itr.hasNext()) {
                College col = (College) itr.next();
                SelectItem sel = new SelectItem();
                sel.setLabel(col.getCollegename());
                sel.setValue(col.getCollegename());
                list.add(sel);
            }
            this.collegelist = list;
            return collegelist;

        } catch (Exception exception) {return null;
        }

    }

    public void setCollegelist(List<SelectItem> collegelist) {
        this.collegelist = collegelist;
    }

    public CollegeBean() {
    }
}
