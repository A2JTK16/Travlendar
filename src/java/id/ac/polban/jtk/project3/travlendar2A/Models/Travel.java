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
 * @author Auliya Aqma Dinillah
 */
public class Travel {
    private String event_id;
    private Timestamp depature_time;
    @JsonProperty(value = "username")
    private String traveller_username;
    private Integer start_location_id;
    private Integer end_location_id;
    @JsonProperty(value = "transportation")
    private String transportation_mode;

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
     * @return the depature_time
     */
    public Timestamp getDepature_time() {
        return depature_time;
    }

    /**
     * @param depature_time the depature_time to set
     */
    public void setDepature_time(Timestamp depature_time) {
        this.depature_time = depature_time;
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
