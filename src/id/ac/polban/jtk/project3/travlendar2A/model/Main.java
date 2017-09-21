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
    private Traveller traveller;
    
    public static void main(String[] args) {
        Main objMain = new Main();
        int option = 0;
        int id = 0;
        String fullname, username, email, password;
        Scanner n = new Scanner(System.in);
        
        ArrayList<Event> eventList = new ArrayList();
        
        
        System.out.println("Masukkan Nama Lengkap Anda : ");
        fullname = n.nextLine();
        
        System.out.println("Masukkan Username Anda : ");
        username = n.nextLine();
        
        System.out.println("Masukkan email Anda : ");
        email = n.nextLine();
        
        System.out.println("Masukkan password Anda : ");
        password = n.nextLine();
        objMain.traveller = new Traveller(fullname, username, email, password);
        //  do {
            switch(option){
   
                case 1 : //memasukkan event dan segala atributnya
                    
                    
                    
                    /*System.out.println("Masukkan Lokasi : ");
                    for
                    String l = n.nextLine();
                    objMain.locationEvent.setNama_lokasi(l);*/
                    
                    System.out.println("1. Mobil \n2. Motor \n3. Pesawat \n4. Kereta \n5. Bus\n");
                    System.out.println("Pilih Moda Transportasi : ");
                    String t = n.nextLine();
                    
                    
                    //E.addEvent(en, at, dt);
                    //eventList.add(e)
            }
        }//while();
        
    }