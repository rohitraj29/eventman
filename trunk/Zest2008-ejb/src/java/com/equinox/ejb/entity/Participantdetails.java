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
@Table(name = "PARTICIPANTDETAILS")
@NamedQueries({@NamedQuery(name = "Participantdetails.findByPartid", query = "SELECT p FROM Participantdetails p WHERE p.partid = :partid"), @NamedQuery(name = "Participantdetails.findByPartname", query = "SELECT p FROM Participantdetails p WHERE p.partname = :partname"), @NamedQuery(name = "Participantdetails.findByPartregno", query = "SELECT p FROM Participantdetails p WHERE p.partregno = :partregno")})
public class Participantdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARTID", nullable = false)
    private Long partid;
    @Column(name = "PARTNAME")
    private String partname;
    @Column(name = "PARTREGNO",nullable = false,unique=true)
    private String partregno;
    
    
    @JoinColumn(name = "COLLEGEID", referencedColumnName = "COLLEGEID")
    @ManyToOne
    private College collegeid;

    public Participantdetails() {
    }

    public Participantdetails(Long partid) {
        this.partid = partid;
    }

    public Long getPartid() {
        return partid;
    }

    public void setPartid(Long partid) {
        this.partid = partid;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public String getPartregno() {
        return partregno;
    }

    public void setPartregno(String partregno) {
        this.partregno = partregno;
    }

    

    public College getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(College collegeid) {
        this.collegeid = collegeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partid != null ? partid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participantdetails)) {
            return false;
        }
        Participantdetails other = (Participantdetails) object;
        if ((this.partid == null && other.partid != null) || (this.partid != null && !this.partid.equals(other.partid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Participantdetails[partid=" + partid + "]";
    }
    
   

}
