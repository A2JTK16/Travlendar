/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_proyek3;

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class TransportationMode {
    private Transport jenisKendaraan;
    
    /**
     * @return the jenisKendaraan
     */
    public Transport getJenisKendaraan() {
        return jenisKendaraan;
    }

    /**
     * @param jenisKendaraan the jenisKendaraan to set
     */
    public void setJenisKendaraan(Transport jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
    
    public enum Transport{
        Mobil, Motor, Pesawat, Kereta, Bus;
    }
    
    public int vehicleSpeed (Transport vhc){
        int speed = 0;
        switch(vhc){
            case Mobil :
                speed = 50;
                break;
            case Motor :
                speed = 60;
                break;
            case Pesawat :
                speed = 900;
                break;
            case Kereta :
                speed = 150;
                break;
            case Bus :
                speed = 40;
                break;
        }
        return speed;
    }

}
