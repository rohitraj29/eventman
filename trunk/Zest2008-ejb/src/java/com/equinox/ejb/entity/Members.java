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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "MEMBERS")
@NamedQueries({@NamedQuery(name = "Members.findByMemberid", query = "SELECT m FROM Members m WHERE m.memberid = :memberid"), @NamedQuery(name = "Members.findByMembername", query = "SELECT m FROM Members m WHERE m.membername = :membername"), @NamedQuery(name = "Members.findByMemberregno", query = "SELECT m FROM Members m WHERE m.memberregno = :memberregno"), @NamedQuery(name = "Members.findByMemberdes", query = "SELECT m FROM Members m WHERE m.memberdes = :memberdes")})
public class Members implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBERID", nullable = false)
    private Long memberid;
    @Column(name = "MEMBERNAME")
    private String membername;
    @Column(name = "MEMBERREGNO")
    private String memberregno;
    @Column(name = "MEMBERDES")
    private String memberdes;
    

    public Members() {
    }

    public Members(Long memberid) {
        this.memberid = memberid;
    }

    public Long getMemberid() {
        return memberid;
    }

    public void setMemberid(Long memberid) {
        this.memberid = memberid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberregno() {
        return memberregno;
    }

    public void setMemberregno(String memberregno) {
        this.memberregno = memberregno;
    }

    public String getMemberdes() {
        return memberdes;
    }

    public void setMemberdes(String memberdes) {
        this.memberdes = memberdes;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberid != null ? memberid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Members)) {
            return false;
        }
        Members other = (Members) object;
        if ((this.memberid == null && other.memberid != null) || (this.memberid != null && !this.memberid.equals(other.memberid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Members[memberid=" + memberid + "]";
    }

}
