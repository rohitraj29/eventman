/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.College;
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
public class CollegeFacade implements CollegeFacadeLocal, CollegeFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(College college) {
        try{
        College col=this.findByName(college.getCollegename());
        }catch(Exception e){
        em.persist(college);
        }
    }

    public void edit(College college) {
        em.merge(college);
    }

    public void remove(College college) {
        em.remove(em.merge(college));
    }

    public College find(Object id) {
        return em.find(com.equinox.ejb.entity.College.class, id);
    }

    public List<College> findAll() {
        return em.createQuery("select object(o) from College as o").getResultList();
    }
    public College findByName(String str)
    {
        Query q1=em.createNamedQuery("College.findByCollegename");
        q1.setParameter("collegename",str );
        return (College)q1.getSingleResult();
        
    }

}
