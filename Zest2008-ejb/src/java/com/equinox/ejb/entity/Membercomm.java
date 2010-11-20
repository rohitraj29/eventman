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
@Table(name = "MEMBERCOMM")
@NamedQueries({@NamedQuery(name = "Membercomm.findByMembershipid", query = "SELECT m FROM Membercomm m WHERE m.membershipid = :membershipid")})
public class Membercomm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBERSHIPID", nullable = false)
    private Long membershipid;
    @JoinColumn(name = "COMMID", referencedColumnName = "COMMID")
    @ManyToOne
    private Committee commid;
    @JoinColumn(name = "MEMBERID", referencedColumnName = "MEMBERID")
    @ManyToOne
    private Members memberid;

    public Membercomm() {
    }

    public Membercomm(Long membershipid) {
        this.membershipid = membershipid;
    }

    public Long getMembershipid() {
        return membershipid;
    }

    public void setMembershipid(Long membershipid) {
        this.membershipid = membershipid;
    }

    public Committee getCommid() {
        return commid;
    }

    public void setCommid(Committee commid) {
        this.commid = commid;
    }

    public Members getMemberid() {
        return memberid;
    }

    public void setMemberid(Members memberid) {
        this.memberid = memberid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membershipid != null ? membershipid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membercomm)) {
            return false;
        }
        Membercomm other = (Membercomm) object;
        if ((this.membershipid == null && other.membershipid != null) || (this.membershipid != null && !this.membershipid.equals(other.membershipid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Membercomm[membershipid=" + membershipid + "]";
    }

}
