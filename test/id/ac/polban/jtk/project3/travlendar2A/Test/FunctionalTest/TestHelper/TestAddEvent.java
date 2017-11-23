/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author mufidjamaluddin
 */
public class TestAddEvent 
{
    public static void main(String[] args) throws ParseException
    {
        IDao<Event> daoEvent;
        daoEvent = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Event.class);
        
        Event event = new Event();
        
        event.setEvent_id(new Long(5));
        event.setEvent_name("Kerja Kelompok");
        event.setLocation_id(1);
        event.setTraveller_id(new Long(1));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        event.setStart_event(new Timestamp( dateFormat.parse("2017-09-22 08:08:11").getTime() ));
        event.setEnd_event(new Timestamp( dateFormat.parse("2017-10-22 12:08:11").getTime() ));
        
        boolean created;      

        created = daoEvent.create(event);

        
        if(created)
            System.out.println("SUKSES INPUT KE DATABASE");
        else
            System.out.println("GAGAL INPUT KE DATABASE");
    }
}
