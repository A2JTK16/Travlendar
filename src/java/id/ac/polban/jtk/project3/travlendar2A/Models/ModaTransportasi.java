/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author mufidjamaluddin
 */
public class ModaTransportasi {
   private int KodeTransportasi;
   private String NamaTransportasi;
   private float Kecepatan;

    /**
     * @return the KodeTransportasi
     */
    public int getKodeTransportasi() {
        return KodeTransportasi;
    }

    /**
     * @param KodeTransportasi the KodeTransportasi to set
     */
    public void setKodeTransportasi(int KodeTransportasi) {
        this.KodeTransportasi = KodeTransportasi;
    }

    /**
     * @return the NamaTransportasi
     */
    public String getNamaTransportasi() {
        return NamaTransportasi;
    }

    /**
     * @param NamaTransportasi the NamaTransportasi to set
     */
    public void setNamaTransportasi(String NamaTransportasi) {
        this.NamaTransportasi = NamaTransportasi;
    }

    /**
     * @return the Kecepatan
     */
    public float getKecepatan() {
        return Kecepatan;
    }

    /**
     * @param Kecepatan the Kecepatan to set
     */
    public void setKecepatan(float Kecepatan) {
        this.Kecepatan = Kecepatan;
    }

   
}
