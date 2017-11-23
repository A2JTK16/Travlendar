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
}
