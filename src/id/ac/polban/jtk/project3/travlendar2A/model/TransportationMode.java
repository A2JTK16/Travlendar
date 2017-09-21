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
    
    /*
    public enum Transport{
        Mobil, Motor, Pesawat, Kereta, Bus;
    }
    */
    public int vehicleSpeed (String vhc){
        int speed = 0;
        switch(vhc){
            case "Mobil" :
                speed = 50; //set speed untuk mobil
                break;
            case "Motor" :
                speed = 60; //set speed untuk motor
                break;
            case "Pesawat" :
                speed = 900; //set speed untuk pesawat
                break;
            case "Kereta" :
                speed = 150; //set speed untuk kereta
                break;
            case "Bus" : //set speed untuk bus
                speed = 40;
                break;
        }
        return speed;
    }

    /**
     * @return the speedKendaraan
     */
    public int getSpeedKendaraan() {
        return speedKendaraan;
    }
}