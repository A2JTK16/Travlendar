package id.ac.polban.jtk.project3.travlendar2A.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * REVIEW
 * 1.   Perlu ditamahkan ArrayList Event
 */

/**
 *
 * @author Auliya
 */

public class Traveller {
    //atribut pada kelas traveller
    private int id_traveller;
    private String nama_pengguna;
    private String alamat_email;
    private String kata_sandi;
    private String nama_lengkap;
    
    /**
     * 
     * @param nama_lengkap
     * @param nama_pengguna
     * @param alamat_email
     * @param kata_sandi
     */
    public Traveller(String nama_lengkap, String nama_pengguna, String alamat_email, String kata_sandi) {
        this.nama_lengkap = nama_lengkap;
        this.nama_pengguna = nama_pengguna;
        this.alamat_email = alamat_email;
        this.kata_sandi = kata_sandi;
    }
    
    /*
     * Setter digunakan untuk setting apabila data Traveller telah di diisi dengan menggunakan konstruktor 
     * Karena apabila tidak ada setter maka variabel akan/harus menjadi bertipe final(konstan) sehingga
     * nantinya variabel tersebut tidak dapat di rubah isinya
    */

    /**
     * @return the id_traveller
     */
    public int getId_traveller() {
        return id_traveller;
    }

    /**
     * @param id_traveller the id_traveller to set
     */
    public void setId_traveller(int id_traveller) {
        this.id_traveller = id_traveller;
    }

    /**
     * @return the nama_pengguna
     */
    public String getNama_pengguna() {
        return nama_pengguna;
    }

    /**
     * @param nama_pengguna the nama_pengguna to set
     */
    public void setNama_pengguna(String nama_pengguna) {
        this.nama_pengguna = nama_pengguna;
    }

    /**
     * @return the alamat_email
     */
    public String getAlamat_email() {
        return alamat_email;
    }

    /**
     * @param alamat_email the alamat_email to set
     */
    public void setAlamat_email(String alamat_email) {
        this.alamat_email = alamat_email;
    }

    /**
     * @return the kata_sandi
     */
    public String getKata_sandi() {
        return kata_sandi;
    }

    /**
     * @param kata_sandi the kata_sandi to set
     */
    public void setKata_sandi(String kata_sandi) {
        this.kata_sandi = kata_sandi;
    }

    /**
     * @return the nama_lengkap
     */
    public String getNama_lengkap() {
        return nama_lengkap;
    }

    /**
     * @param nama_lengkap the nama_lengkap to set
     */
    public void setNama_lengkap(String nama_lengkap) {
        this.nama_lengkap = nama_lengkap;
    }
}