
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class IntegerValueBean {
private List<SelectItem> positionList;
private List<SelectItem> evnttypeList;

    public List<SelectItem> getEvnttypeList() {
       
       
        return evnttypeList;
    }

    public void setEvnttypeList(List<SelectItem> evnttypeList) {
        this.evnttypeList = evnttypeList;
    }

    public List<SelectItem> getPositionList() {
       
        return positionList;
    }

    public void setPositionList(List<SelectItem> positionList) {
        this.positionList = positionList;
    }
    /** Creates a new instance of IntegerValueBean */
    public IntegerValueBean() {
    }

}
