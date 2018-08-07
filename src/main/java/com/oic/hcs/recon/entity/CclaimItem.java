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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CCLAIM_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CclaimItem.findAll", query = "SELECT c FROM CclaimItem c"),
    @NamedQuery(name = "CclaimItem.findByCclaimId", query = "SELECT c FROM CclaimItem c WHERE c.cclaimItemPK.cclaimId = :cclaimId"),
    @NamedQuery(name = "CclaimItem.findByCclaimItem", query = "SELECT c FROM CclaimItem c WHERE c.cclaimItemPK.cclaimItem = :cclaimItem"),
    @NamedQuery(name = "CclaimItem.findByItemStatus", query = "SELECT c FROM CclaimItem c WHERE c.itemStatus = :itemStatus"),
    @NamedQuery(name = "CclaimItem.findByItemStatusDt", query = "SELECT c FROM CclaimItem c WHERE c.itemStatusDt = :itemStatusDt"),
    @NamedQuery(name = "CclaimItem.findByBenefitType", query = "SELECT c FROM CclaimItem c WHERE c.benefitType = :benefitType"),
    @NamedQuery(name = "CclaimItem.findByBenefit", query = "SELECT c FROM CclaimItem c WHERE c.benefit = :benefit"),
    @NamedQuery(name = "CclaimItem.findByServiceDt", query = "SELECT c FROM CclaimItem c WHERE c.serviceDt = :serviceDt"),
    @NamedQuery(name = "CclaimItem.findByClaimedUnitPrice", query = "SELECT c FROM CclaimItem c WHERE c.claimedUnitPrice = :claimedUnitPrice"),
    @NamedQuery(name = "CclaimItem.findByCpredIdent", query = "SELECT c FROM CclaimItem c WHERE c.cpredIdent = :cpredIdent"),
    @NamedQuery(name = "CclaimItem.findByInvoiceNum", query = "SELECT c FROM CclaimItem c WHERE c.invoiceNum = :invoiceNum"),
    @NamedQuery(name = "CclaimItem.findByInvoiceDt", query = "SELECT c FROM CclaimItem c WHERE c.invoiceDt = :invoiceDt"),
    @NamedQuery(name = "CclaimItem.findByWorkRelatedClaim", query = "SELECT c FROM CclaimItem c WHERE c.workRelatedClaim = :workRelatedClaim"),
    @NamedQuery(name = "CclaimItem.findByInpatientClaim", query = "SELECT c FROM CclaimItem c WHERE c.inpatientClaim = :inpatientClaim"),
    @NamedQuery(name = "CclaimItem.findByEmergencyClaim", query = "SELECT c FROM CclaimItem c WHERE c.emergencyClaim = :emergencyClaim"),
    @NamedQuery(name = "CclaimItem.findByAccidentClaim", query = "SELECT c FROM CclaimItem c WHERE c.accidentClaim = :accidentClaim"),
    @NamedQuery(name = "CclaimItem.findByPrvdLocCdRef", query = "SELECT c FROM CclaimItem c WHERE c.prvdLocCdRef = :prvdLocCdRef"),
    @NamedQuery(name = "CclaimItem.findByPrvdLocCd", query = "SELECT c FROM CclaimItem c WHERE c.prvdLocCd = :prvdLocCd"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnCdRef", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnCdRef = :prvdPrsnCdRef"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnCd", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnCd = :prvdPrsnCd"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnSpec", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnSpec = :prvdPrsnSpec"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnAreaCd", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnAreaCd = :prvdPrsnAreaCd"),
    @NamedQuery(name = "CclaimItem.findByPrvdLocAreaCd", query = "SELECT c FROM CclaimItem c WHERE c.prvdLocAreaCd = :prvdLocAreaCd"),
    @NamedQuery(name = "CclaimItem.findByRprvdLocCdRef", query = "SELECT c FROM CclaimItem c WHERE c.rprvdLocCdRef = :rprvdLocCdRef"),
    @NamedQuery(name = "CclaimItem.findByRprvdLocCd", query = "SELECT c FROM CclaimItem c WHERE c.rprvdLocCd = :rprvdLocCd"),
    @NamedQuery(name = "CclaimItem.findByRprvdPrsnSpec", query = "SELECT c FROM CclaimItem c WHERE c.rprvdPrsnSpec = :rprvdPrsnSpec"),
    @NamedQuery(name = "CclaimItem.findByRprvdPrsnCdRef", query = "SELECT c FROM CclaimItem c WHERE c.rprvdPrsnCdRef = :rprvdPrsnCdRef"),
    @NamedQuery(name = "CclaimItem.findByRprvdPrsnCd", query = "SELECT c FROM CclaimItem c WHERE c.rprvdPrsnCd = :rprvdPrsnCd"),
    @NamedQuery(name = "CclaimItem.findByRefillCd", query = "SELECT c FROM CclaimItem c WHERE c.refillCd = :refillCd"),
    @NamedQuery(name = "CclaimItem.findByRefillAuth", query = "SELECT c FROM CclaimItem c WHERE c.refillAuth = :refillAuth"),
    @NamedQuery(name = "CclaimItem.findByOriginalRxNum", query = "SELECT c FROM CclaimItem c WHERE c.originalRxNum = :originalRxNum"),
    @NamedQuery(name = "CclaimItem.findByCurrentRxNum", query = "SELECT c FROM CclaimItem c WHERE c.currentRxNum = :currentRxNum"),
    @NamedQuery(name = "CclaimItem.findByDaysSupply", query = "SELECT c FROM CclaimItem c WHERE c.daysSupply = :daysSupply"),
    @NamedQuery(name = "CclaimItem.findByHospitalAdmitDt", query = "SELECT c FROM CclaimItem c WHERE c.hospitalAdmitDt = :hospitalAdmitDt"),
    @NamedQuery(name = "CclaimItem.findByHospitalDischargeDt", query = "SELECT c FROM CclaimItem c WHERE c.hospitalDischargeDt = :hospitalDischargeDt"),
    @NamedQuery(name = "CclaimItem.findByQuantity", query = "SELECT c FROM CclaimItem c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CclaimItem.findByDiagCdPrimary", query = "SELECT c FROM CclaimItem c WHERE c.diagCdPrimary = :diagCdPrimary"),
    @NamedQuery(name = "CclaimItem.findByDiagCdSecondary", query = "SELECT c FROM CclaimItem c WHERE c.diagCdSecondary = :diagCdSecondary"),
    @NamedQuery(name = "CclaimItem.findByDiagCdOther", query = "SELECT c FROM CclaimItem c WHERE c.diagCdOther = :diagCdOther"),
    @NamedQuery(name = "CclaimItem.findBySegmentCd", query = "SELECT c FROM CclaimItem c WHERE c.segmentCd = :segmentCd"),
    @NamedQuery(name = "CclaimItem.findByToothSurfaces", query = "SELECT c FROM CclaimItem c WHERE c.toothSurfaces = :toothSurfaces"),
    @NamedQuery(name = "CclaimItem.findByDlabProcCd", query = "SELECT c FROM CclaimItem c WHERE c.dlabProcCd = :dlabProcCd"),
    @NamedQuery(name = "CclaimItem.findByDlabClaimedAmt", query = "SELECT c FROM CclaimItem c WHERE c.dlabClaimedAmt = :dlabClaimedAmt"),
    @NamedQuery(name = "CclaimItem.findByCoverrides", query = "SELECT c FROM CclaimItem c WHERE c.coverrides = :coverrides"),
    @NamedQuery(name = "CclaimItem.findByCreimburseAmt", query = "SELECT c FROM CclaimItem c WHERE c.creimburseAmt = :creimburseAmt"),
    @NamedQuery(name = "CclaimItem.findByClaimCopay", query = "SELECT c FROM CclaimItem c WHERE c.claimCopay = :claimCopay"),
    @NamedQuery(name = "CclaimItem.findByClaimDeductible", query = "SELECT c FROM CclaimItem c WHERE c.claimDeductible = :claimDeductible"),
    @NamedQuery(name = "CclaimItem.findByClaimCoinsurance", query = "SELECT c FROM CclaimItem c WHERE c.claimCoinsurance = :claimCoinsurance"),
    @NamedQuery(name = "CclaimItem.findByClaimOverMax", query = "SELECT c FROM CclaimItem c WHERE c.claimOverMax = :claimOverMax"),
    @NamedQuery(name = "CclaimItem.findByMsgLogStream", query = "SELECT c FROM CclaimItem c WHERE c.msgLogStream = :msgLogStream"),
    @NamedQuery(name = "CclaimItem.findByReimburseType", query = "SELECT c FROM CclaimItem c WHERE c.reimburseType = :reimburseType"),
    @NamedQuery(name = "CclaimItem.findByConcurrentSpouse", query = "SELECT c FROM CclaimItem c WHERE c.concurrentSpouse = :concurrentSpouse"),
    @NamedQuery(name = "CclaimItem.findByThirdCfeegdId", query = "SELECT c FROM CclaimItem c WHERE c.thirdCfeegdId = :thirdCfeegdId"),
    @NamedQuery(name = "CclaimItem.findByFruleIds", query = "SELECT c FROM CclaimItem c WHERE c.fruleIds = :fruleIds"),
    @NamedQuery(name = "CclaimItem.findByBenefitGenderInd", query = "SELECT c FROM CclaimItem c WHERE c.benefitGenderInd = :benefitGenderInd"),
    @NamedQuery(name = "CclaimItem.findByFrstDiagBlockId", query = "SELECT c FROM CclaimItem c WHERE c.frstDiagBlockId = :frstDiagBlockId"),
    @NamedQuery(name = "CclaimItem.findByMembDebitFor", query = "SELECT c FROM CclaimItem c WHERE c.membDebitFor = :membDebitFor"),
    @NamedQuery(name = "CclaimItem.findByMembDebitAmt", query = "SELECT c FROM CclaimItem c WHERE c.membDebitAmt = :membDebitAmt"),
    @NamedQuery(name = "CclaimItem.findByMembOverpayAmt", query = "SELECT c FROM CclaimItem c WHERE c.membOverpayAmt = :membOverpayAmt"),
    @NamedQuery(name = "CclaimItem.findByPrvdDebitAmt", query = "SELECT c FROM CclaimItem c WHERE c.prvdDebitAmt = :prvdDebitAmt"),
    @NamedQuery(name = "CclaimItem.findByPrvdLocId", query = "SELECT c FROM CclaimItem c WHERE c.prvdLocId = :prvdLocId"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnId", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnId = :prvdPrsnId"),
    @NamedQuery(name = "CclaimItem.findByRprvdLocId", query = "SELECT c FROM CclaimItem c WHERE c.rprvdLocId = :rprvdLocId"),
    @NamedQuery(name = "CclaimItem.findByRprvdPrsnId", query = "SELECT c FROM CclaimItem c WHERE c.rprvdPrsnId = :rprvdPrsnId"),
    @NamedQuery(name = "CclaimItem.findByCregItem", query = "SELECT c FROM CclaimItem c WHERE c.cregItem = :cregItem"),
    @NamedQuery(name = "CclaimItem.findByDiscAmt", query = "SELECT c FROM CclaimItem c WHERE c.discAmt = :discAmt"),
    @NamedQuery(name = "CclaimItem.findByDiscPerc", query = "SELECT c FROM CclaimItem c WHERE c.discPerc = :discPerc"),
    @NamedQuery(name = "CclaimItem.findByDiscPercAmt", query = "SELECT c FROM CclaimItem c WHERE c.discPercAmt = :discPercAmt"),
    @NamedQuery(name = "CclaimItem.findByEligDlabProcFee", query = "SELECT c FROM CclaimItem c WHERE c.eligDlabProcFee = :eligDlabProcFee"),
    @NamedQuery(name = "CclaimItem.findByEligDaysSupply", query = "SELECT c FROM CclaimItem c WHERE c.eligDaysSupply = :eligDaysSupply"),
    @NamedQuery(name = "CclaimItem.findByEligQuantity", query = "SELECT c FROM CclaimItem c WHERE c.eligQuantity = :eligQuantity"),
    @NamedQuery(name = "CclaimItem.findByEligUnitPrice", query = "SELECT c FROM CclaimItem c WHERE c.eligUnitPrice = :eligUnitPrice"),
    @NamedQuery(name = "CclaimItem.findByRprvdDebitAmt", query = "SELECT c FROM CclaimItem c WHERE c.rprvdDebitAmt = :rprvdDebitAmt"),
    @NamedQuery(name = "CclaimItem.findByAcceptAssign", query = "SELECT c FROM CclaimItem c WHERE c.acceptAssign = :acceptAssign"),
    @NamedQuery(name = "CclaimItem.findByPrvdPrsnType", query = "SELECT c FROM CclaimItem c WHERE c.prvdPrsnType = :prvdPrsnType"),
    @NamedQuery(name = "CclaimItem.findByPrvdLocType", query = "SELECT c FROM CclaimItem c WHERE c.prvdLocType = :prvdLocType"),
    @NamedQuery(name = "CclaimItem.findByRacceptAssign", query = "SELECT c FROM CclaimItem c WHERE c.racceptAssign = :racceptAssign"),
    @NamedQuery(name = "CclaimItem.findByRprvdPrsnType", query = "SELECT c FROM CclaimItem c WHERE c.rprvdPrsnType = :rprvdPrsnType"),
    @NamedQuery(name = "CclaimItem.findByRprvdLocType", query = "SELECT c FROM CclaimItem c WHERE c.rprvdLocType = :rprvdLocType"),
    @NamedQuery(name = "CclaimItem.findByRprvdLocAreaCd", query = "SELECT c FROM CclaimItem c WHERE c.rprvdLocAreaCd = :rprvdLocAreaCd"),
    @NamedQuery(name = "CclaimItem.findByCpredType", query = "SELECT c FROM CclaimItem c WHERE c.cpredType = :cpredType"),
    @NamedQuery(name = "CclaimItem.findByAccidentDtime", query = "SELECT c FROM CclaimItem c WHERE c.accidentDtime = :accidentDtime"),
    @NamedQuery(name = "CclaimItem.findByClassfn", query = "SELECT c FROM CclaimItem c WHERE c.classfn = :classfn"),
    @NamedQuery(name = "CclaimItem.findByClassfnValue", query = "SELECT c FROM CclaimItem c WHERE c.classfnValue = :classfnValue"),
    @NamedQuery(name = "CclaimItem.findByCplanCd", query = "SELECT c FROM CclaimItem c WHERE c.cplanCd = :cplanCd"),
    @NamedQuery(name = "CclaimItem.findByDsubplanCd", query = "SELECT c FROM CclaimItem c WHERE c.dsubplanCd = :dsubplanCd"),
    @NamedQuery(name = "CclaimItem.findByMsubplanCd", query = "SELECT c FROM CclaimItem c WHERE c.msubplanCd = :msubplanCd"),
    @NamedQuery(name = "CclaimItem.findByPredReceivedDtime", query = "SELECT c FROM CclaimItem c WHERE c.predReceivedDtime = :predReceivedDtime"),
    @NamedQuery(name = "CclaimItem.findByNotes", query = "SELECT c FROM CclaimItem c WHERE c.notes = :notes"),
    @NamedQuery(name = "CclaimItem.findByCreateId", query = "SELECT c FROM CclaimItem c WHERE c.createId = :createId"),
    @NamedQuery(name = "CclaimItem.findByCreateDtime", query = "SELECT c FROM CclaimItem c WHERE c.createDtime = :createDtime"),
    @NamedQuery(name = "CclaimItem.findByRemitted", query = "SELECT c FROM CclaimItem c WHERE c.remitted = :remitted"),
    @NamedQuery(name = "CclaimItem.findByDenialCd", query = "SELECT c FROM CclaimItem c WHERE c.denialCd = :denialCd"),
    @NamedQuery(name = "CclaimItem.findByPenalties", query = "SELECT c FROM CclaimItem c WHERE c.penalties = :penalties"),
    @NamedQuery(name = "CclaimItem.findByActivityNet", query = "SELECT c FROM CclaimItem c WHERE c.activityNet = :activityNet")})
public class CclaimItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CclaimItemPK cclaimItemPK;
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
    @JoinColumn(name = "CCLAIM_ID", referencedColumnName = "CCLAIM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CclaimHdr cclaimHdr;

    public CclaimItem() {
    }

    public CclaimItem(CclaimItemPK cclaimItemPK) {
        this.cclaimItemPK = cclaimItemPK;
    }

    public CclaimItem(CclaimItemPK cclaimItemPK, String itemStatus, Date itemStatusDt, String benefitType, String benefit, Date serviceDt, Double claimedUnitPrice, BigInteger workRelatedClaim, BigInteger inpatientClaim, BigInteger emergencyClaim, BigInteger accidentClaim, Double creimburseAmt, Double claimCopay, Double claimDeductible, Double claimCoinsurance, Double claimOverMax, Double eligDlabProcFee, Double eligUnitPrice, String createId, Date createDtime) {
        this.cclaimItemPK = cclaimItemPK;
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

    public CclaimItem(BigInteger cclaimId, BigInteger cclaimItem) {
        this.cclaimItemPK = new CclaimItemPK(cclaimId, cclaimItem);
    }

    public CclaimItemPK getCclaimItemPK() {
        return cclaimItemPK;
    }

    public void setCclaimItemPK(CclaimItemPK cclaimItemPK) {
        this.cclaimItemPK = cclaimItemPK;
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

    public CclaimHdr getCclaimHdr() {
        return cclaimHdr;
    }

    public void setCclaimHdr(CclaimHdr cclaimHdr) {
        this.cclaimHdr = cclaimHdr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cclaimItemPK != null ? cclaimItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CclaimItem)) {
            return false;
        }
        CclaimItem other = (CclaimItem) object;
        if ((this.cclaimItemPK == null && other.cclaimItemPK != null) || (this.cclaimItemPK != null && !this.cclaimItemPK.equals(other.cclaimItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CclaimItem[ cclaimItemPK=" + cclaimItemPK + " ]";
    }
    
}
