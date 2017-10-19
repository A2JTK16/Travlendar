/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author AGS
 */
public class City {
    private String city_code;
    private String city_name;
    private String province_code;

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
     * @return the city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * @param city_name the city_name to set
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
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
}
