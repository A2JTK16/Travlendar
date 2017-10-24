/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public class LocationDaoImp extends DAO
{
    /**
     * Atribut
     * limit untuk batas jml item / list size
     * yg ditampilkan dalam satu page
     */
    int limit;
    
    /**
     * Konstruktor
     * 
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     * @param limit 
     */
    public LocationDaoImp (String jdbcURL, String jdbcUsername, String jdbcPassword, int limit)
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
        this.limit = limit;
    }
    
    /**
     * Method untuk Mendapatkan Data Satu Record
     * Berdasarkan Kode Location
     * 
     * @param locCode
     * @return 
     * @throws java.sql.SQLException 
     */
    public Location getDataFromDB(String locCode) throws SQLException
    {   
        // write code here
        return null;
    }
    
    /**
     * Method untuk mendapatkan jumlah halaman
     * berdasarkan limit item yg telah ditentukan
     * dengan cara mengembalikan jml record/tuple
     * dari tabel database
     * 
     * @return 
     * @throws java.sql.SQLException 
     */
    public int getCountPage() throws SQLException
    {
        // write code here
        return 0;   
    }
    
    /**
     * Method untuk mendapatkan nilai kebenaran
     * tentang <strong>ada tidaknya location</strong>
     * dengan kode yang telah ditentukan. Jika ada,
     * maka akan mengembalikan nilai true.
     * 
     * Jika gagal mendapatkan data dari database,
     * maka akan keluar eksepsi
     * 
     * @param locCode
     * @return 
     * @throws java.sql.SQLException 
     */
    public boolean isModeAvaiable(String locCode) throws SQLException
    {
        // write code here
        return false;  
    }
    
    /**
     * Method untuk Mendapatkan Data dari Database.
     * Parameter Page untuk Pagination di Laman Web.
     * Parameter Batas untuk Batas Record/Tuple yang 
     * akan Ditampilkan di Laman Web.
     * 
     * <strong>Secara tekniks, Parameter Page dan Batas
     * Menentukan Limit Query</strong>
     * 
     * @param page
     * @return List
     * @throws SQLException 
     */
    public List<Location> getListFromDB(int page) throws SQLException 
    {     
       // write code here
        
        return null;
    }   
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param objLoc
     * @throws SQLException 
     */
    public void saveDataToDB(Location objLoc) throws SQLException
    {
        // write code here
    }
    
    /**
     * Method untuk mengubah data record di database
     * berdasarkan kode Location
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * @param modaCode
     * @param objLoc
     * @throws SQLException 
     */
    public void updateDataToDB(String modaCode, Location objLoc) throws SQLException
    {
   
    }
    
    /**
     * Method untuk mengubah data record di database
     * berdasarkan kode ModaTransportasi (pk).
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * @param locCode
     * @throws SQLException 
     */
    public void deleteDataInDB(String locCode) throws SQLException
    {
        // write code here
    }
}
