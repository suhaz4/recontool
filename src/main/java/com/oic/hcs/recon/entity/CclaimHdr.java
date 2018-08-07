/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.entity;

import java.io.Serializable;
//import java.math.Double;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author noaman000
 */
@Entity
@Table(name = "CCLAIM_HDR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CclaimHdr.findAll", query = "SELECT c FROM CclaimHdr c"),
    @NamedQuery(name = "CclaimHdr.findByCclaimId", query = "SELECT c FROM CclaimHdr c WHERE c.cclaimId = :cclaimId"),
    @NamedQuery(name = "CclaimHdr.findByCclaimStatus", query = "SELECT c FROM CclaimHdr c WHERE c.cclaimStatus = :cclaimStatus"),
    @NamedQuery(name = "CclaimHdr.findByCclaimStatusDt", query = "SELECT c FROM CclaimHdr c WHERE c.cclaimStatusDt = :cclaimStatusDt"),
    @NamedQuery(name = "CclaimHdr.findByCclaimTmpStatus", query = "SELECT c FROM CclaimHdr c WHERE c.cclaimTmpStatus = :cclaimTmpStatus"),
    @NamedQuery(name = "CclaimHdr.findByCrevId", query = "SELECT c FROM CclaimHdr c WHERE c.crevId = :crevId"),
    @NamedQuery(name = "CclaimHdr.findByTransferDt", query = "SELECT c FROM CclaimHdr c WHERE c.transferDt = :transferDt"),
    @NamedQuery(name = "CclaimHdr.findByPaidDt", query = "SELECT c FROM CclaimHdr c WHERE c.paidDt = :paidDt"),
    @NamedQuery(name = "CclaimHdr.findByPaymentMethod", query = "SELECT c FROM CclaimHdr c WHERE c.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "CclaimHdr.findByChqEftNum", query = "SELECT c FROM CclaimHdr c WHERE c.chqEftNum = :chqEftNum"),
    @NamedQuery(name = "CclaimHdr.findByTransDtime", query = "SELECT c FROM CclaimHdr c WHERE c.transDtime = :transDtime"),
    @NamedQuery(name = "CclaimHdr.findByReceivedDtime", query = "SELECT c FROM CclaimHdr c WHERE c.receivedDtime = :receivedDtime"),
    @NamedQuery(name = "CclaimHdr.findByTraceNum", query = "SELECT c FROM CclaimHdr c WHERE c.traceNum = :traceNum"),
    @NamedQuery(name = "CclaimHdr.findByHcsVersion", query = "SELECT c FROM CclaimHdr c WHERE c.hcsVersion = :hcsVersion"),
    @NamedQuery(name = "CclaimHdr.findByPrvdSwNum", query = "SELECT c FROM CclaimHdr c WHERE c.prvdSwNum = :prvdSwNum"),
    @NamedQuery(name = "CclaimHdr.findByPrvdSwVersion", query = "SELECT c FROM CclaimHdr c WHERE c.prvdSwVersion = :prvdSwVersion"),
    @NamedQuery(name = "CclaimHdr.findByPrvdSwDevice", query = "SELECT c FROM CclaimHdr c WHERE c.prvdSwDevice = :prvdSwDevice"),
    @NamedQuery(name = "CclaimHdr.findByCarrierCCd", query = "SELECT c FROM CclaimHdr c WHERE c.carrierCCd = :carrierCCd"),
    @NamedQuery(name = "CclaimHdr.findByGrpCd", query = "SELECT c FROM CclaimHdr c WHERE c.grpCd = :grpCd"),
    @NamedQuery(name = "CclaimHdr.findByMembCd", query = "SELECT c FROM CclaimHdr c WHERE c.membCd = :membCd"),
    @NamedQuery(name = "CclaimHdr.findByMembFname", query = "SELECT c FROM CclaimHdr c WHERE c.membFname = :membFname"),
    @NamedQuery(name = "CclaimHdr.findByMembLname", query = "SELECT c FROM CclaimHdr c WHERE c.membLname = :membLname"),
    @NamedQuery(name = "CclaimHdr.findByRcpCd", query = "SELECT c FROM CclaimHdr c WHERE c.rcpCd = :rcpCd"),
    @NamedQuery(name = "CclaimHdr.findByRcpDob", query = "SELECT c FROM CclaimHdr c WHERE c.rcpDob = :rcpDob"),
    @NamedQuery(name = "CclaimHdr.findByCrelationshipCd", query = "SELECT c FROM CclaimHdr c WHERE c.crelationshipCd = :crelationshipCd"),
    @NamedQuery(name = "CclaimHdr.findByRcpFname", query = "SELECT c FROM CclaimHdr c WHERE c.rcpFname = :rcpFname"),
    @NamedQuery(name = "CclaimHdr.findByRcpLname", query = "SELECT c FROM CclaimHdr c WHERE c.rcpLname = :rcpLname"),
    @NamedQuery(name = "CclaimHdr.findByHealthNum", query = "SELECT c FROM CclaimHdr c WHERE c.healthNum = :healthNum"),
    @NamedQuery(name = "CclaimHdr.findByRcpSex", query = "SELECT c FROM CclaimHdr c WHERE c.rcpSex = :rcpSex"),
    @NamedQuery(name = "CclaimHdr.findByReimburseTo", query = "SELECT c FROM CclaimHdr c WHERE c.reimburseTo = :reimburseTo"),
    @NamedQuery(name = "CclaimHdr.findByReimburseRefNum", query = "SELECT c FROM CclaimHdr c WHERE c.reimburseRefNum = :reimburseRefNum"),
    @NamedQuery(name = "CclaimHdr.findByCregIdent", query = "SELECT c FROM CclaimHdr c WHERE c.cregIdent = :cregIdent"),
    @NamedQuery(name = "CclaimHdr.findByAddr1", query = "SELECT c FROM CclaimHdr c WHERE c.addr1 = :addr1"),
    @NamedQuery(name = "CclaimHdr.findByAddr2", query = "SELECT c FROM CclaimHdr c WHERE c.addr2 = :addr2"),
    @NamedQuery(name = "CclaimHdr.findByAddr3", query = "SELECT c FROM CclaimHdr c WHERE c.addr3 = :addr3"),
    @NamedQuery(name = "CclaimHdr.findByCity", query = "SELECT c FROM CclaimHdr c WHERE c.city = :city"),
    @NamedQuery(name = "CclaimHdr.findByProvince", query = "SELECT c FROM CclaimHdr c WHERE c.province = :province"),
    @NamedQuery(name = "CclaimHdr.findByCountry", query = "SELECT c FROM CclaimHdr c WHERE c.country = :country"),
    @NamedQuery(name = "CclaimHdr.findByPostalCd", query = "SELECT c FROM CclaimHdr c WHERE c.postalCd = :postalCd"),
    @NamedQuery(name = "CclaimHdr.findByMsgLogStream", query = "SELECT c FROM CclaimHdr c WHERE c.msgLogStream = :msgLogStream"),
    @NamedQuery(name = "CclaimHdr.findByAdjDtime", query = "SELECT c FROM CclaimHdr c WHERE c.adjDtime = :adjDtime"),
    @NamedQuery(name = "CclaimHdr.findByCarrierId", query = "SELECT c FROM CclaimHdr c WHERE c.carrierId = :carrierId"),
    @NamedQuery(name = "CclaimHdr.findByGrpId", query = "SELECT c FROM CclaimHdr c WHERE c.grpId = :grpId"),
    @NamedQuery(name = "CclaimHdr.findBySgrpId", query = "SELECT c FROM CclaimHdr c WHERE c.sgrpId = :sgrpId"),
    @NamedQuery(name = "CclaimHdr.findByMembId", query = "SELECT c FROM CclaimHdr c WHERE c.membId = :membId"),
    @NamedQuery(name = "CclaimHdr.findByRcpId", query = "SELECT c FROM CclaimHdr c WHERE c.rcpId = :rcpId"),
    @NamedQuery(name = "CclaimHdr.findByPrescrDt", query = "SELECT c FROM CclaimHdr c WHERE c.prescrDt = :prescrDt"),
    @NamedQuery(name = "CclaimHdr.findByCreateId", query = "SELECT c FROM CclaimHdr c WHERE c.createId = :createId"),
    @NamedQuery(name = "CclaimHdr.findByCreateDtime", query = "SELECT c FROM CclaimHdr c WHERE c.createDtime = :createDtime"),
    @NamedQuery(name = "CclaimHdr.findByRcpMobno", query = "SELECT c FROM CclaimHdr c WHERE c.rcpMobno = :rcpMobno"),
    @NamedQuery(name = "CclaimHdr.findByEmail", query = "SELECT c FROM CclaimHdr c WHERE c.email = :email"),
    @NamedQuery(name = "CclaimHdr.findByEclaim", query = "SELECT c FROM CclaimHdr c WHERE c.eclaim = :eclaim"),
    @NamedQuery(name = "CclaimHdr.findByResubmissiontype", query = "SELECT c FROM CclaimHdr c WHERE c.resubmissiontype = :resubmissiontype"),
    @NamedQuery(name = "CclaimHdr.findByRaPostDt", query = "SELECT c FROM CclaimHdr c WHERE c.raPostDt = :raPostDt"),
    @NamedQuery(name = "CclaimHdr.findByRaOldPostDt", query = "SELECT c FROM CclaimHdr c WHERE c.raOldPostDt = :raOldPostDt"),
    @NamedQuery(name = "CclaimHdr.findByPaidDate", query = "SELECT c FROM CclaimHdr c WHERE c.paidDate = :paidDate"),
    @NamedQuery(name = "CclaimHdr.findByPrvPaidDate", query = "SELECT c FROM CclaimHdr c WHERE c.prvPaidDate = :prvPaidDate"),
    @NamedQuery(name = "CclaimHdr.findByPrvRcvDt", query = "SELECT c FROM CclaimHdr c WHERE c.prvRcvDt = :prvRcvDt"),
    @NamedQuery(name = "CclaimHdr.findByPrvClaimNo", query = "SELECT c FROM CclaimHdr c WHERE c.prvClaimNo = :prvClaimNo"),
    @NamedQuery(name = "CclaimHdr.findByIsToBeAudited", query = "SELECT c FROM CclaimHdr c WHERE c.isToBeAudited = :isToBeAudited"),
    @NamedQuery(name = "CclaimHdr.findByAuditNotes", query = "SELECT c FROM CclaimHdr c WHERE c.auditNotes = :auditNotes"),
    @NamedQuery(name = "CclaimHdr.findByAuditFlag", query = "SELECT c FROM CclaimHdr c WHERE c.auditFlag = :auditFlag"),
    @NamedQuery(name = "CclaimHdr.findByRejAllFlag", query = "SELECT c FROM CclaimHdr c WHERE c.rejAllFlag = :rejAllFlag"),
    @NamedQuery(name = "CclaimHdr.findByRejAllDenCd", query = "SELECT c FROM CclaimHdr c WHERE c.rejAllDenCd = :rejAllDenCd")})
public class CclaimHdr implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLAIM_ID")
    private Double cclaimId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CCLAIM_STATUS")
    private String cclaimStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLAIM_STATUS_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cclaimStatusDt;
    @Size(max = 1)
    @Column(name = "CCLAIM_TMP_STATUS")
    private String cclaimTmpStatus;
    @Column(name = "CREV_ID")
    private BigInteger crevId;
    @Column(name = "TRANSFER_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDt;
    @Column(name = "PAID_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDt;
    @Column(name = "PAYMENT_METHOD")
    private BigInteger paymentMethod;
    @Size(max = 20)
    @Column(name = "CHQ_EFT_NUM")
    private String chqEftNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANS_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEIVED_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "TRACE_NUM")
    private String traceNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "HCS_VERSION")
    private String hcsVersion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "PRVD_SW_NUM")
    private String prvdSwNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PRVD_SW_VERSION")
    private String prvdSwVersion;
    @Size(max = 8)
    @Column(name = "PRVD_SW_DEVICE")
    private String prvdSwDevice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "CARRIER_C_CD")
    private String carrierCCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "GRP_CD")
    private String grpCd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MEMB_CD")
    private String membCd;
    @Size(max = 20)
    @Column(name = "MEMB_FNAME")
    private String membFname;
    @Size(max = 30)
    @Column(name = "MEMB_LNAME")
    private String membLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "RCP_CD")
    private String rcpCd;
    @Column(name = "RCP_DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcpDob;
    @Column(name = "CRELATIONSHIP_CD")
    private BigInteger crelationshipCd;
    @Size(max = 40)
    @Column(name = "RCP_FNAME")
    private String rcpFname;
    @Size(max = 40)
    @Column(name = "RCP_LNAME")
    private String rcpLname;
    @Size(max = 30)
    @Column(name = "HEALTH_NUM")
    private String healthNum;
    @Size(max = 1)
    @Column(name = "RCP_SEX")
    private String rcpSex;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REIMBURSE_TO")
    private BigInteger reimburseTo;
    @Size(max = 100)
    @Column(name = "REIMBURSE_REF_NUM")
    private String reimburseRefNum;
    @Column(name = "CREG_IDENT")
    private BigInteger cregIdent;
    @Size(max = 30)
    @Column(name = "ADDR1")
    private String addr1;
    @Size(max = 30)
    @Column(name = "ADDR2")
    private String addr2;
    @Size(max = 30)
    @Column(name = "ADDR3")
    private String addr3;
    @Size(max = 30)
    @Column(name = "CITY")
    private String city;
    @Size(max = 3)
    @Column(name = "PROVINCE")
    private String province;
    @Size(max = 30)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 10)
    @Column(name = "POSTAL_CD")
    private String postalCd;
    @Size(max = 4000)
    @Column(name = "MSG_LOG_STREAM")
    private String msgLogStream;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADJ_DTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date adjDtime;
    @Column(name = "CARRIER_ID")
    private BigInteger carrierId;
    @Column(name = "GRP_ID")
    private BigInteger grpId;
    @Column(name = "SGRP_ID")
    private BigInteger sgrpId;
    @Column(name = "MEMB_ID")
    private BigInteger membId;
    @Column(name = "RCP_ID")
    private BigInteger rcpId;
    @Column(name = "PRESCR_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prescrDt;
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
    @Size(max = 100)
    @Column(name = "RCP_MOBNO")
    private String rcpMobno;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ECLAIM")
    private Short eclaim;
    @Size(max = 20)
    @Column(name = "RESUBMISSIONTYPE")
    private String resubmissiontype;
    @Column(name = "RA_POST_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date raPostDt;
    @Column(name = "RA_OLD_POST_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date raOldPostDt;
    @Column(name = "PAID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paidDate;
    @Column(name = "PRV_PAID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prvPaidDate;
    @Column(name = "PRV_RCV_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prvRcvDt;
    @Column(name = "PRV_CLAIM_NO")
    private BigInteger prvClaimNo;
    @Column(name = "IS_TO_BE_AUDITED")
    private Short isToBeAudited;
    @Size(max = 2000)
    @Column(name = "AUDIT_NOTES")
    private String auditNotes;
    @Size(max = 255)
    @Column(name = "AUDIT_FLAG")
    private String auditFlag;
    @Column(name = "REJ_ALL_FLAG")
    private Short rejAllFlag;
    @Size(max = 20)
    @Column(name = "REJ_ALL_DEN_CD")
    private String rejAllDenCd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cclaimHdr")
    private Collection<CclaimItem> cclaimItemCollection;

    public CclaimHdr() {
    }

    public CclaimHdr(Double cclaimId) {
        this.cclaimId = cclaimId;
    }

    public CclaimHdr(Double cclaimId, String cclaimStatus, Date cclaimStatusDt, Date transDtime, Date receivedDtime, String traceNum, String hcsVersion, String prvdSwNum, String prvdSwVersion, String carrierCCd, String grpCd, String membCd, String rcpCd, BigInteger reimburseTo, Date adjDtime, String createId, Date createDtime) {
        this.cclaimId = cclaimId;
        this.cclaimStatus = cclaimStatus;
        this.cclaimStatusDt = cclaimStatusDt;
        this.transDtime = transDtime;
        this.receivedDtime = receivedDtime;
        this.traceNum = traceNum;
        this.hcsVersion = hcsVersion;
        this.prvdSwNum = prvdSwNum;
        this.prvdSwVersion = prvdSwVersion;
        this.carrierCCd = carrierCCd;
        this.grpCd = grpCd;
        this.membCd = membCd;
        this.rcpCd = rcpCd;
        this.reimburseTo = reimburseTo;
        this.adjDtime = adjDtime;
        this.createId = createId;
        this.createDtime = createDtime;
    }

    public Double getCclaimId() {
        return cclaimId;
    }

    public void setCclaimId(Double cclaimId) {
        this.cclaimId = cclaimId;
    }

    public String getCclaimStatus() {
        return cclaimStatus;
    }

    public void setCclaimStatus(String cclaimStatus) {
        this.cclaimStatus = cclaimStatus;
    }

    public Date getCclaimStatusDt() {
        return cclaimStatusDt;
    }

    public void setCclaimStatusDt(Date cclaimStatusDt) {
        this.cclaimStatusDt = cclaimStatusDt;
    }

    public String getCclaimTmpStatus() {
        return cclaimTmpStatus;
    }

    public void setCclaimTmpStatus(String cclaimTmpStatus) {
        this.cclaimTmpStatus = cclaimTmpStatus;
    }

    public BigInteger getCrevId() {
        return crevId;
    }

    public void setCrevId(BigInteger crevId) {
        this.crevId = crevId;
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

    public BigInteger getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(BigInteger paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getChqEftNum() {
        return chqEftNum;
    }

    public void setChqEftNum(String chqEftNum) {
        this.chqEftNum = chqEftNum;
    }

    public Date getTransDtime() {
        return transDtime;
    }

    public void setTransDtime(Date transDtime) {
        this.transDtime = transDtime;
    }

    public Date getReceivedDtime() {
        return receivedDtime;
    }

    public void setReceivedDtime(Date receivedDtime) {
        this.receivedDtime = receivedDtime;
    }

    public String getTraceNum() {
        return traceNum;
    }

    public void setTraceNum(String traceNum) {
        this.traceNum = traceNum;
    }

    public String getHcsVersion() {
        return hcsVersion;
    }

    public void setHcsVersion(String hcsVersion) {
        this.hcsVersion = hcsVersion;
    }

    public String getPrvdSwNum() {
        return prvdSwNum;
    }

    public void setPrvdSwNum(String prvdSwNum) {
        this.prvdSwNum = prvdSwNum;
    }

    public String getPrvdSwVersion() {
        return prvdSwVersion;
    }

    public void setPrvdSwVersion(String prvdSwVersion) {
        this.prvdSwVersion = prvdSwVersion;
    }

    public String getPrvdSwDevice() {
        return prvdSwDevice;
    }

    public void setPrvdSwDevice(String prvdSwDevice) {
        this.prvdSwDevice = prvdSwDevice;
    }

    public String getCarrierCCd() {
        return carrierCCd;
    }

    public void setCarrierCCd(String carrierCCd) {
        this.carrierCCd = carrierCCd;
    }

    public String getGrpCd() {
        return grpCd;
    }

    public void setGrpCd(String grpCd) {
        this.grpCd = grpCd;
    }

    public String getMembCd() {
        return membCd;
    }

    public void setMembCd(String membCd) {
        this.membCd = membCd;
    }

    public String getMembFname() {
        return membFname;
    }

    public void setMembFname(String membFname) {
        this.membFname = membFname;
    }

    public String getMembLname() {
        return membLname;
    }

    public void setMembLname(String membLname) {
        this.membLname = membLname;
    }

    public String getRcpCd() {
        return rcpCd;
    }

    public void setRcpCd(String rcpCd) {
        this.rcpCd = rcpCd;
    }

    public Date getRcpDob() {
        return rcpDob;
    }

    public void setRcpDob(Date rcpDob) {
        this.rcpDob = rcpDob;
    }

    public BigInteger getCrelationshipCd() {
        return crelationshipCd;
    }

    public void setCrelationshipCd(BigInteger crelationshipCd) {
        this.crelationshipCd = crelationshipCd;
    }

    public String getRcpFname() {
        return rcpFname;
    }

    public void setRcpFname(String rcpFname) {
        this.rcpFname = rcpFname;
    }

    public String getRcpLname() {
        return rcpLname;
    }

    public void setRcpLname(String rcpLname) {
        this.rcpLname = rcpLname;
    }

    public String getHealthNum() {
        return healthNum;
    }

    public void setHealthNum(String healthNum) {
        this.healthNum = healthNum;
    }

    public String getRcpSex() {
        return rcpSex;
    }

    public void setRcpSex(String rcpSex) {
        this.rcpSex = rcpSex;
    }

    public BigInteger getReimburseTo() {
        return reimburseTo;
    }

    public void setReimburseTo(BigInteger reimburseTo) {
        this.reimburseTo = reimburseTo;
    }

    public String getReimburseRefNum() {
        return reimburseRefNum;
    }

    public void setReimburseRefNum(String reimburseRefNum) {
        this.reimburseRefNum = reimburseRefNum;
    }

    public BigInteger getCregIdent() {
        return cregIdent;
    }

    public void setCregIdent(BigInteger cregIdent) {
        this.cregIdent = cregIdent;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getAddr3() {
        return addr3;
    }

    public void setAddr3(String addr3) {
        this.addr3 = addr3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd;
    }

    public String getMsgLogStream() {
        return msgLogStream;
    }

    public void setMsgLogStream(String msgLogStream) {
        this.msgLogStream = msgLogStream;
    }

    public Date getAdjDtime() {
        return adjDtime;
    }

    public void setAdjDtime(Date adjDtime) {
        this.adjDtime = adjDtime;
    }

    public BigInteger getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(BigInteger carrierId) {
        this.carrierId = carrierId;
    }

    public BigInteger getGrpId() {
        return grpId;
    }

    public void setGrpId(BigInteger grpId) {
        this.grpId = grpId;
    }

    public BigInteger getSgrpId() {
        return sgrpId;
    }

    public void setSgrpId(BigInteger sgrpId) {
        this.sgrpId = sgrpId;
    }

    public BigInteger getMembId() {
        return membId;
    }

    public void setMembId(BigInteger membId) {
        this.membId = membId;
    }

    public BigInteger getRcpId() {
        return rcpId;
    }

    public void setRcpId(BigInteger rcpId) {
        this.rcpId = rcpId;
    }

    public Date getPrescrDt() {
        return prescrDt;
    }

    public void setPrescrDt(Date prescrDt) {
        this.prescrDt = prescrDt;
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

    public String getRcpMobno() {
        return rcpMobno;
    }

    public void setRcpMobno(String rcpMobno) {
        this.rcpMobno = rcpMobno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getEclaim() {
        return eclaim;
    }

    public void setEclaim(Short eclaim) {
        this.eclaim = eclaim;
    }

    public String getResubmissiontype() {
        return resubmissiontype;
    }

    public void setResubmissiontype(String resubmissiontype) {
        this.resubmissiontype = resubmissiontype;
    }

    public Date getRaPostDt() {
        return raPostDt;
    }

    public void setRaPostDt(Date raPostDt) {
        this.raPostDt = raPostDt;
    }

    public Date getRaOldPostDt() {
        return raOldPostDt;
    }

    public void setRaOldPostDt(Date raOldPostDt) {
        this.raOldPostDt = raOldPostDt;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public Date getPrvPaidDate() {
        return prvPaidDate;
    }

    public void setPrvPaidDate(Date prvPaidDate) {
        this.prvPaidDate = prvPaidDate;
    }

    public Date getPrvRcvDt() {
        return prvRcvDt;
    }

    public void setPrvRcvDt(Date prvRcvDt) {
        this.prvRcvDt = prvRcvDt;
    }

    public BigInteger getPrvClaimNo() {
        return prvClaimNo;
    }

    public void setPrvClaimNo(BigInteger prvClaimNo) {
        this.prvClaimNo = prvClaimNo;
    }

    public Short getIsToBeAudited() {
        return isToBeAudited;
    }

    public void setIsToBeAudited(Short isToBeAudited) {
        this.isToBeAudited = isToBeAudited;
    }

    public String getAuditNotes() {
        return auditNotes;
    }

    public void setAuditNotes(String auditNotes) {
        this.auditNotes = auditNotes;
    }

    public String getAuditFlag() {
        return auditFlag;
    }

    public void setAuditFlag(String auditFlag) {
        this.auditFlag = auditFlag;
    }

    public Short getRejAllFlag() {
        return rejAllFlag;
    }

    public void setRejAllFlag(Short rejAllFlag) {
        this.rejAllFlag = rejAllFlag;
    }

    public String getRejAllDenCd() {
        return rejAllDenCd;
    }

    public void setRejAllDenCd(String rejAllDenCd) {
        this.rejAllDenCd = rejAllDenCd;
    }

    @XmlTransient
    public Collection<CclaimItem> getCclaimItemCollection() {
        return cclaimItemCollection;
    }

    public void setCclaimItemCollection(Collection<CclaimItem> cclaimItemCollection) {
        this.cclaimItemCollection = cclaimItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cclaimId != null ? cclaimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CclaimHdr)) {
            return false;
        }
        CclaimHdr other = (CclaimHdr) object;
        if ((this.cclaimId == null && other.cclaimId != null) || (this.cclaimId != null && !this.cclaimId.equals(other.cclaimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CclaimHdr[ cclaimId=" + cclaimId + " ]";
    }
    
}
