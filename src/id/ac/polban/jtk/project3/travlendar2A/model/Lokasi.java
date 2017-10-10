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
public class Lokasi extends Kota{
    
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