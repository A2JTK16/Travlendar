/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

/**
 *
 * @author mufidjamaluddin
 */
public class ViewEvent 
{
    @JsonProperty(value = "id")
    private Long event_id;
    
    @JsonProperty(value = "title")
    private String event_name;
    
    @JsonProperty(value = "start")
    private Timestamp start_event;
    
    @JsonProperty(value = "end")
    private Timestamp end_event;
    
    @JsonProperty(value = "transportation")
    private String transportation_mode;
    
    @JsonProperty(value = "depature_time")
    private Timestamp depature_time;
    
    @JsonProperty(value = "latitude")
    private Float strt_loc_lat;
    
    @JsonProperty(value = "longitude")
    private Float strt_loc_long;
    
   // private Float end_loc_lat;
    //private Float end_loc_long;
    
    @JsonProperty(value = "address")
    private String start_location_name;
    
    private String note;
  //  private String username;
   // private String fullname;
  //  private String home_address;

    /**
     * @return the event_id
     */
    public Long getEvent_id() {
        return event_id;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    /**
     * @return the event_name
     */
    public String getEvent_name() {
        return event_name;
    }

    /**
     * @param event_name the event_name to set
     */
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    /**
     * @return the start_event
     */
    public Timestamp getStart_event() {
        return start_event;
    }

    /**
     * @param start_event the start_event to set
     */
    public void setStart_event(Timestamp start_event) {
        this.start_event = start_event;
    }

    /**
     * @return the end_event
     */
    public Timestamp getEnd_event() {
        return end_event;
    }

    /**
     * @param end_event the end_event to set
     */
    public void setEnd_event(Timestamp end_event) {
        this.end_event = end_event;
    }

    /**
     * @return the transportation_mode
     */
    public String getTransportation_mode() {
        return transportation_mode;
    }

    /**
     * @param transportation_mode the transportation_mode to set
     */
    public void setTransportation_mode(String transportation_mode) {
        this.transportation_mode = transportation_mode;
    }

    /**
     * @return the departure_time
     */
    public Timestamp getDepature_time() {
        return depature_time;
    }

    /**
     * @param departure_time the departure_time to set
     */
    public void setDepature_time(Timestamp departure_time) {
        this.depature_time = departure_time;
    }

    /**
     * @return the strt_loc_lat
     */
    public Float getStrt_loc_lat() {
        return strt_loc_lat;
    }

    /**
     * @param strt_loc_lat the strt_loc_lat to set
     */
    public void setStrt_loc_lat(Float strt_loc_lat) {
        this.strt_loc_lat = strt_loc_lat;
    }

    /**
     * @return the strt_loc_long
     */
    public Float getStrt_loc_long() {
        return strt_loc_long;
    }

    /**
     * @param strt_loc_long the strt_loc_long to set
     */
    public void setStrt_loc_long(Float strt_loc_long) {
        this.strt_loc_long = strt_loc_long;
    }

    /**
     * @return the start_location_name
     */
    public String getStart_location_name() {
        return start_location_name;
    }

    /**
     * @param start_location_name the start_location_name to set
     */
    public void setStart_location_name(String start_location_name) {
        this.start_location_name = start_location_name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
   
}
