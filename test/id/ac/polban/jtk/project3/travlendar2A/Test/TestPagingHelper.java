/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test;

import id.ac.polban.jtk.project3.travlendar2A.Helpers.PagingListIntHelper;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class TestPagingHelper {
    
    public static void main(String[] args)
    {
        List<Integer> listInt;
        PagingListIntHelper objP;
        
        System.out.println("\nMaks Page : 63, Maks Paging : 10");
        objP = new PagingListIntHelper(63,10);
        
        System.out.println("\nJika Page Active : 16");
          
        listInt = objP.getList(16);
        listInt.forEach((objInt) -> {
            System.out.print(objInt + "-");
        });
        
        System.out.println("\nJika Page Active : 32");
        
        listInt = objP.getList(32);
        listInt.forEach((objInt) -> {
            System.out.print(objInt + "-");
        });
        
        System.out.println("\nJika Page Active : 55");
        
        listInt = objP.getList(55);
        listInt.forEach((objInt) -> {
            System.out.print(objInt + "-");
        });
        
        System.out.println("\nJika Page Active : 50");
        
        listInt = objP.getList(80);
        listInt.forEach((objInt) -> {
            System.out.print(objInt + "-");
        });
        
        System.out.println("\nJika Page Active : 80");
        
        listInt = objP.getList(80);
        if(listInt != null)
            listInt.forEach((objInt) -> {
                System.out.print(objInt + "-");
            });
        else
            System.out.print("Tidak ada paging, keluar nilai maks");
        
        System.out.println("Sukses");
    }
}
