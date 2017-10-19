/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DataAccessObject;

import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Dwi Kurniawan
 */
    public class ModaTransportasiDAO extends DAO {
        public ModaTransportasiDAO (String jdbcURL, String jdbcUsername, String jdbcPassword){
            super(jdbcURL, jdbcUsername, jdbcPassword);
        }
    
    public List<ModaTransportasi> getDataFromDB() throws SQLException {
        List <ModaTransportasi> listData;
        listData = new ArrayList();
        ModaTransportasi modaTrans;
        
        String sql = "SELECT `KD_TRSMODE`, `NAMA_TRANSPORTASI`, `KECEPATAN` FROM `travlendar2a`.`mode_transportasi`";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            modaTrans = new ModaTransportasi();
            
            modaTrans.setKecepatan(rs.getFloat("KECEPATAN"));
            modaTrans.setKodeTransportasi(rs.getInt("KD_TRSMODE"));
            modaTrans.setNamaTransportasi(rs.getString("NAMA_TRANSPORTASI"));
            
            listData.add(modaTrans);
        }
        
        stmt.close();
        super.disconnect();
        
        return listData;
    }   
    
        /**
     * Menyimpan data ke database
     * @param modaTrs
     * @throws SQLException 
     */
    public void saveDataToDB(ModaTransportasi modaTrs) throws SQLException
    {
        /**
         * Buat Koneksi ke DBMS
         */
        super.connect();
        /**
         * Buat Statement
         */
        Statement statement;
        statement = super.getJdbcConnection().createStatement();
        /**
         * Eksekusi Query
         */
        String sql = String.format("INSERT INTO mode_transportasi(KD_TRSMODE, NAMA_TRANSPORTASI, KECEPATAN) VALUES ('%s','%s','%s')", modaTrs.getKodeTransportasi(),modaTrs.getNamaTransportasi(), modaTrs.getKecepatan() );
        statement.executeQuery(sql);
        /**
         * Tutup Statement
         */
        statement.close();
        /**
         * Tutup Koneksi
         */
        super.disconnect();
    }
}