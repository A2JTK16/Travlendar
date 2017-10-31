/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.CityDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.EventDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.LocationDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.DaoConcreteClass.TravelDaoImp;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.DateTHelper;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.PagingListIntHelper;
import id.ac.polban.jtk.project3.travlendar2A.Models.City;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
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

@WebServlet(name = "event", urlPatterns = {"/Admin-Panel/event"}) /* URL Controllernya */
public class EventController extends HttpServlet 
{
    /**
     * Atribut wajib
     */
    private EventDaoImp eventDAO;
    private TravelDaoImp travelDao;
    private CityDaoImp cityDao;
    private LocationDaoImp locationDao;
    private PagingListIntHelper pagingHelp;
    /**
     * Override instansiasi
     */
    @Override
    public void init() 
    {
       // String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
       // String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
       // String jdbcPassword = getServletContext().getInitParameter("jdbcPassword"); 
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendardb?zeroDateTimeBehavior=convertToNull";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        /**
         * Buat Hubungan dengan Database
         */
        eventDAO = new EventDaoImp(jdbcURL, jdbcUsername, jdbcPassword);
        cityDao = new CityDaoImp(jdbcURL, jdbcUsername, jdbcPassword);
        locationDao = new LocationDaoImp(jdbcURL, jdbcUsername, jdbcPassword);
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
                    this.setAttrLoc(request);
                    // set content include
                    request.setAttribute("content", "event");
                    //request.getRequestDispatcher("index.jsp").forward(request, response);
                    request.getRequestDispatcher("Event/list_event.jsp").forward(request, response);
                    break;
                case "add":
                    
                    this.setAttrLoc(request);
                    // set content atribute
                    request.setAttribute("content", "addevent");    
                    //request.getRequestDispatcher("TransportationMode/index.jsp").forward(request, response);
                    break;
                case "edit":
                    // set httprequest atribut dengan obj modatransportasi dari database
                    this.setAttrObj(request);
                    // edit content attribute
                    request.setAttribute("content", "editevent");
                    break;
                default:
                    // set message
                    request.setAttribute("message", "Laman yang Anda Cari Tidak Ditemukan");
                    break;
            }
            // forward ke index.jsp dengan dapat menggunakan reesource yg ada
            request.getRequestDispatcher("Event/list_event.jsp").forward(request, response);
        }
        else
        {
            // set message
            request.setAttribute("message", "Laman yang Anda Cari Tidak Ditemukan");
            // forward ke index.jsp dengan dapat menggunakan reesource yg ada
            request.getRequestDispatcher("pusat.jsp").forward(request, response); 
        }        
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
        String aksiPage;
        Event objEvent;
        boolean isSuccess;
        int tempInt;
        float tempFloat;
        String tempString;
        aksiPage = req.getParameter("input");
        
        if(aksiPage != null)
        {
            if (aksiPage.equals("baru")) 
            {
                objEvent = new Event();
                
                /*tempInt = Integer.parseInt(req.getParameter("event_id"));
                objEvent.setEvent_id(tempInt);*/
                tempInt = Integer.parseInt(req.getParameter("location_id"));
                objEvent.setLocation_id(tempInt);
                
                tempInt = Integer.parseInt(req.getParameter("event_id"));
                objEvent.setEvent_id(tempInt);
                
                //tempInt = Integer.parseInt(req.getParameter("traveller_id"));
                objEvent.setTraveller_id(1);
                
                tempString = req.getParameter("event_name");
                if(tempString == null) System.out.println("Gagal ambil data dari request event name");
                objEvent.setEvent_name(tempString);
                
                objEvent.setStart_event(DateTHelper.parseDate("dd-MM-yyyy HH:mm",req.getParameter("start_event")));
                
                objEvent.setEnd_event(DateTHelper.parseDate("dd-MM-yyyy HH:mm",req.getParameter("end_event")));
                
                tempString = req.getParameter("note");
                
                if(tempString == null) System.out.println("Gagal ambil data dari request event name");
                objEvent.setNote(tempString);
                
                tempString = req.getParameter("place");
                objEvent.setPlace(tempString);
                
                
                try 
                {
                    this.eventDAO.saveDataToDB(objEvent);
                    req.setAttribute("message", "Anda sukses menyimpan data ke DB");
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                    req.setAttribute("message", "Anda gagal menyimpan data ke DB");
                }
                
                //req.setAttribute("content", "addevent");
                //resp.sendRedirect("pusat");
                resp.sendRedirect("event?action=show");
            }
            else if (aksiPage.equals("terbaru")) 
            {
                objEvent = new Event();
                
                tempInt = Integer.parseInt(req.getParameter("location_id"));
                objEvent.setLocation_id(tempInt);
                
                tempInt = Integer.parseInt(req.getParameter("event_id"));
                objEvent.setEvent_id(tempInt);
                
                tempInt = Integer.parseInt(req.getParameter("traveller_id"));
                objEvent.setTraveller_id(tempInt);
                
                tempString = req.getParameter("event_name");
                if(tempString == null) System.out.println("Gagal ambil data dari request event name");
                objEvent.setEvent_name(tempString);
                
                objEvent.setStart_event(DateTHelper.parseDate("dd-MM-yyyy HH:mm",req.getParameter("start_event")));
                
                objEvent.setEnd_event(DateTHelper.parseDate("dd-MM-yyyy HH:mm",req.getParameter("end_event")));
                
                tempString = req.getParameter("note");
                
                if(tempString == null) System.out.println("Gagal ambil data dari request event name");
                objEvent.setNote(tempString);
                
                tempString = req.getParameter("place");
                objEvent.setPlace(tempString);
                
                /*tempString = request.getParameter("TRANSPORTATION_CODE");
                objModa.setKodeTransportasi(tempString);
                
                tempString = request.getParameter("TRANSPORTATION_NAME");
                objModa.setNamaTransportasi(tempString);
              
                tempFloat = Float.parseFloat(request.getParameter("TRANSPORTATION_SPEED"));
                objModa.setKecepatan(tempFloat);*/
                
                try
                {
                    this.eventDAO.updateDataToDB(objEvent);
                    req.setAttribute("message", "Anda sukses menyimpan data ke DB");
                }
                catch (SQLException ex)
                {
                    req.setAttribute("message", "Anda gagal menyimpan data ke DB");
                }
                
              
                
                req.getRequestDispatcher("pusat.jsp").forward(req, resp);
            }
        }
    }
    
    private void setAttrLoc(HttpServletRequest request) 
    {
        List<Location> listLoc;
        
        try {
            listLoc = this.locationDao.getListFromDB(1);
        } catch (SQLException ex) {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            listLoc = null;
        }
                // dikirimkan ke httprequest atribut
        request.setAttribute("locationList", listLoc);
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
        List<Event> listEvent;
        int page = 1;
        String pagestr = request.getParameter("page");
        
        // Jika parameter page di set
        if(pagestr != null)
        {
            page = Integer.parseInt(pagestr);
        }
                
        try
        {
            listEvent = this.eventDAO.getListFromDB(page);
        }     
        catch (SQLException ex)
        {
            // ex.printStackTrace();
            listEvent = null;
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("eventList", listEvent);
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
        String eventCode = request.getParameter("code");
        int inteventCode = Integer.parseInt(eventCode);
        
        Event objEvent = null;
        try 
        {
            objEvent = this.eventDAO.getDataFromDB(inteventCode);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "gagal mendapatkan data");
        }
        // dikirimkan ke httprequest atribut
        request.setAttribute("eventObj", objEvent);
    }
}
