/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DataAccessObject;

import id.ac.polban.jtk.project3.travlendar2A.Models.DAO.DAO;
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
public class TravellerDAO extends DAO {
    
    /**
     *
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword
     */
    public TravellerDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

        /**
         *
         * @return
         * @throws SQLException
         */
    public List<Traveller> getDataFromDB() throws SQLException {
        List <Traveller> listData;
        listData = new ArrayList();
        Traveller traveller;
        
        String sql = "SELECT `TRAVELLER_ID`, `TRAVELLER_FULLNAME` FROM `travlendardb`.`traveller`";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            traveller = new Traveller();
                
            traveller.setTraveller_id(rs.getInt("TRAVELLER_ID"));
            traveller.setTraveller_fullName(rs.getString("TRAVELLER_FULLNAME"));
            
            listData.add(traveller);
        }
        
        stmt.close();
        super.disconnect();
            
        return listData;
        }   
    }
