/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoInterface;

import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
import java.sql.SQLException;
import java.util.List;

/**
 *  Interface standar operasi akses database 
 *  tabel ModaTransportasi
 * 
 */
public interface ITransportationMdDao 
{
    /**
     * Method untuk Mendapatkan Data Satu Record
     * Berdasarkan Kode ModaTransportasi
     * 
     * @param trscode
     * @return 
     * @throws java.sql.SQLException
     */
    public ModaTransportasi getDataFromDB(String trscode) throws SQLException;
    
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
     * tentang <strong>ada tidaknya moda transportasi</strong>
     * dengan kode ModaTransportasi yang telah ditentukan. Jika ada,
     * maka akan mengembalikan nilai true.
     * 
     * Jika gagal mendapatkan data dari database,
     * maka akan keluar eksepsi
     * 
     * @param modaCode
     * @return 
     * @throws java.sql.SQLException
     */
    public boolean isModeAvaiable(String modaCode) throws SQLException;
    
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
    public List<ModaTransportasi> getListFromDB(int page) throws SQLException;
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param modaTrs
     * @throws SQLException 
     */
    public void saveDataToDB(ModaTransportasi modaTrs) throws SQLException;
    
    /**
     * Method untuk mengubah data record di database
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * Note : PK tidak boleh diubah
     * 
     * @param modaCode
     * @param modaTrs
     * @throws SQLException 
     */
    public void updateDataToDB(ModaTransportasi modaTrs) throws SQLException;
    
    /**
     * Method untuk mengubah data record di database
     * berdasarkan kode ModaTransportasi (pk).
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * @param modaCode
     * @throws SQLException 
     */
    public void deleteDataToDB(String modaCode) throws SQLException;
    
}
