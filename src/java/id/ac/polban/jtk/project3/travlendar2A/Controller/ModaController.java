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
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendar";
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
        String aksiPage;
        
        aksiPage = request.getParameter("aksi");
        
        if(aksiPage != null)
        {
            aksiPage = "show";
        }
        
        if (aksiPage.equals("show")) 
        {
            List<ModaTransportasi> listModa;
            try
            {
                listModa = this.modaDao.getDataFromDB();
            }     
            catch (SQLException ex)
            {
                listModa = null;
            }
                
            request.setAttribute("modaTransList", listModa);
                
                
            request.setAttribute("content", "modatransportasi");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if(aksiPage.equals("add"))
        {
            request.setAttribute("content", "addmodatransportasi");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String aksiPage;
        ModaTransportasi objModa;
        int tempInt;
        float tempFloat;
        String tempString;
        aksiPage = request.getParameter("input");
        
        if(aksiPage != null)
        {
            if (aksiPage.equals("baru")) 
            {
                objModa = new ModaTransportasi();
                
                tempString = request.getParameter("kode_trans");
                objModa.setKodeTransportasi(tempString);
                
                tempString = request.getParameter("nama_trans");
                objModa.setNamaTransportasi(tempString);
                
                
                tempFloat = Float.parseFloat(request.getParameter("kecepatan"));
                objModa.setKecepatan(tempFloat);
                
                try
                {
                    this.modaDao.saveDataToDB(objModa);
                    request.setAttribute("message", "Anda sukses menyimpan data ke DB");
                }
                catch (SQLException ex)
                {
                    request.setAttribute("message", "Anda gagal menyimpan data ke DB");
                }
                
                request.setAttribute("content", "addmodatransportasi");
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    
}