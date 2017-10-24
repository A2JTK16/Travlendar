/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class induk untuk koneksi ke Database
 * 
 * @author Zulkifli Arsyad
 */
public class DAO { 
    
    /**
     * Atribut
     */
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    /**
     * Konstruktor
     * 
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     */
    public DAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    /**
     * Method untuk koneksi ke Database MySQL
     * menggunakan Jdbc Driver.
     * Setelah koneksi, jangan lupa untuk disconnect.
     */
    protected void connect()
    {
        try {
            // jika koneksi belum diset atau ditutup
            if (jdbcConnection == null || jdbcConnection.isClosed()) 
            {
                try 
                {
                    // mendapatkan class jdbc driver
                    Class.forName("com.mysql.jdbc.Driver");
                } 
                catch (ClassNotFoundException e) 
                {
                    // kelas gagal ditemukan
                    throw new SQLException(e);
                }
                // assignment koneksi
                jdbcConnection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
        } 
        catch (SQLException ex) 
        {
            // Gagal koneksi, trace log histori
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk disconnect 
     * koneksi dengan DBMS
     */
    protected void disconnect()
    {
        try 
        {
            // jika koneksi masih ada dan belum ditutup
            if (jdbcConnection != null && !jdbcConnection.isClosed()) 
            {
                // koneksi ditutup
                jdbcConnection.close();
            }
        } 
        catch (SQLException ex) 
        {
            // gagal menutup koneksi, trace log
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method untuk mendapatkan Jdbc URL.
     * Maksud URL disini adalah URL 
     * untuk koneksi ke DBMS MySQL
     * 
     * @return 
     */
    public String getJdbcURL() 
    {
        return jdbcURL;
    }
    
    /**
     * Method untuk Mengganti Jdbc URL
     * Maksud URL Disini Adalah URL untuk Koneksi
     * ke MySQL DBMS
     * 
     * @param jdbcURL 
     */
    public void setJdbcURL(String jdbcURL) 
    {
        this.jdbcURL = jdbcURL;
    }
    
    /**
     * Method untuk Mendapatkan Jdbc Username,
     * yakni Username Database Akses DBMS
     * 
     * @return 
     */
    public String getJdbcUsername() 
    {
        return jdbcUsername;
    }
    
    /**
     * Method untuk Mengganti Jdbc Username,
     * Username Database Akses DBMS
     * 
     * @param jdbcUsername 
     */
    public void setJdbcUsername(String jdbcUsername) 
    {
        this.jdbcUsername = jdbcUsername;
    }
    
    /**
     * Mendapatkan Password DBMS
     * 
     * @return 
     */
    public String getJdbcPassword() 
    {
        return jdbcPassword;
    }
    
    /**
     * Method untuk Mengganti Jdbc Password
     * @param jdbcPassword 
     */
    public void setJdbcPassword(String jdbcPassword) 
    {
        this.jdbcPassword = jdbcPassword;
    }
    
    /**
     * Method untuk Mendapatkan Reference Connection
     * @return 
     */
    public Connection getJdbcConnection() 
    {
        return jdbcConnection;
    }
    
    /**
     * Method untuk Mengganti Connection
     * @param jdbcConnection 
     */
    public void setJdbcConnection(Connection jdbcConnection) 
    {
        this.jdbcConnection = jdbcConnection;
    }

}