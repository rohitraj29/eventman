/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Groups;
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
public class GroupsFacade implements GroupsFacadeLocal, GroupsFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Groups groups) {
        try{
            Groups temp=this.findByName(groups.getGroupname());
        }catch(Exception e){
        
        em.persist(groups);}
    }

    public void edit(Groups groups) {
        em.merge(groups);
    }

    public void remove(Groups groups) {
        em.remove(em.merge(groups));
    }

    public Groups find(Object id) {
        return em.find(com.equinox.ejb.entity.Groups.class, id);
    }

    public List<Groups> findAll() {
        return em.createQuery("select object(o) from Groups as o").getResultList();
    }

    public Groups findByName(String grpname) {
        Query q1= em.createNamedQuery("Groups.findByGroupname");
        q1.setParameter("groupname", grpname);
        return (Groups) q1.getSingleResult();
    }
    

}
