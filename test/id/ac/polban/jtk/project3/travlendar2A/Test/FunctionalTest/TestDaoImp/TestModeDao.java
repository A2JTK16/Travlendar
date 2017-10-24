/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Test.FunctionalTest.TestDaoImp;

import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.TransportationMdDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class TestModeDao 
{
    protected final TransportationMdDaoImp objModaDao;
    
    public TestModeDao()
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendar";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        int limit = 5;
        
        this.objModaDao = new TransportationMdDaoImp(jdbcURL, jdbcUsername, jdbcPassword, limit);
    }
    
    // Program untuk test ModaTransportasi
    // Jika tidak keluar eksepsi (yg engga pakai try catch), maka sukses
    public static void main(String[] args) throws SQLException
    {
        TestModeDao objTest;
        List<ModaTransportasi> listModa;
        objTest = new TestModeDao();
        
        //-----------------------------------------------------------
        System.out.println("-------------------\nTEST GET LIST DATA");
        listModa = objTest.objModaDao.getListFromDB(1);
        
        listModa.forEach((objModa) -> {
            System.out.println(objModa.getKodeTransportasi() + "\t" + objModa.getNamaTransportasi() + "\t" + objModa.getKecepatan());
        });
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST GET SPECIFICT DATA");
        ModaTransportasi objModa;
        objModa = objTest.objModaDao.getDataFromDB("MK");

        if(objModa != null)
            System.out.println(objModa.getKodeTransportasi() + "\t" + objModa.getNamaTransportasi() + "\t" + objModa.getKecepatan());
        else
            System.out.println(" >> Gagal");
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST GET PAGE COUNT");
        System.out.println("Page : "+objTest.objModaDao.getCountPage());
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST UPDATE DB");
        objModa = new ModaTransportasi();
        
        objModa.setKodeTransportasi("C");
        objModa.setNamaTransportasi("Mobil");
        objModa.setKecepatan((float)30.78);
        objTest.objModaDao.updateDataToDB(objModa);
        
        System.out.println(" >> Sukses");
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST INSERT DB");
        objModa.setKodeTransportasi("MS");
        objModa.setNamaTransportasi("Makanan Air");
        objModa.setKecepatan((float)14.32);
        objTest.objModaDao.saveDataToDB(objModa);
        
        System.out.println(" >> Sukses");
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST ISAVAIABLE");
        boolean modeAvaiable;
        // masukkan kode matakuliah yg ada di DB
        modeAvaiable = objTest.objModaDao.isModeAvaiable("MK");
        if(!modeAvaiable)
            System.out.println("Gagal");
        
        System.out.println(" >> Sukses");
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nTEST DELETE FIELD DB");
        objTest.objModaDao.deleteDataToDB("MS");
        
        System.out.println(" >> Sukses");
        
        //-----------------------------------------------------------
        System.out.println("--------------------\nSUCCESS . . .");
        
        System.out.println(31%10 + " " + 32%10 + " "+ 33%10 + " " + 34%10 + " "+ 35%10);
        System.out.println(36%10 + " " + 37%10 + " "+ 38%10 + " " + 39%10 + " "+ 40%10);
    }

}
