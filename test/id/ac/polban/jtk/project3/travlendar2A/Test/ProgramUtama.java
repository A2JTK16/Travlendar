/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test;


import id.ac.polban.jtk.project3.travlendar2A.Helpers.Moda_Transportasi;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.Moda_Transportasi;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.ParseDate;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.ParseDate;
import id.ac.polban.jtk.project3.travlendar2A.Models.Agenda;
import id.ac.polban.jtk.project3.travlendar2A.Models.EstimasiWaktu;
import id.ac.polban.jtk.project3.travlendar2A.Models.Lokasi;
import id.ac.polban.jtk.project3.travlendar2A.Models.Perjalanan;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import java.text.ParseException;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author AGS
 */

public class ProgramUtama{        
    protected Lokasi lokasi;
    protected Perjalanan distance;
    protected EstimasiWaktu esTime;
    protected Moda_Transportasi transport;
    protected Agenda event;
    protected ParseDate parsedt;
    protected Traveller traveller;
    
    public static void main(String[] args) throws ParseException{
        
        Lokasi lokasiEvent = new Lokasi();
        Perjalanan jarakLokasi = new Perjalanan();
        EstimasiWaktu esTime = new EstimasiWaktu();
        Moda_Transportasi nama_transportasi = new Moda_Transportasi();
        ParseDate parsedt = new ParseDate();
        Date waktumulai;
        Date waktuberakhir; 
        int transportation;
        int option;
        int id, kodelokasi, kodekotaawal, kodekotatujuan;
        double speed=0;
        String nama_lengkap, nama_pengguna, alamat_email, kata_sandi, nama_agenda, tanggalStr, waktuStr, lokasi, kotaawal = null, kotatujuan = null;
        Scanner n = new Scanner(System.in);
        double diff = 0, diffSeconds = 0, diffMinutes = 0, diffHours = 0;
       // ArrayList<ProgramUtama> eventList = new ArrayList();
        //List<String> list = new ArrayList<String>();
        ArrayList<Agenda> daftar_agenda = new ArrayList<>();
        //--------------------Input Data Traveller (Name, username, pass,....)--------------------------------------//
        //--------------------- DAPAT DIBUAT METHOD BARU ----------------------------------------------------------//

        /*System.out.println("Masukkan Nama Lengkap Anda : ");
        nama_lengkap = n.nextLine();
        
        System.out.println("Masukkan Username Anda : ");
        nama_pengguna = n.nextLine();
        
        System.out.println("Masukkan email Anda : ");
        alamat_email = n.nextLine();
        
        System.out.println("Masukkan password Anda : ");
        kata_sandi = n.nextLine();
        Traveller traveller = new Traveller(nama_lengkap, nama_pengguna, alamat_email, kata_sandi); */
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
                  
                    //------------Input Data Agenda(Nama event, waktu berangkat, waktu tiba)-----------------------------------//
                    Agenda agenda = new Agenda();
                    System.out.println("Nama Event : ");
                    nama_agenda = n.nextLine();
                    agenda.setNama_agenda(nama_agenda);
                        
                    /**
                     * REVIEW : UNTUK SET ARRIVALTIME DAN DEPATURE TIME DAAPAT DBUAT METHOD BARU
                     */
                    //--------------------------------------------------------------------------------------------//
                    do{
                        System.out.println("Masukkan Tanggal Mulai Agenda\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    agenda.setWaktu_berakhir_agenda(parsedt.getDateValue());
                    //-------------------------------------------------------------------------------------------//
                    
                    do{
                        System.out.println("Masukkan Tanggal Berakhirnya Agenda\nDate (Format dd-mm-yyyy) : ");
                    } 
                    while(!parsedt.setDateValue(n.next())); 
            
                    do{
                        System.out.println("Time (Format hh.mm)");
                    } 
                    while(!parsedt.setTimeValStr(n.next()));
                    agenda.setWaktu_mulai_agenda(parsedt.getDateValue());
                    //--------------------------------------------------------------------------------------------//
                    /**
                     * REVIEW : DAPAT DIBUAT CLASS BARU
                     * CLASS PREDIKSI ATAU APA
                     * 
                     */
                    
                    
                    waktumulai = agenda.getWaktu_mulai_agenda();
                    waktuberakhir = agenda.getWaktu_berakhir_agenda();
                    
                    diff = waktumulai.getTime() - waktuberakhir.getTime(); //untuk menghitung selisih jam
                    diffSeconds = diff / 1000 % 60; //selisih jam 
                    diffMinutes = diff / (60 * 1000) % 60; //selisih menit
                    diffHours = (diff / (60 * 60 * 1000)); //selisih detik
                    //---------------------------------------------------------------------------------------------//
                    
                    
                    
                    lokasiEvent.tampil_Lokasi();
                     System.out.print("Masukkan kode lokasi awal : ");
                     agenda.setKodeLokasiAwal(n.nextInt() );
                     System.out.println(lokasiEvent.getNamaLoc(agenda.getKodeLokasiAwal()));
                     
                    lokasiEvent.tampil_Lokasi();
                     System.out.print("Masukkan kode lokasi tujuan : ");
                     agenda.setKodeLokasiTujuan(n.nextInt() );
                    System.out.println(lokasiEvent.getNamaLoc(agenda.getKodeLokasiAwal() ));
                   
                    jarakLokasi.getDistance(agenda.getKodeLokasiAwal(), agenda.getKodeLokasiTujuan());
                    double jarak = jarakLokasi.getDistance(agenda.getKodeLokasiAwal(), agenda.getKodeLokasiTujuan());
                    System.out.println(String.format("jarak : %3.2f", jarak ));
                    
                    nama_transportasi.transportRecomendation(jarak, (double) diffHours);
                    if (!nama_transportasi.getIsTransportAvailable()){
                        System.out.println("masukan transportasi yang akan dipilih");
                        String transportasi = n.next();
                       // ProgramUtama objMain = new ProgramUtama(event.getEvent(), transport, locationEvent, distance, esTime);
                        //eventList.add(objMain);
                        //list.add(traveller.getFullname());
                        //list.add(agenda.getEvent());
                        //list.add(transportasi);
                        daftar_agenda.add(agenda);
                    } else {
                        break;
                    }
                    break;
                case 2 :
                    // DAPAT DIBUAT METHOD BARU //
                   for (Agenda s : daftar_agenda) {
                        System.out.println(s.getEvent());
                        }
                    break;           
            }
        }while(option != 3);
    }
}