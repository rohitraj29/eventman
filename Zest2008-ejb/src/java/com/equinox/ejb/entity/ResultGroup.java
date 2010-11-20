/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class ResultGroup implements Serializable {
    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @JoinColumn(name="GROUPID", referencedColumnName="GROUPID")
    @OneToOne   
     private Groups groupid;
     @Column(name="POSITION")
     private int position;

    public Eventdetails getEventid() {
        return eventid;
    }

    public void setEventid(Eventdetails eventid) {
        this.eventid = eventid;
    }

    public Groups getGroupid() {
        return groupid;
    }

    public void setGroupid(Groups groupid) {
        this.groupid = groupid;
    }
     @JoinColumn(name="EVENTID",referencedColumnName="EVENTID")
    @ManyToOne
     private Eventdetails eventid;

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
        if (!(object instanceof ResultGroup)) {
            return false;
        }
        ResultGroup other = (ResultGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.ResultGroup[id=" + id + "]";
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
