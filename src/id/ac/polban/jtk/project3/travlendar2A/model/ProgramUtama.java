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
//<<<<<<< HEAD
    protected Location locationEvent;
    protected DistanceMatrix distance;
    protected EstimationTime esTime;
    protected TransportationMode transport;
    protected Event event;
    protected Traveller traveller;
    
    public static void main(String[] args) throws ParseException{
        ProgramUtama objMain = new ProgramUtama();
        //Event event = new Event();
        objMain.event = new Event();
        objMain.locationEvent = new Location();
        objMain.distance = new DistanceMatrix();
        objMain.esTime = new EstimationTime();
        objMain.transport = new TransportationMode();
        
        int option = 1;
        int id, kodelokasi, speed, kodekotaawal, kodekotatujuan;
        String fullname, username, email, password, eventName, tanggalStr, waktuStr, lokasi, kotaawal = null, kotatujuan = null;
        Scanner n = new Scanner(System.in);
        
        ArrayList<Event> eventList = new ArrayList();
        
        //--------------------Input Data Traveller (Name, username, pass,....)--------------------------------------//
        System.out.println("Masukkan Nama Lengkap Anda : ");
        fullname = n.nextLine();
        
        System.out.println("Masukkan Username Anda : ");
        username = n.nextLine();
        
        System.out.println("Masukkan email Anda : ");
        email = n.nextLine();
        
        System.out.println("Masukkan password Anda : ");
        password = n.nextLine();
        objMain.traveller = new Traveller(fullname, username, email, password);
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
                    objMain.event.setNama_event(eventName);
                    do{
                        System.out.println("Masukkan Tanggal Berangkat : (dd-mm-yyyy)");
                        tanggalStr = n.next();
                    }while(!objMain.event.isDate(tanggalStr));
                    System.out.println("Masukkan Waktu Berangkat : (hh.mm.ss");
                    waktuStr = n.next();
                    
                    objMain.event.setDeparturetime(tanggalStr + "." + waktuStr);
                    System.out.println("Masukkan Tanggal Tiba : (dd-mm-yyyy)");
                    tanggalStr = n.next();
                    
                    System.out.println("Masukkan Waktu Tiba : (hh.mm.ss");
                    waktuStr = n.next();
                   
                    objMain.event.setArrivaltime(tanggalStr + "." + waktuStr);
                    //-------------------------------------------------------------------------------------------------------------//
                    
                    /*System.out.println("1. MOBIL \n2. MOTOR \n3. PESAWAT \n4. KERETA \n5. BUS\n");
                    System.out.println("Masukkan Kode Moda Transportasi : ");*/
                    /*transport tp = transport.values()[n.nextInt()];
                    
                    speed = objMain.transport.getSpeedKendaraan(TransportationMode.Transport.transportasi);*/
                    
                    //------------Input Data Lokasi(Kode lokasi, nama lokasi(Bandara Husen, Rumah Anu,...)------------------//
                    System.out.println("Masukkan Kode Lokasi Event : ");
                    kodelokasi = n.nextInt(); n.nextLine();
                    objMain.locationEvent.setKode_lokasi(kodelokasi);
                    
                    System.out.println("Masukkan Nama Lokasi Anda (Rumah, Bandara,...) : ");
                    lokasi = n.nextLine();
                    objMain.locationEvent.setNama_lokasi(lokasi);
                    //-------------------------------------------------------------------------------------------------------//
                    
                    System.out.println("1. Bandung \n2. Bekasi\n3. Bogor \n4. Ciamis\n5. Cianjur\n6. Cirebon\n7. Garut\n8. Indramayu\n9. Karawang\n10. Kuningan\n11. Majalengka\n12. Pangandaran\n13. Purwakarta\n14. Subang\n15. Sukabumi\n16. Sumedang\n17. Tasikmalaya\n");
                    System.out.println("Masukkan Kode Kota Awal Anda (1-17) : ");
                    kodekotaawal = n.nextInt();
                    switch(kodekotaawal) {
                        case 1 :
                            kotaawal = "Bandung";
                            
                            break;
                        case 2 :
                            kotaawal = "Bekasi";
                            
                            break;
                        case 3 :
                            kotaawal = "Bogor";
                            
                            break;
                        case 4 :
                            kotaawal = "Ciamis";
                            
                            break;
                        case 5 :
                            kotaawal = "Cianjur";
                            
                            break;
                        case 6 :
                            kotaawal = "Cirebon";
                            
                            break;
                        case 7 :
                            kotaawal = "Garut";
                            
                            break;
                        case 8 :
                            kotaawal = "Indramayu";
                            
                            break;
                        case 9 :
                            kotaawal = "Karawang";
                            
                            break;
                        case 10 :
                            kotaawal = "Kuningan";
                            
                            break;    
                        case 11 :
                            kotaawal = "Majalengka";
                            
                            break;
                        case 12 :
                            kotaawal = "Pangandaran";
                            
                            break;    
                        case 13 :
                            kotaawal = "Purwakarta";
                            
                            break;
                        case 14 :
                            kotaawal = "Subang";
                            
                            break;
                        case 15 :
                            kotaawal = "Sukabumi";
                            
                            break;    
                        case 16 :
                            kotaawal = "Sumedang";
                            
                            break;    
                        case 17 :
                            kotaawal = "Tasikmalaya";
                            
                            break;                                
                    }

                    System.out.println("1. Bandung \n2. Bekasi\n3. Bogor \n4. Ciamis\n5. Cianjur\n6. Cirebon\n7. Garut\n8. Indramayu\n9. Karawang\n10. Kuningan\n11. Majalengka\n12. Pangandaran\n13. Purwakarta\n14. Subang\n15. Sukabumi\n16. Sumedang\n17. Tasikmalaya\n");
                    System.out.println("Masukkan Kode Kota Tujuan Anda (1-17) : ");
                    kodekotatujuan = n.nextInt();
                    switch(kodekotatujuan) {
                        case 1 :
                            kotatujuan = "Bandung";
                            
                            break;
                        case 2 :
                            kotatujuan = "Bekasi";
                            
                            break;
                        case 3 :
                            kotatujuan = "Bogor";
                            
                            break;
                        case 4 :
                            kotatujuan = "Ciamis";
                            
                            break;
                        case 5 :
                            kotatujuan = "Cianjur";
                            
                            break;
                        case 6 :
                            kotatujuan = "Cirebon";
                            
                            break;
                        case 7 :
                            kotatujuan = "Garut";
                            
                            break;
                        case 8 :
                            kotatujuan = "Indramayu";
                            
                            break;
                        case 9 :
                            kotatujuan = "Karawang";
                            
                            break;
                        case 10 :
                            kotatujuan = "Kuningan";
                            
                            break;    
                        case 11 :
                            kotatujuan = "Majalengka";
                            
                            break;
                        case 12 :
                            kotatujuan = "Pangandaran";
                            
                            break;    
                        case 13 :
                            kotatujuan = "Purwakarta";
                            
                            break;
                        case 14 :
                            kotatujuan = "Subang";
                            
                            break;
                        case 15 :
                            kotatujuan = "Sukabumi";
                            
                            break;    
                        case 16 :
                            kotatujuan = "Sumedang";
                            
                            break;    
                        case 17 :
                            kotatujuan = "Tasikmalaya";
                            
                            break;                                
                    }

                    
                    //double[][] jarak = objMain.distance.jarak;
                    
                    /*System.out.println("1. Bandung \n2. Bekasi\n3. Bogor \n4. Ciamis\n5. Cianjur\n6. Cirebon\n7. Garut\n8. Indramayu\n9. Karawang\n10. Kuningan\n11. Majalengka\n12. Pangandaran\n13. Purwakarta\n14. Subang\n15. Sukabumi\n16. Sumedang\n17. Tasikmalaya\n");
                    System.out.println("Masukkan Kode Kota Awal Anda : ");
                    kodelokasiawal = n.nextInt();
                    switch(kodelokasiawal) {
                        case 1 :
                            lokasi = "Bandung";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 2 :
                            lokasi = "Bekasi";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 3 :
                            lokasi = "Bogor";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 4 :
                            lokasi = "Ciamis";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 5 :
                            lokasi = "Cianjur";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 6 :
                            lokasi = "Cirebon";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 7 :
                            lokasi = "Garut";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 8 :
                            lokasi = "Indramayu";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 9 :
                            lokasi = "Karawang";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 10 :
                            lokasi = "Kuningan";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;    
                        case 11 :
                            lokasi = "Majalengka";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 12 :
                            lokasi = "Pangandaran";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;    
                        case 13 :
                            lokasi = "Purwakarta";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 14 :
                            lokasi = "Subang";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;
                        case 15 :
                            lokasi = "Sukabumi";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;    
                        case 16 :
                            lokasi = "Sumedang";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;    
                        case 17 :
                            lokasi = "Tasikmalaya";
                            objMain.locationEvent.setKode_lokasi(kodelokasiawal);
                            objMain.locationEvent.setNama_lokasi(lokasi);
                            break;                                
                    }
                    
                    System.out.println("Masukkan Kode Kota Tujuan Anda : ");
                    kodelokasitujuan = n.nextInt();
                    switch(kodelokasitujuan) {
                        case 1 :
                            lokasitujuan = "Bandung";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 2 :
                            lokasitujuan = "Bekasi";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 3 :
                            lokasitujuan = "Bogor";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 4 :
                            lokasitujuan = "Ciamis";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 5 :
                            lokasitujuan = "Cianjur";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 6 :
                            lokasitujuan = "Cirebon";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 7 :
                            lokasitujuan = "Garut";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 8 :
                            lokasitujuan = "Indramayu";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 9 :
                            lokasitujuan = "Karawang";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 10 :
                            lokasitujuan = "Kuningan";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;    
                        case 11 :
                            lokasitujuan = "Majalengka";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 12 :
                            lokasitujuan = "Pangandaran";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;    
                        case 13 :
                            lokasitujuan = "Purwakarta";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 14 :
                            lokasitujuan = "Subang";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;
                        case 15 :
                            lokasitujuan = "Sukabumi";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;    
                        case 16 :
                            lokasitujuan = "Sumedang";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;    
                        case 17 :
                            lokasitujuan = "Tasikmalaya";
                            objMain.locationEvent.setKode_lokasi(kodelokasitujuan);
                            objMain.locationEvent.setNama_lokasi(lokasitujuan);
                            break;	                             
                    }*/
                    break;
                case 2 :
                    System.out.println("Nama Traveller : " + objMain.traveller.getFullname());
                    System.out.println("Username Traveller : " + objMain.traveller.getUsername());
                    
                    objMain.event.getEvent();
                    System.out.println("Lokasi : " + objMain.locationEvent.getNama_lokasi());
                    if(kotaawal!=null){
                        objMain.distance.cek_kota(kotaawal, kotatujuan);
                    }
                    break;
            }
        }while(option != 3);
    }
}
    

