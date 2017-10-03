package id.ac.polban.jtk.project3.travlendar2A.model;

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
    private String username;
    private String email;
    private String password;
    private String fullname;
    
    /**
     * 
     * @param fullname
     * @param username
     * @param email
     * @param password 
     */
    public Traveller(String fullname, String username, String email, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}
