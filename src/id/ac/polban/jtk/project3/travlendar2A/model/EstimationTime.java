package id.ac.polban.jtk.project3.travlendar2A.model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import id.ac.polban.jtk.project3.travlendar2A.model.TransportationMode;
import id.ac.polban.jtk.project3.travlendar2A.model.TransportationMode.Transport;
import java.util.Date;


/**
 *
 * @author Reza Dwi Kurniawan
 */
public class EstimationTime {
    private int distance;
    private int speed;
   
    /**
     * @return the distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
 
    public int countEstimationTime(int speed, int distance){
        this.speed = speed;
        this.distance = distance;        
        return distance/speed;
    }
    
    public static void main(String[] args) {
        Transport tp = null;
        int speed, jarak;
        TransportationMode tm = new TransportationMode();
        EstimationTime et = new EstimationTime();
        et.setDistance(100);
        jarak = et.getDistance();
        speed = tm.vehicleSpeed(tp.Mobil);
        System.out.println(et.countEstimationTime(speed,jarak)+" hours");
    }
}