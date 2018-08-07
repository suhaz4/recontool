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

/**
 *
 * @author noaman000
 */
@Embeddable
public class CclaimItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLAIM_ID")
    private BigInteger cclaimId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLAIM_ITEM")
    private BigInteger cclaimItem;

    public CclaimItemPK() {
    }

    public CclaimItemPK(BigInteger cclaimId, BigInteger cclaimItem) {
        this.cclaimId = cclaimId;
        this.cclaimItem = cclaimItem;
    }

    public BigInteger getCclaimId() {
        return cclaimId;
    }

    public void setCclaimId(BigInteger cclaimId) {
        this.cclaimId = cclaimId;
    }

    public BigInteger getCclaimItem() {
        return cclaimItem;
    }

    public void setCclaimItem(BigInteger cclaimItem) {
        this.cclaimItem = cclaimItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cclaimId != null ? cclaimId.hashCode() : 0);
        hash += (cclaimItem != null ? cclaimItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CclaimItemPK)) {
            return false;
        }
        CclaimItemPK other = (CclaimItemPK) object;
        if ((this.cclaimId == null && other.cclaimId != null) || (this.cclaimId != null && !this.cclaimId.equals(other.cclaimId))) {
            return false;
        }
        if ((this.cclaimItem == null && other.cclaimItem != null) || (this.cclaimItem != null && !this.cclaimItem.equals(other.cclaimItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CclaimItemPK[ cclaimId=" + cclaimId + ", cclaimItem=" + cclaimItem + " ]";
    }
    
}
