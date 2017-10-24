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
    public TravellerDaoImp(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }

        /**
         *
         * @return
         * @throws SQLException
         */
    public List<Traveller> getListFromDB() throws SQLException {
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

    @Override
    public Traveller getDataFromDB(int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCountPage() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isTravellerAvaiable(int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Traveller> getListFromDB(int page) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveDataToDB(Traveller travellerObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDataToDB(Traveller travellerObj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDataFromDB(int travellerId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
