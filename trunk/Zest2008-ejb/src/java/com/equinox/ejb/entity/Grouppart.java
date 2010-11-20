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
@Table(name = "GROUPPART")
@NamedQueries({@NamedQuery(name = "Grouppart.findByTransid", query = "SELECT g FROM Grouppart g WHERE g.transid = :transid")})
public class Grouppart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSID", nullable = false)
    private Long transid;
    @JoinColumn(name = "GROUPID", referencedColumnName = "GROUPID")
    @ManyToOne
    private Groups groupid;
    @JoinColumn(name = "PARTID", referencedColumnName = "PARTID")
    @ManyToOne
    private Participantdetails partid;

    public Grouppart() {
    }

    public Grouppart(Long transid) {
        this.transid = transid;
    }

    public Long getTransid() {
        return transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

    public Groups getGroupid() {
        return groupid;
    }

    public void setGroupid(Groups groupid) {
        this.groupid = groupid;
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
        if (!(object instanceof Grouppart)) {
            return false;
        }
        Grouppart other = (Grouppart) object;
        if ((this.transid == null && other.transid != null) || (this.transid != null && !this.transid.equals(other.transid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Grouppart[transid=" + transid + "]";
    }

}
