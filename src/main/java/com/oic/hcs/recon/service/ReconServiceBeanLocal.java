/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.service;

import com.oic.hcs.recon.entity.ReconClaimHdr;
import com.oic.hcs.recon.entity.ReconClaimsData;
import com.oic.hcs.recon.entity.ReconClaimsDataPK;
//import java.math.Double;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;
import com.oic.hcs.recon.utility.DataAndSummary;
import com.oic.hcs.recon.utility.LocationErrors;
import com.oic.hcs.recon.utility.ReconDataValidationErrors;
import com.oic.hcs.recon.utility.StatusErrors;

/**
 *
 * @author noaman000
 */
@Local
public interface ReconServiceBeanLocal {
    
    public void insertCandidateClaim(BigInteger claimId,String locationCode,String reconId,String createdBy,String reconType)
            throws Exception;
    public double authenticate(String username,String password);
    public DataAndSummary getReconClaimItemsByReconId(String reconId);
    public DataAndSummary getReconClaimHdrByReconId(String reconId);
    public DataAndSummary getReconClaimsDataByReconId(String reconId);
    public DataAndSummary getCandidatesByReconId(String reconId);
    public DataAndSummary getCompletedReconByReconId(String reconId);
    public DataAndSummary getOverallSummary(String reconId);
    public List candidateValidations(String reconId);
    public boolean deleteStatusErrors(String reconId,List<StatusErrors> errorClaims) throws Exception;
    public boolean deleteGroupErrors(String reconId, List errorClaims) throws Exception;
    public boolean deleteLocationErrors(String reconId, List<LocationErrors> errorClaims) throws Exception;
    public boolean updateAllLocationErrors(String reconId, String locationCd, List<LocationErrors> errorClaims, String user) throws Exception;
    public boolean updateLocationError(String reconId, String locationCd, String errorClaim,String user) throws Exception;
    public void insertReconStagingData(String reconId, String user) throws Exception;
    public void updateReconClaimsData(ReconClaimsDataPK key, Double newAmount, String notes, String user) throws Exception;
    public DataAndSummary getUpdatedSummary(DataAndSummary payload, String reconId, String type);
    public void deleteRecon(String reconId) throws Exception;
    public ReconDataValidationErrors validateReconData(String reconId);
    public boolean deleteReconDataErrors(List<ReconClaimsData> errorClaims)
    throws Exception;
    public void generateNewReconClaims(String reconId, String user) throws Exception;
    public void updateCreditNoteNumber(String reconId, List<ReconClaimHdr> hdrList, String user, String chqEftNum) throws Exception;
    public void acceptClaimsInproduction(String reconId, String reconType, String user) throws Exception;
    public void updatePendingReconClaimsInProduction(String reconId, String user) throws Exception;
    public DataAndSummary getPendingReconClaimsByReconId(String reconId);
    public void clearAndInsertReconClaimsData(List<ReconClaimsData> ls, String user);
     public void validateNewPayableAmount(ReconClaimsData data) throws Exception;
}
