/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.CityDAO;
import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.ProvinceDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.City;
import id.ac.polban.jtk.project3.travlendar2A.Models.Province;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reza Dwi Kurniawan
 */
@WebServlet(name = "location", urlPatterns = {"/location"})
public class LocationController extends HttpServlet {
    
    CityDAO cityDao;
    ProvinceDAO provinceDao;
    
    public LocationController(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/travlendardb?zeroDateTimeBehavior=convertToNull";
        String jdbcUser = "root";
        String jdbcPass = "";
        
        cityDao = new CityDAO(jdbcUrl, jdbcUser, jdbcPass);
        provinceDao = new ProvinceDAO(jdbcUrl, jdbcUser, jdbcPass);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> listCity;
        List<Province> listProvince;
        try {
            listCity = this.cityDao.getDataFromDB();
            listProvince = this.provinceDao.getDataFromDB();
        } catch (SQLException ex) {
            listCity = null;
            listProvince = null;
        }
        
        request.setAttribute("cityList", listCity);
        request.setAttribute("provinceList", listProvince);
        request.setAttribute("content", "location");        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}