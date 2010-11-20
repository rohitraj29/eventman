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
@Table(name = "COMMITTEE")
@NamedQueries({@NamedQuery(name = "Committee.findByCommid", query = "SELECT c FROM Committee c WHERE c.commid = :commid"), @NamedQuery(name = "Committee.findByCommname", query = "SELECT c FROM Committee c WHERE c.commname = :commname")})
public class Committee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMMID", nullable = false)
    private Long commid;
    @Column(name = "COMMNAME")
    private String commname;
    @OneToMany(mappedBy = "commid")
    private Collection<Membercomm> membercommCollection;
    

    public Committee() {
    }

    public Committee(Long commid) {
        this.commid = commid;
    }

    public Long getCommid() {
        return commid;
    }

    public void setCommid(Long commid) {
        this.commid = commid;
    }

    public String getCommname() {
        return commname;
    }

    public void setCommname(String commname) {
        this.commname = commname;
    }

    public Collection<Membercomm> getMembercommCollection() {
        return membercommCollection;
    }

    public void setMembercommCollection(Collection<Membercomm> membercommCollection) {
        this.membercommCollection = membercommCollection;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commid != null ? commid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Committee)) {
            return false;
        }
        Committee other = (Committee) object;
        if ((this.commid == null && other.commid != null) || (this.commid != null && !this.commid.equals(other.commid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Committee[commid=" + commid + "]";
    }

}
