package id.ac.polban.jtk.project3.travlendar2A.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Auliya Aqma Dinillah
 */
public class Lokasi{

    /**
     * @return the kd_kota
     */
    public int getKd_kota() {
        return kd_kota;
    }

    /**
     * @param kd_kota the kd_kota to set
     */
    public void setKd_kota(int kd_kota) {
        this.kd_kota = kd_kota;
    }

    /**
     * @return the nm_kota
     */
    public String getNm_kota() {
        return nm_kota;
    }

    /**
     * @param nm_kota the nm_kota to set
     */
    public void setNm_kota(String nm_kota) {
        this.nm_kota = nm_kota;
    }

    /**
     * @return the kd_provinsi
     */
    public int getKd_provinsi() {
        return kd_provinsi;
    }

    /**
     * @param kd_provinsi the kd_provinsi to set
     */
    public void setKd_provinsi(int kd_provinsi) {
        this.kd_provinsi = kd_provinsi;
    }

    /**
     * @return the nm_provinsi
     */
    public String getNm_provinsi() {
        return nm_provinsi;
    }

    /**
     * @param nm_provinsi the nm_provinsi to set
     */
    public void setNm_provinsi(String nm_provinsi) {
        this.nm_provinsi = nm_provinsi;
    }
    
     /**
     * REVIEW :
     *      1. Sepertinya atribut Nama_lokasi dan Kode_lokasi tidak perlu 
     *          karena sudah ada array nama_lokasi dan array kode_lokasi
     */
        
    /**
     *  Review :
     *          1. atribut tipe lokasi simpan di awal bersama atribut nama_lokasi dan kode_lokasi
     */

    //private String [] nama_lokasi = {"Bandung", "Bekasi", "Bogor","Ciamis", "Cianjur","Cirebon","Garut","Indramayu","Karawang","Kuningan","Majalengka", "Pangandaran","Purwakarta","Subang","Sukabumi","Sumedang","Tasikmalaya"};
    //private int [] kode_lokasi = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    
    private String [] alamat_tempat = {"Rumah", "Kantor DPRD Bangka Tengah", "Bandara Depati Amir", "Bandara Soekarno Hatta", "Kantor DPRD Jakarta", "Tanggerang"};
    private int [] kd_lokasi = {1,2,3,4,5,6};
    private int [] tipe_Lokasi = {0,0,1,1,0,0}; //1=bandara, 0=biasa
    private int kd_kota;
    private String nm_kota;
    private int kd_provinsi;
    private String nm_provinsi;
    
    int m = alamat_tempat.length;
    
    //===============method==================
    
    //untuk menampilkan daftar alamat
    public void tampil_Lokasi () {
        for (int i=1;i<=m;i++){
            System.out.println(i + ". " + getNamaLoc(i));
        }
    }
    
    //untuk mereturn alamat
    public String getNamaLoc (int kodeTempat) {
        return alamat_tempat[kodeTempat-1];
    }

    //untuk mereturn tipe lokasi (bandara atau bukan)
    public int getTipe_Lokasi (int KodeLoc)
    {
        return tipe_Lokasi[KodeLoc];
    }
    
    //untuk pengecekan apakah bisa menggunakan pesawat atau tidak
    public boolean bisaDilaluiPesawat(int kodeTempatAwal, int kodeTempatAkhir)
    {
        Lokasi objLoc = new Lokasi ();
        if(objLoc.getTipe_Lokasi(kodeTempatAwal) == objLoc.getTipe_Lokasi(kodeTempatAkhir))
        {
            return true;
        } else {
            return false;
        }
    }
}