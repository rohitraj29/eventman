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
@Table(name = "GROUPS")
@NamedQueries({@NamedQuery(name = "Groups.findByGroupid", query = "SELECT g FROM Groups g WHERE g.groupid = :groupid"), @NamedQuery(name = "Groups.findByGroupname", query = "SELECT g FROM Groups g WHERE g.groupname = :groupname")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUPID", nullable = false)
    private Long groupid;
    @Column(name = "GROUPNAME")
    private String groupname;
    @JoinColumn(name="COLLEGEID",referencedColumnName="COLLEGEID")
    @ManyToOne
    private College collegeid;

    public College getCollege() {
        return collegeid;
    }

    public void setCollege(College college) {
        this.collegeid = college;
    }
    

    public Groups() {
    }

    public Groups(Long groupid) {
        this.groupid = groupid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupid != null ? groupid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupid == null && other.groupid != null) || (this.groupid != null && !this.groupid.equals(other.groupid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Groups[groupid=" + groupid + "]";
    }

}
