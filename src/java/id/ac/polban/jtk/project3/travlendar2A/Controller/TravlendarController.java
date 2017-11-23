/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author mufidjamaluddin
 */
@WebServlet(name = "index", urlPatterns = {"index"})
public class TravlendarController extends HttpServlet
{
    /**
     * Atribut
     */
    IDao<Event> eventDao;
    
    /**
     * Method yang akan dipanggil ketika servlet dihidupkan
     */
    @Override
    public void init()
    {
        /**
         * Mendapatkan username, url, password secara dinamis
         */
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        /**
         * Instansiasi
         */
        
        this.eventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Event.class);
        
    }
    
    /**
     * 
     * Ketika Controller bisa dipanggil langsung lewat URL
     * 
     * @param request
     * @param response 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        /**
         * JSON Array
         */
        JSONArray jsonArrObj = new JSONArray();
        /**
         * http:// .... /index?action=...
         */
        String param = request.getParameter("action");
        
        switch(param)
        {
            case "findEvent" :
                // TULIS CODE DISINI !!!
                break;
                
            case "getlistEvent" : // CONTOH
                /**
                 * Mendapatkan list event
                 */
                List<Event> list = this.eventDao.getList();
                /**
                 * Menyimpan list dan mengubahnya ke bentuk json
                 */
                jsonArrObj.put(list);
                
                /**
                 * Mengirimkan json ke browser client
                 */
                this.responseJson(response, jsonArrObj.toString());
 
                break;
                
            case "getlistUser" :
                // TULIS CODE DISINI !!!
                break;
                
            case "findUser":
                // TULIS CODE DISINI !!!
                break;
                
            default:
                // TULIS CODE DISINI !!!
                break;  
        }
    }
    
    /**
     * 
     * Lebih baik digunakan untuk insert data
     * 
     * @param request
     * @param response 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        String param = request.getParameter("action");
        
        switch(param)
        {
            case "addEvent":
                // TULIS CODE DISINI !!!
                break;
                
            case "editEvent":
                // TULIS CODE DISINI !!!
                break;
                    
            case "deleteEvent":
                // TULIS CODE DISINI !!!
                break;
                
            case "registerUser":
                // TULIS CODE DISINI !!!
                break;
                
            case "deleteUser":
                // TULIS CODE DISINI !!!
                break;
                
            case "addUser":
                // TULIS CODE DISINI !!!
                break;
                
            case "addAdmin":
                // TULIS CODE DISINI !!!
                break;
        }
        // TULIS CODE DISINI !!!
    }
    
    /**
     * Menampilkan string teks/html ketika controller beres dipanggil
     */
    private void responseStr(HttpServletResponse response, String strMessage)
    {
        try 
        {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(strMessage);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Menampilkan json ketika controller beres dipanggil
     */
    private void responseJson(HttpServletResponse response, String strJson)
    {
        try 
        {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(strJson);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
}
