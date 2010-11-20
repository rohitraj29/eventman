/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name = "EVENTDETAILS")
@NamedQueries({@NamedQuery(name = "Eventdetails.findByEventid", query = "SELECT e FROM Eventdetails e WHERE e.eventid = :eventid"), @NamedQuery(name = "Eventdetails.findByEventname", query = "SELECT e FROM Eventdetails e WHERE e.eventname = :eventname"), @NamedQuery(name = "Eventdetails.findByEventtype", query = "SELECT e FROM Eventdetails e WHERE e.eventtype = :eventtype"), @NamedQuery(name = "Eventdetails.findByEventdate", query = "SELECT e FROM Eventdetails e WHERE e.eventdate = :eventdate"), @NamedQuery(name = "Eventdetails.findByEventtime", query = "SELECT e FROM Eventdetails e WHERE e.eventtime = :eventtime")})
public class Eventdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EVENTID", nullable = false)
    private Long eventid;
    @Column(name = "EVENTNAME")
    private String eventname;
    @Column(name = "EVENTTYPE")
    private Integer eventtype;
    @Column(name = "EVENTDATE")
    @Temporal(TemporalType.DATE)
    private Date eventdate;
    @Column(name = "EVENTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventtime;
    @Column(name="EVENTVENUE")
    private String eventvenue;

    public String getEventvenue() {
        return eventvenue;
    }

    public void setEventvenue(String eventvenue) {
        this.eventvenue = eventvenue;
    }
    
    @JoinColumn(name = "COMMITTEEID", referencedColumnName = "COMMID")
    @ManyToOne
    private Committee committeeid;

    public Eventdetails() {
    }

    public Eventdetails(Long eventid) {
        this.eventid = eventid;
    }

    public Long getEventid() {
        return eventid;
    }

    public void setEventid(Long eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Integer getEventtype() {
        return eventtype;
    }

    public void setEventtype(Integer eventtype) {
        this.eventtype = eventtype;
    }

    public Date getEventdate() {
        
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public Date getEventtime() {
        return eventtime;
    }

    public void setEventtime(Date eventtime) {
        this.eventtime = eventtime;
    }

   

    public Committee getCommitteeid() {
        return committeeid;
    }

    public void setCommitteeid(Committee committeeid) {
        this.committeeid = committeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventid != null ? eventid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventdetails)) {
            return false;
        }
        Eventdetails other = (Eventdetails) object;
        if ((this.eventid == null && other.eventid != null) || (this.eventid != null && !this.eventid.equals(other.eventid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Eventdetails[eventid=" + eventid + "]";
    }

}
