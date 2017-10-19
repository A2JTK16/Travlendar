package id.ac.polban.jtk.project3.travlendar2A.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Auliya Aqma Dinillah
 */
public class Location{

    private String province_code;
    private String city_code;
    private int location_id;
    private String address_place;
    
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
        Location objLoc = new Location ();
        if(objLoc.getTipe_Lokasi(kodeTempatAwal) == objLoc.getTipe_Lokasi(kodeTempatAkhir))
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the province_code
     */
    public String getProvince_code() {
        return province_code;
    }

    /**
     * @param province_code the province_code to set
     */
    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    /**
     * @return the city_code
     */
    public String getCity_code() {
        return city_code;
    }

    /**
     * @param city_code the city_code to set
     */
    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    /**
     * @return the location_id
     */
    public int getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the address_place
     */
    public String getAddress_place() {
        return address_place;
    }

    /**
     * @param address_place the address_place to set
     */
    public void setAddress_place(String address_place) {
        this.address_place = address_place;
    }
}