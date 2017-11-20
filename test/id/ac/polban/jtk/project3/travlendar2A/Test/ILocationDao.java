/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.test;

import java.sql.SQLException;
import java.util.List;

/**
 *  Interface standar operasi akses database 
 *  tabel Location
 * 
 */
public interface ILocationDao 
{
    /**
     * Method untuk Mendapatkan Data Satu Record
     * 
     * @param provinceCode
     * @param cityCode
     * @param locId
     * @return 
     * @throws java.sql.SQLException
     */
    public Location getDataFromDB(String provinceCode, String cityCode, int locId) throws SQLException;  
    
    /**
     * Method untuk Mendapatkan Data Satu Record
     * sebelum kode loc yang telah ditentukan
     * 
     * @param provinceCode
     * @param cityCode
     * @param locId
     * @return 
     * @throws java.sql.SQLException
     */
    public Location getDataBefore(String provinceCode, String cityCode, int locId) throws SQLException;
    /**
     * Method untuk mendapatkan jumlah halaman
     * berdasarkan limit item yg telah ditentukan
     * dengan cara mengembalikan jml record/tuple
     * dari tabel database
     * 
     * @return 
     * @throws java.sql.SQLException
     */
    public int getCountPage() throws SQLException;
    
    /**
     * Method untuk mendapatkan nilai kebenaran
     * tentang <strong>ada tidaknya loc</strong>
     * dengan kode PK yang telah ditentukan. Jika ada,
     * maka akan mengembalikan nilai true.
     * 
     * Jika gagal mendapatkan data dari database,
     * maka akan keluar eksepsi
     * 
     * @param provinceCode
     * @param cityCode
     * @param locId
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean isLocationAvaiable(String provinceCode, String cityCode, int locId) throws SQLException;
    
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
     * @return 
     * @throws java.sql.SQLException
     */
    public List<Location> getListFromDB(int page) throws SQLException;
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param myLocation
     * @throws SQLException 
     */
    public void saveDataToDB(Location myLocation) throws SQLException;
    
    /**
     * Method untuk mengubah data record di database berdasarkan PK
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * Note : PK tidak boleh diubah
     * 
     * @param myLocation
     * @throws SQLException 
     */
    public void updateDataToDB(Location myLocation) throws SQLException;
    
    /**
     * Method untuk menghapus record
     * 
     * @param provinceCode
     * @param cityCode
     * @param locId
     * @throws SQLException 
     */
    public void deleteDataFromDB(String provinceCode, String cityCode, int locId) throws SQLException;
    
}