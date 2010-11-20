
import com.equinox.ejb.entity.ResultGroup;
import com.equinox.ejb.session.facade.ResultGroupFacadeRemote;
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

public class CollegeResGrpBean {
    @EJB
    private ResultGroupFacadeRemote resultGroupFacade;
private String collegename;
private List<ResultGroup> reslist;

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public List<ResultGroup> getReslist() {
        if(reslist!=null)
        return reslist;
        else
            return new ArrayList<ResultGroup>();
    }

    public void setReslist(List<ResultGroup> reslist) {
        this.reslist = reslist;
    }
    /** Creates a new instance of CollegeResGrpBean */
    public CollegeResGrpBean() {
    }
    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.collegename=(String) cmb1.getValue();
    }
    
    public String RetrieveData()
    {
        List<ResultGroup> list=this.resultGroupFacade.findAll();
        ArrayList<ResultGroup> temp=new ArrayList<ResultGroup>();
        Iterator itr=list.iterator();
        while(itr.hasNext())
        {
            ResultGroup rg=(ResultGroup) itr.next();
            if(rg.getGroupid().getCollege().getCollegename().equals(this.collegename))
            {
                temp.add(rg);
            }
        }
        this.reslist=temp;
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("collegewiseresult.jsp");
        return null;
    }

}
