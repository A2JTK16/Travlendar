/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.EventDesc;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author mufidjamaluddin
 */
public class TestEventDesc
{
    public static void main(String[] args) throws ParseException, JsonProcessingException, IOException
    {
        EventDesc evd = new EventDesc();
        Event event = new Event();
        Location loc = new Location();
        
        event.setEvent_id(new Long(1));
        event.setEvent_name("Jalan jalan");
        event.setStart_event(new Timestamp(new Date().getTime()));
        event.setEnd_event(new Timestamp(new Date().getTime()));
        event.setNote("APA YACH ?");
        
        loc.setLocation_id(1);
        loc.setLatitude(new Float(11111111));
        loc.setLongitude(new Float(22222222));
        
        evd.setEvent(event);
        evd.setLocation(loc);
        
        ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(evd);
        
        System.out.println(json);
        
        evd = mapper.readValue(json, EventDesc.class);
        
        event = evd.getEvent();
        loc = evd.getLocation();
        event.setEnd_location_id(loc.getLocation_id());
        
        System.out.println(event.getEvent_id() + " | "+ event.getEvent_name() + " | " + event.getStart_event() + " | " + event.getEnd_event() + " | " + event.getNote());
        System.out.println(loc.getLocation_id() + " | "  + loc.getLatitude() + " | " + loc.getLongitude());
    }
}
