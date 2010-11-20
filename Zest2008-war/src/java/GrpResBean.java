
import com.equinox.ejb.entity.ResultGroup;
import com.equinox.ejb.session.facade.ResultGroupFacadeRemote;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class GrpResBean {
    @EJB
    private ResultGroupFacadeRemote resultGroupFacade;
private List<ResultGroup> reslist;

    public List<ResultGroup> getReslist() {
        String temp=Update();
        return reslist;
    }

    public void setReslist(List<ResultGroup> reslist) {
        this.reslist = reslist;
    }

    /** Creates a new instance of GrpResBean */
    public GrpResBean() {
        
        
    }
    

    public String Update()
    {
        this.reslist=this.resultGroupFacade.findAll();
        FacesContext fc=FacesContext.getCurrentInstance();
         url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("latestresults.jsp");
        return null;
        
    }
}
