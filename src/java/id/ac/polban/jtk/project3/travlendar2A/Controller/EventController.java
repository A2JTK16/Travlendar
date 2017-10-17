/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.EventDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "event", urlPatterns = {"/event"}) /* URL Controllernya */
public class EventController extends HttpServlet 
{
    /**
     * Atribut wajib
     */
    private EventDAO eventDAO;

    /**
     * Override instansiasi
     */
    @Override
    public void init() 
    {
       // String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
       // String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
       // String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendar?zeroDateTimeBehavior=convertToNull";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        /**
         * Buat Hubungan dengan Database
         */
        eventDAO = new EventDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    /**
     * Method GET dan POST URL (doGet & doPost)
     * Mohon diisi
     * @param req
     */
    
    /**
     * Method GET URL 
     * Materi : https://www.w3schools.com/tags/ref_httpmethods.asp
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
       /**
        * Ambil data dari DAO
        * Masukkan ke request atribut
        * 
        * kirimkan ke JSP nya pakai requestdispatcher forward
        */
        List<Event> listEvent;
        try{
            listEvent = this.eventDAO.listAllAgenda(0, 0);
        }catch (SQLException e){
            listEvent = null;
        }
        
        req.setAttribute("eventList", listEvent);
        
        req.setAttribute("content", "event");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * Method POST
     * materi : https://www.w3schools.com/tags/ref_httpmethods.asp
     * 
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
       /**
        * Ambil data dari form JSP
        * Masukkan ke objek dan masukkan ke Database via DAO
        * Setelah itu, pindah ke JSP nya pakai requestdispatcher forward / response forward
        */
    }
}
