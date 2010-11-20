/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

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
public class MembersFacade implements MembersFacadeLocal, MembersFacadeRemote {
    @PersistenceContext
    private EntityManager em;

     public Members findByRegNo(String regno)
     {
         try {
             Query q1 = em.createNamedQuery("Members.findByMemberregno");
             q1.setParameter("memberregno", regno);
             return (Members) q1.getSingleResult();

         } catch (Exception exception) {exception.printStackTrace(); return null;
         }

     }
    public void create(Members members) {
        try{
            Members temp=this.findByRegNo(members.getMemberregno());
            if(temp==null)
            {
                em.persist(members);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        em.persist(members);
        }
    }

    public void edit(Members members) {
        em.merge(members);
    }

    public void remove(Members members) {
        em.remove(em.merge(members));
    }

    public Members find(Object id) {
        return em.find(com.equinox.ejb.entity.Members.class, id);
    }

    public List<Members> findAll() {
        return em.createQuery("select object(o) from Members as o").getResultList();
    }
    
    
            

}
