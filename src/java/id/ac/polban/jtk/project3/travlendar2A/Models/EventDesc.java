/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author mufidjamaluddin
 */
public class EventDesc 
{
    private Event event;
    private Location startLocation;
    private Location endLocation;
    private Travel travel;
    
    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the startLocation
     */
    public Location getStartLocation() {
        return startLocation;
    }

    /**
     * @param startLocation the startLocation to set
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    /**
     * @return the endLocation
     */
    public Location getEndLocation() {
        return endLocation;
    }

    /**
     * @param endLocation the endLocation to set
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    /**
     * @return the travel
     */
    public Travel getTravel() {
        return travel;
    }

    /**
     * @param travel the travel to set
     */
    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
