/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoInterface;

import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.sql.SQLException;
import java.util.List;

/**
 *  Interface standar operasi akses database 
 *  tabel Event
 * 
 */
public interface IEventDao 
{
    /**
     * Method untuk Mendapatkan Data Satu Record
     * 
     * @param eventCode
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException
     */
    public Event getDataFromDB(int eventCode, int travellerId) throws SQLException;  
    
    /**
     * Method untuk Mendapatkan Data Satu Record
     * sebelum kode event yang telah ditentukan
     * 
     * @param eventCode
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException
     */
    public Event getDataBefore(int eventCode, int travellerId) throws SQLException;
    /**
     * Method untuk mendapatkan jumlah halaman
     * berdasarkan limit item yg telah ditentukan
     * dengan cara mengembalikan jml record/tuple
     * dari tabel database
     * 
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException
     */
    public int getCountPage(int travellerId) throws SQLException;
    
    /**
     * Method untuk mendapatkan nilai kebenaran
     * tentang <strong>ada tidaknya event</strong>
     * dengan kode PK yang telah ditentukan. Jika ada,
     * maka akan mengembalikan nilai true.
     * 
     * Jika gagal mendapatkan data dari database,
     * maka akan keluar eksepsi
     * 
     * @param eventCode
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean isEventAvaiable(int eventCode, int travellerId) throws SQLException;
    
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
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException
     */
    public List<Event> getListFromDB(int page, int travellerId) throws SQLException;
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param myEvent
     * @throws SQLException 
     */
    public void saveDataToDB(Event myEvent) throws SQLException;
    
    /**
     * Method untuk mengubah data record di database berdasarkan PK
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * Note : PK tidak boleh diubah
     * 
     * @param myEvent
     * @throws SQLException 
     */
    public void updateDataToDB(Event myEvent) throws SQLException;
    
    /**
     * Method untuk menghapus record
     * 
     * @param travellerId
     * @param eventCode
     * @throws SQLException 
     */
    public void deleteDataFromDB(int travellerId, int eventCode) throws SQLException;
    
}