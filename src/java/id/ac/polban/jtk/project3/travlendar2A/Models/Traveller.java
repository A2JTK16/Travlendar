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
    private int traveller_id;
    private String traveller_name;
    private String traveller_email;
    private String traveller_password;
    private String traveller_fullName;
    
    
    public Traveller() {
//        this.traveller_fullName = traveller_fullName;
//        this.traveller_name = traveller_name;
//        this.traveller_email = traveller_email;
//        this.traveller_password = traveller_password;
    }

    /*
     * Setter digunakan untuk setting apabila data Traveller telah di diisi dengan menggunakan konstruktor 
     * Karena apabila tidak ada setter maka variabel akan/harus menjadi bertipe final(konstan) sehingga
     * nantinya variabel tersebut tidak dapat di rubah isinya
    */

    /**
     * @return the traveller_id
     */
    public int getTraveller_id() {
        return traveller_id;
    }

    /**
     * @param traveller_id the traveller_id to set
     */
    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
    }

    /**
     * @return the traveller_name
     */
    public String getTraveller_name() {
        return traveller_name;
    }

    /**
     * @param traveller_name the traveller_name to set
     */
    public void setTraveller_name(String traveller_name) {
        this.traveller_name = traveller_name;
    }

    /**
     * @return the traveller_email
     */
    public String getTraveller_email() {
        return traveller_email;
    }

    /**
     * @param traveller_email the traveller_email to set
     */
    public void setTraveller_email(String traveller_email) {
        this.traveller_email = traveller_email;
    }

    /**
     * @return the traveller_password
     */
    public String getTraveller_password() {
        return traveller_password;
    }

    /**
     * @param traveller_password the traveller_password to set
     */
    public void setTraveller_password(String traveller_password) {
        this.traveller_password = traveller_password;
    }

    /**
     * @return the traveller_fullName
     */
    public String getTraveller_fullName() {
        return traveller_fullName;
    }

    /**
     * @param traveller_fullName the traveller_fullName to set
     */
    public void setTraveller_fullName(String traveller_fullName) {
        this.traveller_fullName = traveller_fullName;
    }
}
