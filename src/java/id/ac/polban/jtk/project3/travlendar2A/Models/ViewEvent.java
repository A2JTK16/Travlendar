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
    //@JsonProperty(value = "id")
    //private Long event_id;
    
    @JsonProperty(value = "title")
    private String event_name;
    
    @JsonProperty(value = "start")
    private Timestamp start_event;
    
    @JsonProperty(value = "end")
    private Timestamp end_event;
    
    @JsonProperty(value = "transportation")
    private String transportation_mode;
    
    @JsonProperty(value = "departure_time")
    private Timestamp departure_time;
    
    private String event_note;
    private String start_location_name;
    private float strt_loc_lat;
    private float strt_loc_long;
    private float end_loc_lat;
    private float end_loc_long;
    
    private String event_location_name;
    
    private String username;
    private String fullname;
    private String home_address;
    
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
     * @return the departure_time
     */
    public Timestamp getDeparture_time() {
        return departure_time;
    }

    /**
     * @param departure_time the departure_time to set
     */
    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
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
     * @return the event_note
     */
    public String getEvent_note() {
        return event_note;
    }

    /**
     * @param event_note the event_note to set
     */
    public void setEvent_note(String event_note) {
        this.event_note = event_note;
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
     * @return the strt_loc_lat
     */
    public float getStrt_loc_lat() {
        return strt_loc_lat;
    }

    /**
     * @param strt_loc_lat the strt_loc_lat to set
     */
    public void setStrt_loc_lat(float strt_loc_lat) {
        this.strt_loc_lat = strt_loc_lat;
    }

    /**
     * @return the strt_loc_long
     */
    public float getStrt_loc_long() {
        return strt_loc_long;
    }

    /**
     * @param strt_loc_long the strt_loc_long to set
     */
    public void setStrt_loc_long(float strt_loc_long) {
        this.strt_loc_long = strt_loc_long;
    }

    /**
     * @return the end_loc_lat
     */
    public float getEnd_loc_lat() {
        return end_loc_lat;
    }

    /**
     * @param end_loc_lat the end_loc_lat to set
     */
    public void setEnd_loc_lat(float end_loc_lat) {
        this.end_loc_lat = end_loc_lat;
    }

    /**
     * @return the end_loc_long
     */
    public float getEnd_loc_long() {
        return end_loc_long;
    }

    /**
     * @param end_loc_long the end_loc_long to set
     */
    public void setEnd_loc_long(float end_loc_long) {
        this.end_loc_long = end_loc_long;
    }

    /**
     * @return the event_location_name
     */
    public String getEvent_location_name() {
        return event_location_name;
    }

    /**
     * @param event_location_name the event_location_name to set
     */
    public void setEvent_location_name(String event_location_name) {
        this.event_location_name = event_location_name;
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

    /**
     * @return the home_address
     */
    public String getHome_address() {
        return home_address;
    }

    /**
     * @param home_address the home_address to set
     */
    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }
}
