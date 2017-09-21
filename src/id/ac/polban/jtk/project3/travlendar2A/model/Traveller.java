package id.ac.polban.jtk.project3.travlendar2A.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    Traveller() {
        
    }
    
    Traveller(String fullname) {
        this.fullname = fullname;
    }
    
    Traveller(String fullname, String username) {
        this.fullname = fullname;
        this.username = username;
    }
    
    Traveller(String fullname, String username, String email) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
    }
    
    Traveller(String fullname, String username, String email, String password) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * @return the id_traveller
     */
    public int getId_traveller() { //mengambil value id_traveller
        return id_traveller;
    }

    /**
     * @param id_traveller the id_traveller to set
     */
//mengubah value id_traveller
    public void setId_traveller(int id_traveller) { 
        this.id_traveller = id_traveller;
    }

    /**
     * @return the username
     */
    public String getUsername() { //mengambil value username
        return username;
    }

    /**
     * @param username the username to set
     */
	//mengubah value username
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() { //mengambil value email
        return email;
    }

    /**
     * @param email the email to set
     */
	//mengubah value email
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() { //mengambil value password
        return password;
    }

    /**
     * @param password the password to set
     */
	//mengubah value password
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {//mengambil value fullname
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
	//mengubah value fullname
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public static void main(String[] args) {
        Traveller data = new Traveller("maryammm", "maryam@gmail.com", "Siti Maryam", "maryam123");
        data.setId_traveller(421998);
        System.out.println("Id Traveller : " + data.getId_traveller());
        System.out.println("Username     : " + data.getUsername());
        System.out.println("Full Name    : " + data.getFullname());
        System.out.println("Email        : " + data.getEmail());
        System.out.println("Password     : " + data.getPassword());
    }
}
