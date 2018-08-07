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
@Table(name = "RECON_CLAIM_ITEMS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReconClaimItems.findAll", query = "SELECT r FROM ReconClaimItems r"),
    @NamedQuery(name = "ReconClaimItems.findByCclaimId", query = "SELECT r FROM ReconClaimItems r WHERE r.reconClaimItemsPK.cclaimId = :cclaimId"),
    @NamedQuery(name = "ReconClaimItems.findByCclaimItem", query = "SELECT r FROM ReconClaimItems r WHERE r.reconClaimItemsPK.cclaimItem = :cclaimItem"),
    @NamedQuery(name = "ReconClaimItems.findByItemStatus", query = "SELECT r FROM ReconClaimItems r WHERE r.itemStatus = :itemStatus"),
    @NamedQuery(name = "ReconClaimItems.findByItemStatusDt", query = "SELECT r FROM ReconClaimItems r WHERE r.itemStatusDt = :itemStatusDt"),
    @NamedQuery(name = "ReconClaimItems.findByBenefitType", query = "SELECT r FROM ReconClaimItems r WHERE r.benefitType = :benefitType"),
    @NamedQuery(name = "ReconClaimItems.findByBenefit", query = "SELECT r FROM ReconClaimItems r WHERE r.benefit = :benefit"),
    @NamedQuery(name = "ReconClaimItems.findByServiceDt", query = "SELECT r FROM ReconClaimItems r WHERE r.serviceDt = :serviceDt"),
    @NamedQuery(name = "ReconClaimItems.findByClaimedUnitPrice", query = "SELECT r FROM ReconClaimItems r WHERE r.claimedUnitPrice = :claimedUnitPrice"),
    @NamedQuery(name = "ReconClaimItems.findByCpredIdent", query = "SELECT r FROM ReconClaimItems r WHERE r.cpredIdent = :cpredIdent"),
    @NamedQuery(name = "ReconClaimItems.findByInvoiceNum", query = "SELECT r FROM ReconClaimItems r WHERE r.invoiceNum = :invoiceNum"),
    @NamedQuery(name = "ReconClaimItems.findByInvoiceDt", query = "SELECT r FROM ReconClaimItems r WHERE r.invoiceDt = :invoiceDt"),
    @NamedQuery(name = "ReconClaimItems.findByWorkRelatedClaim", query = "SELECT r FROM ReconClaimItems r WHERE r.workRelatedClaim = :workRelatedClaim"),
    @NamedQuery(name = "ReconClaimItems.findByInpatientClaim", query = "SELECT r FROM ReconClaimItems r WHERE r.inpatientClaim = :inpatientClaim"),
    @NamedQuery(name = "ReconClaimItems.findByEmergencyClaim", query = "SELECT r FROM ReconClaimItems r WHERE r.emergencyClaim = :emergencyClaim"),
    @NamedQuery(name = "ReconClaimItems.findByAccidentClaim", query = "SELECT r FROM ReconClaimItems r WHERE r.accidentClaim = :accidentClaim"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdLocCdRef", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdLocCdRef = :prvdLocCdRef"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdLocCd", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdLocCd = :prvdLocCd"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnCdRef", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnCdRef = :prvdPrsnCdRef"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnCd", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnCd = :prvdPrsnCd"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnSpec", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnSpec = :prvdPrsnSpec"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnAreaCd", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnAreaCd = :prvdPrsnAreaCd"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdLocAreaCd", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdLocAreaCd = :prvdLocAreaCd"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdLocCdRef", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdLocCdRef = :rprvdLocCdRef"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdLocCd", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdLocCd = :rprvdLocCd"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdPrsnSpec", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdPrsnSpec = :rprvdPrsnSpec"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdPrsnCdRef", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdPrsnCdRef = :rprvdPrsnCdRef"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdPrsnCd", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdPrsnCd = :rprvdPrsnCd"),
    @NamedQuery(name = "ReconClaimItems.findByRefillCd", query = "SELECT r FROM ReconClaimItems r WHERE r.refillCd = :refillCd"),
    @NamedQuery(name = "ReconClaimItems.findByRefillAuth", query = "SELECT r FROM ReconClaimItems r WHERE r.refillAuth = :refillAuth"),
    @NamedQuery(name = "ReconClaimItems.findByOriginalRxNum", query = "SELECT r FROM ReconClaimItems r WHERE r.originalRxNum = :originalRxNum"),
    @NamedQuery(name = "ReconClaimItems.findByCurrentRxNum", query = "SELECT r FROM ReconClaimItems r WHERE r.currentRxNum = :currentRxNum"),
    @NamedQuery(name = "ReconClaimItems.findByDaysSupply", query = "SELECT r FROM ReconClaimItems r WHERE r.daysSupply = :daysSupply"),
    @NamedQuery(name = "ReconClaimItems.findByHospitalAdmitDt", query = "SELECT r FROM ReconClaimItems r WHERE r.hospitalAdmitDt = :hospitalAdmitDt"),
    @NamedQuery(name = "ReconClaimItems.findByHospitalDischargeDt", query = "SELECT r FROM ReconClaimItems r WHERE r.hospitalDischargeDt = :hospitalDischargeDt"),
    @NamedQuery(name = "ReconClaimItems.findByQuantity", query = "SELECT r FROM ReconClaimItems r WHERE r.quantity = :quantity"),
    @NamedQuery(name = "ReconClaimItems.findByDiagCdPrimary", query = "SELECT r FROM ReconClaimItems r WHERE r.diagCdPrimary = :diagCdPrimary"),
    @NamedQuery(name = "ReconClaimItems.findByDiagCdSecondary", query = "SELECT r FROM ReconClaimItems r WHERE r.diagCdSecondary = :diagCdSecondary"),
    @NamedQuery(name = "ReconClaimItems.findByDiagCdOther", query = "SELECT r FROM ReconClaimItems r WHERE r.diagCdOther = :diagCdOther"),
    @NamedQuery(name = "ReconClaimItems.findBySegmentCd", query = "SELECT r FROM ReconClaimItems r WHERE r.segmentCd = :segmentCd"),
    @NamedQuery(name = "ReconClaimItems.findByToothSurfaces", query = "SELECT r FROM ReconClaimItems r WHERE r.toothSurfaces = :toothSurfaces"),
    @NamedQuery(name = "ReconClaimItems.findByDlabProcCd", query = "SELECT r FROM ReconClaimItems r WHERE r.dlabProcCd = :dlabProcCd"),
    @NamedQuery(name = "ReconClaimItems.findByDlabClaimedAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.dlabClaimedAmt = :dlabClaimedAmt"),
    @NamedQuery(name = "ReconClaimItems.findByCoverrides", query = "SELECT r FROM ReconClaimItems r WHERE r.coverrides = :coverrides"),
    @NamedQuery(name = "ReconClaimItems.findByCreimburseAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.creimburseAmt = :creimburseAmt"),
    @NamedQuery(name = "ReconClaimItems.findByClaimCopay", query = "SELECT r FROM ReconClaimItems r WHERE r.claimCopay = :claimCopay"),
    @NamedQuery(name = "ReconClaimItems.findByClaimDeductible", query = "SELECT r FROM ReconClaimItems r WHERE r.claimDeductible = :claimDeductible"),
    @NamedQuery(name = "ReconClaimItems.findByClaimCoinsurance", query = "SELECT r FROM ReconClaimItems r WHERE r.claimCoinsurance = :claimCoinsurance"),
    @NamedQuery(name = "ReconClaimItems.findByClaimOverMax", query = "SELECT r FROM ReconClaimItems r WHERE r.claimOverMax = :claimOverMax"),
    @NamedQuery(name = "ReconClaimItems.findByMsgLogStream", query = "SELECT r FROM ReconClaimItems r WHERE r.msgLogStream = :msgLogStream"),
    @NamedQuery(name = "ReconClaimItems.findByReimburseType", query = "SELECT r FROM ReconClaimItems r WHERE r.reimburseType = :reimburseType"),
    @NamedQuery(name = "ReconClaimItems.findByConcurrentSpouse", query = "SELECT r FROM ReconClaimItems r WHERE r.concurrentSpouse = :concurrentSpouse"),
    @NamedQuery(name = "ReconClaimItems.findByThirdCfeegdId", query = "SELECT r FROM ReconClaimItems r WHERE r.thirdCfeegdId = :thirdCfeegdId"),
    @NamedQuery(name = "ReconClaimItems.findByFruleIds", query = "SELECT r FROM ReconClaimItems r WHERE r.fruleIds = :fruleIds"),
    @NamedQuery(name = "ReconClaimItems.findByBenefitGenderInd", query = "SELECT r FROM ReconClaimItems r WHERE r.benefitGenderInd = :benefitGenderInd"),
    @NamedQuery(name = "ReconClaimItems.findByFrstDiagBlockId", query = "SELECT r FROM ReconClaimItems r WHERE r.frstDiagBlockId = :frstDiagBlockId"),
    @NamedQuery(name = "ReconClaimItems.findByMembDebitFor", query = "SELECT r FROM ReconClaimItems r WHERE r.membDebitFor = :membDebitFor"),
    @NamedQuery(name = "ReconClaimItems.findByMembDebitAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.membDebitAmt = :membDebitAmt"),
    @NamedQuery(name = "ReconClaimItems.findByMembOverpayAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.membOverpayAmt = :membOverpayAmt"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdDebitAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdDebitAmt = :prvdDebitAmt"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdLocId", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdLocId = :prvdLocId"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnId", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnId = :prvdPrsnId"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdLocId", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdLocId = :rprvdLocId"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdPrsnId", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdPrsnId = :rprvdPrsnId"),
    @NamedQuery(name = "ReconClaimItems.findByCregItem", query = "SELECT r FROM ReconClaimItems r WHERE r.cregItem = :cregItem"),
    @NamedQuery(name = "ReconClaimItems.findByCpredId", query = "SELECT r FROM ReconClaimItems r WHERE r.cpredId = :cpredId"),
    @NamedQuery(name = "ReconClaimItems.findByCpredItem", query = "SELECT r FROM ReconClaimItems r WHERE r.cpredItem = :cpredItem"),
    @NamedQuery(name = "ReconClaimItems.findByDiscAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.discAmt = :discAmt"),
    @NamedQuery(name = "ReconClaimItems.findByDiscPerc", query = "SELECT r FROM ReconClaimItems r WHERE r.discPerc = :discPerc"),
    @NamedQuery(name = "ReconClaimItems.findByDiscPercAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.discPercAmt = :discPercAmt"),
    @NamedQuery(name = "ReconClaimItems.findByEligDlabProcFee", query = "SELECT r FROM ReconClaimItems r WHERE r.eligDlabProcFee = :eligDlabProcFee"),
    @NamedQuery(name = "ReconClaimItems.findByEligDaysSupply", query = "SELECT r FROM ReconClaimItems r WHERE r.eligDaysSupply = :eligDaysSupply"),
    @NamedQuery(name = "ReconClaimItems.findByEligQuantity", query = "SELECT r FROM ReconClaimItems r WHERE r.eligQuantity = :eligQuantity"),
    @NamedQuery(name = "ReconClaimItems.findByEligUnitPrice", query = "SELECT r FROM ReconClaimItems r WHERE r.eligUnitPrice = :eligUnitPrice"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdDebitAmt", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdDebitAmt = :rprvdDebitAmt"),
    @NamedQuery(name = "ReconClaimItems.findByAcceptAssign", query = "SELECT r FROM ReconClaimItems r WHERE r.acceptAssign = :acceptAssign"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdPrsnType", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdPrsnType = :prvdPrsnType"),
    @NamedQuery(name = "ReconClaimItems.findByPrvdLocType", query = "SELECT r FROM ReconClaimItems r WHERE r.prvdLocType = :prvdLocType"),
    @NamedQuery(name = "ReconClaimItems.findByRacceptAssign", query = "SELECT r FROM ReconClaimItems r WHERE r.racceptAssign = :racceptAssign"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdPrsnType", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdPrsnType = :rprvdPrsnType"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdLocType", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdLocType = :rprvdLocType"),
    @NamedQuery(name = "ReconClaimItems.findByRprvdLocAreaCd", query = "SELECT r FROM ReconClaimItems r WHERE r.rprvdLocAreaCd = :rprvdLocAreaCd"),
    @NamedQuery(name = "ReconClaimItems.findByCpredType", query = "SELECT r FROM ReconClaimItems r WHERE r.cpredType = :cpredType"),
    @NamedQuery(name = "ReconClaimItems.findByAccidentDtime", query = "SELECT r FROM ReconClaimItems r WHERE r.accidentDtime = :accidentDtime"),
    @NamedQuery(name = "ReconClaimItems.findByClassfn", query = "SELECT r FROM ReconClaimItems r WHERE r.classfn = :classfn"),
    @NamedQuery(name = "ReconClaimItems.findByClassfnValue", query = "SELECT r FROM ReconClaimItems r WHERE r.classfnValue = :classfnValue"),
    @NamedQuery(name = "ReconClaimItems.findByCplanCd", query = "SELECT r FROM ReconClaimItems r WHERE r.cplanCd = :cplanCd"),
    @NamedQuery(name = "ReconClaimItems.findByDsubplanCd", query = "SELECT r FROM ReconClaimItems r WHERE r.dsubplanCd = :dsubplanCd"),
    @NamedQuery(name = "ReconClaimItems.findByMsubplanCd", query = "SELECT r FROM ReconClaimItems r WHERE r.msubplanCd = :msubplanCd"),
    @NamedQuery(name = "ReconClaimItems.findByPredReceivedDtime", query = "SELECT r FROM ReconClaimItems r WHERE r.predReceivedDtime = :predReceivedDtime"),
    @NamedQuery(name = "ReconClaimItems.findByNotes", query = "SELECT r FROM ReconClaimItems r WHERE r.notes = :notes"),
    @NamedQuery(name = "ReconClaimItems.findByCreateId", query = "SELECT r FROM ReconClaimItems r WHERE r.createId = :createId"),
    @NamedQuery(name = "ReconClaimItems.findByCreateDtime", query = "SELECT r FROM ReconClaimItems r WHERE r.createDtime = :createDtime"),
    @NamedQuery(name = "ReconClaimItems.findByRemitted", query = "SELECT r FROM ReconClaimItems r WHERE r.remitted = :remitted"),
    @NamedQuery(name = "ReconClaimItems.findByDenialCd", query = "SELECT r FROM ReconClaimItems r WHERE r.denialCd = :denialCd"),
    @NamedQuery(name = "ReconClaimItems.findByPenalties", query = "SELECT r FROM ReconClaimItems r WHERE r.penalties = :penalties"),
    @NamedQuery(name = "ReconClaimItems.findByActivityNet", query = "SELECT r FROM ReconClaimItems r WHERE r.activityNet = :activityNet"),
    @NamedQuery(name = "ReconClaimItems.findByCreatedBy", query = "SELECT r FROM ReconClaimItems r WHERE r.createdBy = :createdBy"),
    @NamedQuery(name = "ReconClaimItems.findByCreatedOn", query = "SELECT r FROM ReconClaimItems r WHERE r.createdOn = :createdOn"),
    @NamedQuery(name = "ReconClaimItems.findByLastUpdatedBy", query = "SELECT r FROM ReconClaimItems r WHERE r.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "ReconClaimItems.findByLastUpdatedOn", query = "SELECT r FROM ReconClaimItems r WHERE r.lastUpdatedOn = :lastUpdatedOn"),
    @NamedQuery(name = "ReconClaimItems.findByReconId", query = "SELECT r FROM ReconClaimItems r WHERE r.reconId = :reconId")})
public class ReconClaimItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReconClaimItemsPK reconClaimItemsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ITEM_STATUS")
    private String itemStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_STATUS_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemStatusDt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "BENEFIT_TYPE")
    private String benefitType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "BENEFIT")
    private String benefit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIMED_UNIT_PRICE")
    private Double claimedUnitPrice;
    @Column(name = "CPRED_IDENT")
    private BigInteger cpredIdent;
    @Size(max = 50)
    @Column(name = "INVOICE_NUM")
    private String invoiceNum;
    @Column(name = "INVOICE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORK_RELATED_CLAIM")
    private BigInteger workRelatedClaim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INPATIENT_CLAIM")
    private BigInteger inpatientClaim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMERGENCY_CLAIM")
    private BigInteger emergencyClaim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCIDENT_CLAIM")
    private BigInteger accidentClaim;
    @Size(max = 30)
    @Column(name = "PRVD_LOC_CD_REF")
    private String prvdLocCdRef;
    @Size(max = 30)
    @Column(name = "PRVD_LOC_CD")
    private String prvdLocCd;
    @Size(max = 30)
    @Column(name = "PRVD_PRSN_CD_REF")
    private String prvdPrsnCdRef;
    @Size(max = 30)
    @Column(name = "PRVD_PRSN_CD")
    private String prvdPrsnCd;
    @Size(max = 4)
    @Column(name = "PRVD_PRSN_SPEC")
    private String prvdPrsnSpec;
    @Size(max = 6)
    @Column(name = "PRVD_PRSN_AREA_CD")
    private String prvdPrsnAreaCd;
    @Size(max = 6)
    @Column(name = "PRVD_LOC_AREA_CD")
    private String prvdLocAreaCd;
    @Size(max = 30)
    @Column(name = "RPRVD_LOC_CD_REF")
    private String rprvdLocCdRef;
    @Size(max = 30)
    @Column(name = "RPRVD_LOC_CD")
    private String rprvdLocCd;
    @Size(max = 4)
    @Column(name = "RPRVD_PRSN_SPEC")
    private String rprvdPrsnSpec;
    @Size(max = 30)
    @Column(name = "RPRVD_PRSN_CD_REF")
    private String rprvdPrsnCdRef;
    @Size(max = 30)
    @Column(name = "RPRVD_PRSN_CD")
    private String rprvdPrsnCd;
    @Size(max = 1)
    @Column(name = "REFILL_CD")
    private String refillCd;
    @Column(name = "REFILL_AUTH")
    private BigInteger refillAuth;
    @Size(max = 50)
    @Column(name = "ORIGINAL_RX_NUM")
    private String originalRxNum;
    @Size(max = 9)
    @Column(name = "CURRENT_RX_NUM")
    private String currentRxNum;
    @Column(name = "DAYS_SUPPLY")
    private BigInteger daysSupply;
    @Column(name = "HOSPITAL_ADMIT_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hospitalAdmitDt;
    @Column(name = "HOSPITAL_DISCHARGE_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hospitalDischargeDt;
    @Column(name = "QUANTITY")
    private Double quantity;
    @Size(max = 15)
    @Column(name = "DIAG_CD_PRIMARY")
    private String diagCdPrimary;
    @Size(max = 15)
    @Column(name = "DIAG_CD_SECONDARY")
    private String diagCdSecondary;
    @Size(max = 15)
    @Column(name = "DIAG_CD_OTHER")
    private String diagCdOther;
    @Size(max = 2)
    @Column(name = "SEGMENT_CD")
    private String segmentCd;
    @Size(max = 10)
    @Column(name = "TOOTH_SURFACES")
    private String toothSurfaces;
    @Size(max = 5)
    @Column(name = "DLAB_PROC_CD")
    private String dlabProcCd;
    @Column(name = "DLAB_CLAIMED_AMT")
    private Double dlabClaimedAmt;
    @Size(max = 200)
    @Column(name = "COVERRIDES")
    private String coverrides;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREIMBURSE_AMT")
    private Double creimburseAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIM_COPAY")
    private Double claimCopay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIM_DEDUCTIBLE")
    private Double claimDeductible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIM_COINSURANCE")
    private Double claimCoinsurance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLAIM_OVER_MAX")
    private Double claimOverMax;
    @Size(max = 4000)
    @Column(name = "MSG_LOG_STREAM")
    private String msgLogStream;
    @Column(name = "REIMBURSE_TYPE")
    private BigInteger reimburseType;
    @Column(name = "CONCURRENT_SPOUSE")
    private BigInteger concurrentSpouse;
    @Column(name = "THIRD_CFEEGD_ID")
    private BigInteger thirdCfeegdId;
    @Size(max = 200)
    @Column(name = "FRULE_IDS")
    private String fruleIds;
    @Column(name = "BENEFIT_GENDER_IND")
    private BigInteger benefitGenderInd;
    @Column(name = "FRST_DIAG_BLOCK_ID")
    private BigInteger frstDiagBlockId;
    @Column(name = "MEMB_DEBIT_FOR")
    private BigInteger membDebitFor;
    @Column(name = "MEMB_DEBIT_AMT")
    private Double membDebitAmt;
    @Column(name = "MEMB_OVERPAY_AMT")
    private Double membOverpayAmt;
    @Column(name = "PRVD_DEBIT_AMT")
    private Double prvdDebitAmt;
    @Column(name = "PRVD_LOC_ID")
    private BigInteger prvdLocId;
    @Column(name = "PRVD_PRSN_ID")
    private BigInteger prvdPrsnId;
    @Column(name = "RPRVD_LOC_ID")
    private BigInteger rprvdLocId;
    @Column(name = "RPRVD_PRSN_ID")
    private BigInteger rprvdPrsnId;
    @Column(name = "CREG_ITEM")
    private BigInteger cregItem;
    @Column(name = "CPRED_ID")
    private BigInteger cpredId;
    @Column(name = "CPRED_ITEM")
    private BigInteger cpredItem;
    @Column(name = "DISC_AMT")
    private Double discAmt;
    @Column(name = "DISC_PERC")
    private Double discPerc;
    @Column(name = "DISC_PERC_AMT")
    private Double discPercAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIG_DLAB_PROC_FEE")
    private Double eligDlabProcFee;
    @Column(name = "ELIG_DAYS_SUPPLY")
    private BigInteger eligDaysSupply;
    @Column(name = "ELIG_QUANTITY")
    private Double eligQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ELIG_UNIT_PRICE")
    private Double eligUnitPrice;
    @Column(name = "RPRVD_DEBIT_AMT")
    private Double rprvdDebitAmt;
    @Column(name = "ACCEPT_ASSIGN")
    private BigInteger acceptAssign;
    @Size(max = 4)
    @Column(name = "PRVD_PRSN_TYPE")
    private String prvdPrsnType;
    @Size(max = 4)
    @Column(name = "PRVD_LOC_TYPE")
    private String prvdLocType;
    @Column(name = "RACCEPT_ASSIGN")
    private BigInteger racceptAssign;
    @Size(max = 4)
    @Column(name = "RPRVD_PRSN_TYPE")
    private String rprvdPrsnType;
    @Size(max = 4)
    @Column(name = "RPRVD_LOC_TYPE")
    private String rprvdLocType;
    @Size(max = 6)
    @Column(name = "RPRVD_LOC_AREA_CD")
    private String rprvdLocAreaCd;
    @Column(name = "CPRED_TYPE")
    private BigInteger cpredType;
    @Column(name = "ACCIDENT_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accidentDtime;
    @Size(max = 4)
    @Column(name = "CLASSFN")
    private String classfn;
    @Size(max = 8)
    @Column(name = "CLASSFN_VALUE")
    private String classfnValue;
    @Size(max = 10)
    @Column(name = "CPLAN_CD")
    private String cplanCd;
    @Size(max = 10)
    @Column(name = "DSUBPLAN_CD")
    private String dsubplanCd;
    @Size(max = 10)
    @Column(name = "MSUBPLAN_CD")
    private String msubplanCd;
    @Column(name = "PRED_RECEIVED_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date predReceivedDtime;
    @Size(max = 4000)
    @Column(name = "NOTES")
    private String notes;
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
    @Column(name = "REMITTED")
    private Short remitted;
    @Size(max = 20)
    @Column(name = "DENIAL_CD")
    private String denialCd;
    @Column(name = "PENALTIES")
    private Double penalties;
    @Column(name = "ACTIVITY_NET")
    private Double activityNet;
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
    @Size(max = 100)
    @Column(name = "RECON_ID")
    private String reconId;
    @Size(max = 2)
    @Column(name = "RECON_TYPE")
    private String reconType;
    @Column(name = "FROZEN")
    private Integer frozen;

    
    public ReconClaimItems() {
    }

    public ReconClaimItems(ReconClaimItemsPK reconClaimItemsPK) {
        this.reconClaimItemsPK = reconClaimItemsPK;
    }

    public ReconClaimItems(ReconClaimItemsPK reconClaimItemsPK, String itemStatus, Date itemStatusDt, String benefitType, String benefit, Date serviceDt, Double claimedUnitPrice, BigInteger workRelatedClaim, BigInteger inpatientClaim, BigInteger emergencyClaim, BigInteger accidentClaim, Double creimburseAmt, Double claimCopay, Double claimDeductible, Double claimCoinsurance, Double claimOverMax, Double eligDlabProcFee, Double eligUnitPrice, String createId, Date createDtime) {
        this.reconClaimItemsPK = reconClaimItemsPK;
        this.itemStatus = itemStatus;
        this.itemStatusDt = itemStatusDt;
        this.benefitType = benefitType;
        this.benefit = benefit;
        this.serviceDt = serviceDt;
        this.claimedUnitPrice = claimedUnitPrice;
        this.workRelatedClaim = workRelatedClaim;
        this.inpatientClaim = inpatientClaim;
        this.emergencyClaim = emergencyClaim;
        this.accidentClaim = accidentClaim;
        this.creimburseAmt = creimburseAmt;
        this.claimCopay = claimCopay;
        this.claimDeductible = claimDeductible;
        this.claimCoinsurance = claimCoinsurance;
        this.claimOverMax = claimOverMax;
        this.eligDlabProcFee = eligDlabProcFee;
        this.eligUnitPrice = eligUnitPrice;
        this.createId = createId;
        this.createDtime = createDtime;
    }

    public ReconClaimItems(BigInteger cclaimId, BigInteger cclaimItem) {
        this.reconClaimItemsPK = new ReconClaimItemsPK(cclaimId, cclaimItem);
    }

    public ReconClaimItemsPK getReconClaimItemsPK() {
        return reconClaimItemsPK;
    }

    public void setReconClaimItemsPK(ReconClaimItemsPK reconClaimItemsPK) {
        this.reconClaimItemsPK = reconClaimItemsPK;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getItemStatusDt() {
        return itemStatusDt;
    }

    public void setItemStatusDt(Date itemStatusDt) {
        this.itemStatusDt = itemStatusDt;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Date getServiceDt() {
        return serviceDt;
    }

    public void setServiceDt(Date serviceDt) {
        this.serviceDt = serviceDt;
    }

    public Double getClaimedUnitPrice() {
        return claimedUnitPrice;
    }

    public void setClaimedUnitPrice(Double claimedUnitPrice) {
        this.claimedUnitPrice = claimedUnitPrice;
    }

    public BigInteger getCpredIdent() {
        return cpredIdent;
    }

    public void setCpredIdent(BigInteger cpredIdent) {
        this.cpredIdent = cpredIdent;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Date getInvoiceDt() {
        return invoiceDt;
    }

    public void setInvoiceDt(Date invoiceDt) {
        this.invoiceDt = invoiceDt;
    }

    public BigInteger getWorkRelatedClaim() {
        return workRelatedClaim;
    }

    public void setWorkRelatedClaim(BigInteger workRelatedClaim) {
        this.workRelatedClaim = workRelatedClaim;
    }

    public BigInteger getInpatientClaim() {
        return inpatientClaim;
    }

    public void setInpatientClaim(BigInteger inpatientClaim) {
        this.inpatientClaim = inpatientClaim;
    }

    public BigInteger getEmergencyClaim() {
        return emergencyClaim;
    }

    public void setEmergencyClaim(BigInteger emergencyClaim) {
        this.emergencyClaim = emergencyClaim;
    }

    public BigInteger getAccidentClaim() {
        return accidentClaim;
    }

    public void setAccidentClaim(BigInteger accidentClaim) {
        this.accidentClaim = accidentClaim;
    }

    public String getPrvdLocCdRef() {
        return prvdLocCdRef;
    }

    public void setPrvdLocCdRef(String prvdLocCdRef) {
        this.prvdLocCdRef = prvdLocCdRef;
    }

    public String getPrvdLocCd() {
        return prvdLocCd;
    }

    public void setPrvdLocCd(String prvdLocCd) {
        this.prvdLocCd = prvdLocCd;
    }

    public String getPrvdPrsnCdRef() {
        return prvdPrsnCdRef;
    }

    public void setPrvdPrsnCdRef(String prvdPrsnCdRef) {
        this.prvdPrsnCdRef = prvdPrsnCdRef;
    }

    public String getPrvdPrsnCd() {
        return prvdPrsnCd;
    }

    public void setPrvdPrsnCd(String prvdPrsnCd) {
        this.prvdPrsnCd = prvdPrsnCd;
    }

    public String getPrvdPrsnSpec() {
        return prvdPrsnSpec;
    }

    public void setPrvdPrsnSpec(String prvdPrsnSpec) {
        this.prvdPrsnSpec = prvdPrsnSpec;
    }

    public String getPrvdPrsnAreaCd() {
        return prvdPrsnAreaCd;
    }

    public void setPrvdPrsnAreaCd(String prvdPrsnAreaCd) {
        this.prvdPrsnAreaCd = prvdPrsnAreaCd;
    }

    public String getPrvdLocAreaCd() {
        return prvdLocAreaCd;
    }

    public void setPrvdLocAreaCd(String prvdLocAreaCd) {
        this.prvdLocAreaCd = prvdLocAreaCd;
    }

    public String getRprvdLocCdRef() {
        return rprvdLocCdRef;
    }

    public void setRprvdLocCdRef(String rprvdLocCdRef) {
        this.rprvdLocCdRef = rprvdLocCdRef;
    }

    public String getRprvdLocCd() {
        return rprvdLocCd;
    }

    public void setRprvdLocCd(String rprvdLocCd) {
        this.rprvdLocCd = rprvdLocCd;
    }

    public String getRprvdPrsnSpec() {
        return rprvdPrsnSpec;
    }

    public void setRprvdPrsnSpec(String rprvdPrsnSpec) {
        this.rprvdPrsnSpec = rprvdPrsnSpec;
    }

    public String getRprvdPrsnCdRef() {
        return rprvdPrsnCdRef;
    }

    public void setRprvdPrsnCdRef(String rprvdPrsnCdRef) {
        this.rprvdPrsnCdRef = rprvdPrsnCdRef;
    }

    public String getRprvdPrsnCd() {
        return rprvdPrsnCd;
    }

    public void setRprvdPrsnCd(String rprvdPrsnCd) {
        this.rprvdPrsnCd = rprvdPrsnCd;
    }

    public String getRefillCd() {
        return refillCd;
    }

    public void setRefillCd(String refillCd) {
        this.refillCd = refillCd;
    }

    public BigInteger getRefillAuth() {
        return refillAuth;
    }

    public void setRefillAuth(BigInteger refillAuth) {
        this.refillAuth = refillAuth;
    }

    public String getOriginalRxNum() {
        return originalRxNum;
    }

    public void setOriginalRxNum(String originalRxNum) {
        this.originalRxNum = originalRxNum;
    }

    public String getCurrentRxNum() {
        return currentRxNum;
    }

    public void setCurrentRxNum(String currentRxNum) {
        this.currentRxNum = currentRxNum;
    }

    public BigInteger getDaysSupply() {
        return daysSupply;
    }

    public void setDaysSupply(BigInteger daysSupply) {
        this.daysSupply = daysSupply;
    }

    public Date getHospitalAdmitDt() {
        return hospitalAdmitDt;
    }

    public void setHospitalAdmitDt(Date hospitalAdmitDt) {
        this.hospitalAdmitDt = hospitalAdmitDt;
    }

    public Date getHospitalDischargeDt() {
        return hospitalDischargeDt;
    }

    public void setHospitalDischargeDt(Date hospitalDischargeDt) {
        this.hospitalDischargeDt = hospitalDischargeDt;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getDiagCdPrimary() {
        return diagCdPrimary;
    }

    public void setDiagCdPrimary(String diagCdPrimary) {
        this.diagCdPrimary = diagCdPrimary;
    }

    public String getDiagCdSecondary() {
        return diagCdSecondary;
    }

    public void setDiagCdSecondary(String diagCdSecondary) {
        this.diagCdSecondary = diagCdSecondary;
    }

    public String getDiagCdOther() {
        return diagCdOther;
    }

    public void setDiagCdOther(String diagCdOther) {
        this.diagCdOther = diagCdOther;
    }

    public String getSegmentCd() {
        return segmentCd;
    }

    public void setSegmentCd(String segmentCd) {
        this.segmentCd = segmentCd;
    }

    public String getToothSurfaces() {
        return toothSurfaces;
    }

    public void setToothSurfaces(String toothSurfaces) {
        this.toothSurfaces = toothSurfaces;
    }

    public String getDlabProcCd() {
        return dlabProcCd;
    }

    public void setDlabProcCd(String dlabProcCd) {
        this.dlabProcCd = dlabProcCd;
    }

    public Double getDlabClaimedAmt() {
        return dlabClaimedAmt;
    }

    public void setDlabClaimedAmt(Double dlabClaimedAmt) {
        this.dlabClaimedAmt = dlabClaimedAmt;
    }

    public String getCoverrides() {
        return coverrides;
    }

    public void setCoverrides(String coverrides) {
        this.coverrides = coverrides;
    }

    public Double getCreimburseAmt() {
        return creimburseAmt;
    }

    public void setCreimburseAmt(Double creimburseAmt) {
        this.creimburseAmt = creimburseAmt;
    }

    public Double getClaimCopay() {
        return claimCopay;
    }

    public void setClaimCopay(Double claimCopay) {
        this.claimCopay = claimCopay;
    }

    public Double getClaimDeductible() {
        return claimDeductible;
    }

    public void setClaimDeductible(Double claimDeductible) {
        this.claimDeductible = claimDeductible;
    }

    public Double getClaimCoinsurance() {
        return claimCoinsurance;
    }

    public void setClaimCoinsurance(Double claimCoinsurance) {
        this.claimCoinsurance = claimCoinsurance;
    }

    public Double getClaimOverMax() {
        return claimOverMax;
    }

    public void setClaimOverMax(Double claimOverMax) {
        this.claimOverMax = claimOverMax;
    }

    public String getMsgLogStream() {
        return msgLogStream;
    }

    public void setMsgLogStream(String msgLogStream) {
        this.msgLogStream = msgLogStream;
    }

    public BigInteger getReimburseType() {
        return reimburseType;
    }

    public void setReimburseType(BigInteger reimburseType) {
        this.reimburseType = reimburseType;
    }

    public BigInteger getConcurrentSpouse() {
        return concurrentSpouse;
    }

    public void setConcurrentSpouse(BigInteger concurrentSpouse) {
        this.concurrentSpouse = concurrentSpouse;
    }

    public BigInteger getThirdCfeegdId() {
        return thirdCfeegdId;
    }

    public void setThirdCfeegdId(BigInteger thirdCfeegdId) {
        this.thirdCfeegdId = thirdCfeegdId;
    }

    public String getFruleIds() {
        return fruleIds;
    }

    public void setFruleIds(String fruleIds) {
        this.fruleIds = fruleIds;
    }

    public BigInteger getBenefitGenderInd() {
        return benefitGenderInd;
    }

    public void setBenefitGenderInd(BigInteger benefitGenderInd) {
        this.benefitGenderInd = benefitGenderInd;
    }

    public BigInteger getFrstDiagBlockId() {
        return frstDiagBlockId;
    }

    public void setFrstDiagBlockId(BigInteger frstDiagBlockId) {
        this.frstDiagBlockId = frstDiagBlockId;
    }

    public BigInteger getMembDebitFor() {
        return membDebitFor;
    }

    public void setMembDebitFor(BigInteger membDebitFor) {
        this.membDebitFor = membDebitFor;
    }

    public Double getMembDebitAmt() {
        return membDebitAmt;
    }

    public void setMembDebitAmt(Double membDebitAmt) {
        this.membDebitAmt = membDebitAmt;
    }

    public Double getMembOverpayAmt() {
        return membOverpayAmt;
    }

    public void setMembOverpayAmt(Double membOverpayAmt) {
        this.membOverpayAmt = membOverpayAmt;
    }

    public Double getPrvdDebitAmt() {
        return prvdDebitAmt;
    }

    public void setPrvdDebitAmt(Double prvdDebitAmt) {
        this.prvdDebitAmt = prvdDebitAmt;
    }

    public BigInteger getPrvdLocId() {
        return prvdLocId;
    }

    public void setPrvdLocId(BigInteger prvdLocId) {
        this.prvdLocId = prvdLocId;
    }

    public BigInteger getPrvdPrsnId() {
        return prvdPrsnId;
    }

    public void setPrvdPrsnId(BigInteger prvdPrsnId) {
        this.prvdPrsnId = prvdPrsnId;
    }

    public BigInteger getRprvdLocId() {
        return rprvdLocId;
    }

    public void setRprvdLocId(BigInteger rprvdLocId) {
        this.rprvdLocId = rprvdLocId;
    }

    public BigInteger getRprvdPrsnId() {
        return rprvdPrsnId;
    }

    public void setRprvdPrsnId(BigInteger rprvdPrsnId) {
        this.rprvdPrsnId = rprvdPrsnId;
    }

    public BigInteger getCregItem() {
        return cregItem;
    }

    public void setCregItem(BigInteger cregItem) {
        this.cregItem = cregItem;
    }

    public BigInteger getCpredId() {
        return cpredId;
    }

    public void setCpredId(BigInteger cpredId) {
        this.cpredId = cpredId;
    }

    public BigInteger getCpredItem() {
        return cpredItem;
    }

    public void setCpredItem(BigInteger cpredItem) {
        this.cpredItem = cpredItem;
    }

    public Double getDiscAmt() {
        return discAmt;
    }

    public void setDiscAmt(Double discAmt) {
        this.discAmt = discAmt;
    }

    public Double getDiscPerc() {
        return discPerc;
    }

    public void setDiscPerc(Double discPerc) {
        this.discPerc = discPerc;
    }

    public Double getDiscPercAmt() {
        return discPercAmt;
    }

    public void setDiscPercAmt(Double discPercAmt) {
        this.discPercAmt = discPercAmt;
    }

    public Double getEligDlabProcFee() {
        return eligDlabProcFee;
    }

    public void setEligDlabProcFee(Double eligDlabProcFee) {
        this.eligDlabProcFee = eligDlabProcFee;
    }

    public BigInteger getEligDaysSupply() {
        return eligDaysSupply;
    }

    public void setEligDaysSupply(BigInteger eligDaysSupply) {
        this.eligDaysSupply = eligDaysSupply;
    }

    public Double getEligQuantity() {
        return eligQuantity;
    }

    public void setEligQuantity(Double eligQuantity) {
        this.eligQuantity = eligQuantity;
    }

    public Double getEligUnitPrice() {
        return eligUnitPrice;
    }

    public void setEligUnitPrice(Double eligUnitPrice) {
        this.eligUnitPrice = eligUnitPrice;
    }

    public Double getRprvdDebitAmt() {
        return rprvdDebitAmt;
    }

    public void setRprvdDebitAmt(Double rprvdDebitAmt) {
        this.rprvdDebitAmt = rprvdDebitAmt;
    }

    public BigInteger getAcceptAssign() {
        return acceptAssign;
    }

    public void setAcceptAssign(BigInteger acceptAssign) {
        this.acceptAssign = acceptAssign;
    }

    public String getPrvdPrsnType() {
        return prvdPrsnType;
    }

    public void setPrvdPrsnType(String prvdPrsnType) {
        this.prvdPrsnType = prvdPrsnType;
    }

    public String getPrvdLocType() {
        return prvdLocType;
    }

    public void setPrvdLocType(String prvdLocType) {
        this.prvdLocType = prvdLocType;
    }

    public BigInteger getRacceptAssign() {
        return racceptAssign;
    }

    public void setRacceptAssign(BigInteger racceptAssign) {
        this.racceptAssign = racceptAssign;
    }

    public String getRprvdPrsnType() {
        return rprvdPrsnType;
    }

    public void setRprvdPrsnType(String rprvdPrsnType) {
        this.rprvdPrsnType = rprvdPrsnType;
    }

    public String getRprvdLocType() {
        return rprvdLocType;
    }

    public void setRprvdLocType(String rprvdLocType) {
        this.rprvdLocType = rprvdLocType;
    }

    public String getRprvdLocAreaCd() {
        return rprvdLocAreaCd;
    }

    public void setRprvdLocAreaCd(String rprvdLocAreaCd) {
        this.rprvdLocAreaCd = rprvdLocAreaCd;
    }

    public BigInteger getCpredType() {
        return cpredType;
    }

    public void setCpredType(BigInteger cpredType) {
        this.cpredType = cpredType;
    }

    public Date getAccidentDtime() {
        return accidentDtime;
    }

    public void setAccidentDtime(Date accidentDtime) {
        this.accidentDtime = accidentDtime;
    }

    public String getClassfn() {
        return classfn;
    }

    public void setClassfn(String classfn) {
        this.classfn = classfn;
    }

    public String getClassfnValue() {
        return classfnValue;
    }

    public void setClassfnValue(String classfnValue) {
        this.classfnValue = classfnValue;
    }

    public String getCplanCd() {
        return cplanCd;
    }

    public void setCplanCd(String cplanCd) {
        this.cplanCd = cplanCd;
    }

    public String getDsubplanCd() {
        return dsubplanCd;
    }

    public void setDsubplanCd(String dsubplanCd) {
        this.dsubplanCd = dsubplanCd;
    }

    public String getMsubplanCd() {
        return msubplanCd;
    }

    public void setMsubplanCd(String msubplanCd) {
        this.msubplanCd = msubplanCd;
    }

    public Date getPredReceivedDtime() {
        return predReceivedDtime;
    }

    public void setPredReceivedDtime(Date predReceivedDtime) {
        this.predReceivedDtime = predReceivedDtime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Short getRemitted() {
        return remitted;
    }

    public void setRemitted(Short remitted) {
        this.remitted = remitted;
    }

    public String getDenialCd() {
        return denialCd;
    }

    public void setDenialCd(String denialCd) {
        this.denialCd = denialCd;
    }

    public Double getPenalties() {
        return penalties;
    }

    public void setPenalties(Double penalties) {
        this.penalties = penalties;
    }

    public Double getActivityNet() {
        return activityNet;
    }

    public void setActivityNet(Double activityNet) {
        this.activityNet = activityNet;
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
    
    public String getReconId() {
        return reconId;
    }

    public void setReconId(String reconId) {
        this.reconId = reconId;
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
        hash += (reconClaimItemsPK != null ? reconClaimItemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReconClaimItems)) {
            return false;
        }
        ReconClaimItems other = (ReconClaimItems) object;
        if ((this.reconClaimItemsPK == null && other.reconClaimItemsPK != null) || (this.reconClaimItemsPK != null && !this.reconClaimItemsPK.equals(other.reconClaimItemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReconClaimItems[ reconClaimItemsPK=" + reconClaimItemsPK + " ]";
    }
    
}
