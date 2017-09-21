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
    
    public int getSpeedKendaraan (String vhc){
        switch(vhc){
            case "Mobil" :
                speedKendaraan = 50; //set speed untuk mobil
                break;
            case "Motor" :
                speedKendaraan = 60; //set speed untuk motor
                break;
            case "Pesawat" :
                speedKendaraan = 900; //set speed untuk pesawat
                break;
            case "Kereta" :
                speedKendaraan = 150; //set speed untuk kereta
                break;
            case "Bus" : //set speed untuk bus
                speedKendaraan = 40;
                break;
        }
        return speedKendaraan;
    }
}