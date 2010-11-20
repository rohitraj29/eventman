
import java.io.Serializable;
import javax.faces.event.ActionEvent;
import org.richfaces.component.html.HtmlPanelMenuItem;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */

public class url implements Serializable{
private String pageid;


    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }
    /** Creates a new instance of url */
    public url() {
        this.pageid="welcomefile.jsp";
    }
   
    public void menuaction(ActionEvent e)
    {
        try {
            HtmlPanelMenuItem item = (HtmlPanelMenuItem) e.getComponent();
            String str1 = item.getData().toString();
            this.setPageid(str1);

        } catch (Exception exception) {
        }

    }
    
    }


