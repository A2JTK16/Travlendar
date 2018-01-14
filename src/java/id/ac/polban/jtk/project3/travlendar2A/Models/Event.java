/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author mufidjamaluddin
 * 
 * Sudah disamakan dengan database
 */
public class Event 
{
    @JsonProperty(value = "id")
    private String event_id;
        
    private Integer start_location_id;
    private Integer end_location_id;
    @JsonProperty(value = "username")
    private String traveller_username;   
    @JsonProperty(value = "title")
    private String event_name;
    @JsonProperty(value = "start")
    private Timestamp start_event;
    @JsonProperty(value = "end")
    private Timestamp end_event;
    
    private String note;

    /**
     * @return the event_id
     */
    public String getEvent_id() {
        return event_id;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    /**
     * @return the start_location_id
     */
    public Integer getStart_location_id() {
        return start_location_id;
    }

    /**
     * @param start_location_id the start_location_id to set
     */
    public void setStart_location_id(Integer start_location_id) {
        this.start_location_id = start_location_id;
    }

    /**
     * @return the end_location_id
     */
    public Integer getEnd_location_id() {
        return end_location_id;
    }

    /**
     * @param end_location_id the end_location_id to set
     */
    public void setEnd_location_id(Integer end_location_id) {
        this.end_location_id = end_location_id;
    }

    /**
     * @return the traveller_username
     */
    public String getTraveller_username() {
        return traveller_username;
    }

    /**
     * @param traveller_username the traveller_username to set
     */
    public void setTraveller_username(String traveller_username) {
        this.traveller_username = traveller_username;
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
