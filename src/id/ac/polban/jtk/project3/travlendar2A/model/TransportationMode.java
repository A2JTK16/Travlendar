package id.ac.polban.jtk.project3.travlendar2A.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class TransportationMode {
    private int speedKendaraan;
    private double time_mobil;
    //private DistanceMatrix Distance;
    public enum Transport{
        MOBIL, MOTOR, PESAWAT, KERETA, BUS;
    }
    
    public double getSpeedKendaraan (Transport vhc){
        switch(vhc){
            //satuan kecepatan adalah km/jam
            case MOBIL :
                speedKendaraan = 50; //set speed untuk mobil
                //this.time_mobil = (Distance.getdistance())/speedKendaraan;
                break;
            case MOTOR :
                speedKendaraan = 60; //set speed untuk motor
                break;
            case PESAWAT :
                speedKendaraan = 900; //set speed untuk pesawat
                break;
            case KERETA :
                speedKendaraan = 150; //set speed untuk kereta
                break;
            case BUS : //set speed untuk bus
                speedKendaraan = 40;
                break;
        }
        return speedKendaraan;
    }
    
    public double gettimemobil(){
return time_mobil;
}
}

