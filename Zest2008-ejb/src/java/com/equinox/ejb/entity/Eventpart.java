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
@Table(name = "EVENTPART")
@NamedQueries({@NamedQuery(name = "Eventpart.findByTransid", query = "SELECT e FROM Eventpart e WHERE e.transid = :transid")})
public class Eventpart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSID", nullable = false)
    private Long transid;
    @JoinColumn(name = "EVENTID", referencedColumnName = "EVENTID")
    @ManyToOne
    private Eventdetails eventid;
    @JoinColumn(name = "PARTID", referencedColumnName = "PARTID")
    @ManyToOne
    private Participantdetails partid;

    public Eventpart() {
    }

    public Eventpart(Long transid) {
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

    public Participantdetails getPartid() {
        return partid;
    }

    public void setPartid(Participantdetails partid) {
        this.partid = partid;
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
        if (!(object instanceof Eventpart)) {
            return false;
        }
        Eventpart other = (Eventpart) object;
        if ((this.transid == null && other.transid != null) || (this.transid != null && !this.transid.equals(other.transid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Eventpart[transid=" + transid + "]";
    }

}
