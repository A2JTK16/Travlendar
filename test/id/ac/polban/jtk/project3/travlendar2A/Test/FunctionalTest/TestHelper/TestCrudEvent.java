/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        ObjectMapper mapper = new ObjectMapper();
        String json;
        dao = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Event.class);
        //--------------------------------------------------------------------------------------//
        /**
         * TEST MENAMPILKAN LIST EVENT DAN SHOW DI JSON
         */
        System.out.println("Test Menampilkan List Event");
        /**
         * Mendapatkan list event
         */
        list = dao.getList();
        /**
         * Menampilkan loop
         */
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        /**
         * Menampilkan dalam format json
         */
        try 
        {
            json = mapper.writeValueAsString(list);
            System.out.println(json);
        } 
        catch (JsonProcessingException ex) 
        {
            Logger.getLogger(TestCrudEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--------------------------------------------------------------------------------------//
        /**
         * TEST MENAMBAHKAN EVENT DARI JSON
         */
        System.out.println("Test Menambahkan Event");
        /**
         * Mapping json ke object
         */
        json = "{\"location_id\":1,\"traveller_id\":1,\"event_name\":\"Kerja Kelompok\",\"start_event\":1253581691000,\"end_event\":1253552891000,\"note\":null}";
        
        System.out.println(json);
        
        Event objEvent = null;
        try 
        {
            objEvent = mapper.readValue(json, Event.class);
            System.out.println("Start Event : " + objEvent.getStart_event().getTime());
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TestCrudEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Insert ke database
         */ 
        int idPK = dao.create(objEvent);
        System.out.println("Insert " + idPK);
        list = dao.getList();
        /**
         * Tampilkan dari Database
         */
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        /**
         * Tampilkan format json
         */
        try 
        {
            json = mapper.writeValueAsString(list);
            System.out.println(json);
        } 
        catch (JsonProcessingException ex) 
        {
            Logger.getLogger(TestCrudEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--------------------------------------------------------------------------------------//
        /**
         * TEST MENAMPILKAN EVENT
         */
        System.out.println("Test Menampilkan Event yang event_id=" + idPK);
        
        objEvent = dao.getObj("event_id", String.format("%s", idPK));
        System.out.println(objEvent.getEvent_id() + " | "+ objEvent.getEvent_name() + " | " + objEvent.getStart_event() + " | " + objEvent.getEnd_event() + " | " + objEvent.getNote());
        
        /**
         * Tampilkan format json
         */
        try 
        {
            json = mapper.writeValueAsString(objEvent);
            System.out.println(json);
        } 
        catch (JsonProcessingException ex) 
        {
            Logger.getLogger(TestCrudEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        //--------------------------------------------------------------------------------------//
        /**
         * TEST EDIT EVENT 
         */
        System.out.println("Test Edit Event");
        objEvent.setEvent_name("Kerja Kelompok Bareng");
        objEvent.setNote("APPPPPPPPPPPPPPPPPPP");
        
        int affectedRow = dao.edit(objEvent, "event_id", String.format("%s",idPK));
        System.out.println("Update " + idPK + " dan affectedRow : " + affectedRow);
        
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        
        //--------------------------------------------------------------------------------------//
        /**
         * Test Hapus Event
         */
        System.out.println("Test Menghapus Event yang event_id=5");
        affectedRow = dao.delete("event_id", String.format("%s",idPK));
        System.out.println("Delete " + idPK + " dan affectedRow : " + affectedRow);
        list = dao.getList();
        
        list.forEach((event) -> {
            System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        });
        
        //--------------------------------------------------------------------------------------//       
    }       
}
