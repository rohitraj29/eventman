
import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.session.buslogic.CollegeResultsBeanRemote;
import java.util.ArrayList;
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

public class CollegeResBean {
    @EJB
    private CollegeResultsBeanRemote collegeResultsBeanBean;
private String collegename;
private List<ResultPositions> reslist;

    /** Creates a new instance of CollegeResBean */
    public CollegeResBean() {
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public List<ResultPositions> getReslist() {
        if(reslist!=null)
        return reslist;
        else
            return new ArrayList<ResultPositions>();
    }
    

    public void setReslist(List<ResultPositions> reslist) {
        this.reslist = reslist;
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.collegename=(String) cmb1.getValue();
    }
    
    public String RetrieveData()
    {
        this.reslist=this.collegeResultsBeanBean.getIndResults(collegename);
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("collegewiseresult.jsp");
        return null;
    }

}
