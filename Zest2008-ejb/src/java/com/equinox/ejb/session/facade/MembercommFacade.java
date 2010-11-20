/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Committee;
import com.equinox.ejb.entity.Membercomm;
import com.equinox.ejb.entity.Members;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class MembercommFacade implements MembercommFacadeLocal, MembercommFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Membercomm membercomm) {
        em.persist(membercomm);
    }

    public void edit(Membercomm membercomm) {
        em.merge(membercomm);
    }

    public void remove(Membercomm membercomm) {
        em.remove(em.merge(membercomm));
    }

    public Membercomm find(Object id) {
        return em.find(com.equinox.ejb.entity.Membercomm.class, id);
    }

    public List<Membercomm> findAll() {
        return em.createQuery("select object(o) from Membercomm as o").getResultList();
    }
    public Membercomm findByMemberComm(Committee com,Members mem)
    {
        Query q1=em.createQuery("SELECT Object(o) FROM Membercomm o WHERE o.commid=:commid AND o.memberid=:memberid");
        q1.setParameter("commid",com );
        q1.setParameter("memberid", mem);
        return (Membercomm) q1.getSingleResult();
    }

}
