/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.Models.DAO.ModaTransportasiDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.ModaTransportasi;
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
 *  REVIEW :
 *  1.  Sdh bagus, belajar lagi dari contoh
 *      dan implementasikan di controller / dao
 *      yang lainnya
 *  2.  Setelah UTS nanti, alokasikan waktu yg cukup
 *      untuk menyelesaikan proyek ini
 */

/**
 *
 * @author Reza Dwi Kurniawan
 */
@WebServlet(name = "moda", urlPatterns = {"/moda"})
public class ModaController extends HttpServlet 
{
    private ModaTransportasiDAO modaDao;
    
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
        
        modaDao = new ModaTransportasiDAO(jdbcURL, jdbcUsername, jdbcPassword, limit);
    }
     
    /**
     * 
     * Method GET URL 
     * Materi : https://www.w3schools.com/tags/ref_httpmethods.asp
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
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
                    request.setAttribute("content", "modatransportasi");
                    break;
                case "add":
                    // set content atribute
                    request.setAttribute("content", "addmodatransportasi");    
                    break;
                case "edit":
                    // set httprequest atribut dengan obj modatransportasi dari database
                    this.setAttrObj(request);
                    // edit content attribute
                    request.setAttribute("content", "editmodatransportasi");
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
     * 
     * Method POST
     * materi : https://www.w3schools.com/tags/ref_httpmethods.asp
     * 
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
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
    
    /**
     * Method untuk menambahkan List dari Database
     * ke Atribut request
     * 
     * @param request 
     */
    private void setAttrList(HttpServletRequest request)
    {
        // Deklarasi
        List<ModaTransportasi> listModa;
        int page = 1;
        String pagestr = request.getParameter("page");
        
        // Jika parameter page di set
        if(pagestr != null)
        {
            page = Integer.parseInt(pagestr);
        }
                
        try
        {
            listModa = this.modaDao.getListFromDB(page);
        }     
        catch (SQLException ex)
        {
            // ex.printStackTrace();
            listModa = null;
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("modaTransList", listModa);
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
        String modaCode = request.getParameter("code");
        ModaTransportasi objModa = null;
        
        try 
        {
            objModa = this.modaDao.getDataFromDB(modaCode);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ModaController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "gagal mendapatkan data");
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("modaTransObj", objModa);
    }
}