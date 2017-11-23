/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author Auliya Aqma Dinillah
 */
public class Traveller {
    private Long traveller_id;
    private String traveller_name;
    private String traveller_email;
    private String traveller_password;
    private String traveller_fullname;
    private String traveller_address;

    /**
     * @return the traveller_id
     */
    public Long getTraveller_id() {
        return traveller_id;
    }

    /**
     * @param traveller_id the traveller_id to set
     */
    public void setTraveller_id(Long traveller_id) {
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
     * @return the traveller_fullname
     */
    public String getTraveller_fullname() {
        return traveller_fullname;
    }

    /**
     * @param traveller_fullname the traveller_fullname to set
     */
    public void setTraveller_fullname(String traveller_fullname) {
        this.traveller_fullname = traveller_fullname;
    }

    /**
     * @return the traveller_address
     */
    public String getTraveller_address() {
        return traveller_address;
    }

    /**
     * @param traveller_address the traveller_address to set
     */
    public void setTraveller_address(String traveller_address) {
        this.traveller_address = traveller_address;
    }
}
