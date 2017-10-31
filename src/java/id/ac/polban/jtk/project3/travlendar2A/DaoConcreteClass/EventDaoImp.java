/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.IEventDao;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.DateTHelper;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EventDaoImp extends DAO implements IEventDao
{
    private int limit;
    
    public EventDaoImp(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    /**
     * Ambil data list (with paging) dengan Query SQL, misalnya SELECT * FROM agenda LIMIT ..
     * Edit data dengan Query SQL
     * Delete data dengan Query SQL
     * Save data objek dengan Query SQL
     * 
     * Lih Class Diagram
     * @param halaman
     * @return 
     * @throws java.sql.SQLException 
     */
    @Override
    public List<Event> getListFromDB(int halaman) throws SQLException{
        List<Event> listEvent;
        Event event;
        String sql, sql1;
        int tempInt;
        String tempStr;
        Date tempDate;
        listEvent = new ArrayList();
        //tempInt = (halaman-1) * this.limit;
        sql = String.format("SELECT * FROM `event`");
        //sql = String.format("SELECT `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `NOTE`, `ADDRESS_PLACE` FROM `event`, `location` WHERE `event.LOCATION_ID` = `location.LOCATION_ID`");
        //sql1 = String.format("SELECT ADDRESS_PLACE FROM `location`, `event` WHERE `event`.LOCATION_ID = `location`.LOCATION_ID");
        super.connect();
        Statement statement;
        ResultSet resultSet, resultSet1;

            statement = super.getJdbcConnection().createStatement();
            resultSet = statement.executeQuery(sql);  
            //resultSet1 = statement.executeQuery(sql1);
            while (resultSet.next()) {
                event = new Event();
                
                tempInt = resultSet.getInt("LOCATION_ID");
                event.setLocation_id(tempInt);
                
                tempInt = resultSet.getInt("EVENT_ID");
                event.setEvent_id(tempInt);
                
                tempInt = resultSet.getInt("TRAVELLER_ID");
                event.setTraveller_id(tempInt);
                
                tempStr = resultSet.getString("EVENT_NAME");
                event.setEvent_name(tempStr);
                
                tempDate = DateTHelper.parseDateM(resultSet.getString("START_EVENT"));
                event.setStart_event(tempDate);
                    
                tempDate = DateTHelper.parseDateM(resultSet.getString("END_EVENT"));
                event.setEnd_event(tempDate);
                
                /*tempInt = resultSet.getInt("KODE_LOKASI_AWAL");
                event.setKodeLokasiAwal(tempInt);
                
                tempInt = resultSet.getInt("KODE_LOKASI_TUJUAN");
                event.setKodeLokasiTujuan(tempInt);*/
                
                tempStr = resultSet.getString("NOTE");
                event.setNote(tempStr);
                
                tempStr = resultSet.getString("PLACE");
                event.setPlace(tempStr);
                
                listEvent.add(event);
            }
            statement.close();
               
        super.disconnect();
        return listEvent;
    }
    
    public int getPageCount(int batas)
    {
        String sql;
        sql = "SELECT count(*) FROM travlendardb.event";
        super.connect();
        Statement statement;
        int page;
        
        try 
        {    
            statement = super.getJdbcConnection().createStatement();
            page = statement.executeUpdate(sql);
            page = (int) page / batas;
            statement.close();
        } 
        catch (SQLException ex) 
        {
            page = -1;
        }
        super.disconnect();
        return page;
    }
    
    /**
     *
     * @param myEvent 
     * @throws java.sql.SQLException 
     */
    @Override
    public void saveDataToDB(Event myEvent) throws SQLException
    {
        String sql;
        boolean isSaveSuccess;
        sql = String.format("INSERT INTO `event`(`LOCATION_ID`, `EVENT_ID`, `TRAVELLER_ID`, `EVENT_NAME`, `START_EVENT`, `END_EVENT`, `NOTE`, `PLACE`) VALUES ('%d', '%d', '%d', '%s', '%s', '%s', '%s', '%s')", myEvent.getLocation_id(), myEvent.getEvent_id(), myEvent.getTraveller_id(), myEvent.getEvent_name(), DateTHelper.toStringM(myEvent.getStart_event()), DateTHelper.toStringM(myEvent.getEnd_event()), myEvent.getNote(), myEvent.getPlace());
        
        super.connect();
        Statement statement;
        
        statement = super.getJdbcConnection().createStatement();
        statement.executeUpdate(sql);
        statement.close();
      
        super.disconnect();
    }

    @Override
    public Event getDataBefore(int eventCode, int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountPage(int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEventAvaiable(int eventCode, int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void updateDataToDB(Event event) throws SQLException
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
        //sql = String.format("UPDATE `transportation_mode` SET `TRANSPORTATION_NAME`='%s',`TRANSPORTATION_SPEED`='%s' WHERE `TRANSPORTATION_CODE`='%s'",modaTrs.getNamaTransportasi(), modaTrs.getKecepatan(), modaTrs.getKodeTransportasi() );
        sql = String.format("UPDATE `event` SET `LOCATION_ID`='%d', `TRAVELLER_ID`='%d', `EVENT_NAME`='%s', `START_EVENT`='%s', `END_EVENT`='%s', `NOTE`='%s', `PLACE`='%s' WHERE `EVENT_ID`='%s'", event.getLocation_id(), event.getTraveller_id(), event.getEvent_name(), event.getStart_event(), event.getEnd_event(), event.getNote(), event.getPlace(), event.getEvent_id());
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

    @Override
    public void deleteDataFromDB(int travellerId, int eventCode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Event getDataFromDB(int eventCode) throws SQLException
    {   
        // jika trscode nya null
        /*if(eventCode==null)
            return null;
        
        // jika panjang nya lebih dari panjang schema db
        if(eventCode.length()>2)
            return null;*/
        int tempInt;
        String tempStr;
        Date tempDate;
        Event event;
        String sql;

        // instansiasi
        event = new Event();

        // koneksi
        super.connect();
        
        Statement statement; 
        ResultSet resultSet;
        
        // buat statement
        statement = super.getJdbcConnection().createStatement();
        
        // eksekusi query
        sql = String.format("SELECT * FROM `event` WHERE `EVENT_ID` = '%d'",eventCode);
        resultSet = statement.executeQuery(sql);
        
        // jika ada result
        while(resultSet.next())
        {
            // mendapatkan data sesuai atribut 
            
            
                tempInt = resultSet.getInt("LOCATION_ID");
                event.setLocation_id(tempInt);
                
                tempInt = resultSet.getInt("EVENT_ID");
                event.setEvent_id(tempInt);
                
                tempInt = resultSet.getInt("TRAVELLER_ID");
                event.setTraveller_id(tempInt);
                
                tempStr = resultSet.getString("EVENT_NAME");
                event.setEvent_name(tempStr);
                
                tempDate = DateTHelper.parseDateM(resultSet.getString("START_EVENT"));
                event.setStart_event(tempDate);
                    
                tempDate = DateTHelper.parseDateM(resultSet.getString("END_EVENT"));
                event.setEnd_event(tempDate);
                
                /*tempInt = resultSet.getInt("KODE_LOKASI_AWAL");
                event.setKodeLokasiAwal(tempInt);
                
                tempInt = resultSet.getInt("KODE_LOKASI_TUJUAN");
                event.setKodeLokasiTujuan(tempInt);*/
                
                tempStr = resultSet.getString("NOTE");
                event.setNote(tempStr);
                
                tempStr = resultSet.getString("PLACE");
                event.setPlace(tempStr);
        }

        // tutup statement
        statement.close();
        // tutup koneksi
        super.disconnect();
        
        return event;
    }
    
    
    /**
     * Jangan lupa ketika beres koneksi, diskonek aja
     */
}