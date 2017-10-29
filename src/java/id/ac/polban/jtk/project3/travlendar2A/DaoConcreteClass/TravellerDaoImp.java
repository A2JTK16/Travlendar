/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.ITravellerDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class TravellerDaoImp extends DAO implements ITravellerDao
{
    
    /**
     *
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword
     */
    int limit;
    
    public TravellerDaoImp(String jdbcURL, String jdbcUsername, String jdbcPassword, int limit) 
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
        this.limit = limit;
    }

        /**
         *
         * @return
         * @throws SQLException
         */
    @Override
    public List<Traveller> getListFromDB(int page) throws SQLException {
        List <Traveller> listData;
        listData = new ArrayList();
        Traveller traveller;
        
        page = (page-1) * this.limit;
        
        String sql = String.format("SELECT * FROM `travlendar`.`traveller` LIMIT %d, %d", page, this.limit);
        
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            traveller = new Traveller();
                
            traveller.setTraveller_id(rs.getInt("TRAVELLER_ID"));
            traveller.setTraveller_name(rs.getString("TRAVELLER_NAME"));
            traveller.setTraveller_email(rs.getString("TRAVELLER_EMAIL"));
            traveller.setTraveller_password(rs.getString("TRAVELLER_PASSWORD"));
            traveller.setTraveller_fullName(rs.getString("TRAVELLER_FULLNAME"));
            
            listData.add(traveller);
        }
        
        stmt.close();
        super.disconnect();
            
        return listData;
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
    @Override
    public int getCountPage() throws SQLException
    {
        // deklarasi
        int recCount;
        int page;
        double pageD;
        Statement statement;
        ResultSet resultset;
        
        // inisiasi
        recCount = 0;
        
        // koneksi
        super.connect();
        // buat statementStatement statement;
        statement = super.getJdbcConnection().createStatement();
        // eksekusi query
        resultset = statement.executeQuery("SELECT COUNT(*) FROM `transportation_mode`");
        
        
        while(resultset.next())
        {
            recCount = resultset.getInt("COUNT(*)");
        }
        
        // diskonek
        resultset.close();
        super.disconnect();
        
        // menghitung jumlah page
        pageD = (double) recCount / this.limit;
        page = (int) recCount / this.limit;
        
        // pembulatan
        pageD = (double) pageD - page;
        if(pageD > 0) 
        {
            page += 1;
        }
           
        return page;
    }

    @Override
    public boolean isTravellerAvaiable(int travellerId) throws SQLException 
    {
        // deklarasi
        boolean isAvaiable;
        String sql;
        Statement statement;
        ResultSet resultset;
        
        // inisialisasi
        isAvaiable = false;
        
        // koneksi
        super.connect();
        // buat statement
        statement = super.getJdbcConnection().createStatement();
        // eksekusi query
        sql = String.format("SELECT COUNT(`TRAVELLER_ID`) FROM `traveller` WHERE `TRAVELLER_ID`='%d'",travellerId);
        resultset = statement.executeQuery(sql);
        
        while(resultset.next())
        {
            // jika jumlah record yg ditemukan lebih dari nol
            if(resultset.getInt("COUNT(`TRAVELLER_ID`)") > 0)
                isAvaiable = true;
        }

        // diskonek
        super.disconnect();
        
        return isAvaiable;
    }

        /**
     * Method untuk Mendapatkan Data Satu Record
     * Berdasarkan Kode ModaTransportasi
     * 
     * @param travellerId
     * @return 
     * @throws java.sql.SQLException 
     */
    
    @Override
    public Traveller getDataFromDB(Integer travellerId) throws SQLException  
    {   
        // jika trscode nya null
        if(travellerId==null)
            return null;
        
        // jika panjang nya lebih dari panjang schema db
//        if(travellerId.length()>2)
//            return null;
        
        Traveller traveller;
        String sql;

        // instansiasi
        traveller = new Traveller();

        // koneksi
        super.connect();
        
        Statement statement; 
        ResultSet resultset;
        
        // buat statement
        statement = super.getJdbcConnection().createStatement();
        
        // eksekusi query
        sql = String.format("SELECT * FROM `traveller` WHERE `TRANSPORTATION_CODE` = '%s'",travellerId);
        resultset = statement.executeQuery(sql);
        
        // jika ada result
        while(resultset.next())
        {
            // mendapatkan data sesuai atribut 
            traveller.setTraveller_id(resultset.getInt("TRAVELLER_ID"));
            traveller.setTraveller_name(resultset.getString("TRAVELLER_NAME"));
            traveller.setTraveller_email(resultset.getString("TRAVELLER_EMAIL"));
            traveller.setTraveller_password(resultset.getString("TRAVELLER_PASSWORD"));
            traveller.setTraveller_fullName(resultset.getString("TRAVELLER_FULLNAME"));
        }
                // tutup statement
        statement.close();
        // tutup koneksi
        super.disconnect();
        
        return traveller;
    }
    @Override
    public void saveDataToDB(Traveller travellerObj) throws SQLException
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
        String sql = String.format("INSERT INTO `traveller`(`TRAVELLER_ID`, `TRAVELLER_NAME`, `TRAVELLER_EMAIL`, `TRAVELLER_PASSWORD`, `TRAVELLER_FULLNAME`) VALUES ('%d','%s','%s', '%s', '%s')", travellerObj.getTraveller_id(),travellerObj.getTraveller_name(), travellerObj.getTraveller_email(), travellerObj.getTraveller_password(), travellerObj.getTraveller_fullName() );
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
     * berdasarkan kode ModaTransportasi (pk).
     * Jika gagal mengubah, maka akan keluar eks
     * @param travellerObj
     * @param travellerObjepsi
     * 
     * @param modaCode
     * @param modaTrs
     * @throws SQLException 
     */
    
    @Override
    public void updateDataToDB(Traveller travellerObj) throws SQLException
    {
        // deklarasi
        String sql;
        Statement statement;
        /**
         * Buat Koneksi ke DBMS
         */
        super.connect();
        /**
         * Buat Statement
         */
        
        statement = super.getJdbcConnection().createStatement();
        /**
         * Eksekusi Query
         * 
         * Note : PK tdk boleh diupdate
         */
        sql = String.format("UPDATE `traveller` SET `TRAVELLER_NAME`='%s',`TRAVELLER_EMAIL`='%s',`TRAVELLER_PASSWORD`='%s', `TRAVELLER_FULLNAME`='%s' WHERE `TRAVELLER_ID`='%s'", travellerObj.getTraveller_name(),travellerObj.getTraveller_email(), travellerObj.getTraveller_password(), travellerObj.getTraveller_fullName(),travellerObj.getTraveller_id() );
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
     * berdasarkan kode ModaTransportasi (pk).
     * Jika gagal mengubah, maka akan keluar eksepsi
     * 
     * @param modaCode
     * @throws SQLException 
     */
    @Override
    public void deleteDataFromDB(int travellerId) throws SQLException
    {
        // deklarasi
        String sql;
        Statement statement;
        /**
         * Buat Koneksi ke DBMS
         */
        super.connect();
        /**
         * Buat Statement
         */
        
        statement = super.getJdbcConnection().createStatement();
        /**
         * Eksekusi Query
         */
        sql = String.format("DELETE FROM `traveller` WHERE `TRAVELLER_ID`='%d'",travellerId);
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
}