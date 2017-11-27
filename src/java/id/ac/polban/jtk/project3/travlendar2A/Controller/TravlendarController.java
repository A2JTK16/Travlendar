/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "index", urlPatterns = {"/index"})
public class TravlendarController extends HttpServlet
{
    /**
     * Atribut
     */
    IDao<Event> eventDao;
    IDao<Traveller> travellerDao;
    /**
     * Method yang akan dipanggil ketika servlet dihidupkan
     */
    @Override
    public void init()
    {
        /**
         * Mendapatkan username, url, password secara dinamis
         
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");       
        */
        String jdbcURL = "jdbc:mysql://localhost:3306/a2travlendar";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        
        /**
         * Instansiasi
         */
        
        this.eventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Event.class);
        this.travellerDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Traveller.class);
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
                String event_id = request.getParameter("event_id");
                
                Event event = this.eventDao.getObj("event_id", event_id);
                
                jsonArrObj.put(event);
                this.responseJson(response, jsonArrObj.toString());
                break;
                
            /**
             * cara akses json 
             * kunjungi http://localhost:8080/index?action=getlistEvent
             * dengan ajax
             */
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
                List<Traveller> listTraveller = this.travellerDao.getList();
                jsonArrObj.put(listTraveller);
                this.responseJson(response, jsonArrObj.toString());
                break;
                
            case "findUser":
                // TULIS CODE DISINI !!!
                String fullname = request.getParameter("fullname");
                
                Traveller traveller = this.travellerDao.getObj("fullname", fullname);
                
                //mengirimkan respon ke browser format json
                jsonArrObj.put(traveller);
                this.responseJson(response, jsonArrObj.toString());
                break;
                
           /** default:
                // TULIS CODE DISINI !!!
                break;  */
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
        boolean isSuccess;
        
        switch(param)
        {
            case "addEvent":
                Event objEvent = new Event();
        
                objEvent.setEvent_id(new Long(request.getParameter("event_id"))); // harusnya auto increment  
                objEvent.setLocation_id(new Integer(request.getParameter("location_id")));
                objEvent.setTraveller_id(new Long(1));
                objEvent.setEvent_name(request.getParameter("name"));
        
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
                try 
                {
                    objEvent.setStart_event(new Timestamp( dateFormat.parse(request.getParameter("start")).getTime() ));
                    objEvent.setEnd_event(new Timestamp( dateFormat.parse(request.getParameter("end")).getTime() ));
                    
                    isSuccess = this.eventDao.create(objEvent);
                } 
                catch (ParseException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                    isSuccess = false;
                }
                
                if(isSuccess)
                    this.responseStr(response, "Sukses Menambahkan Event Baru");
                else
                    this.responseStr(response, "Gagal Menambahkan Event");  
        
                break;
                
            case "editEvent":
                objEvent = new Event();
        
                objEvent.setEvent_id(new Long(request.getParameter("event_id"))); // harusnya auto increment  
                objEvent.setLocation_id(new Integer(request.getParameter("location_id")));
                objEvent.setTraveller_id(new Long(1));
                objEvent.setEvent_name(request.getParameter("name"));
        
                dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    
                try 
                {
                    objEvent.setStart_event(new Timestamp( dateFormat.parse(request.getParameter("start")).getTime() ));
                    objEvent.setEnd_event(new Timestamp( dateFormat.parse(request.getParameter("end")).getTime() ));
                    
                    isSuccess = this.eventDao.edit(objEvent, "event_id", request.getParameter("event_id"));
                } 
                catch (ParseException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                    isSuccess = false;
                }
                
                if(isSuccess)
                    this.responseStr(response, "Sukses Mengedit Event");
                else
                    this.responseStr(response, "Gagal Mengedit Event");  
        
                break;
                    
            case "deleteEvent":
                
                String id = request.getParameter("event_id");
                
                isSuccess = this.eventDao.delete("event_id", id);
                
                if(isSuccess)
                    this.responseStr(response, "Sukses Menghapus Event");
                else
                    this.responseStr(response, "Gagal Menghapus Event");  
                
                break;
                
            case "registerUser":
                Traveller traveller = new Traveller();
                
                
                break;
                
            case "deleteUser":
                // TULIS CODE DISINI !!!
                break;
                
            case "editUser":
                // TULIS CODE DISINI !!!
                break;
                
            case "addAdmin":
                // TULIS CODE DISINI !!!
                break;
                
            case "editAdmin":
                // TULIS CODE DISINI !!!
                break;
                
            case "deleteAdmin":
                // TULIS CODE DISINI !!!
                break;
            /**default:
                this.responseStr(response, "Maaf! Permintaan Anda Tidak Dapat Dilakukan...");
                break;*/
        }
    }
    
    /**
     * Menampilkan string teks/html ketika controller beres dipanggil
     * 
     * @param response
     * @param strMessage 
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
     * @param response
     * @param strJson 
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
