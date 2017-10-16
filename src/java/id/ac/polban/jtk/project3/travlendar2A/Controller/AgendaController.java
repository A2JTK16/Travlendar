/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DataAccessObject.AgendaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "index", urlPatterns = {"/index"}) /* URL Controllernya */
public class AgendaController extends HttpServlet 
{
    /**
     * Atribut wajib
     */
    private AgendaDAO agendaDAO;

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
        agendaDAO = new AgendaDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
