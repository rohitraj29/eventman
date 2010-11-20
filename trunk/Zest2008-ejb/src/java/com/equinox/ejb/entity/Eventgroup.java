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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVENTGROUP")
@NamedQueries({@NamedQuery(name = "Eventgroup.findByTransid", query = "SELECT e FROM Eventgroup e WHERE e.transid = :transid")})
public class Eventgroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSID", nullable = false)
    private Long transid;
    @JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
    @ManyToOne
    private Eventdetails eventid;
    @JoinColumn(name = "GROUPID", referencedColumnName = "GROUPID")
    @ManyToOne
    private Groups groupid;

    public Eventgroup() {
    }

    public Eventgroup(Long transid) {
        this.transid = transid;
    }

    public Long getTransid() {
        return transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transid != null ? transid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventgroup)) {
            return false;
        }
        Eventgroup other = (Eventgroup) object;
        if ((this.transid == null && other.transid != null) || (this.transid != null && !this.transid.equals(other.transid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Eventgroup[transid=" + transid + "]";
    }

}
