/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 * 
 * Kelas Hash SHA - 1
 * 40 karakter 
 * 
 * @author mufidjamaluddin
 */
public class HashSHA1 
{
    /**
     * Instan dari class ini, Singleton
     */
    private static final HashSHA1 SHA1_INSTANCE = new HashSHA1();
    
    /**
     * Mendapatkan Instan
     * @return 
     */
    public static HashSHA1 getInstance()
    {
        return SHA1_INSTANCE;
    }
    
    /**
     * Object untuk hash
     */
    private MessageDigest crypt;
    
    /**
     * Konstruktor
     */
    public HashSHA1()
    {
        try 
        {
            /**
             * Mendapatkan object untuk hash
             */
            this.crypt = MessageDigest.getInstance("SHA-1");
        } 
        catch (NoSuchAlgorithmException ex) 
        {
            this.crypt = null;
            Logger.getLogger(HashSHA1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Hash Password SHA 256
     * @param data
     * @return 
     */
    public String hash(String data)
    {
        String result;
        try 
        {
            /**
             * Bersihkan 
             */
            this.crypt.reset();
            
            /**
             * Hash array byte dari String UTF-8 menjadi array byte hasil hash
             */
            byte[] hashresult = this.crypt.digest(data.getBytes("UTF-8"));
            
            /**
             * Konversi array byte menjadi string
             */
            result = DatatypeConverter.printHexBinary(hashresult);
        } 
        catch (UnsupportedEncodingException ex) 
        {
            result = null;
        }
        return result;
    }
    
    /*
     * Contoh Penggunaan
     * @param args
     *
    public static void main(String[] args)
    {
        **
         * Dapatkan Instans
         *
        HashSHA1 objHash = HashSHA1.getInstance();
        
        String password = "123";
        
        String hashpwd = objHash.hash(password);
        
        System.out.println("Password : " + password);
        
        System.out.println("Hasil Hash : " + hashpwd);
        
        System.out.println("Cek Panjang Hash (40 bukan) : " + hashpwd.length());
    }
    **/
}
