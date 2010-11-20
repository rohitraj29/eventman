
import com.equinox.ejb.session.facade.CollegeFacadeRemote;
import com.equinox.ejb.session.facade.MembersFacadeRemote;
import com.equinox.ejb.session.facade.ParticipantdetailsFacadeRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public class EJBAdapter implements java.io.Serializable{
    private CollegeFacadeRemote collegeFacade;
    private MembersFacadeRemote membersFacade;
    private ParticipantdetailsFacadeRemote participantdetailsFacade;

    public ParticipantdetailsFacadeRemote getParticipantdetailsFacade() {
        return this.lookupParticipantdetailsFacade();
    }

    public void setParticipatdetailsFacade(ParticipantdetailsFacadeRemote participatdetailsFacade) {
        this.participantdetailsFacade = participatdetailsFacade;
    }

    public CollegeFacadeRemote getCollegeFacade() {
        return this.lookupCollegeFacade();
    }

    public void setCollegeFacade(CollegeFacadeRemote collegeFacade) {
        this.collegeFacade = collegeFacade;
    }

    public MembersFacadeRemote getMembersFacade() {
        return this.lookupMembersFacade();
    }

    public void setMembersFacade(MembersFacadeRemote membersFacade) {
        this.membersFacade = membersFacade;
    }

    private CollegeFacadeRemote lookupCollegeFacade() {
        try {
            Context c = new InitialContext();
            return (CollegeFacadeRemote) c.lookup("java:comp/env/CollegeFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private MembersFacadeRemote lookupMembersFacade() {
        try {
            Context c = new InitialContext();
            return (MembersFacadeRemote) c.lookup("java:comp/env/MembersFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ParticipantdetailsFacadeRemote lookupParticipantdetailsFacade() {
        try {
            Context c = new InitialContext();
            return (ParticipantdetailsFacadeRemote) c.lookup("java:comp/env/ParticipantdetailsFacade");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
   
    
    

}
