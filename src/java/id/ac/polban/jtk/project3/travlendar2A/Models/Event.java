/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import java.sql.Timestamp;

/**
 *
 * @author mufidjamaluddin
 * 
 * Sudah disamakan dengan database
 */
public class Event 
{
    private Long event_id;
    private Integer location_id;
    private Long traveller_id;
    private String event_name;
    private Timestamp start_event;
    private Timestamp end_event;
    private String note;

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
