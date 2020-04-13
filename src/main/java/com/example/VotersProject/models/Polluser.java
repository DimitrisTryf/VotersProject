/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.VotersProject.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dimit
 */
@Entity
@Table(name = "polluser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polluser.findAll", query = "SELECT p FROM Polluser p"),
    @NamedQuery(name = "Polluser.findByUId", query = "SELECT p FROM Polluser p WHERE p.uId = :uId"),
    @NamedQuery(name = "Polluser.findByUSurname", query = "SELECT p FROM Polluser p WHERE p.uSurname = :uSurname"),
    @NamedQuery(name = "Polluser.findByUName", query = "SELECT p FROM Polluser p WHERE p.uName = :uName"),
    @NamedQuery(name = "Polluser.findByUPassword", query = "SELECT p FROM Polluser p WHERE p.uPassword = :uPassword"),
    @NamedQuery(name = "Polluser.findByULoginname", query = "SELECT p FROM Polluser p WHERE p.uLoginname = :uLoginname"),
    @NamedQuery(name = "Polluser.findByUCountry", query = "SELECT p FROM Polluser p WHERE p.uCountry = :uCountry")})
public class Polluser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "U_ID")
    private Integer uId;
    @Size(max = 20)
    @Column(name = "U_SURNAME")
    private String uSurname;
    @Size(max = 20)
    @Column(name = "U_NAME")
    private String uName;
    @Size(max = 60)
    @Column(name = "U_PASSWORD")
    private String uPassword;
    @Size(max = 20)
    @Column(name = "U_LOGINNAME")
    private String uLoginname;
    @Size(max = 45)
    @Column(name = "U_COUNTRY")
    private String uCountry;
    @JoinColumn(name = "U_ROLE_ID", referencedColumnName = "ROLE_ID")
    @ManyToOne
    private Pollrole uRoleId;
    @OneToMany(mappedBy = "candidateId")
    private Collection<Pollvote> pollvoteCollection;
    @OneToOne(mappedBy = "voterId")
    private Pollvote pollvote;

    public Polluser() {
    }

    public Polluser(Integer uId) {
        this.uId = uId;
    }

    public Integer getUId() {
        return uId;
    }

    public void setUId(Integer uId) {
        this.uId = uId;
    }

    public String getUSurname() {
        return uSurname;
    }

    public void setUSurname(String uSurname) {
        this.uSurname = uSurname;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassword() {
        return uPassword;
    }

    public void setUPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getULoginname() {
        return uLoginname;
    }

    public void setULoginname(String uLoginname) {
        this.uLoginname = uLoginname;
    }

    public String getUCountry() {
        return uCountry;
    }

    public void setUCountry(String uCountry) {
        this.uCountry = uCountry;
    }

    public Pollrole getURoleId() {
        return uRoleId;
    }

    public void setURoleId(Pollrole uRoleId) {
        this.uRoleId = uRoleId;
    }

    @XmlTransient
    public Collection<Pollvote> getPollvoteCollection() {
        return pollvoteCollection;
    }

    public void setPollvoteCollection(Collection<Pollvote> pollvoteCollection) {
        this.pollvoteCollection = pollvoteCollection;
    }

    public Pollvote getPollvote() {
        return pollvote;
    }

    public void setPollvote(Pollvote pollvote) {
        this.pollvote = pollvote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uId != null ? uId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polluser)) {
            return false;
        }
        Polluser other = (Polluser) object;
        if ((this.uId == null && other.uId != null) || (this.uId != null && !this.uId.equals(other.uId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.VotersProject.models.Polluser[ uId=" + uId + " ]";
    }
    
}
