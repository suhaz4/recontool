/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.utility;

import com.oic.hcs.recon.entity.ReconClaimsData;
import java.util.List;

/**
 *
 * @author noaman000
 */
public class ReconDataValidationErrors {
    List<ReconClaimsData> nullErrors;
    List<ReconClaimsData> zeroErrors;
    List<ReconClaimsData> amtErrors;

    public List<ReconClaimsData> getNullErrors() {
        return nullErrors;
    }

    public void setNullErrors(List<ReconClaimsData> nullErrors) {
        this.nullErrors = nullErrors;
    }

    public List<ReconClaimsData> getZeroErrors() {
        return zeroErrors;
    }

    public void setZeroErrors(List<ReconClaimsData> zeroErrors) {
        this.zeroErrors = zeroErrors;
    }

    public List<ReconClaimsData> getAmtErrors() {
        return amtErrors;
    }

    public void setAmtErrors(List<ReconClaimsData> amtErrors) {
        this.amtErrors = amtErrors;
    }
    
    
}
