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
import java.util.Date;
import java.util.List;
/**
 *
 * @author AGS
 */

public class ProgramUtama{
    
    /**
     * REVIEW
     * 1.   Great. 
     * 2.   Untuk Event, dapat ditambahkan array list karena satu traveller memiliki banyak event
     * 3.   Dapat ditampilkan rekomendasi kendaraan dari jarak kedua acara.
     *      Jika selisih waktu berangkat dari Event pertama dengan waktu tiba di Event kedua
     *      lebih besar daripada waktu yang harus ditempuh oleh semua moda transportasi,
     *      maka tampilkan saran kendaraan tersebut.
     *      Note : hal ini dapat dibuat class baru
     * 
     */
    
    protected Location locationEvent;
    protected DistanceMatrix distance;
    protected EstimationTime esTime;
    protected TransportationMode transport;
    protected Event event;
    protected ParseDate parsedt;
    protected Traveller traveller;
    
    public ProgramUtama(Event event, TransportationMode transport, Location locationEvent, DistanceMatrix distance, EstimationTime esTime){
        this.event = event;
        this.transport = transport;
        this.locationEvent = locationEvent;
        this.distance = distance;
        this.esTime = esTime;
    }
    
    public static void main(String[] args) throws ParseException{
        //ProgramUtama objMain = new ProgramUtama();
        //Event event = new Event();
        Event event = new Event();
        Location locationEvent = new Location();
        DistanceMatrix distance = new DistanceMatrix();
        EstimationTime esTime = new EstimationTime();
        TransportationMode transport = new TransportationMode();
        ParseDate parsedt = new ParseDate();
        Date arrivalTime = null;
        Date departureTime = null; 
        int transportation;
        int option = 1;
        int id, kodelokasi, kodekotaawal, kodekotatujuan;
        double speed=0;
        String fullname, username, email, password, eventName, tanggalStr, waktuStr, lokasi, kotaawal = null, kotatujuan = null;
        Scanner n = new Scanner(System.in);
        double diff = 0, diffSeconds = 0, diffMinutes = 0, diffHours = 0;
       // ArrayList<ProgramUtama> eventList = new ArrayList();
        List<String> list = new ArrayList<String>();
        
        //--------------------Input Data Traveller (Name, username, pass,....)--------------------------------------//
        System.out.println("Masukkan Nama Lengkap Anda : ");
        fullname = n.nextLine();
        
        System.out.println("Masukkan Username Anda : ");
        username = n.nextLine();
        
        System.out.println("Masukkan email Anda : ");
        email = n.nextLine();
        
        System.out.println("Masukkan password Anda : ");
        password = n.nextLine();
        Traveller traveller = new Traveller(fullname, username, email, password); 
        //-------------------------------------------------------------------------------------------------------------//
        
        do{
            System.out.println("\n1. Input Data\n2. Menampilkan Data\n3. Keluar : ");
            System.out.println("Masukkan Pilihan Anda : ");
            option = n.nextInt(); n.nextLine();
            switch(option){
   
                case 1 : //memasukkan event dan segala atributnya
                    //------------Input Data Event(Nama event, waktu berangkat, waktu tiba)-----------------------------------//
                    System.out.println("Nama Event : ");
                    eventName = n.nextLine();
                    event.setNama_event(eventName);
                    
                    do{
                        System.out.println("Masukkan Tanggal Tiba\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm.ss)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    event.setArrivalTime(parsedt.getDateValue());
                    
                    do{
                        System.out.println("Masukkan Tanggal Berangkat\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm.ss)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    event.setDepatureTime(parsedt.getDateValue());
                    
                    arrivalTime = event.getArrivaltime();
                    departureTime = event.getDeparturetime();
                    
                    diff = arrivalTime.getTime() - departureTime.getTime(); //untuk menghitung selisih jam
                    diffSeconds = diff / 1000 % 60; //selisih jam 
                    diffMinutes = diff / (60 * 1000) % 60; //selisih menit
                    diffHours = -1*(diff / (60 * 60 * 1000)); //selisih detik
                    //------------------------------------m-------------------------------------------------------------------------//
                
                    System.out.println("Masukkan lokasi awal : ");
                    kotaawal = n.next();
                    locationEvent.setNama_Lokasi(kotaawal);
                    distance.setKode_kota1(locationEvent.getKode_Lokasi());
                    System.out.println("kode kotaawal : " + locationEvent.getKode_Lokasi());
                    System.out.println("Masukkan lokasi tujuan : ");
                    kotatujuan = n.next();
                    locationEvent.setNama_Lokasi(kotatujuan);
                    distance.setKode_kota2(locationEvent.getKode_Lokasi());
                    System.out.println("kode kotatujuan : " + locationEvent.getKode_Lokasi());
                    System.out.println("jarak " + kotaawal + " - " + kotatujuan + " = " + distance.getJarak_lokasi());
                    
                    distance.getJarak_lokasi();
                    double jarak = distance.getJarak_lokasi();
                    esTime.transportRecomendation(jarak, (long) diffHours);
                    System.out.println("masukan transportasi yang akan dipilih");
                    String transportasi = n.next();
                   // ProgramUtama objMain = new ProgramUtama(event.getEvent(), transport, locationEvent, distance, esTime);
                    //eventList.add(objMain);
                    list.add(traveller.getFullname());
                    list.add(event.getEvent());
                    list.add(transportasi);
                    break;
                case 2 :
                   for (String s : list) {
                        System.out.println(s);
                        }
                    break;           
            }
        }while(option != 3);
    }
}