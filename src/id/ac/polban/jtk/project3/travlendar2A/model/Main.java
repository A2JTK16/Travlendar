/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author AGS
 */

public class Main {
    private Location locationEvent;
    private DistanceMatrix distance;
    private EstimationTime esTime;
    private TransportationMode transport;
    private Event event;
   
    public static void main(String[] args) {
        Main objMain = new Main();
        int option = 0;
 
        
        ArrayList<Event> eventList = new ArrayList();
      //  do {
            switch(option){
                case 1 : //memasukkan event dan segala atributnya
                    Calendar dt = objMain.event.inputDepartureTime();
                    Calendar at = objMain.event.inputArrivalTime();
                    Scanner n = new Scanner(System.in);
                    System.out.println("Nama Event : ");
                    String en = n.nextLine();
                    
                    
                    System.out.println("Masukkan Lokasi : ");
                    String l = n.nextLine();
                    objMain.locationEvent.setNama_lokasi(l);
                    
                    
                    
                    
                    //E.addEvent(en, at, dt);
                    //eventList.add(e)
            }
        }//while();
        
    }
