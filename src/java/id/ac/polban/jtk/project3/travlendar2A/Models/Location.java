package id.ac. polban.jtk.project3.travlendar2A.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Auliya Aqma Dinillah
 */
public class Location
{

   private int idEvent;
   private String latitude;
   private String longitude;
   private String description;
   
    public Location()
    {
        
    }
    
    public Location(int idEvent, String latitude, String longitude, String desc)
    {
        this.idEvent = idEvent;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = desc;
    }

    /**
     * @return the idEvent
     */
    public int getIdEvent() {
        return idEvent;
    }

    /**
     * @param idEvent the idEvent to set
     */
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

   
  
}