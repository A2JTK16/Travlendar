package id.ac.polban.jtk.project3.travlendar2A.model;

import id.ac.polban.jtk.project3.travlendar2A.model.TransportationMode.Transport;
import java.text.DecimalFormat;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Reza Dwi Kurniawan
 */
public class EstimationTime {
    private double distance;
    private double speed;
    private double eta;
   
    /**
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(int distance)    {
        this.distance = distance;
    }
 
    
    /**
     * @return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double countEstimationTime(double speed, double distance){
        this.speed = speed * 1000 / 3600;
        this.distance = distance * 1000;
        eta = distance/speed;
        return eta;
    }
    
    public void printDistance(){
        int inteta = (int) eta;
        eta = eta % 1 * 10 * 6;
        System.out.print(inteta/1+" hours");
        System.out.printf(" %.0f",eta);
        System.out.print(" minutes");
    }
    
    public static void main(String[] args) {
        Transport tp = null;
        double speed, jarak, eta;
        TransportationMode tm = new TransportationMode();
        EstimationTime et = new EstimationTime();
        et.setDistance(120);
        jarak = et.getDistance();
        speed = tm.vehicleSpeed(tp.Mobil);
        eta = et.countEstimationTime(speed,jarak);
        et.printDistance();
    }
}