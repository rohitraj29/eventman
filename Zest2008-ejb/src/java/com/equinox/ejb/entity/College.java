/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "COLLEGE")
@NamedQueries({@NamedQuery(name = "College.findByCollegeid", query = "SELECT c FROM College c WHERE c.collegeid = :collegeid"), @NamedQuery(name = "College.findByCollegename", query = "SELECT c FROM College c WHERE c.collegename = :collegename")})
public class College implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COLLEGEID", nullable = false)
    private Long collegeid;
    @Column(name = "COLLEGENAME")
    private String collegename;
    @OneToMany(mappedBy = "collegeid")
    private Collection<Participantdetails> participantdetailsCollection;

    public College() {
    }

    public College(Long collegeid) {
        this.collegeid = collegeid;
    }

    public Long getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(Long collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public Collection<Participantdetails> getParticipantdetailsCollection() {
        return participantdetailsCollection;
    }

    public void setParticipantdetailsCollection(Collection<Participantdetails> participantdetailsCollection) {
        this.participantdetailsCollection = participantdetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collegeid != null ? collegeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof College)) {
            return false;
        }
        College other = (College) object;
        if ((this.collegeid == null && other.collegeid != null) || (this.collegeid != null && !this.collegeid.equals(other.collegeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.College[collegeid=" + collegeid + "]";
    }

}
