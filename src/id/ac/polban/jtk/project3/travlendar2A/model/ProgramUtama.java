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

    
    
    protected Location locationEvent;
    protected DistanceMatrix distance;
    protected EstimasiWaktu esTime;
    protected ModaTransportasi transport;
    protected Event event;
    protected ParseDate parsedt;
    protected Traveller traveller;
    
    public ProgramUtama(Event event, ModaTransportasi transport, Location locationEvent, DistanceMatrix distance, EstimasiWaktu esTime){
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
        EstimasiWaktu esTime = new EstimasiWaktu();
        ModaTransportasi transport = new ModaTransportasi();
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
        //--------------------- DAPAT DIBUAT METHOD BARU ----------------------------------------------------------//

        /*System.out.println("Masukkan Nama Lengkap Anda : ");
        fullname = n.nextLine();
        
        System.out.println("Masukkan Username Anda : ");
        username = n.nextLine();
        
        System.out.println("Masukkan email Anda : ");
        email = n.nextLine();
        
        System.out.println("Masukkan password Anda : ");
        password = n.nextLine();
        Traveller traveller = new Traveller(fullname, username, email, password); */
        //Kode di atas belum digunakan karena usernya hanya satu, yaitu Ibu Maryam
        //-------------------------------------------------------------------------------------------------------------//
        
        do{
            System.out.println("\n1. Input Data\n2. Menampilkan Data\n3. Keluar : ");
            System.out.println("Masukkan Pilihan Anda : ");
            option = n.nextInt(); n.nextLine();
            switch(option){
   
                case 1 : 
                  /**
                   * REVIEW : Dapat dibuat CLASS BARU
                   * misalnya Class Input Event
                   * Isinya input Event, ArrivalTime, DepatureTime, dsb
                   */  
                  
                    //------------Input Data Event(Nama event, waktu berangkat, waktu tiba)-----------------------------------//

                    System.out.println("Nama Event : ");
                    eventName = n.nextLine();
                    event.setNama_event(eventName);
                        
                    /**
                     * REVIEW : UNTUK SET ARRIVALTIME DAN DEPATURE TIME DAAPAT DBUAT METHOD BARU
                     */
                    //--------------------------------------------------------------------------------------------//
                    do{
                        System.out.println("Masukkan Tanggal Berangkat\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    event.setDepartureTime(parsedt.getDateValue());
                    //-------------------------------------------------------------------------------------------//
                    
                    do{
                        System.out.println("Masukkan Tanggal Tiba\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    event.setArrivalTime(parsedt.getDateValue());
                    //--------------------------------------------------------------------------------------------//
                    /**
                     * REVIEW : DAPAT DIBUAT CLASS BARU
                     * CLASS PREDIKSI ATAU APA
                     * 
                     */
                    
                    
                    arrivalTime = event.getArrivaltime();
                    departureTime = event.getDeparturetime();
                    
                    diff = arrivalTime.getTime() - departureTime.getTime(); //untuk menghitung selisih jam
                    diffSeconds = diff / 1000 % 60; //selisih jam 
                    diffMinutes = diff / (60 * 1000) % 60; //selisih menit
                    diffHours = (diff / (60 * 60 * 1000)); //selisih detik
                    //---------------------------------------------------------------------------------------------//
                    
                    
                    
                    locationEvent.tampil_Lokasi();
                     System.out.print("Masukkan kode lokasi awal : ");
                     event.setKodeLokasiAwal(n.nextInt() );
                     System.out.println(locationEvent.getNamaLoc(event.getKodeLokasiAwal()));
                     
                    locationEvent.tampil_Lokasi();
                     System.out.print("Masukkan kode lokasi tujuan : ");
                     event.setKodeLokasiTujuan(n.nextInt() );
                    System.out.println(locationEvent.getNamaLoc(event.getKodeLokasiAwal() ));
                   
                    distance.getDistance(event.getKodeLokasiAwal(), event.getKodeLokasiTujuan());
                    double jarak = distance.getDistance(event.getKodeLokasiAwal(), event.getKodeLokasiTujuan());
                    System.out.println(String.format("jarak : %3.2f", jarak ));
                    
                    transport.transportRecomendation(jarak, (double) diffHours);
                    if (!transport.getIsTransportAvailable()){
                        System.out.println("masukan transportasi yang akan dipilih");
                        String transportasi = n.next();
                       // ProgramUtama objMain = new ProgramUtama(event.getEvent(), transport, locationEvent, distance, esTime);
                        //eventList.add(objMain);
                        //list.add(traveller.getFullname());
                        list.add(event.getEvent());
                        list.add(transportasi);
                    } else {
                        break;
                    }
                    break;
                case 2 :
                    // DAPAT DIBUAT METHOD BARU //
                   for (String s : list) {
                        System.out.println(s);
                        }
                    break;           
            }
        }while(option != 3);
    }
}