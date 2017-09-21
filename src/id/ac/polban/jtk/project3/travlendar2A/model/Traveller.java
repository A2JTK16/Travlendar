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
     * @return the email
     */
    public String getEmail() { //mengambil value email
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() { //mengambil value password
        return password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {//mengambil value fullname
        return fullname;
    }

    /*public static void main(String[] args) {
        Traveller data = new Traveller("maryammm", "maryam@gmail.com", "Siti Maryam", "maryam123");
        data.setId_traveller(421998);
        System.out.println("Id Traveller : " + data.getId_traveller());
        System.out.println("Username     : " + data.getUsername());
        System.out.println("Full Name    : " + data.getFullname());
        System.out.println("Email        : " + data.getEmail());
        System.out.println("Password     : " + data.getPassword());
    }*/
}
