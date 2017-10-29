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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    /**
     * 
     */
    @Override
    public void init()
    {
        // String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
        // String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
        // String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendar";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        int limit = 10;
        
        travDao = new TravellerDaoImp(jdbcURL, jdbcUsername, jdbcPassword, limit);
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
                    request.setAttribute("content", "traveller");
                    break;
                case "add":
                    // set content atribute
                    request.setAttribute("content", "addtraveller");    
                    break;
                case "edit":
                    // set httprequest atribut dengan obj modatransportasi dari database
                    this.setAttrObj(request);
                    // edit content attribute
                    request.setAttribute("content", "edittraveller");
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
    
    /**
     * Method untuk menambahkan List dari Database
     * ke Atribut request
     * 
     * @param request 
     */
    private void setAttrList(HttpServletRequest request)
    {
        // Deklarasi
        List<Traveller> listTraveller;
        int page = 1;
        String pagestr = request.getParameter("page");
        
        // Jika parameter page di set
        if(pagestr != null)
        {
            page = Integer.parseInt(pagestr);
        }
                
        try
        {
            listTraveller = this.travDao.getListFromDB(page);
        }     
        catch (SQLException ex)
        {
            // ex.printStackTrace();
            listTraveller = null;
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("travellerList", listTraveller);
    }
    
    /**
     * Method untuk menambahkan objek modatransportasi
     * ke httprequest
     * 
     * @param request 
     */
    private void setAttrObj(HttpServletRequest request)
    {
        // Deklarasi
        String travCode = request.getParameter("code");
        int intTravCode = Integer.parseInt(travCode);
        Traveller objTraveller = null;
        
        try 
        {
            objTraveller = this.travDao.getDataFromDB(intTravCode);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ModaController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "gagal mendapatkan data");
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("travellerObj", objTraveller);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        /**
         *  REVIEW :
         *  1.  Gunakan contoh doPost diatas untuk Input Edit, Input Baru dan Delete
         *      boleh menggunakan nested if atau swith-case tetapi harus konsisten
         *  2.  Alokasikan waktu untuk belajar.
         */
        String aksiPage;
        Traveller objTraveller;
        int tempInt;
        String tempString;
        aksiPage = request.getParameter("input");
        
        if(aksiPage != null)
        {
            if (aksiPage.equals("baru")) 
            {
                objTraveller = new Traveller();
                
                tempString = request.getParameter("id_trav");
                tempInt = Integer.parseInt(tempString);
                objTraveller.setTraveller_id(tempInt);
                
                tempString = request.getParameter("nama_trav");
                objTraveller.setTraveller_name(tempString);
              
                tempString = request.getParameter("email_trav");
                objTraveller.setTraveller_email(tempString);
              
                tempString = request.getParameter("password_trav");
                objTraveller.setTraveller_password(tempString);
              
                tempString = request.getParameter("fullname_trav");
                objTraveller.setTraveller_fullName(tempString);
              
                
                try
                {
                    this.travDao.saveDataToDB(objTraveller);
                    request.setAttribute("message", "Anda sukses menyimpan data ke DB");
                }
                catch (SQLException ex)
                {
                    request.setAttribute("message", "Anda gagal menyimpan data ke DB");
                }
                
              
                response.sendRedirect("traveller?action=show");
                //request.getRequestDispatcher("?action=show").forward(request, response);
            }
        }
    }    
}    