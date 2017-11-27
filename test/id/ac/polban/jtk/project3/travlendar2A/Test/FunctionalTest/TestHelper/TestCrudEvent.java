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
import java.util.List;


/**
 *
 * @author mufidjamaluddin
 */
public class TestCrudEvent
{
    public static void main(String[] args) throws ParseException
    {
        //--------------------------------------------------------------------------------------//
        IDao<Event> dao;
        List<Event> list;
        dao = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Event.class);
        //--------------------------------------------------------------------------------------//
        System.out.println("Test Menampilkan List Event");
        
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        //--------------------------------------------------------------------------------------//
        System.out.println("Test Menambahkan Event");
        
        Event objEvent = new Event();
        
        objEvent.setEvent_id(new Long(5));
        objEvent.setEvent_name("Kerja Kelompok");
        objEvent.setLocation_id(1);
        objEvent.setTraveller_id(new Long(1));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        objEvent.setStart_event(new Timestamp( dateFormat.parse("2017-09-22 08:08:11").getTime() ));
        objEvent.setEnd_event(new Timestamp( dateFormat.parse("2017-10-22 12:08:11").getTime() ));
        
        boolean created = dao.create(objEvent);
        if(!created) System.out.println("Insert gagal");
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        //--------------------------------------------------------------------------------------//
        
        System.out.println("Test Edit Event");
        objEvent.setEvent_name("Kerja Kelompok Bareng");
        objEvent.setNote("APPPPPPPPPPPPPPPPPPP");
        
        boolean edit = dao.edit(objEvent, "event_id", "5");
        if(!edit)
            System.out.println("Gagal Edit!");
        
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        
        //--------------------------------------------------------------------------------------//
        System.out.println("Test Menghapus Event yang event_id=5");
        boolean delete = dao.delete("event_id", "5");
        if(!delete) System.out.println("Delete gagal");
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        
        //--------------------------------------------------------------------------------------//
        System.out.println("Test Menampilkan Event yang event_id=2");
        Event event = dao.getObj("event_id", "2");
        System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
    }       
}
