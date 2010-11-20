/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author root
 */
@Entity
public class ParticipationMaster implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @JoinColumn(name = "PARTID", referencedColumnName = "PARTID")
    @ManyToOne
    private Participantdetails partid;
    @JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
    @ManyToOne
    private Eventdetails eventid;
     @JoinColumn(name = "COLLEGEID", referencedColumnName = "COLLEGEID")
    @ManyToOne
    private College collegeid;
     
     @JoinColumn(name= "GROUPID", referencedColumnName="GROUPID")
     @ManyToOne
     private Groups groupid;

    public Groups getGroupid() {
        return groupid;
    }

    public void setGroupid(Groups groupid) {
        this.groupid = groupid;
    }

    public College getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(College collegeid) {
        this.collegeid = collegeid;
    }

    public Eventdetails getEventid() {
        return eventid;
    }

    public void setEventid(Eventdetails eventid) {
        this.eventid = eventid;
    }

    public int getEventtype() {
        return eventtype;
    }

    public void setEventtype(int eventtype) {
        this.eventtype = eventtype;
    }

    public Participantdetails getPartid() {
        return partid;
    }

    public void setPartid(Participantdetails partid) {
        this.partid = partid;
    }
    private int eventtype;
    
    public void setId(Long id) {
        this.id = id;
    }

   
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipationMaster)) {
            return false;
        }
        ParticipationMaster other = (ParticipationMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.ParticipationMaster[id=" + id + "]";
    }

}
