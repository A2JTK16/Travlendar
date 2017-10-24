/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author AGS
 */
public class Distance {
    
    private String kd_provinsi_akhir;
    private String kd_kota__akhir;
    private int id_lokasi_akhir;
    
    private String kd_provinsi_awal;
    private String kd_kota_awal;
    private int id_lokasi_awal;
    
    private double distance;

    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * @return the kd_provinsi_akhir
     */
    public String getKd_provinsi_akhir() {
        return kd_provinsi_akhir;
    }

    /**
     * @param kd_provinsi_akhir the kd_provinsi_akhir to set
     */
    public void setKd_provinsi_akhir(String kd_provinsi_akhir) {
        this.kd_provinsi_akhir = kd_provinsi_akhir;
    }

    /**
     * @return the kd_kota__akhir
     */
    public String getKd_kota__akhir() {
        return kd_kota__akhir;
    }

    /**
     * @param kd_kota__akhir the kd_kota__akhir to set
     */
    public void setKd_kota__akhir(String kd_kota__akhir) {
        this.kd_kota__akhir = kd_kota__akhir;
    }

    /**
     * @return the id_lokasi_akhir
     */
    public int getId_lokasi_akhir() {
        return id_lokasi_akhir;
    }

    /**
     * @param id_lokasi_akhir the id_lokasi_akhir to set
     */
    public void setId_lokasi_akhir(int id_lokasi_akhir) {
        this.id_lokasi_akhir = id_lokasi_akhir;
    }

    /**
     * @return the kd_provinsi_awal
     */
    public String getKd_provinsi_awal() {
        return kd_provinsi_awal;
    }

    /**
     * @param kd_provinsi_awal the kd_provinsi_awal to set
     */
    public void setKd_provinsi_awal(String kd_provinsi_awal) {
        this.kd_provinsi_awal = kd_provinsi_awal;
    }

    /**
     * @return the kd_kota_awal
     */
    public String getKd_kota_awal() {
        return kd_kota_awal;
    }

    /**
     * @param kd_kota_awal the kd_kota_awal to set
     */
    public void setKd_kota_awal(String kd_kota_awal) {
        this.kd_kota_awal = kd_kota_awal;
    }

    /**
     * @return the id_lokasi_awal
     */
    public int getId_lokasi_awal() {
        return id_lokasi_awal;
    }

    /**
     * @param id_lokasi_awal the id_lokasi_awal to set
     */
    public void setId_lokasi_awal(int id_lokasi_awal) {
        this.id_lokasi_awal = id_lokasi_awal;
    }
}
