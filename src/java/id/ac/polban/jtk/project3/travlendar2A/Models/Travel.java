/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import java.sql.Timestamp;

/**
 *
 * @author Auliya Aqma Dinillah
 */
public class Travel {
    private Float event_id;
    private Timestamp departure_time;
    private String traveller_username;
    private int start_location_id;
    private int end_location_id;
    private String transportation_mode;

    /**
     * @return the event_id
     */
    public Float getEvent_id() {
        return event_id;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEvent_id(Float event_id) {
        this.event_id = event_id;
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
     * @return the start_location_id
     */
    public int getStart_location_id() {
        return start_location_id;
    }

    /**
     * @param start_location_id the start_location_id to set
     */
    public void setStart_location_id(int start_location_id) {
        this.start_location_id = start_location_id;
    }

    /**
     * @return the end_location_id
     */
    public int getEnd_location_id() {
        return end_location_id;
    }

    /**
     * @param end_location_id the end_location_id to set
     */
    public void setEnd_location_id(int end_location_id) {
        this.end_location_id = end_location_id;
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
}
