/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;
import javax.faces.event.ActionEvent;
import org.richfaces.component.html.HtmlPanelMenuItem;


/**
 *
 * @author root
 */
public class tyrourl implements Serializable{
    public tyrourl(){
        this.pageid="welcometyro.jsp";
    }
    
    private String pageid;

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }
public void menuaction(ActionEvent e){
    HtmlPanelMenuItem item=(HtmlPanelMenuItem)e.getComponent();
    this.pageid=item.getData().toString();
    
}
}
