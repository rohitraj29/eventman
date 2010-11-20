/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session.buslogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class RuleBeanBean implements RuleBeanRemote, RuleBeanLocal {
    @PersistenceContext
    private EntityManager em;

    public boolean validateParticipation(String regno) {
       return true;
        
    }

   
    
    
 
}
