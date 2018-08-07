/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "RECON_AUTHORITY")
@XmlRootElement
public class ReconAuthority implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "LIMIT")
    private Double limit;
    @Size(max = 50)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Size(max = 50)
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;   
    @Column(name = "LAST_UPDATED_ON")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedOn;
    @Column(name = "ACTIVE_STATUS")
    private String activeStatus; 
    
    public ReconAuthority(){
        
    }
    
    public ReconAuthority(String username, Double limit,String createdBy,Date createdOn,String lastUpdatedBy,Date lastUpdatedOn){
        this.username=username;
        this.limit=limit;
        this.createdBy=createdBy;
        this.createdOn=createdOn;
        this.lastUpdatedBy=lastUpdatedBy;
        this.lastUpdatedOn=lastUpdatedOn;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
     public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }
    
    
    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
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
        if (!(object instanceof ReconAuthority)) {
            return false;
        }
        ReconAuthority other = (ReconAuthority) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReconAuthority[ username=" + username + " ]";
    }
    
}
