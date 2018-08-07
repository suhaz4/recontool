/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oic.hcs.recon.utility;

/**
 *
 * @author noaman000
 */
public class AlreadyExistsException extends Exception{
    
    public AlreadyExistsException(String message){
        super(message);
    }
}
