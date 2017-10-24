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
    public List<Event> getListFromDB(int halaman, int travellerId) throws SQLException{
        List<Event> listEvent;
        Event event;
        String sql;
        int tempInt;
        String tempStr;
        Date tempDate;
        listEvent = new ArrayList();
        tempInt = (halaman-1) * this.limit;
        sql = String.format("SELECT * FROM tes.event order by EVENT_ID asc LIMIT %d, %d",tempInt,this.limit);
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
     * @throws java.sql.SQLException 
     */
    @Override
    public void saveDataToDB(Event myEvent) throws SQLException
    {
        String sql;
        boolean isSaveSuccess;
        sql = String.format("INSERT INTO tes.event(EVENT_NAME, START_EVENT, END_EVENT, NOTE, PLACE) VALUES ('%s', '%s', '%s', '%s', '%s')", myEvent.getEvent_name(), DateTHelper.toStringM(myEvent.getStart_event()), DateTHelper.toStringM(myEvent.getEnd_event()), myEvent.getNote(), myEvent.getPlace());
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

    @Override
    public void updateDataToDB(Event myEvent) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataFromDB(int travellerId, int eventCode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Event getDataFromDB(int eventCode, int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * Jangan lupa ketika beres koneksi, diskonek aja
     */
}