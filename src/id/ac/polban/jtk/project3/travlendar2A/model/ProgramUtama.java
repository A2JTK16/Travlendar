/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.model;

import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author AGS
 */

public class ProgramUtama {
   protected Location locationEvent;
    protected DistanceMatrix distance;
    protected EstimationTime esTime;
    protected TransportationMode transport;
//    private Event event;
    protected Traveller traveller;
    
    public static void main(String[] args) throws ParseException{
        ProgramUtama objMain = new ProgramUtama();
        Event event = new Event();
        int option = 1;
        int id = 0;
        // kodelokasi untuk apa ya?
        int kodelokasi = 0;
        String fullname, username, email, password, eventName, tanggalStr, waktuStr, transportasi, lokasi;
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
                    System.out.println("Nama Event : ");
                    eventName = n.nextLine();
                   
                    do{
                        System.out.println("Masukkan Tanggal Berangkat : (dd-mm-yyyy)");
                        tanggalStr = n.next();
                    }while(!event.isDate(tanggalStr));
                    System.out.println("Masukkan Waktu Berangkat : (hh.mm.ss");
                    waktuStr = n.next();
                  
                    event.setArrivaltime(tanggalStr + "." + waktuStr);
                    System.out.println("Masukkan Tanggal Tiba : (dd-mm-yyyy)");
                    tanggalStr = n.next();
                    
                    System.out.println("Masukkan Waktu Tiba : (hh.mm.ss");
                    waktuStr = n.next();
                   
                    event.setArrivaltime(tanggalStr + "." + waktuStr);
                    
                    System.out.println("1. Mobil \n2. Motor \n3. Pesawat \n4. Kereta \n5. Bus\n");
                    System.out.println("Masukkan Nama Moda Transportasi : ");
                    transportasi = n.nextLine();
                    n.next();
                    
                    System.out.println("1. Bandung - 10001\n2. Bogor - 10002\n3. Jakarta - 10003\n4. Sumedang - 10004\n5. Tasik - 10005\n6. Bekasi - 10006\n");
                    System.out.println("Masukkan Kode Lokasi : ");
                    kodelokasi = n.nextInt();
                    switch(kodelokasi) {
                        case 10001 :
                            lokasi = "Bandung";
                            break;
                        case 10002 :
                            lokasi = "Bogor";
                            break;
                        case 10003 :
                            lokasi = "Jakarta";
                            break;
                        case 10004 :
                            lokasi = "Sumedang";
                            break;
                        case 10005 :
                            lokasi = "Tasik";
                            break;
                        case 10006 :
                            lokasi = "Bekasi";
                            break;
                    }
                    
            }
        }//while();
}

