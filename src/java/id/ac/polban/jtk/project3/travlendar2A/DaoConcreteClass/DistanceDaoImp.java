/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.IDistanceDao;
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
public class DistanceDaoImp extends DAO implements IDistanceDao
{
    public DistanceDaoImp (String jdbcURL, String jdbcUsername, String jdbcPassword)
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    /**
     *
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public List<Distance> getListFromDB(int page) throws SQLException {
        List <Distance> listDistance;
        listDistance = new ArrayList();
        Distance distance;
        
        String sql = "SELECT * FROM `distance`";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            distance = new Distance();
            
            distance.setStart_location_id(rs.getInt("START_LOCATION_ID"));
            distance.setEnd_location_id(rs.getInt("END_LOCATION_ID"));
            distance.setDistance(rs.getFloat("DISTANCE"));
            
            
            listDistance.add(distance);
        }
        
        stmt.close();
        super.disconnect();
        
        return listDistance;
    }
    
    @Override
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
        String sql = "INSERT INTO distance(START_LOCATION_ID, END_LOCATION_ID, DISTANCE) VALUES ('"+distance.getStart_location_id()+"','"+distance.getEnd_location_id()+"','"+distance.getDistance()+"')";
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

    @Override
    public double getDistance(Distance distanceObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountPage() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataToDB(Distance distanceObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataFromDB(Distance distanceObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}