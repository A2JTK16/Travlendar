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

    private String nama_event;
    private Date arrivaltime;
    private Date departuretime;
    private final SimpleDateFormat datetimeFormatter;
    private final SimpleDateFormat dateFormat;
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
         this.setNama_event(nama_event);
    }

    /**
     * @param arrivaltimeStr
     * @throws java.text.ParseException
     */
    public void setArrivaltime(String arrivaltimeStr) throws ParseException {
        this.arrivaltime = this.datetimeFormatter.parse("arrivaltimeStr");
    }

    /**
     * @param departuretime the departuretime to set
     * @throws java.text.ParseException
     */
    public void setDeparturetime(Date departuretime) throws ParseException {
        this.departuretime = this.datetimeFormatter.parse("departuretime");
    }
    
    public boolean isDate(String arrivalTimeStr)
    {
        try{
            this.dateFormat.parse(arrivalTimeStr);
            return true;
        }
        catch(ParseException e)
        {
            return false;
        }
    }
    
    public boolean isTime(String time)
    {
        try{
            this.timeFormat.parse(time);
            return true;
        }
        catch(ParseException d){
            return false;
        }
    }
    
}