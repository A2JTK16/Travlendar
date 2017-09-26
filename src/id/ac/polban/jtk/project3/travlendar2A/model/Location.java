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
public class Location {
    private String [] nama_lokasi = {"Bandung", "Bekasi", "Bogor","Ciamis", "Cianjur","Cirebon","Garut","Indramayu","Karawang","Kuningan","Majalengka", "Pangandaran","Purwakarta","Subang","Sukabumi","Sumedang","Tasikmalaya"};
    private int [] kode_lokasi = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
    private String Nama_Lokasi;
    private int Kode_Lokasi;

    public String[] getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String[] nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }

    public int[] getKode_lokasi() {
        return kode_lokasi;
    }

    public void setKode_lokasi(int[] kode_lokasi) {
        this.kode_lokasi = kode_lokasi;
    }

    public int getKode_Lokasi() {
        for (int i=0;i<17;i++)
        {
          if (Nama_Lokasi.equals(nama_lokasi[i]))  
          this.Kode_Lokasi=kode_lokasi[i];
        }
        return Kode_Lokasi;
    }

    public void setKode_Lokasi(int Kode_Lokasi) {
        this.Kode_Lokasi = Kode_Lokasi;
    }

    public String getNama_Lokasi() {
        return Nama_Lokasi;
    }

    public void setNama_Lokasi(String Nama_Lokasi) {
        this.Nama_Lokasi = Nama_Lokasi;
    }
}

