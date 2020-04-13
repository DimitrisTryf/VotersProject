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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dimit
 */
@Entity
@Table(name = "pollrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pollrole.findAll", query = "SELECT p FROM Pollrole p"),
    @NamedQuery(name = "Pollrole.findByRoleId", query = "SELECT p FROM Pollrole p WHERE p.roleId = :roleId"),
    @NamedQuery(name = "Pollrole.findByRoleName", query = "SELECT p FROM Pollrole p WHERE p.roleName = :roleName")})
public class Pollrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Size(max = 10)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @OneToMany(mappedBy = "uRoleId")
    private Collection<Polluser> polluserCollection;

    public Pollrole() {
    }

    public Pollrole(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public Collection<Polluser> getPolluserCollection() {
        return polluserCollection;
    }

    public void setPolluserCollection(Collection<Polluser> polluserCollection) {
        this.polluserCollection = polluserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pollrole)) {
            return false;
        }
        Pollrole other = (Pollrole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.VotersProject.models.Pollrole[ roleId=" + roleId + " ]";
    }
    
}
