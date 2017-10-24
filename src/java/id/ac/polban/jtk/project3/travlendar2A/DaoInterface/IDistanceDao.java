/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoInterface;

import id.ac.polban.jtk.project3.travlendar2A.Models.Distance;
import java.sql.SQLException;
import java.util.List;

/**
 *  Interface standar operasi akses database 
 *  tabel Distance
 * 
 */
public interface IDistanceDao 
{
    /**
     * Method untuk Mendapatkan Jarak dari 
     * objek Distance
     * ( provinsi awal, kota awal, lokasi awal,
     * provinsi akhir, kota akhir, lokasi akhir )
     * 
     * Untuk parameter, atribut distance tidak diinisiasi
     * 
     * @param distanceObj
     * @return 
     * @throws java.sql.SQLException
     */
    public double getDistance(Distance distanceObj) throws SQLException;  
    
    /**
     * Method untuk mendapatkan jumlah halaman
     * berdasarkan limit item yg telah ditentukan
     * dengan cara mengembalikan jml record/tuple
     * dari tabel database
     * @return 
     * @throws java.sql.SQLException
     */
    public int getCountPage() throws SQLException;
    
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
    public List<Distance> getListFromDB(int page) throws SQLException;
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param distanceObj
     * @throws SQLException 
     */
    public void saveDataToDB(Distance distanceObj) throws SQLException;
    
    /**
     * Method untuk mengubah data record di database berdasarkan PK
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * Note : PK tidak boleh diubah
     * 
     * @param distanceObj
     * @throws SQLException 
     */
    public void updateDataToDB(Distance distanceObj) throws SQLException;
    
    /**
     * Method untuk menghapus record
     * 
     * @param distanceObj
     * @throws SQLException 
     */
    public void deleteDataFromDB(Distance distanceObj) throws SQLException;
    
}