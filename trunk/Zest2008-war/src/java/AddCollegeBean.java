
import com.equinox.ejb.entity.College;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class AddCollegeBean {
private String collegename;
private College college;
    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }
    /** Creates a new instance of AddCollegeBean */
    public AddCollegeBean() {
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    public String register()
    {
        try {
            EJBAdapter adapter = new EJBAdapter();
            College col = new College();
            col.setCollegename(this.collegename);
            adapter.getCollegeFacade().create(col);
            this.college = adapter.getCollegeFacade().findByName(this.collegename);
            FacesContext fc = FacesContext.getCurrentInstance();
            url urlbean = (url) fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
            urlbean.setPageid("collegeconf.jsp");
            return null;

        } catch (Exception exception) {exception.printStackTrace(); return null;
        }

    }

}
