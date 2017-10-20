/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.TravellerDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
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
@WebServlet(name = "traveller", urlPatterns = {"/traveller"})
public class TravellerController extends HttpServlet {
    TravellerDAO travDao;
    
    public TravellerController(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/travlendardb?zeroDateTimeBehavior=convertToNull";
        String jdbcUser = "root";
        String jdbcPass = "";
        
        travDao = new TravellerDAO(jdbcUrl, jdbcUser, jdbcPass);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Traveller> listTraveller;
        try {
            listTraveller = this.travDao.getDataFromDB();
        } catch (SQLException ex) {
            listTraveller = null;
        }
        
        request.setAttribute("travellerList", listTraveller);
        request.setAttribute("content", "traveller");
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}