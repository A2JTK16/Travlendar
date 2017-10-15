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
public class Agenda {
    /**
     * REVIEW
     * 1.   Perlu Ditambahkan kode_lokasi dan id_traveller,
     *      Supaya Dapat Memiliki Relasi dengan Lokasi dan Traveller.
     *      kode_event Dapat Menjadi Object Counter atau
     *      Tidak Perlu di Set Karena Nantinya di Database Dapat
     *      Otomatis Auto_increment
     * 2.   Saran Saya untuk Date Parser dibuat Class Khusus
     * 3.   Perbaiki Lagi Getter dan Setter nya
     */
    
    private String nama_agenda;
    private Date waktu_mulai_agenda;
    private Date waktu_berakhir_agenda;
    private int kodeLokasiAwal;
    private int kodeLokasiTujuan;
    private String catatan; 
    private Date tanggal;
    
    public Agenda(){
        this.nama_agenda = null;
        this.waktu_mulai_agenda = null;
        this.waktu_berakhir_agenda = null;
    }
   
    public String getEvent() {
        Lokasi objLoc = new Lokasi();
        return ("Nama Event : " + this.nama_agenda + "\nWaktu Berangkat : " + this.getWaktu_berakhir_agenda() + "\nWaktu Tiba : " + this.getWaktu_mulai_agenda() + "\nLokasi : " + objLoc.getNamaLoc(this.getKodeLokasiTujuan()) + "\n") ;
    }

    /**
     * @param nama_agenda the nama_agenda to set
     */
    public void setNama_agenda(String nama_agenda) {
         this.nama_agenda = nama_agenda;
    }

    
    public void setWaktu_mulai_agenda(Date waktu_mulai_agenda) {
        if(this.waktu_berakhir_agenda.before(waktu_mulai_agenda)) {
            this.waktu_mulai_agenda = waktu_mulai_agenda;
        } else {
            System.out.println("Arrival time and departure time that you enter interchangeable, we will exchange it");
            this.waktu_mulai_agenda = this.getWaktu_berakhir_agenda();
            this.waktu_berakhir_agenda = waktu_mulai_agenda;
        }
        
    }

    
    public void setWaktu_berakhir_agenda(Date waktu_berakhir_agenda) {

        this.waktu_berakhir_agenda = waktu_berakhir_agenda;
    }

    /**
     * @return the waktu_mulai_agenda
     */
    public Date getWaktu_mulai_agenda() {
        return waktu_mulai_agenda;
    }

    /**
     * @return the waktu_berakhir_agenda
     */
    public Date getWaktu_berakhir_agenda() {
        return waktu_berakhir_agenda;
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