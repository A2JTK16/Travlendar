/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author AGS
 */
public class Event {
    
    
    private String nama_event;
    private Calendar arrivaltime;
    private Calendar departuretime;
    
    
    //penamaan event saya ganti menjadi addEvent supaya tidak jadi kontrakstor
    public void addEvent(String nama_event, Calendar arrivaltime, Calendar departuretime){
        
        this.setNama_event(nama_event);
        this.setArrivaltime(arrivaltime);
        this.setDeparturetime(departuretime);
        
    }

    /**
     * @return the nama_event
     */
    public String getNama_event() {
        return nama_event;
    }

    /**
     * @param nama_event the nama_event to set
     */
    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    /**
     * @return the arrivaltime
     */
    public Calendar getArrivaltime() {
        return arrivaltime;
    }

    /**
     * @param arrivaltime the arrivaltime to set
     */
    public void setArrivaltime(Calendar arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    /**
     * @return the departuretime
     */
    public Calendar getDeparturetime() {
        return departuretime;
    }

    /**
     * @param departuretime the departuretime to set
     */
    public void setDeparturetime(Calendar departuretime) {
        this.departuretime = departuretime;
    }
    public Calendar inputArrivalTime() {
        Scanner scan = new Scanner(System.in);
        Calendar at = Calendar.getInstance();
        System.out.print("Tahun event dimulai : ");
        int yearStart = Integer.parseInt(scan.nextLine());
        System.out.print("Bulan event dimulai : ");
        int monthStart = Integer.parseInt(scan.nextLine());
        monthStart = monthStart - 1;
        System.out.print("Tanggal event dimulai : ");
        int dayStart = Integer.parseInt(scan.nextLine());
        System.out.print("Jam Tiba : ");
        int hourStart = Integer.parseInt(scan.nextLine());
        System.out.print("Menit Tiba : ");
        int minuteStart = Integer.parseInt(scan.nextLine());
        int secondStart = 0;
        at.set(yearStart, monthStart, dayStart, hourStart, minuteStart, secondStart);
        return at;
    }
    
    public Calendar inputDepartureTime() {
        Scanner scan = new Scanner(System.in);
        Calendar dt = Calendar.getInstance();
        System.out.print("Tahun event dimulai : ");
        int yearStart = Integer.parseInt(scan.nextLine());
        System.out.print("Bulan event dimulai : ");
        int monthStart = Integer.parseInt(scan.nextLine());
        monthStart = monthStart - 1;
        System.out.print("Tanggal event dimulai : ");
        int dayStart = Integer.parseInt(scan.nextLine());
        System.out.print("Jam Berangkat : ");
        int hourStart = Integer.parseInt(scan.nextLine());
        System.out.print("Menit Berangkat : ");
        int minuteStart = Integer.parseInt(scan.nextLine());
        int secondStart = 0;
        dt.set(yearStart, monthStart, dayStart, hourStart, minuteStart, secondStart);
        return dt;
    }
    //Method supaya programbisa di running
    public static void main(String[] args)
    {
       Event E = new Event();
       
       Calendar at = E.inputArrivalTime();
       
       //Method input
       //E.addEvent(1234,"apajare",123,123,123,"apane");
       //Method print ke layar
       //System.out.println("Event : " + E.id_event);
    }   

    
}
