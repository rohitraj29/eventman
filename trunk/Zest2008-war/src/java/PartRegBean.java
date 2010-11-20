
import com.equinox.ejb.entity.Participantdetails;
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */
public class PartRegBean implements Serializable{
    private EJBAdapter adapter;
    private String partname;
    private String partcollege;
    private String partregno;
    private Long serialid;

    public Long getSerialid() {
        if(serialid==null)
        this.serialid=adapter.getParticipantdetailsFacade().findByRegNo(partregno).getPartid();
        return serialid;
    }

    public void setSerialid(Long serialid) {
        this.serialid = serialid;
    }

    public String getPartcollege() {
        return partcollege;
    }

    public void setPartcollege(String partcollege) {
        this.partcollege = partcollege;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getPartregno() {
        return partregno;
    }

    public void setPartregno(String partregno) {
        this.partregno = partregno;
    }
    

    /** Creates a new instance of PartRegBean */
    public PartRegBean() {
        this.adapter= new EJBAdapter();
    }
    
    public String register()
    {
        try
        {
        Participantdetails part=new Participantdetails();
        part.setPartname(this.getPartname());
        part.setPartregno(this.getPartregno().trim());
        part.setCollegeid(this.adapter.getCollegeFacade().findByName(this.getPartcollege()));
        this.adapter.getParticipantdetailsFacade().create(part);
        this.serialid=this.adapter.getParticipantdetailsFacade().findByRegNo(partregno).getPartid();
        FacesContext fc= FacesContext.getCurrentInstance();
        url ret=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        if(this.adapter.getParticipantdetailsFacade().findByRegNo(partregno)!=null)
        ret.setPageid("RegSuccess.jsp");
        
        return "success";
     }catch(Exception e)
     {
         e.printStackTrace();
         FacesContext fc= FacesContext.getCurrentInstance();
        url ret=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        ret.setPageid("RegFailure.jsp");
        
         return null;
     }
    }
    
    public void changeFired(ValueChangeEvent e)
    {
        try{
        HtmlComboBox menu1=(HtmlComboBox)e.getComponent();
       this.partcollege=(String)menu1.getValue();
     }catch(Exception ex){ex.printStackTrace();}
    }
    
    public String clear()
    {
        
        this.setPartname(null);
        this.setPartcollege(null);
        this.setPartregno(null);
         FacesContext fc= FacesContext.getCurrentInstance();
        url ret=(url)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{url}", url.class).getValue(fc.getELContext());
        ret.setPageid("regpart.jsp");
        
        return null;
    }
   
    }

