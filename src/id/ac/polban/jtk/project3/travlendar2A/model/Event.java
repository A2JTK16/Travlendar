package id.ac.polban.jtk.project3.travlendar2A.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


/**
 *
 * @author AGS
 */
public class Event {
    /**
     * REVIEW
     * 1.   Bisa Ditambahkan kode_lokasi dan id_traveller,
     *      Supaya Dapat Memiliki Relasi dengan Lokasi dan Traveller.
     *      kode_event Dapat Menjadi Object Counter atau
     *      Tidak Perlu di Set Karena Nantinya di Database Dapat
     *      Otomatis Auto_increment
     * 2.   Saran Saya untuk Date Parser dibuat Class Khusus
     * 3.   Perbaiki Lagi Getter dan Setter nya
     */
    
    private String nama_event;
    private Date arrivaltime;
    private Date departuretime;
    private SimpleDateFormat datetimeFormatter;
    private SimpleDateFormat dateFormat;
    private SimpleDateFormat timeFormat;
    
    public Event(){
        this.datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss");
        this.dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        this.timeFormat = new SimpleDateFormat("HH.mm.ss");
        this.arrivaltime = null;
        this.departuretime = null;
    }
   
    public void getEvent() {
        System.out.println("Nama Event : " + this.nama_event + "\nWaktu Tiba : " + this.arrivaltime + "\nWaktu Berangkat : " + this.departuretime + "\n") ;
    }

    /**
     * @param nama_event the nama_event to set
     */
    public void setNama_event(String nama_event) {
         this.nama_event = nama_event;
         // Rev : Ini infinite, perlu diperbaiki
    }

    /**
     * @param arrivaltimeStr
     * @throws java.text.ParseException
     */
    public void setArrivaltime(String arrivaltimeStr) throws ParseException {
        this.arrivaltime = this.datetimeFormatter.parse(arrivaltimeStr);
    }

    /**
     * @param departuretime the departuretime to set
     * @throws java.text.ParseException
     */
    public void setDeparturetime(String departuretimenn) throws ParseException {
        this.departuretime = this.datetimeFormatter.parse(departuretimenn);
    }
    
    /**
     *
     * @param arrivalTimeStr
     * @return
     */
    public boolean isDate(String arrivalTimeStr)
    {
        try{
            this.dateFormat.parse(arrivalTimeStr);
            return true;
        }
        catch(ParseException e)
        {
             System.out.println("Tanggal Tidak Valid !");
            return false;
        }
    }
    
    /**
     *
     * @param timeStr
     * @return
     */
    public boolean isTime(String timeStr)
    {
        try{
            this.timeFormat.parse(timeStr);
            return true;
        }
        catch(ParseException d){
             System.out.println("Waktu Tidak Valid !");
            return false;
        }
    }
    
}