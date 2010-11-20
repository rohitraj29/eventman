
import com.equinox.ejb.entity.ResultPositions;
import com.equinox.ejb.session.facade.ResultPositionsFacadeRemote;
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

public class IndResBean {
    @EJB
    private ResultPositionsFacadeRemote resultPositionsFacade;

    private List<ResultPositions> reslist;

    public List<ResultPositions> getReslist() {
        Update();
        return reslist;
    }

    public void setReslist(List<ResultPositions> reslist) {
        this.reslist = reslist;
    }
    
    /** Creates a new instance of IndResBean */
    public IndResBean() {
        
    }

    private String Update() {
        this.reslist=this.resultPositionsFacade.findAll();
        FacesContext fc=FacesContext.getCurrentInstance();
        url urlbean=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        urlbean.setPageid("latestresults.jsp");
        return null;
    }

}
