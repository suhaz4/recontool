/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.util.Date;

/**
 *
 * @author noaman000
 */
public class CompletedReconData {
    private String reconId;
    private String newClaimId;
    private String oldClaimId;
    private Date transferDt;
    private Date paidDt;
    private String chqEftNum;
    private String prvdLocationCode;
    private String createId;
    private Date createDtime;
    private String reconType;
    private double paidAmt;

    public String getReconId() {
        return reconId;
    }

    public void setReconId(String reconId) {
        this.reconId = reconId;
    }

    public String getNewClaimId() {
        return newClaimId;
    }

    public void setNewClaimId(String newClaimId) {
        this.newClaimId = newClaimId;
    }

    public String getOldClaimId() {
        return oldClaimId;
    }

    public void setOldClaimId(String oldClaimId) {
        this.oldClaimId = oldClaimId;
    }

    public Date getTransferDt() {
        return transferDt;
    }

    public void setTransferDt(Date transferDt) {
        this.transferDt = transferDt;
    }

    public Date getPaidDt() {
        return paidDt;
    }

    public void setPaidDt(Date paidDt) {
        this.paidDt = paidDt;
    }

    public String getChqEftNum() {
        return chqEftNum;
    }

    public void setChqEftNum(String chqEftNum) {
        this.chqEftNum = chqEftNum;
    }

    public String getPrvdLocationCode() {
        return prvdLocationCode;
    }

    public void setPrvdLocationCode(String prvdLocationCode) {
        this.prvdLocationCode = prvdLocationCode;
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

    public String getReconType() {
        return reconType;
    }

    public void setReconType(String reconType) {
        this.reconType = reconType;
    }

    public double getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(double paidAmt) {
        this.paidAmt = paidAmt;
    }
        
    
}
