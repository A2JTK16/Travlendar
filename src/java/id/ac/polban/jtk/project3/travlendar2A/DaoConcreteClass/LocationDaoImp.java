/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.ILocationDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LocationDaoImp extends DAO implements ILocationDao
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
    public LocationDaoImp (String jdbcURL, String jdbcUsername, String jdbcPassword)
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
        //this.limit = limit;
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
     /**
         *
         * @return
         * @throws SQLException
         */
    @Override
    public List<Location> getListFromDB(int page) throws SQLException {
        List <Location> listLoc;
        listLoc = new ArrayList();
        Location location;
        
      //  page = (page-1) * this.limit;
        
        String sql = String.format("SELECT * FROM `markers`");
        
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            location = new Location();
            
            location.setIdEvent(rs.getInt("id"));
            location.setDesc(rs.getString("address"));
            location.setLat(rs.getString("lat"));
            location.setLng(rs.getString("lng"));
            
            listLoc.add(location);
        }
        
        stmt.close();
        super.disconnect();
            
        return listLoc;
        }
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param objLoc
     * @throws SQLException 
     */
    @Override
    public void saveDataToDB(Location objLoc) throws SQLException
    {   
        String sql;
        sql = String.format("INSERT INTO `markers`(`name`, `address`, `lat`, `lng`) VALUES ('%s','%s','%s','%s')", "New Add", objLoc.getDesc(), objLoc.getLat(), objLoc.getLng() );
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
        
        statement.executeUpdate(sql);
        /**
         * Tutup Statement
         */
        statement.close();
        /**
         * Tutup Koneksi
         */
        super.disconnect();
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

    @Override
    public Location getDataFromDB(String provinceCode, String cityCode, int locId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getDataBefore(String provinceCode, String cityCode, int locId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLocationAvaiable(String provinceCode, String cityCode, int locId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataToDB(Location myLocation) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataFromDB(String provinceCode, String cityCode, int locId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
