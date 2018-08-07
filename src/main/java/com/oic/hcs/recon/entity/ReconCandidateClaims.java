/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author noaman000
 */
@Entity
@Table(name = "RECON_CANDIDATE_CLAIMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReconCandidateClaims.findAll", query = "SELECT r FROM ReconCandidateClaims r"),
    @NamedQuery(name = "ReconCandidateClaims.findByClaimId", query = "SELECT r FROM ReconCandidateClaims r WHERE r.reconCandidateClaimsPK.claimId = :claimId"),
    @NamedQuery(name = "ReconCandidateClaims.findByLocationCd", query = "SELECT r FROM ReconCandidateClaims r WHERE r.reconCandidateClaimsPK.locationCd = :locationCd"),
    @NamedQuery(name = "ReconCandidateClaims.findByReconId", query = "SELECT r FROM ReconCandidateClaims r WHERE r.reconCandidateClaimsPK.reconId = :reconId"),
    @NamedQuery(name = "ReconCandidateClaims.findByCreatedBy", query = "SELECT r FROM ReconCandidateClaims r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "ReconCandidateClaims.findByCreatedOn", query = "SELECT r FROM ReconCandidateClaims r WHERE r.createdOn = :createdOn"),
    @NamedQuery(name = "ReconCandidateClaims.findByLastUpdatedBy", query = "SELECT r FROM ReconCandidateClaims r WHERE r.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "ReconCandidateClaims.findByLastUpdatedOn", query = "SELECT r FROM ReconCandidateClaims r WHERE r.lastUpdatedOn = :lastUpdatedOn")})
public class ReconCandidateClaims implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReconCandidateClaimsPK reconCandidateClaimsPK;
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
    @Size(max = 2)
    @Column(name = "RECON_TYPE")
    private String reconType;
    @Column(name = "FROZEN")
    private Integer frozen;
    

    public ReconCandidateClaims(ReconCandidateClaimsPK reconCandidateClaimsPK) {
        this.reconCandidateClaimsPK = reconCandidateClaimsPK;
    }

    public ReconCandidateClaims(BigInteger claimId, String locationCd, String reconId) {
        this.reconCandidateClaimsPK = new ReconCandidateClaimsPK(claimId, locationCd, reconId);
    }

    public ReconCandidateClaimsPK getReconCandidateClaimsPK() {
        return reconCandidateClaimsPK;
    }

    public void setReconCandidateClaimsPK(ReconCandidateClaimsPK reconCandidateClaimsPK) {
        this.reconCandidateClaimsPK = reconCandidateClaimsPK;
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
    
    public String getReconType() {
        return reconType;
    }

    public void setReconType(String reconType) {
        this.reconType = reconType;
    }

    public ReconCandidateClaims() {
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reconCandidateClaimsPK != null ? reconCandidateClaimsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReconCandidateClaims)) {
            return false;
        }
        ReconCandidateClaims other = (ReconCandidateClaims) object;
        if ((this.reconCandidateClaimsPK == null && other.reconCandidateClaimsPK != null) || (this.reconCandidateClaimsPK != null && !this.reconCandidateClaimsPK.equals(other.reconCandidateClaimsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReconCandidateClaims[ reconCandidateClaimsPK=" + reconCandidateClaimsPK + " ]";
    }
    
}
