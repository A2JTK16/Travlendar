/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Account;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.UserAccount;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    IDao<Account> adminDao;
    IDao<UserAccount> userDao;
    
    /**
     * Method yang akan dipanggil ketika servlet dihidupkan
     */
    @Override
    public void init()
    {
        /**
         * Mendapatkan username, url, password dinamis
         */
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        /**
         * Instansiasi
         */
        this.adminDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword);
        this.eventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword);
        this.userDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword);
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
         * http:// .... /index?action=...
         */
        String param = request.getParameter("action");
        
        switch(param)
        {
            case "addevent" :
                // TULIS CODE DISINI !!!
                break;
            case "getlistevent" :
                // TULIS CODE DISINI !!!
                break;
            case "searchevent" :
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
        // TULIS CODE DISINI !!!
    }
    
    /**
     * Menampilkan string teks/html ketika controller beres dipanggil
     */
    private void showStr(HttpServletResponse response, String strMessage) throws IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(strMessage);
    }
    
    /**
     * Menampilkan json ketika controller beres dipanggil
     */
    private void showJson(HttpServletResponse response, String strJson) throws IOException
    {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(strJson);
    }
           
}
