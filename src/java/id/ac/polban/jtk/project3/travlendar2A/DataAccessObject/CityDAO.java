/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DataAccessObject;

import id.ac.polban.jtk.project3.travlendar2A.Models.City;
import id.ac.polban.jtk.project3.travlendar2A.Models.DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class CityDAO extends DAO {    
        public CityDAO (String jdbcURL, String jdbcUsername, String jdbcPassword){
            super(jdbcURL, jdbcUsername, jdbcPassword);
        }

    
    
    public List<City> getDataFromDB() throws SQLException {
        List <City> listData;
        listData = new ArrayList();
        City city;
        
        String sql = "SELECT `CITY_CODE`, `CITY_NAME` FROM `travlendardb`.`city`";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            city = new City();
            
            city.setCityCode(rs.getString("CITY_CODE"));
            city.setCityName(rs.getString("CITY_NAME"));
            
            listData.add(city);
        }
        
        stmt.close();
        super.disconnect();
            
        return listData;
    }   
}