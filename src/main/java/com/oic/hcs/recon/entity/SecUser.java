/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noaman000
 */
@Entity
@Table(name = "SEC_USER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecUser.findAll", query = "SELECT s FROM SecUser s"),
    @NamedQuery(name = "SecUser.findByUsername", query = "SELECT s FROM SecUser s WHERE s.username = :username"),
    @NamedQuery(name = "SecUser.findByPassword", query = "SELECT s FROM SecUser s WHERE s.password = :password"),
    @NamedQuery(name = "SecUser.findByFirstName", query = "SELECT s FROM SecUser s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SecUser.findByLastName", query = "SELECT s FROM SecUser s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SecUser.findByAllowCardUse", query = "SELECT s FROM SecUser s WHERE s.allowCardUse = :allowCardUse"),
    @NamedQuery(name = "SecUser.findByAllowEligEntry", query = "SELECT s FROM SecUser s WHERE s.allowEligEntry = :allowEligEntry"),
    @NamedQuery(name = "SecUser.findByCreateId", query = "SELECT s FROM SecUser s WHERE s.createId = :createId"),
    @NamedQuery(name = "SecUser.findByCreateDtime", query = "SELECT s FROM SecUser s WHERE s.createDtime = :createDtime"),
    @NamedQuery(name = "SecUser.findByActivateDate", query = "SELECT s FROM SecUser s WHERE s.activateDate = :activateDate"),
    @NamedQuery(name = "SecUser.findByDeactivateDate", query = "SELECT s FROM SecUser s WHERE s.deactivateDate = :deactivateDate"),
    @NamedQuery(name = "SecUser.findByUserAndPassword", query = "SELECT s FROM SecUser s WHERE s.username = :username and s.password = :password")})
public class SecUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ALLOW_CARD_USE")
    private BigInteger allowCardUse;
    @Column(name = "ALLOW_ELIG_ENTRY")
    private BigInteger allowEligEntry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CREATE_ID")
    private String createId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDtime;
    @Column(name = "ACTIVATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activateDate;
    @Column(name = "DEACTIVATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deactivateDate;

    public SecUser() {
    }

    public SecUser(String username) {
        this.username = username;
    }

    public SecUser(String username, String password, String firstName, String lastName, String createId, Date createDtime) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createId = createId;
        this.createDtime = createDtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigInteger getAllowCardUse() {
        return allowCardUse;
    }

    public void setAllowCardUse(BigInteger allowCardUse) {
        this.allowCardUse = allowCardUse;
    }

    public BigInteger getAllowEligEntry() {
        return allowEligEntry;
    }

    public void setAllowEligEntry(BigInteger allowEligEntry) {
        this.allowEligEntry = allowEligEntry;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateDtime() {
        return createDtime;
    }

    public void setCreateDtime(Date createDtime) {
        this.createDtime = createDtime;
    }

    public Date getActivateDate() {
        return activateDate;
    }

    public void setActivateDate(Date activateDate) {
        this.activateDate = activateDate;
    }

    public Date getDeactivateDate() {
        return deactivateDate;
    }

    public void setDeactivateDate(Date deactivateDate) {
        this.deactivateDate = deactivateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SecUser)) {
            return false;
        }
        SecUser other = (SecUser) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SecUser[ username=" + username + " ]";
    }
    
}
