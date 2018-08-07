/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.service;

import com.oic.hcs.recon.entity.CclaimHdr;
import com.oic.hcs.recon.entity.CclaimItem;
import com.oic.hcs.recon.entity.CclaimItemPK;
import com.oic.hcs.recon.entity.CompletedReconData;
import com.oic.hcs.recon.entity.ReconAuthority;
import com.oic.hcs.recon.entity.ReconCandidateClaims;
import com.oic.hcs.recon.entity.ReconCandidateClaimsPK;
import com.oic.hcs.recon.entity.ReconClaimHdr;
import com.oic.hcs.recon.entity.ReconClaimItems;
import com.oic.hcs.recon.entity.ReconClaimsData;
import com.oic.hcs.recon.entity.ReconClaimsDataPK;
//import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import com.oic.hcs.recon.utility.AlreadyExistsException;
import com.oic.hcs.recon.utility.DataAndSummary;
import com.oic.hcs.recon.utility.LocationErrors;
import com.oic.hcs.recon.utility.ReconDataValidationErrors;
import com.oic.hcs.recon.utility.StatusErrors;

/**
 *
 * @author noaman000
 */
@Stateless
public class ReconServiceBean implements ReconServiceBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    private EntityManager em;

    @Override
    public void insertCandidateClaim(BigInteger claimId, String locationCode, String reconId, String createdBy, String reconType)
            throws Exception {

        ReconCandidateClaimsPK key = new ReconCandidateClaimsPK(claimId, locationCode, reconId);
        em.clear();
        //em.getEntityManagerFactory().getCache().evictAll();
        if (em.find(ReconCandidateClaims.class, key) != null) {
        	System.out.println("\n ***** throwing error *****");
            throw new AlreadyExistsException("Record already exists in database.");
        }
        Query query = em.createNamedQuery("ReconCandidateClaims.findByClaimId");
        query.setParameter("claimId", claimId);
        List<ReconCandidateClaims> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
                throw new AlreadyExistsException("Claim Id: "+claimId+" has already been used in Recon ID: " + list.get(0).getReconCandidateClaimsPK().getReconId());            
        }
        query = em.createNamedQuery("ReconCandidateClaims.findByReconId");
        query.setParameter("reconId", reconId);
        list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            if (!reconType.equals(list.get(0).getReconType())) {
                throw new AlreadyExistsException("Recon ID: " + reconId + " already exists in database with recon type: " + list.get(0).getReconType());
            }
        }
        ReconCandidateClaims candidateClaimsEntity = new ReconCandidateClaims();
        candidateClaimsEntity.setReconCandidateClaimsPK(key);
        candidateClaimsEntity.setCreatedBy(createdBy);
        candidateClaimsEntity.setCreatedOn(Calendar.getInstance().getTime());
        candidateClaimsEntity.setLastUpdatedBy(createdBy);
        candidateClaimsEntity.setLastUpdatedOn(Calendar.getInstance().getTime());
        candidateClaimsEntity.setReconType(reconType);
        candidateClaimsEntity.setFrozen(0);
        em.persist(candidateClaimsEntity);

    }

    @Override
    public void clearAndInsertReconClaimsData(List<ReconClaimsData> ls, String user) {

        em.clear();
        //em.getEntityManagerFactory().getCache().evictAll();
        Query query = em.createQuery("DELETE FROM ReconClaimsData r WHERE r.reconClaimsDataPK.reconId = :reconId");
        query.setParameter("reconId", ls.get(0).getReconClaimsDataPK().getReconId());
        query.executeUpdate();
        for (ReconClaimsData claim : ls) {
            claim.setUsername(user);
            claim.setCreatedBy(user);
            claim.setCreatedOn(Calendar.getInstance().getTime());
            claim.setLastUpdatedBy(user);
            claim.setLastUpdatedOn(Calendar.getInstance().getTime());
            em.persist(claim);
        }
    }

    @Override
    public double authenticate(String username, String password) {
        double limit = -1;//not authorized for recon
        Query query = em.createQuery("SELECT s FROM SecUser s WHERE s.username = :username and s.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        if (query.getResultList() != null && !query.getResultList().isEmpty()) {
            Query queryRecon = em.createQuery("SELECT s FROM ReconAuthority s WHERE s.username = :username and s.activeStatus = 'A'");
            queryRecon.setParameter("username", username);
            List<ReconAuthority> result = queryRecon.getResultList();
            if (result != null && !result.isEmpty()) {
                limit = result.get(0).getLimit();
            }
        }
        return limit;
    }

    @Override
    public DataAndSummary getCandidatesByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<ReconCandidateClaims> results = new ArrayList<ReconCandidateClaims>();
        Query query = em.createNamedQuery("ReconCandidateClaims.findByReconId");
        query.setParameter("reconId", reconId);
        List<ReconCandidateClaims> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            for (ReconCandidateClaims claim : list) {
                results.add(claim);
            }
        }
        setSummary(payload, reconId, "candidates");
        //payload.setSummary(totalCount, totalClaimedAmount, totalRejectedAmount, eligibleRejectedAmount, totalPatientShare, paidAmount);
        payload.setDataList(results);
        return payload;
    }

    @Override
    public DataAndSummary getReconClaimsDataByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<ReconClaimsData> results = new ArrayList<ReconClaimsData>();
        Query query = em.createNamedQuery("ReconClaimsData.findByReconId");
        query.setParameter("reconId", reconId);
        List<ReconClaimsData> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            for (ReconClaimsData claim : list) {
                results.add(claim);
            }
        }
        setSummary(payload, reconId, "underProcess");
        payload.setDataList(results);
        return payload;
    }

    @Override
    public DataAndSummary getReconClaimHdrByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<ReconClaimHdr> results = new ArrayList<ReconClaimHdr>();
        Query query = em.createNamedQuery("ReconClaimHdr.findByReconId");
        query.setParameter("reconId", reconId);
        List<ReconClaimHdr> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            for (ReconClaimHdr claim : list) {
                results.add(claim);
            }
        }
        setSummary(payload, reconId, "review");
        payload.setDataList(results);
        return payload;
    }

    @Override
    public DataAndSummary getReconClaimItemsByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<ReconClaimItems> results = new ArrayList<ReconClaimItems>();
        Query query = em.createNamedQuery("ReconClaimItems.findByReconId");
        query.setParameter("reconId", reconId);
        List<ReconClaimItems> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            for (ReconClaimItems claim : list) {
                results.add(claim);
            }
        }
        setSummary(payload, reconId, "review");
        payload.setDataList(results);
        return payload;
    }

    @Override
    public DataAndSummary getCompletedReconByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<CompletedReconData> results = new ArrayList<CompletedReconData>();
        Query queryHdr = em.createQuery("SELECT s FROM CclaimHdr s WHERE EXISTS (SELECT 1 from ReconClaimHdr h where h.reconId = :reconId and h.cclaimId = s.cclaimId)");
        queryHdr.setParameter("reconId", reconId);
        List<CclaimHdr> listHdr = queryHdr.getResultList();
        if (listHdr != null && !listHdr.isEmpty()) {
            for (CclaimHdr hdr : listHdr) {
                CompletedReconData data = new CompletedReconData();
                //CclaimHdr hdr = (CclaimHdr) listHdr.iterator().next();
                data.setNewClaimId(String.valueOf(hdr.getCclaimId()));
                data.setOldClaimId(String.valueOf(hdr.getPrvClaimNo()));
                data.setChqEftNum(hdr.getChqEftNum());
                data.setCreateDtime(hdr.getCreateDtime());
                data.setCreateId(hdr.getCreateId());
                data.setPaidDt(hdr.getPaidDt());
                data.setReconId(reconId);
                data.setTransferDt(hdr.getTransferDt());
                TypedQuery<Object[]> queryItem = em.createQuery("SELECT SUM(s.creimburseAmt), MAX(s.prvdLocCd) FROM CclaimItem s WHERE s.cclaimItemPK.cclaimId = " + hdr.getCclaimId(), Object[].class);
                List<Object[]> res = queryItem.getResultList();
                if (res != null && !res.isEmpty()) {
                    for (Object[] result : res) {
                        data.setPaidAmt((((Double) result[0])).doubleValue());
                        data.setPrvdLocationCode((String) result[1]);
                    }
                }
                Query queryReconType = em.createQuery("SELECT DISTINCT s.reconType FROM ReconClaimHdr s WHERE s.cclaimId = " + hdr.getCclaimId());
                String reconType = (String) queryReconType.getSingleResult();
                data.setReconType(reconType);

                results.add(data);
            }
        }
        setSummary(payload, reconId, "completed");
        payload.setDataList(results);
        return payload;
    }

    @Override
    public DataAndSummary getOverallSummary(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        setSummary(payload, reconId, "overall");
        payload.setDataList(null);
        return payload;
    }

    @Override
    public DataAndSummary getUpdatedSummary(DataAndSummary payload, String reconId, String type) {
        setSummary(payload, reconId, type);
        return payload;
    }

    private void setSummary(DataAndSummary summary, String reconId, String type) {
        StoredProcedureQuery summaryQuery;
     
        summaryQuery = em.createStoredProcedureQuery("GET_RECON_SUMMARY");
        summaryQuery.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
        summaryQuery.registerStoredProcedureParameter("p_type", String.class, ParameterMode.IN);
        summaryQuery.registerStoredProcedureParameter("total_count", BigInteger.class, ParameterMode.OUT);
        summaryQuery.registerStoredProcedureParameter("total_claimed_amt", Double.class, ParameterMode.OUT);
        summaryQuery.registerStoredProcedureParameter("total_rejected_amt", Double.class, ParameterMode.OUT);
        summaryQuery.registerStoredProcedureParameter("elig_rejected_amt", Double.class, ParameterMode.OUT);
        summaryQuery.registerStoredProcedureParameter("total_patient_share", Double.class, ParameterMode.OUT);
        summaryQuery.registerStoredProcedureParameter("total_paid_amt", Double.class, ParameterMode.OUT);
        switch (type) {
            case "candidates":
                summaryQuery.setParameter("p_type", "CANDIDATES");
                break;
            case "underProcess":
                summaryQuery.setParameter("p_type", "UNDER_PROCESS");
                break;
            case "completed":
                summaryQuery.setParameter("p_type", "COMPLETED");
                break;
            case "overall":
                summaryQuery.setParameter("p_type", "OVERALL");
                break;
            case "review":
                summaryQuery.setParameter("p_type", "REVIEW");
                break;
            case "pending":
                summaryQuery.setParameter("p_type", "PENDING");
                break;
            default:
                summaryQuery.setParameter("p_type", "CANDIDATES");
                break;
        }
        summaryQuery.setParameter("p_recon_id", reconId);
        summaryQuery.execute();
        if (summaryQuery.getOutputParameterValue("total_count") != null) {
            summary.setTotalCount((Long) summaryQuery.getOutputParameterValue("total_count"));
        } else {
            summary.setTotalCount(0);
        }
        if (summaryQuery.getOutputParameterValue("total_claimed_amt") != null) {
            summary.setTotalClaimedAmount((Double) summaryQuery.getOutputParameterValue("total_claimed_amt"));
        } else {
            summary.setTotalClaimedAmount(0);
        }
        if (summaryQuery.getOutputParameterValue("total_rejected_amt") != null) {
            summary.setTotalRejectedAmount((Double) summaryQuery.getOutputParameterValue("total_rejected_amt"));
        } else {
            summary.setTotalRejectedAmount(0);
        }
        if (summaryQuery.getOutputParameterValue("elig_rejected_amt") != null) {
            summary.setEligibleRejectedAmount((Double) summaryQuery.getOutputParameterValue("elig_rejected_amt"));
        } else {
            summary.setEligibleRejectedAmount(0);
        }
        if (summaryQuery.getOutputParameterValue("total_patient_share") != null) {
            summary.setTotalPatientShare((Double) summaryQuery.getOutputParameterValue("total_patient_share"));
        } else {
            summary.setTotalPatientShare(0);
        }
        if (summaryQuery.getOutputParameterValue("total_paid_amt") != null) {
            summary.setPaidAmount((Double) summaryQuery.getOutputParameterValue("total_paid_amt"));
        } else {
            summary.setPaidAmount(0);
        }
    }

    @Override
    public List candidateValidations(String reconId) {
        List errList = new ArrayList();
        List<StatusErrors> statusErr = new ArrayList<StatusErrors>();
        List<Object[]> grpErr;
        List<LocationErrors> locErr = new ArrayList<LocationErrors>();
        String reconType = null;
        TypedQuery<Object[]> query;
        Query reconTypeQuery = em.createQuery("select r.reconType from ReconCandidateClaims r where r.reconCandidateClaimsPK.reconId = :reconId");
        reconTypeQuery.setParameter("reconId", reconId);
        List<String> reconTypeList = reconTypeQuery.getResultList();
        if (reconTypeList != null && !reconTypeList.isEmpty()) {
            reconType = reconTypeList.get(0);
        }
        if (reconType != null && reconType.equalsIgnoreCase("PN")) {
            query = em.createQuery("select h.cclaimId, h.cclaimStatus from CclaimHdr h where exists (select 1 from ReconCandidateClaims c where c.reconCandidateClaimsPK.reconId = :reconId and c.reconCandidateClaimsPK.claimId = h.cclaimId) and h.cclaimStatus not in ('P')", Object[].class);
        } else {
            query = em.createQuery("select h.cclaimId, h.cclaimStatus from CclaimHdr h where exists (select 1 from ReconCandidateClaims c where c.reconCandidateClaimsPK.reconId = :reconId and c.reconCandidateClaimsPK.claimId = h.cclaimId) and h.cclaimStatus not in ('A','R')", Object[].class);
        }
        query.setParameter("reconId", reconId);
        List<Object[]> ls = query.getResultList();
        if (ls != null && !ls.isEmpty()) {
            for (Object[] result : ls) {
                StatusErrors se = new StatusErrors();
                se.setClaimId((String.valueOf((Double) result[0])));
                se.setClaimStatus((String) result[1]);
                statusErr.add(se);
            }
        }
        errList.add(statusErr);

        query = em.createQuery("select h.cclaimId from CclaimHdr h where (h.grpId = 0 or h.rcpId = 0 or h.membId = 0) and exists (select 1 from ReconCandidateClaims c where c.reconCandidateClaimsPK.claimId = h.cclaimId and c.reconCandidateClaimsPK.reconId = :reconId)", Object[].class);
        query.setParameter("reconId", reconId);
        grpErr = query.getResultList();
        errList.add(grpErr);

        query = em.createQuery("select t.reconCandidateClaimsPK.claimId, t.reconCandidateClaimsPK.locationCd from ReconCandidateClaims t where t.reconCandidateClaimsPK.reconId = :reconId and exists (select 1 from CclaimItem i where i.cclaimItemPK.cclaimId = t.reconCandidateClaimsPK.claimId and i.prvdLocCd != t.reconCandidateClaimsPK.locationCd)", Object[].class);
        query.setParameter("reconId", reconId);
        ls = query.getResultList();
        if (ls != null && !ls.isEmpty()) {
            for (Object[] result : ls) {
                LocationErrors le = new LocationErrors();
                le.setClaimId((String.valueOf((BigInteger) result[0])));
                le.setLocationCode((String) result[1]);
                locErr.add(le);
            }
        }
        errList.add(locErr);

        return errList;
    }

    @Override
    public boolean deleteStatusErrors(String reconId, List<StatusErrors> errorClaims)
            throws Exception {
        String claim = null;
        try {
            Query query = em.createQuery("DELETE from ReconCandidateClaims r where r.reconCandidateClaimsPK.reconId = :reconId and r.reconCandidateClaimsPK.claimId = :claimId");
            for (StatusErrors err : errorClaims) {
                query.setParameter("reconId", reconId);
                claim = err.getClaimId();
                query.setParameter("claimId", new BigInteger(claim));
                query.executeUpdate();
            }
        } catch (Exception e) {
            throw new Exception("Can't delete status error claim: " + claim + " for recon id: " + reconId, e);
        }
        return true;
    }

    @Override
    public boolean deleteGroupErrors(String reconId, List errorClaims)
            throws Exception {
        Double claim = null;
        try {
            Query query = em.createQuery("DELETE from ReconCandidateClaims r where r.reconCandidateClaimsPK.reconId = :reconId and r.reconCandidateClaimsPK.claimId = :claimId");
            for (Object err : errorClaims) {
                query.setParameter("reconId", reconId);
                claim = (Double) err;
                query.setParameter("claimId", claim.longValue());
                query.executeUpdate();
            }
        } catch (Exception e) {
            throw new Exception("Can't delete group/member error claim: " + claim + " for recon id: " + reconId, e);
        }
        return true;
    }

    @Override
    public boolean deleteLocationErrors(String reconId, List<LocationErrors> errorClaims)
            throws Exception {
        String claim = null;
        try {
            Query query = em.createQuery("DELETE from ReconCandidateClaims r where r.reconCandidateClaimsPK.reconId = :reconId and r.reconCandidateClaimsPK.claimId = :claimId");
            for (LocationErrors err : errorClaims) {
                query.setParameter("reconId", reconId);
                claim = err.getClaimId();
                query.setParameter("claimId", new BigInteger(claim));
                query.executeUpdate();
            }
        } catch (Exception e) {
            throw new Exception("Can't delete location error claim: " + claim + " for recon id: " + reconId, e);
        }
        return true;
    }

    @Override
    public boolean updateAllLocationErrors(String reconId, String locationCd, List<LocationErrors> errorClaims, String user) throws Exception {

        String claim = null;
        try {
            Query query = em.createQuery("UPDATE ReconCandidateClaims r SET r.reconCandidateClaimsPK.locationCd = :locationCd, r.lastUpdatedBy = :user, r.lastUpdatedOn = :lastUpdatedOn where r.reconCandidateClaimsPK.reconId = :reconId and r.reconCandidateClaimsPK.claimId = :claimId");
            for (LocationErrors err : errorClaims) {
                query.setParameter("reconId", reconId);
                claim = err.getClaimId();
                query.setParameter("locationCd", locationCd);
                query.setParameter("claimId", new BigInteger(claim));
                query.setParameter("user", user);
                query.setParameter("lastUpdatedOn", Calendar.getInstance().getTime());
                query.executeUpdate();
            }
        } catch (Exception e) {
            throw new Exception("Can't update location error claim: " + claim + " for recon id: " + reconId, e);
        }

        return true;
    }

    @Override
    public boolean updateLocationError(String reconId, String locationCd, String errorClaim, String user) throws Exception {

        try {
            Query query = em.createQuery("UPDATE ReconCandidateClaims r SET r.reconCandidateClaimsPK.locationCd = :locationCd, r.lastUpdatedBy = :user, r.lastUpdatedOn = :lastUpdatedOn where r.reconCandidateClaimsPK.reconId = :reconId and r.reconCandidateClaimsPK.claimId = :claimId");
            query.setParameter("reconId", reconId);
            query.setParameter("locationCd", locationCd);
            query.setParameter("claimId", new BigInteger(errorClaim));
            query.setParameter("user", user);
            query.setParameter("lastUpdatedOn", Calendar.getInstance().getTime());
            query.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Can't update location error claim: " + errorClaim + " for recon id: " + reconId, e);
        }

        return true;
    }

    @Override
    public void insertReconStagingData(String reconId, String user) throws Exception {

        StoredProcedureQuery insertQuery;
        try {
            insertQuery = em.createStoredProcedureQuery("RECON_INSERT_STAGING_DATA");
            insertQuery.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
            insertQuery.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
            insertQuery.registerStoredProcedureParameter("error_msg", String.class, ParameterMode.OUT);

            insertQuery.setParameter("p_recon_id", reconId);
            insertQuery.setParameter("p_user", user);
            insertQuery.execute();
            if (insertQuery.getOutputParameterValue("error_msg") != null
                    && ((String) insertQuery.getOutputParameterValue("error_msg")).equalsIgnoreCase("Y")) {
                throw new AlreadyExistsException("Record already exists in database.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void updateReconClaimsData(ReconClaimsDataPK key, Double newAmount, String notes, String user) throws Exception {
        ReconClaimsData data = em.find(ReconClaimsData.class, key);
        if (data == null) {
            throw new AlreadyExistsException("Can not update the record, no such record exists in the databse.");
        }
        if (data != null && data.getFrozen() == 1) {
            throw new AlreadyExistsException("Can not update this record as it is frozen for update.");
        }
        //BigDecimal roundOffNewAmount = (BigDecimal) Math.round(a * 100.0) / 100.0;
        
       // System.out.println("\Suhas TEST :::"+roundOffNewAmount);
        
        data.setNewPayableAmt(new Double(newAmount.doubleValue()));
        data.setNotes(notes);
        data.setLastUpdatedBy(user);
        data.setLastUpdatedOn(Calendar.getInstance().getTime());
        em.persist(data);
    }

    @Override
    public void deleteRecon(String reconId) throws Exception {

        Query query = em.createQuery("SELECT 1 from CclaimHdr h WHERE EXISTS (SELECT 1 from ReconClaimHdr r WHERE r.cclaimId=h.cclaimId and r.reconId = :reconId) and h.cclaimStatus NOT IN ('U','P')");
        query.setParameter("reconId", reconId);
        List ls = query.getResultList();
        if (ls != null && !ls.isEmpty()) {
            throw new AlreadyExistsException("Can't delete recon because accepted recon claims exist in production.");
        }

        StoredProcedureQuery deleteQuery;
        try {
            deleteQuery = em.createStoredProcedureQuery("RECON_DELETE_ALL");
            deleteQuery.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
            deleteQuery.setParameter("p_recon_id", reconId);
            deleteQuery.execute();
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public ReconDataValidationErrors validateReconData(String reconId) {
        ReconDataValidationErrors err = new ReconDataValidationErrors();
        
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("RECON_VALIDATE_RECON_DATA", ReconClaimsData.class, ReconClaimsData.class, ReconClaimsData.class);
        query.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("zero_cursor", void.class, ParameterMode.REF_CURSOR);
        query.registerStoredProcedureParameter("null_cursor", void.class, ParameterMode.REF_CURSOR);
        query.registerStoredProcedureParameter("amt_cursor", void.class, ParameterMode.REF_CURSOR);
        query.setParameter("p_recon_id", reconId);
        boolean execute = query.execute();
        err.setZeroErrors((List<ReconClaimsData>) query.getOutputParameterValue("zero_cursor"));
        err.setNullErrors((List<ReconClaimsData>) query.getOutputParameterValue("null_cursor"));
        err.setAmtErrors((List<ReconClaimsData>) query.getOutputParameterValue("amt_cursor"));

        return err;
    }

    @Override
    public boolean deleteReconDataErrors(List<ReconClaimsData> errorClaims)
            throws Exception {
        try {
            for (ReconClaimsData err : errorClaims) {
                ReconClaimsData data = em.find(ReconClaimsData.class, err.getReconClaimsDataPK());
                if (data == null) {
                    throw new AlreadyExistsException("Record does not exist in database. Claim Id: " + err.getReconClaimsDataPK().getClaimId()
                            + " Claim Item: " + err.getReconClaimsDataPK().getCclaimItem() + " Recon Id: " + err.getReconClaimsDataPK().getReconId());
                }
                em.remove(data);
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    @Override
    public void generateNewReconClaims(String reconId, String user) throws Exception {
        StoredProcedureQuery query;
        try {
            query = em.createStoredProcedureQuery("RECON_GENERATE_NEW_CLAIMS");
            query.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("error_msg", String.class, ParameterMode.OUT);
            query.setParameter("p_recon_id", reconId);
            query.setParameter("p_user", user);
            query.execute();
            if (query.getOutputParameterValue("error_msg") != null
                    && ((String) query.getOutputParameterValue("error_msg")).equalsIgnoreCase("Y")) {
                throw new AlreadyExistsException("Record already exists in database.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void updateCreditNoteNumber(String reconId, List<ReconClaimHdr> hdrList, String user, String chqEftNum) throws Exception {

        for (ReconClaimHdr claim : hdrList) {
            ReconClaimHdr hdr = em.find(ReconClaimHdr.class, claim.getCclaimId());
            if (hdr == null) {
                throw new AlreadyExistsException("Claim Id: " + claim.getCclaimId() + " is not available in the database.");
            }
            if (hdr.getFrozen() != 1) {
                hdr.setChqEftNum(chqEftNum);
                hdr.setLastUpdatedBy(user);
                hdr.setLastUpdatedOn(Calendar.getInstance().getTime());
            }
        }
    }

    @Override
    public void acceptClaimsInproduction(String reconId, String reconType, String user) throws Exception {
        StoredProcedureQuery query;
        try {
            if (reconType.equalsIgnoreCase("PN")) {
                query = em.createStoredProcedureQuery("RECON_ACCEPT_PENDING_CLAIMS");
                query.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
                query.setParameter("p_recon_id", reconId);
                query.setParameter("p_user", user);
            } else {
                query = em.createStoredProcedureQuery("RECON_ACCEPT_CLAIMS_IN_PROD");
                query.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("p_paid_flag", String.class, ParameterMode.IN);
                query.setParameter("p_recon_id", reconId);
                query.setParameter("p_user", user);
                if (reconType.equalsIgnoreCase("AS")) {
                    query.setParameter("p_paid_flag", "Y");
                } else if (reconType.equalsIgnoreCase("AN")) {
                    query.setParameter("p_paid_flag", "N");
                }
            }
            query.execute();
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void updatePendingReconClaimsInProduction(String reconId, String user) throws Exception {
        DataAndSummary data = getReconClaimsDataByReconId(reconId);
        List<ReconClaimsData> ls = data.getDataList();
        for (ReconClaimsData claim : ls) {
            if (claim.getFrozen() == 1) {
                continue;
            }
            CclaimItem item = em.find(CclaimItem.class, new CclaimItemPK(claim.getReconClaimsDataPK().getClaimId(), claim.getReconClaimsDataPK().getCclaimItem()));
            if (item == null) {
                throw new AlreadyExistsException("Item " + claim.getReconClaimsDataPK().getCclaimItem() + " for claim Id " + claim.getReconClaimsDataPK().getClaimId() + " is not available in database.");
            } else if (!item.getCclaimHdr().getCclaimStatus().equalsIgnoreCase("P")) {
                throw new AlreadyExistsException("Claim Id " + claim.getReconClaimsDataPK().getClaimId() + " is not in pending status.");
            }
        }
        StoredProcedureQuery updateQuery;
        try {
            updateQuery = em.createStoredProcedureQuery("RECON_UPDATE_PENDING_CLAIMS");
            updateQuery.registerStoredProcedureParameter("p_recon_id", String.class, ParameterMode.IN);
            updateQuery.registerStoredProcedureParameter("p_user", String.class, ParameterMode.IN);
            updateQuery.registerStoredProcedureParameter("p_workflow_user", String.class, ParameterMode.OUT);
            updateQuery.registerStoredProcedureParameter("p_claim_under_edit", BigInteger.class, ParameterMode.OUT);
            updateQuery.setParameter("p_recon_id", reconId);
            updateQuery.setParameter("p_user", user);
            updateQuery.execute();
            if (updateQuery.getOutputParameterValue("p_workflow_user") != null) {
                throw new AlreadyExistsException("Can't update claims because claim Id: "
                        + updateQuery.getOutputParameterValue("p_claim_under_edit") + " is being edited by user: "
                        + updateQuery.getOutputParameterValue("p_workflow_user"));
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public DataAndSummary getPendingReconClaimsByReconId(String reconId) {
        DataAndSummary payload = new DataAndSummary();
        ArrayList<CclaimItem> results = new ArrayList<CclaimItem>();
        Query query = em.createQuery("SELECT i FROM CclaimItem i WHERE EXISTS (SELECT 1 FROM ReconClaimsData r WHERE r.reconClaimsDataPK.reconId = :reconId and r.reconClaimsDataPK.claimId = i.cclaimItemPK.cclaimId and r.reconClaimsDataPK.cclaimItem = i.cclaimItemPK.cclaimItem)");
        query.setParameter("reconId", reconId);
        List<CclaimItem> list = query.getResultList();
        if (list != null && !list.isEmpty()) {
            for (CclaimItem claim : list) {
                results.add(claim);
            }
        }
        setSummary(payload, reconId, "pending");
        payload.setDataList(results);
        return payload;
    }

    @Override
    public void validateNewPayableAmount(ReconClaimsData data) throws Exception {
        Double amt = data.getNewPayableAmt();
        if (amt != null) {
            if (amt.doubleValue() < 0) {
                throw new AlreadyExistsException(("New payable Amount can't be less than 0. Claim Id: " + data.getReconClaimsDataPK().getClaimId()
                        + " Claim item: " + data.getReconClaimsDataPK().getCclaimItem()));
            }
        }
    }
}
