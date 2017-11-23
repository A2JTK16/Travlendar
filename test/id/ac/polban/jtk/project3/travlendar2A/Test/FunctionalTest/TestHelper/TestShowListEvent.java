/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import java.util.List;


/**
 *
 * @author mufidjamaluddin
 */
public class TestShowListEvent 
{
    public static void main(String[] args)
    {
        IDao<Event> dao;
        dao = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Event.class);
    
        List<Event> list;
        list = dao.getList();
        
        
            list.forEach((event) -> {
                System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
            });
        
        IDao<Traveller> daoTraveller;
        daoTraveller = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Traveller.class);
        
        List<Traveller> objTravellers = daoTraveller.getList();
        
        objTravellers.forEach((t) -> {
            System.out.println( t.getTraveller_fullname() + " | " + t.getTraveller_email() + " | " + t.getTraveller_password());
        });
        
        IDao<Location> daoLocation;
        daoLocation = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Location.class);
        
        List<Location> objLocation = daoLocation.getList();
        
        objLocation.forEach((loc) -> {
            System.out.println( loc.getLocation_id() + " | " + loc.getLatitude().toString() );
        });
        
        
    }       
}
