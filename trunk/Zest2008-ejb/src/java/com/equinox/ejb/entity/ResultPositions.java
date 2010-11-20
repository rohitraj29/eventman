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
import javax.persistence.OneToOne;

/**
 *
 * @author root
 */
@Entity
public class ResultPositions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn(name="PARTICIPANT", referencedColumnName="PARTID")
    @OneToOne   
    private Participantdetails participant;
    @Column(name="POSITION")
    private int Position;
    @JoinColumn(name="EVENTID",referencedColumnName="EVENTID")
    @ManyToOne
    private Eventdetails eventdetails;

    public Eventdetails getEventdetails() {
        return eventdetails;
    }

    public void setEventdetails(Eventdetails eventdetails) {
        this.eventdetails = eventdetails;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int Position) {
        this.Position = Position;
    }

    public Participantdetails getParticipant() {
        return participant;
    }

    public void setParticipant(Participantdetails participant) {
        this.participant = participant;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultPositions other = (ResultPositions) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Result[id=" + id + "]";
    }

}
