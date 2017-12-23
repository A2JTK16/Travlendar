/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test;

import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 *
 * @author mufidjamaluddin
 */
public class TestDescriptor {
    public static void main(String[] args) throws IntrospectionException
    {
        PropertyDescriptor[] props = Introspector.getBeanInfo(Event.class).getPropertyDescriptors();
        
       for(PropertyDescriptor property : props) 
        {
            if(!property.getName().equals("class"))
            System.out.println(property.getName() + " | " + property.getReadMethod().getName() + " | " + property.getWriteMethod().getName() + " | " + property.getDisplayName() + " | " + property.getPropertyType().getSimpleName());
        }
        
        props = Introspector.getBeanInfo(Traveller.class).getPropertyDescriptors();
        
        System.out.println("");
        
        for(PropertyDescriptor property : props) 
        {
            if(!property.getName().equals("class"))
            System.out.println(property.getName() + " | " + property.getReadMethod().getName() + " | " + property.getWriteMethod().getName() + " | " + property.getDisplayName());
        }
      
    }
}

