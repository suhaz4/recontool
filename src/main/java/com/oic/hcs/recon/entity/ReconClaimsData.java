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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "RECON_CLAIMS_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReconClaimsData.findAll", query = "SELECT r FROM ReconClaimsData r"),
    @NamedQuery(name = "ReconClaimsData.findByClaimId", query = "SELECT r FROM ReconClaimsData r WHERE r.reconClaimsDataPK.claimId = :claimId"),
    @NamedQuery(name = "ReconClaimsData.findByCclaimItem", query = "SELECT r FROM ReconClaimsData r WHERE r.reconClaimsDataPK.cclaimItem = :cclaimItem"),
    @NamedQuery(name = "ReconClaimsData.findByInvoiceNum", query = "SELECT r FROM ReconClaimsData r WHERE r.invoiceNum = :invoiceNum"),
    @NamedQuery(name = "ReconClaimsData.findByMemberId", query = "SELECT r FROM ReconClaimsData r WHERE r.memberId = :memberId"),
    @NamedQuery(name = "ReconClaimsData.findByResubmissiontype", query = "SELECT r FROM ReconClaimsData r WHERE r.resubmissiontype = :resubmissiontype"),
    @NamedQuery(name = "ReconClaimsData.findByServiceDt", query = "SELECT r FROM ReconClaimsData r WHERE r.serviceDt = :serviceDt"),
    @NamedQuery(name = "ReconClaimsData.findByActivityId", query = "SELECT r FROM ReconClaimsData r WHERE r.activityId = :activityId"),
    @NamedQuery(name = "ReconClaimsData.findByDiagDescPrimary", query = "SELECT r FROM ReconClaimsData r WHERE r.diagDescPrimary = :diagDescPrimary"),
    @NamedQuery(name = "ReconClaimsData.findByDiagDescSecondary", query = "SELECT r FROM ReconClaimsData r WHERE r.diagDescSecondary = :diagDescSecondary"),
    @NamedQuery(name = "ReconClaimsData.findByBenefitType", query = "SELECT r FROM ReconClaimsData r WHERE r.benefitType = :benefitType"),
    @NamedQuery(name = "ReconClaimsData.findByBenefitCode", query = "SELECT r FROM ReconClaimsData r WHERE r.benefitCode = :benefitCode"),
    @NamedQuery(name = "ReconClaimsData.findByBenefitDesc", query = "SELECT r FROM ReconClaimsData r WHERE r.benefitDesc = :benefitDesc"),
    @NamedQuery(name = "ReconClaimsData.findByQuantity", query = "SELECT r FROM ReconClaimsData r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "ReconClaimsData.findByClinicianId", query = "SELECT r FROM ReconClaimsData r WHERE r.clinicianId = :clinicianId"),
    @NamedQuery(name = "ReconClaimsData.findByClinicianSpec", query = "SELECT r FROM ReconClaimsData r WHERE r.clinicianSpec = :clinicianSpec"),
    @NamedQuery(name = "ReconClaimsData.findByClaimedNet", query = "SELECT r FROM ReconClaimsData r WHERE r.claimedNet = :claimedNet"),
    @NamedQuery(name = "ReconClaimsData.findByDeductible", query = "SELECT r FROM ReconClaimsData r WHERE r.deductible = :deductible"),
    @NamedQuery(name = "ReconClaimsData.findByPaidAmt", query = "SELECT r FROM ReconClaimsData r WHERE r.paidAmt = :paidAmt"),
    @NamedQuery(name = "ReconClaimsData.findByRejEligibleAmt", query = "SELECT r FROM ReconClaimsData r WHERE r.rejEligibleAmt = :rejEligibleAmt"),
    @NamedQuery(name = "ReconClaimsData.findByTotalRejAmt", query = "SELECT r FROM ReconClaimsData r WHERE r.totalRejAmt = :totalRejAmt"),
    @NamedQuery(name = "ReconClaimsData.findByNewPayableAmt", query = "SELECT r FROM ReconClaimsData r WHERE r.newPayableAmt = :newPayableAmt"),
    @NamedQuery(name = "ReconClaimsData.findByDenialCd", query = "SELECT r FROM ReconClaimsData r WHERE r.denialCd = :denialCd"),
    @NamedQuery(name = "ReconClaimsData.findByNotes", query = "SELECT r FROM ReconClaimsData r WHERE r.notes = :notes"),
    @NamedQuery(name = "ReconClaimsData.findByPreauthId", query = "SELECT r FROM ReconClaimsData r WHERE r.preauthId = :preauthId"),
    @NamedQuery(name = "ReconClaimsData.findByUsername", query = "SELECT r FROM ReconClaimsData r WHERE r.username = :username"),
    @NamedQuery(name = "ReconClaimsData.findByReconId", query = "SELECT r FROM ReconClaimsData r WHERE r.reconClaimsDataPK.reconId = :reconId"),
    @NamedQuery(name = "ReconClaimsData.findByCreatedBy", query = "SELECT r FROM ReconClaimsData r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "ReconClaimsData.findByCreatedOn", query = "SELECT r FROM ReconClaimsData r WHERE r.createdOn = :createdOn"),
    @NamedQuery(name = "ReconClaimsData.findByLastUpdatedBy", query = "SELECT r FROM ReconClaimsData r WHERE r.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "ReconClaimsData.findByLastUpdatedOn", query = "SELECT r FROM ReconClaimsData r WHERE r.lastUpdatedOn = :lastUpdatedOn")})
public class ReconClaimsData implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReconClaimsDataPK reconClaimsDataPK;
    @Size(max = 100)
    @Column(name = "INVOICE_NUM")
    private String invoiceNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MEMBER_ID")
    private String memberId;
    @Size(max = 20)
    @Column(name = "RESUBMISSIONTYPE")
    private String resubmissiontype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDt;
    @Size(max = 50)
    @Column(name = "ACTIVITY_ID")
    private String activityId;
    @Size(max = 500)
    @Column(name = "DIAG_DESC_PRIMARY")
    private String diagDescPrimary;
    @Size(max = 500)
    @Column(name = "DIAG_DESC_SECONDARY")
    private String diagDescSecondary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "BENEFIT_TYPE")
    private String benefitType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BENEFIT_CODE")
    private String benefitCode;
    @Size(max = 2000)
    @Column(name = "BENEFIT_DESC")
    private String benefitDesc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTITY")
    private Double quantity;
    @Size(max = 30)
    @Column(name = "CLINICIAN_ID")
    private String clinicianId;
    @Size(max = 4)
    @Column(name = "CLINICIAN_SPEC")
    private String clinicianSpec;
    @Column(name = "CLAIMED_NET")
    private Double claimedNet;
    @Column(name = "DEDUCTIBLE")
    private Double deductible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAID_AMT")
    private Double paidAmt;
    @Column(name = "REJ_ELIGIBLE_AMT")
    private Double rejEligibleAmt;
    @Column(name = "TOTAL_REJ_AMT")
    private Double totalRejAmt;
    @Column(name = "NEW_PAYABLE_AMT")
    private Double newPayableAmt;
    @Size(max = 20)
    @Column(name = "DENIAL_CD")
    private String denialCd;
    @Size(max = 4000)
    @Column(name = "NOTES")
    private String notes;
    @Column(name = "PREAUTH_ID")
    private String preauthId;
    @Size(max = 12)
    @Column(name = "USERNAME")
    private String username;
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

    public ReconClaimsData() {
    }

    public ReconClaimsData(ReconClaimsDataPK reconClaimsDataPK) {
        this.reconClaimsDataPK = reconClaimsDataPK;
    }

    public ReconClaimsData(ReconClaimsDataPK reconClaimsDataPK, String memberId, Date serviceDt, String benefitType, String benefitCode, Double paidAmt) {
        this.reconClaimsDataPK = reconClaimsDataPK;
        this.memberId = memberId;
        this.serviceDt = serviceDt;
        this.benefitType = benefitType;
        this.benefitCode = benefitCode;
        this.paidAmt = paidAmt;
    }

    public ReconClaimsData(BigInteger claimId, BigInteger cclaimItem, String reconId) {
        this.reconClaimsDataPK = new ReconClaimsDataPK(claimId, cclaimItem, reconId);
    }

    public ReconClaimsDataPK getReconClaimsDataPK() {
        return reconClaimsDataPK;
    }

    public void setReconClaimsDataPK(ReconClaimsDataPK reconClaimsDataPK) {
        this.reconClaimsDataPK = reconClaimsDataPK;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getResubmissiontype() {
        return resubmissiontype;
    }

    public void setResubmissiontype(String resubmissiontype) {
        this.resubmissiontype = resubmissiontype;
    }

    public Date getServiceDt() {
        return serviceDt;
    }

    public void setServiceDt(Date serviceDt) {
        this.serviceDt = serviceDt;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getDiagDescPrimary() {
        return diagDescPrimary;
    }

    public void setDiagDescPrimary(String diagDescPrimary) {
        this.diagDescPrimary = diagDescPrimary;
    }

    public String getDiagDescSecondary() {
        return diagDescSecondary;
    }

    public void setDiagDescSecondary(String diagDescSecondary) {
        this.diagDescSecondary = diagDescSecondary;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitDesc() {
        return benefitDesc;
    }

    public void setBenefitDesc(String benefitDesc) {
        this.benefitDesc = benefitDesc;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public void setClinicianId(String clinicianId) {
        this.clinicianId = clinicianId;
    }

    public String getClinicianSpec() {
        return clinicianSpec;
    }

    public void setClinicianSpec(String clinicianSpec) {
        this.clinicianSpec = clinicianSpec;
    }

    public Double getClaimedNet() {
        return claimedNet;
    }

    public void setClaimedNet(Double claimedNet) {
        this.claimedNet = claimedNet;
    }

    public Double getDeductible() {
        return deductible;
    }

    public void setDeductible(Double deductible) {
        this.deductible = deductible;
    }

    public Double getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(Double paidAmt) {
        this.paidAmt = paidAmt;
    }

    public Double getRejEligibleAmt() {
        return rejEligibleAmt;
    }

    public void setRejEligibleAmt(Double rejEligibleAmt) {
        this.rejEligibleAmt = rejEligibleAmt;
    }

    public Double getTotalRejAmt() {
        return totalRejAmt;
    }

    public void setTotalRejAmt(Double totalRejAmt) {
        this.totalRejAmt = totalRejAmt;
    }

    public Double getNewPayableAmt() {
        return newPayableAmt;
    }

    public void setNewPayableAmt(Double newPayableAmt) {
        this.newPayableAmt = newPayableAmt;
    }

    public String getDenialCd() {
        return denialCd;
    }

    public void setDenialCd(String denialCd) {
        this.denialCd = denialCd;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPreauthId() {
        return preauthId;
    }

    public void setPreauthId(String preauthId) {
        this.preauthId = preauthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reconClaimsDataPK != null ? reconClaimsDataPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReconClaimsData)) {
            return false;
        }
        ReconClaimsData other = (ReconClaimsData) object;
        if ((this.reconClaimsDataPK == null && other.reconClaimsDataPK != null) || (this.reconClaimsDataPK != null && !this.reconClaimsDataPK.equals(other.reconClaimsDataPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReconClaimsData[ reconClaimsDataPK=" + reconClaimsDataPK + " ]";
    }
    
}
