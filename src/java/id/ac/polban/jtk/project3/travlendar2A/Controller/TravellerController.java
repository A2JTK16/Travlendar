/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.TravellerDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.PagingListIntHelper;
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
    private TravellerDaoImp travDao;
    private PagingListIntHelper pagingHelp;
    
    public TravellerController(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/travlendardb?zeroDateTimeBehavior=convertToNull";
        String jdbcUser = "root";
        String jdbcPass = "";
        
        travDao = new TravellerDaoImp(jdbcUrl, jdbcUser, jdbcPass);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Traveller> listTraveller;
        try {
            listTraveller = this.travDao.getListFromDB();
        } catch (SQLException ex) {
            listTraveller = null;
        }
        
        request.setAttribute("travellerList", listTraveller);
        request.setAttribute("content", "traveller");
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
