/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.CityDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.DistanceDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.ProvinceDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.TransportationMdDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.PagingListIntHelper;
import id.ac.polban.jtk.project3.travlendar2A.Models.City;
import id.ac.polban.jtk.project3.travlendar2A.Models.Distance;
import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
import id.ac.polban.jtk.project3.travlendar2A.Models.Province;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author faiza
 */
@WebServlet(name = "distance", urlPatterns = {"/distance"})
public class DistanceController extends HttpServlet {
    
    private DistanceDaoImp distanceDao;
    private PagingListIntHelper pagingHelp;
    
    public DistanceController(){
        String jdbcUrl = "jdbc:mysql://localhost:3306/travlendar2a?zeroDateTimeBehavior=convertToNull";
        String jdbcUser = "root";
        String jdbcPass = "";
        
        distanceDao = new DistanceDaoImp(jdbcUrl, jdbcUser, jdbcPass);
        
    }
        
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // Deklarasi
        String action;
        
        // Mendapatkan data dari parameter
        /* Misalnya http://locallhost:8080/travlendar/moda?action=(parameter action)&page=(parameter page) */
        action = request.getParameter("action");
        
        // Dilaksanakan ketika tidak null
        if(action != null)
        {
            /* Jika isi parameter action itu show, maka tampilkan list moda kendaraan */
            switch(action)
            {
                case "show":
                    // set httprequest atribut dengan list dari database
                    this.setAttrList(request);
                    // set content include
                    request.setAttribute("content", "distance");
                    break;
                default:
                    // set message
                    request.setAttribute("message", "Laman yang Anda Cari Tidak Ditemukan");
                    break;
            }
            // forward ke index.jsp dengan dapat menggunakan reesource yg ada
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else
        {
            // set message
            request.setAttribute("message", "Laman yang Anda Cari Tidak Ditemukan");
            // forward ke index.jsp dengan dapat menggunakan reesource yg ada
            request.getRequestDispatcher("index.jsp").forward(request, response); 
        }        
    }
    
    
    private void setAttrList(HttpServletRequest request)
    {
        // Deklarasi
        List<Distance> listDistance;
        int page = 1;
        String pagestr = request.getParameter("page");
        
        // Jika parameter page di set
        if(pagestr != null)
        {
            page = Integer.parseInt(pagestr);
        }
                
        try
        {
            listDistance = this.distanceDao.getListFromDB(page);
        }     
        catch (SQLException ex)
        {
            // ex.printStackTrace();
            listDistance = null;
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("distanceList", listDistance);
    }
    
}