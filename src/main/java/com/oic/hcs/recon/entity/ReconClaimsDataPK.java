/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author noaman000
 */
@Embeddable
public class ReconClaimsDataPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIM_ID")
    private BigInteger claimId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLAIM_ITEM")
    private BigInteger cclaimItem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RECON_ID")
    private String reconId;

    public ReconClaimsDataPK() {
    }

    public ReconClaimsDataPK(BigInteger claimId, BigInteger cclaimItem, String reconId) {
        this.claimId = claimId;
        this.cclaimItem = cclaimItem;
        this.reconId = reconId;
    }

    public BigInteger getClaimId() {
        return claimId;
    }

    public void setClaimId(BigInteger claimId) {
        this.claimId = claimId;
    }

    public BigInteger getCclaimItem() {
        return cclaimItem;
    }

    public void setCclaimItem(BigInteger cclaimItem) {
        this.cclaimItem = cclaimItem;
    }

    public String getReconId() {
        return reconId;
    }

    public void setReconId(String reconId) {
        this.reconId = reconId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claimId != null ? claimId.hashCode() : 0);
        hash += (cclaimItem != null ? cclaimItem.hashCode() : 0);
        hash += (reconId != null ? reconId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReconClaimsDataPK)) {
            return false;
        }
        ReconClaimsDataPK other = (ReconClaimsDataPK) object;
        if ((this.claimId == null && other.claimId != null) || (this.claimId != null && !this.claimId.equals(other.claimId))) {
            return false;
        }
        if ((this.cclaimItem == null && other.cclaimItem != null) || (this.cclaimItem != null && !this.cclaimItem.equals(other.cclaimItem))) {
            return false;
        }
        if ((this.reconId == null && other.reconId != null) || (this.reconId != null && !this.reconId.equals(other.reconId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReconClaimsDataPK[ claimId=" + claimId + ", cclaimItem=" + cclaimItem + ", reconId=" + reconId + " ]";
    }
    
}
