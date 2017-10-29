/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

/**
 *
 * @author AGS
 */
public class Distance {
    
    private int start_location_id;
    
    private int end_location_id;
    
    private float distance;

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
     * @return the id_lokasi_awal
     */

    /**
     * @return the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(float distance) {
        this.distance = distance;
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

   
}
