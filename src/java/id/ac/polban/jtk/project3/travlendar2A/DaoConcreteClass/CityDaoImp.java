/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass;

import id.ac.polban.jtk.project3.travlendar2A.DaoInterface.ICityDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Reza Dwi Kurniawan
 */
public class CityDaoImp extends DAO implements ICityDao
{    
    public CityDaoImp (String jdbcURL, String jdbcUsername, String jdbcPassword)
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<City> getListFromDB(int page) throws SQLException {
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

    @Override
    public City getDataFromDB(String cityCode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountPage() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCityAvaiable(String cityCode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void saveDataToDB(City cityObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataToDB(City cityObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataFromDB(String cityCode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}