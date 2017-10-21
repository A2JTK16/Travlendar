/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models.DAO;

import id.ac.polban.jtk.project3.travlendar2A.Models.Province;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AGS
 */
public class ProvinceDAO extends DAO{
    
    public ProvinceDAO (String jdbcURL, String jdbcUsername, String jdbcPassword){
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public List<Province> getDataFromDB() throws SQLException {
        List <Province> listData;
        listData = new ArrayList();
        Province province;
        
        String sql = "SELECT * FROM tes.province";
        super.connect();
        
        Statement stmt;
        ResultSet rs;
        
        stmt = super.getJdbcConnection().createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            province = new Province();
            
            province.setProvince_code(rs.getString("PROVINCE_CODE"));
            province.setProvince_name(rs.getString("PROVINCE_NAME"));
            
            
            listData.add(province);
        }
        
        stmt.close();
        super.disconnect();
        
        return listData;
    }
}