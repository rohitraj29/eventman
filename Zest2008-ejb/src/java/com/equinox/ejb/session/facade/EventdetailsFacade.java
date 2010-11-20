/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.facade;

import com.equinox.ejb.entity.Eventdetails;
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
public class EventdetailsFacade implements EventdetailsFacadeLocal, EventdetailsFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Eventdetails eventdetails) {
        try {
            Eventdetails eventdetails1 = this.findByName(eventdetails.getEventname());
            if(eventdetails1.equals(null))
            {
                em.persist(eventdetails);
            }

        } catch (Exception exception) {
            
            em.persist(eventdetails);
            exception.printStackTrace();
        }

        
    }

    public void edit(Eventdetails eventdetails) {
        em.merge(eventdetails);
    }

    public void remove(Eventdetails eventdetails) {
        
        em.remove(em.merge(eventdetails));
    }

    public Eventdetails find(Object id) {
        return em.find(com.equinox.ejb.entity.Eventdetails.class, id);
    }

    public List<Eventdetails> findAll() {
        return em.createQuery("select object(o) from Eventdetails as o").getResultList();
    }
    public Eventdetails findByName(String str)
    {
        try{
        Query q1=em.createNamedQuery("Eventdetails.findByEventname");
        q1.setParameter("eventname", str);
        return (Eventdetails)q1.getSingleResult();}catch(Exception e){e.printStackTrace();return null;}
    }
}
