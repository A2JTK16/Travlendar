/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestHelper;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import id.ac.polban.jtk.project3.travlendar2A.Models.ViewEvent;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class TestLogin {
    
    public static void main(String[] args)
    {
        IDao<Traveller> dao = new GenericDao<>("jdbc:mysql://localhost:3306/a2travlendar","root","",Traveller.class);
    
        Integer executeFunction = dao.executeFunction("isThereUser", Integer.class, "maryam", "123");
        
        if(executeFunction > 0)
            System.out.println("Sukses login!");
        else
            System.out.println("Gagal");
    }
    
}
