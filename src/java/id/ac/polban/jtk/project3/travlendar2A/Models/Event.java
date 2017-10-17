package id.ac.polban.jtk.project3.travlendar2A.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;


/**
 *
 * @author AGS
 */
public class Event {
    /**
     * REVIEW
     * 1.   Perlu Ditambahkan kode_lokasi dan id_traveller,
      Supaya Dapat Memiliki Relasi dengan Location dan Traveller.
      kode_event Dapat Menjadi Object Counter atau
      Tidak Perlu di Set Karena Nantinya di Database Dapat
      Otomatis Auto_increment
 2.   Saran Saya untuk Date Parser dibuat Class Khusus
 3.   Perbaiki Lagi Getter dan Setter nya
     */
    private int event_id;
    private String event_name;
    private Date start_event;
    private Date end_event;
    private int kodeLokasiAwal;
    private int kodeLokasiTujuan;
    private String note; 
    private String place;
    
    public Event(){
        this.event_name = null;
        this.start_event = null;
        this.end_event = null;
    }
   
    public String getEvent() {
        Location objLoc = new Location();
        return ("Nama Event : " + this.getEvent_name() + "\nWaktu Berangkat : " + this.getEnd_event() + "\nWaktu Tiba : " + this.getStart_event() + "\nLokasi : " + objLoc.getNamaLoc(this.getKodeLokasiTujuan()) + "\n") ;
    }

    /**
     * @param event_name the event_name to set
     */
    public void setEvent_name(String event_name) {
         this.event_name = event_name;
    }

    
    public void setStart_event(Date start_event) {
        if(this.end_event.before(start_event)) {
            this.start_event = start_event;
        } else {
            System.out.println("Arrival time and departure time that you enter interchangeable, we will exchange it");
            this.start_event = this.getEnd_event();
            this.end_event = start_event;
        }
        
    }

    
    public void setEnd_event(Date end_event) {

        this.end_event = end_event;
    }

    /**
     * @return the start_event
     */
    public Date getStart_event() {
        return start_event;
    }

    /**
     * @return the end_event
     */
    public Date getEnd_event() {
        return end_event;
    }

    /**
     * @return the kodeLokasiAwal
     */
    public int getKodeLokasiAwal() {
        return kodeLokasiAwal;
    }

    /**
     * @param kodeLokasiAwal the kodeLokasiAwal to set
     */
    public void setKodeLokasiAwal(int kodeLokasiAwal) {
        this.kodeLokasiAwal = kodeLokasiAwal;
    }

    /**
     * @return the kodeLokasiTujuan
     */
    public int getKodeLokasiTujuan() {
        return kodeLokasiTujuan;
    }

    /**
     * @param kodeLokasiTujuan the kodeLokasiTujuan to set
     */
    public void setKodeLokasiTujuan(int kodeLokasiTujuan) {
        this.kodeLokasiTujuan = kodeLokasiTujuan;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return the event_name
     */
    public String getEvent_name() {
        return event_name;
    }

    /**
     * @param event_id the event_id to set
     */
    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
}
    
   
/*    public boolean isDate(String arrivalTimeStr)
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
/*    public boolean isTime(String timeStr)
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
    
}*/
