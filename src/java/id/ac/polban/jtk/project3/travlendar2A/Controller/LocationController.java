/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.CityDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.ProvinceDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.PagingListIntHelper;
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
    
    private CityDaoImp cityDao;
    private ProvinceDaoImp provinceDao;
    private PagingListIntHelper pagingHelp;
    
    public LocationController(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/travlendardb";
        String jdbcUser = "root";
        String jdbcPass = "";
        
        cityDao = new CityDaoImp(jdbcUrl, jdbcUser, jdbcPass);
        provinceDao = new ProvinceDaoImp(jdbcUrl, jdbcUser, jdbcPass);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> listCity;
        List<Province> listProvince;
        try {
            listCity = this.cityDao.getListFromDB(1);
            listProvince = this.provinceDao.getListFromDB(1);
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
