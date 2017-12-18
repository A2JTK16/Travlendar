/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ASUS
 */
public class Location {
    private Integer location_id;
    
    private Float latitude;
    
    private Float longitude;
    private String location_name;
    /**
     * @return the location_id
     */
    public Integer getLocation_id() {
        return location_id;
    }

    /**
     * @param location_id the location_id to set
     */
    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    /**
     * @return the latitude
     */
    public Float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public Float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the location_name
     */
    public String getLocation_name() {
        return location_name;
    }

    /**
     * @param location_name the location_name to set
     */
    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
    
}
