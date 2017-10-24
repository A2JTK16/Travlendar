/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.ITransportationMdDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *  Kelas untuk akses database 
 *  tabel ModaTransportasi
 * 
 * @author Reza Dwi Kurniawan, Mufid Jamaluddin
 */
public class TransportationMdDaoImp extends DAO implements ITransportationMdDao
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
    public TransportationMdDaoImp (String jdbcURL, String jdbcUsername, String jdbcPassword, int limit)
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
        this.limit = limit;
    }
    
    /**
     * Method untuk Mendapatkan Data Satu Record
     * Berdasarkan Kode ModaTransportasi
     * 
     * @param trscode
     * @return 
     * @throws java.sql.SQLException 
     */
    @Override
    public ModaTransportasi getDataFromDB(String trscode) throws SQLException
    {   
        // jika trscode nya null
        if(trscode==null)
            return null;
        
        // jika panjang nya lebih dari panjang schema db
        if(trscode.length()>2)
            return null;
        
        ModaTransportasi modaTrans;
        String sql;

        // instansiasi
        modaTrans = new ModaTransportasi();

        // koneksi
        super.connect();
        
        Statement statement; 
        ResultSet resultset;
        
        // buat statement
        statement = super.getJdbcConnection().createStatement();
        
        // eksekusi query
        sql = String.format("SELECT * FROM `transportation_mode` WHERE `TRANSPORTATION_CODE` = '%s'",trscode);
        resultset = statement.executeQuery(sql);
        
        // jika ada result
        while(resultset.next())
        {
            // mendapatkan data sesuai atribut 
            modaTrans.setKodeTransportasi(resultset.getString("TRANSPORTATION_CODE"));
            modaTrans.setKecepatan(resultset.getFloat("TRANSPORTATION_SPEED"));
            modaTrans.setNamaTransportasi(resultset.getString("TRANSPORTATION_NAME"));
        }

        // tutup statement
        statement.close();
        // tutup koneksi
        super.disconnect();
        
        return modaTrans;
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
    @Override
    public boolean isModeAvaiable(String modaCode) throws SQLException
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
        sql = String.format("SELECT COUNT(`TRANSPORTATION_CODE`) FROM `transportation_mode` WHERE `TRANSPORTATION_CODE`='%s'",modaCode);
        resultset = statement.executeQuery(sql);
        
        while(resultset.next())
        {
            // jika jumlah record yg ditemukan lebih dari nol
            if(resultset.getInt("COUNT(`TRANSPORTATION_CODE`)") > 0)
                isAvaiable = true;
        }

        // diskonek
        super.disconnect();
        
        return isAvaiable;
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
    @Override
    public List<ModaTransportasi> getListFromDB(int page) throws SQLException 
    {     
        // penampung modatransportasi
        List <ModaTransportasi> listData;
        listData = new ArrayList();
        ModaTransportasi modaTrans;
        
        // mendapatkan nilai limit awal
        page = (page-1) * this.limit;
   
        // nilai query
        String sql = String.format("SELECT * FROM `transportation_mode` LIMIT %d, %d",page,this.limit);
        
        // koneksi ke dbms
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        // buat statement dan eksekusi query 
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        // selama resultset nya masih ada
        while(rs.next())
        {
            // instansiasi
            modaTrans = new ModaTransportasi();
            
            // mendapatkan data sesuai atribut 
            modaTrans.setKecepatan(rs.getFloat("TRANSPORTATION_SPEED"));
            modaTrans.setKodeTransportasi(rs.getString("TRANSPORTATION_CODE"));
            modaTrans.setNamaTransportasi(rs.getString("TRANSPORTATION_NAME"));
            
            // menambahkan ke list
            listData.add(modaTrans);
        }
        
        // tutup statement
        stmt.close();
        // tutup koneksi
        super.disconnect();
        
        return listData;
    }   
    
    /**
     * Method untuk menyimpan data (satuan) ke database.
     * Jika gagal menyimpan, maka akan keluar eksepsi
     * 
     * @param modaTrs
     * @throws SQLException 
     */
    @Override
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
        String sql = String.format("INSERT INTO `transportation_mode`(`TRANSPORTATION_CODE`, `TRANSPORTATION_NAME`, `TRANSPORTATION_SPEED`) VALUES ('%s','%s','%s')", modaTrs.getKodeTransportasi(),modaTrs.getNamaTransportasi(), modaTrs.getKecepatan() );
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
     * @param modaTrs
     * @throws SQLException 
     */
    @Override
    public void updateDataToDB(ModaTransportasi modaTrs) throws SQLException
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
        sql = String.format("UPDATE `transportation_mode` SET `TRANSPORTATION_NAME`='%s',`TRANSPORTATION_SPEED`='%s' WHERE `TRANSPORTATION_CODE`='%s'",modaTrs.getNamaTransportasi(), modaTrs.getKecepatan(), modaTrs.getKodeTransportasi() );
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
    public void deleteDataToDB(String modaCode) throws SQLException
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
        sql = String.format("DELETE FROM `transportation_mode` WHERE `TRANSPORTATION_CODE`='%s'",modaCode);
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