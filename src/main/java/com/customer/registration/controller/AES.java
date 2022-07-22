package com.customer.registration.controller;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



public class AES {
	
	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
    
    
 
    
    public static String encrypt(String valueToEnc) throws Exception {
    	 
        Key key =new SecretKeySpec(keyValue, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
  
        byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
        byte[] encryptedByteValue = new Base64().encode(encValue);

  
        return new String(encryptedByteValue);
    }
    
    public static String decrypt(String encryptedValue) throws Exception {
        // Key key = generateKey();
    	Key key =new SecretKeySpec(keyValue, ALGORITHM);
         Cipher cipher = Cipher.getInstance(ALGORITHM);
         cipher.init(Cipher.DECRYPT_MODE, key);
          
         byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());
  
         byte[] enctVal = cipher.doFinal(decodedBytes);
         
        
         return new String(enctVal);
     }
    
    }