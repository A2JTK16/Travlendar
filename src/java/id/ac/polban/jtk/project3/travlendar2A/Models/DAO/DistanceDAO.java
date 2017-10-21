/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models.DAO;

import id.ac.polban.jtk.project3.travlendar2A.Models.Distance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AGS
 */
public class DistanceDAO extends DAO{
    public DistanceDAO (String jdbcURL, String jdbcUsername, String jdbcPassword){
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Distance> getDataFromDB() throws SQLException {
        List <Distance> listData;
        listData = new ArrayList();
        Distance distance;
        
        String sql = "SELECT * FROM tes.distance";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            distance = new Distance();
            
            distance.setKd_provinsi_akhir(rs.getString("KD_PROVINSI_AKHIR"));
            distance.setKd_kota__akhir(rs.getString("KD_KOTA_AKHIR"));
            distance.setId_lokasi_akhir(rs.getInt("ID_LOKASI_AKHIR"));
            distance.setKd_provinsi_awal(rs.getString("KD_PROVINSI_AWAL"));
            distance.setKd_kota_awal(rs.getString("KD_KOTA_AWAL"));
            distance.setId_lokasi_awal(rs.getInt("ID_LOKASI_AWAL"));
            distance.setDistance(rs.getFloat("DISTANCE"));
            
            
            listData.add(distance);
        }
        
        stmt.close();
        super.disconnect();
        
        return listData;
    }
    
    public void saveDataToDB(Distance distance) throws SQLException
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
        String sql = "INSERT INTO distance(KD_PROVINSI_AKHIR, KD_KOTA_AKHIR, ID_LOKASI_AKHIR, KD_PROVINSI_AWAL, KD_KOTA_AWAL, ID_LOKASI_AWAL, DISTANCE) VALUES ('"+distance.getKd_provinsi_akhir()+"','"+distance.getKd_kota__akhir()+"','"+distance.getId_lokasi_akhir()+"','"+distance.getKd_provinsi_awal()+"','"+distance.getKd_kota_awal()+"','"+distance.getId_lokasi_awal()+"','"+distance.getDistance()+"')";
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