package id.ac.polban.jtk.project3.travlendar2A.test;

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
   private String lat;
   private String lng;
   private String desc;
   
    public Location()
    {
        
    }
    
    public Location(int idEvent, String lat, String lng, String desc)
    {
        this.idEvent = idEvent;
        this.lat = lat;
        this.lng = lng;
        this.desc = desc;
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
     * @return the lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat the lat to set
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return the lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng the lng to set
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }      
}