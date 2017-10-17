/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.ModaTransportasiDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
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
@WebServlet(name = "moda", urlPatterns = {"/moda"})
public class ModaController extends HttpServlet 
{
    
    ModaTransportasiDAO modaDao;
    
    public ModaController()
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendar2a?zeroDateTimeBehavior=convertToNull";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        
        modaDao = new ModaTransportasiDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
     
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        List<ModaTransportasi> listModa;
        try {
            listModa = this.modaDao.getDataFromDB();
        } catch (SQLException ex) {
            listModa = null;
        }
        
        request.setAttribute("modaTransList", listModa);


        request.setAttribute("content", "modatransportasi");
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
}
