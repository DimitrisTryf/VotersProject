/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dimit
 */
@Entity
@Table(name = "pollvote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pollvote.findAll", query = "SELECT p FROM Pollvote p"),
    @NamedQuery(name = "Pollvote.findByVoteId", query = "SELECT p FROM Pollvote p WHERE p.voteId = :voteId"),
    @NamedQuery(name = "Pollvote.findByDatetime", query = "SELECT p FROM Pollvote p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Pollvote.findByRating", query = "SELECT p FROM Pollvote p WHERE p.rating = :rating")})
public class Pollvote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOTE_ID")
    private Integer voteId;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "RATING")
    private Integer rating;
    @JoinColumn(name = "CANDIDATE_ID", referencedColumnName = "U_ID")
    @ManyToOne
    private Polluser candidateId;
    @JoinColumn(name = "VOTER_ID", referencedColumnName = "U_ID")
    @OneToOne
    private Polluser voterId;

    public Pollvote() {
    }

    public Pollvote(Integer voteId) {
        this.voteId = voteId;
    }

    public Integer getVoteId() {
        return voteId;
    }

    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Polluser getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Polluser candidateId) {
        this.candidateId = candidateId;
    }

    public Polluser getVoterId() {
        return voterId;
    }

    public void setVoterId(Polluser voterId) {
        this.voterId = voterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voteId != null ? voteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pollvote)) {
            return false;
        }
        Pollvote other = (Pollvote) object;
        if ((this.voteId == null && other.voteId != null) || (this.voteId != null && !this.voteId.equals(other.voteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.VotersProject.models.Pollvote[ voteId=" + voteId + " ]";
    }
    
}
