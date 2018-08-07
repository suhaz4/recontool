/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.utility;

import java.util.List;

/**
 *
 * @author noaman000
 */
public class DataAndSummary {
    private List dataList;
    private long totalCount;
    private double totalClaimedAmount;
    private double totalRejectedAmount;
    private double eligibleRejectedAmount;
    private double totalPatientShare;
    private double paidAmount;

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public double getTotalClaimedAmount() {
        return totalClaimedAmount;
    }

    public void setTotalClaimedAmount(double totalClaimedAmount) {
        this.totalClaimedAmount = totalClaimedAmount;
    }

    public double getTotalRejectedAmount() {
        return totalRejectedAmount;
    }

    public void setTotalRejectedAmount(double totalRejectedAmount) {
        this.totalRejectedAmount = totalRejectedAmount;
    }

    public double getEligibleRejectedAmount() {
        return eligibleRejectedAmount;
    }

    public void setEligibleRejectedAmount(double eligibleRejectedAmount) {
        this.eligibleRejectedAmount = eligibleRejectedAmount;
    }

    public double getTotalPatientShare() {
        return totalPatientShare;
    }

    public void setTotalPatientShare(double totalPatientShare) {
        this.totalPatientShare = totalPatientShare;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }
    
    public void setSummary(long totalCount,double totalClaimedAmount,double totalRejectedAmount,
            double eligibleRejectedAmount,double totalPatientShare,double paidAmount){
        this.totalCount = totalCount;
        this.totalClaimedAmount = totalClaimedAmount;
        this.totalRejectedAmount = totalRejectedAmount;
        this.eligibleRejectedAmount = eligibleRejectedAmount;
        this.totalPatientShare = totalPatientShare;
        this.paidAmount = paidAmount;
    }
}
