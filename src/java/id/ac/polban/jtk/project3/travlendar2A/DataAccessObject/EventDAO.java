/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DataAccessObject;

import id.ac.polban.jtk.project3.travlendar2A.Helpers.ParseDate;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EventDAO extends DAO
{
    
    public EventDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    /**
     * Ambil data list (with paging) dengan Query SQL, misalnya SELECT * FROM agenda LIMIT ..
     * Edit data dengan Query SQL
     * Delete data dengan Query SQL
     * Save data objek dengan Query SQL
     * 
     * Lih Class Diagram
     */
    public List<Event> getDataFromDB(int halaman, int batas) throws SQLException{
        List<Event> listEvent;
        Event event;
        String sql;
        int tempInt;
        String tempStr;
        Date tempDate;
        listEvent = new ArrayList();
        tempInt = (halaman-1) * batas;
        sql = String.format("SELECT * FROM tes.event order by EVENT_ID asc LIMIT %d, %d",tempInt,batas);
        super.connect();
        Statement statement;
        ResultSet resultSet;

            statement = super.getJdbcConnection().createStatement();
            resultSet = statement.executeQuery(sql);  
            
            while (resultSet.next()) {
                event = new Event();
                
                tempInt = resultSet.getInt("EVENT_ID");
                event.setEvent_id(tempInt);
                
                tempStr = resultSet.getString("EVENT_NAME");
                event.setEvent_name(tempStr);
                
                tempDate = ParseDate.getDateValueFromStr(resultSet.getString("START_EVENT"));
                event.setStart_event(tempDate);
                    
                tempDate = ParseDate.getDateValueFromStr(resultSet.getString("END_EVENT"));
                event.setEnd_event(tempDate);
                
                /*tempInt = resultSet.getInt("KODE_LOKASI_AWAL");
                event.setKodeLokasiAwal(tempInt);
                
                tempInt = resultSet.getInt("KODE_LOKASI_TUJUAN");
                event.setKodeLokasiTujuan(tempInt);*/
                
                tempStr = resultSet.getString("NOTE");
                event.setNote(sql);
                
                tempStr = resultSet.getString("PLACE");
                event.setPlace(sql);
                
                listEvent.add(event);
            }
            statement.close();
               
        super.disconnect();
        return listEvent;
    }
    
    public int getPageCount(int batas)
    {
        String sql;
        sql = "SELECT count(*) FROM tes.event";
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
     * @return 
     */
    public boolean saveDataToDB(Event myEvent)
    {
        String sql;
        boolean isSaveSuccess;
        sql = String.format("INSERT INTO tes.event(EVENT_NAME, START_EVENT, END_EVENT, NOTE, PLACE) VALUES ('%s', '%s', '%s', '%s', '%s')", myEvent.getEvent_name(), ParseDate.getStrFromDate(myEvent.getStart_event()), ParseDate.getStrFromDate(myEvent.getEnd_event()), myEvent.getNote(), myEvent.getPlace());
        super.connect();
        Statement statement;
        
        try{
            statement = super.getJdbcConnection().createStatement();
            statement.executeUpdate(sql);
            statement.close();
            isSaveSuccess = true;
        }
        catch(SQLException e)
        {
            isSaveSuccess = false;
        }
        
        super.disconnect();
        
        return isSaveSuccess;
    }
    
    
    /**
     * Jangan lupa ketika beres koneksi, diskonek aja
     */
}