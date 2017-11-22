/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class TestObject 
{
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        //--------------------------- ISI OBJEK ---------------------------------//
        
        Event objEvent = new Event();
        // setter normal
        objEvent.setEvent_name("Polban Islamic Fair");
        // setter dg invokes
        Class myclass = Event.class;
        myclass.getMethod("setNote", String.class).invoke(objEvent, "123.456 Apa");
        
        //--------------MENDAPATKAN NAMA FIELDS DARI CLASS-----------------------//
        
        Class T = Event.class;
        
        Field[] declaredFields;
        declaredFields = T.getDeclaredFields();
        List<String> listStrFields;
        listStrFields = new ArrayList<>();
        
        for(Field myField : declaredFields)
        {
            myField.setAccessible(true); // You might want to set modifier to public first.
            listStrFields.add(myField.getName().toLowerCase());
        }
        
        //--------------- BUAT SQL STRING DARI OBJEK-----------------------//
        Object object = objEvent;
        Field[] arrfield;
        arrfield = object.getClass().getDeclaredFields();
        
        String sql;
        
        List<String> listStrValue;
        List<String> listStrParam;
        
        listStrValue = new ArrayList<>();
        listStrParam = new ArrayList<>();
        
        sql = "INSERT INTO " + object.getClass().getSimpleName().toLowerCase();
        
        for(Field field : arrfield)
        {
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(object); 
            
            if(value != null)
            {
                /**
                 * Nama Parameter. Misal : nama, password
                 */
                listStrParam.add(field.getName().toLowerCase());
                /**
                 * Isi Parameter. Misal : Naufal Muntaaza, 999999999
                 */
                listStrValue.add(value.toString());
            }   
        }
        
        sql += "(";
        for (int i=0; i<listStrParam.size()-1; i++) 
        {
            sql += listStrParam.get(i) +", ";
        }
        sql += listStrParam.get(listStrParam.size()-1) + ")";
        
        sql += " VALUES (";
        for (int i=0; i<listStrValue.size()-1; i++) 
        {
            sql += "'" + listStrValue.get(i) +"', ";
        }
        sql += "'"+ listStrValue.get(listStrValue.size()-1) + "')";
         
        /**
          * Cetak SQL String
          */
        System.out.println(sql);
    }
}

