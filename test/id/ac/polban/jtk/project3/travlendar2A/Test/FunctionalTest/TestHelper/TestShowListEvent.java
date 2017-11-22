/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
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
       
    }       
}
