/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Models.Admin;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.EventDesc;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import id.ac.polban.jtk.project3.travlendar2A.Models.ViewEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mufidjamaluddin
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class TravlendarController extends HttpServlet
{
    /**
     * Data Access Object
     */
    IDao<Event> eventDao;
    IDao<Traveller> travellerDao;
    IDao<Admin> adminDao;
    IDao<Location> locationDao;
    IDao<ViewEvent> vEventDao;
    /**
     * JSON Object Mapper
     */
    ObjectMapper jsonMapper;
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
        this.adminDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Admin.class);
        this.locationDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Location.class);
        this.vEventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, ViewEvent.class);
        this.jsonMapper = new ObjectMapper();
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
         * Parameter dari client (uri)
         * http:// .... /index?action=...
         */
        String param = request.getParameter("action");
        String jsonString;
        
        switch(param)
        {
            case "findEvent" :
                // TULIS CODE DISINI !!!
                String event_id = request.getParameter("event_id");
                
                Event event = this.eventDao.getObj("event_id", event_id);
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(event);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                
            /**
             * cara akses json 
             * kunjungi http://localhost:8080/index?action=getlistEvent
             * dengan ajax
             */
            case "getlistEvent" :
                /**
                 * Mendapatkan list event
                 */
                List<ViewEvent> list = this.vEventDao.getList();
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(list);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                
            case "getlistLocation" :
                /**
                 * Mendapatkan list event
                 */
                List<Location> listLocation = this.locationDao.getList();
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(listLocation);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                
            case "getlistUser" :
                // TULIS CODE DISINI !!!
                List<Traveller> listTraveller = this.travellerDao.getList();
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(listTraveller);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                
            case "findUser":
                // TULIS CODE DISINI !!!
                String fullname = request.getParameter("fullname");
                
                Traveller traveller = this.travellerDao.getObj("traveller_fullname", fullname);
                
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(traveller);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
            
            case "getlistAdmin" :
                // TULIS CODE DISINI !!!
                List<Admin> listAdmin = this.adminDao.getList();
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(listAdmin);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
        } //end switch
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
        /**
         * Parameter yang diterima dari client berupa json
         */
        String param = request.getParameter("action");
        String json = request.getParameter("json");
        int idPK = 0;
        int affectedRow = 0;
        
        switch(param)
        {
            case "addEvent":
                
                try 
                {
                    EventDesc eventdesc = jsonMapper.readValue(json, EventDesc.class);
                    Event objEvent = eventdesc.getEvent();
                    Location objLoc = eventdesc.getLocation();
                    
                    int locId = this.locationDao.create(objLoc);
                    
                    objEvent.setLocation_id(locId);
                    
                    idPK = this.eventDao.create(objEvent);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(idPK > 0)
                    this.responseStr(response, "Sukses Menambahkan Event Baru");
                else
                    this.responseStr(response, "Gagal Menambahkan Event");  
        
                break;
                
            case "editEvent":
                try 
                {
                    EventDesc eventdesc = jsonMapper.readValue(json, EventDesc.class);
                    Event objEvent = eventdesc.getEvent();
                    Location objLoc = eventdesc.getLocation();
                    
                    this.locationDao.edit(objLoc, "location_id", objEvent.getLocation_id().toString());
                    
                    affectedRow = this.eventDao.edit(objEvent, "event_id", objEvent.getEvent_id().toString());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(affectedRow > 0)
                    this.responseStr(response, "Sukses Mengedit Event");
                else
                    this.responseStr(response, "Gagal Mengedit Event");  
        
                break;
                    
            case "deleteEvent":
                
                String id = request.getParameter("event_id");
                
                affectedRow = this.eventDao.delete("event_id", id);
                
                if(affectedRow > 0){
                    this.responseStr(response, "Sukses Menghapus Event");
                }   
                else{
                    this.responseStr(response, "Gagal Menghapus Event");
                }
                      
                
                break;
                
            case "registerUser":
                try 
                {
                    Traveller traveller = jsonMapper.readValue(json, Traveller.class);
                    
                    idPK = this.travellerDao.create(traveller);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(idPK > 0)
                    this.responseStr(response, "Sukses Registrasi User");
                else
                    this.responseStr(response, "Gagal Registrasi User");
                
                break;
                
            case "deleteUser":
                // TULIS CODE DISINI !!!
                String traveller_id = request.getParameter("traveller_id");
                
                int affectedRowEvent = this.eventDao.delete("traveller_id", traveller_id);
                affectedRow = this.travellerDao.delete("traveller_id", traveller_id);
                
                if(affectedRow > 0)
                    this.responseStr(response, "Sukses Menghapus User");
                else
                {
                    if(affectedRowEvent < 0)
                        this.responseStr(response, "Gagal Menghapus User\nData Anda Aman");  
                    else
                        this.responseStr(response, "Data Event Anda Sukses Dihapus Semua\nGagal Menghapus User");
                }
                
                break;
                
            case "editUser":
                try 
                {
                    Traveller traveller = jsonMapper.readValue(json, Traveller.class);
                    
                    idPK = this.travellerDao.edit(traveller, "traveller_id", traveller.getTraveller_id().toString());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(idPK > 0)
                    this.responseStr(response, "Sukses Edit Data");
                else
                    this.responseStr(response, "Gagal Edit Data");
                
                break;
                
            case "addAdmin":
                try 
                {
                    Admin admin = jsonMapper.readValue(json, Admin.class);
                    
                    affectedRow = this.adminDao.create(admin);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(affectedRow > 0)
                    this.responseStr(response, "Sukses Menambahkan Admin");
                else
                    this.responseStr(response, "Gagal Menambahkan Admin\nGunakan Username Lain!!!");
                
                break;
                
            case "editAdmin":
                try 
                {
                    Admin admin = jsonMapper.readValue(json, Admin.class);
                    
                    affectedRow = this.adminDao.edit(admin, "username", admin.getUsername());
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(affectedRow > 0)
                    this.responseStr(response, "Sukses Edit Data");
                else
                    this.responseStr(response, "Gagal Edit Data");
                
                break;
                
            case "deleteAdmin":
                // TULIS CODE DISINI !!!
                String username = request.getParameter("username");
                
                idPK = this.adminDao.delete("username", username);
                
                if(idPK > 0)
                    this.responseStr(response, "Sukses Menghapus Admin");
                else
                    this.responseStr(response, "Gagal Menghapus Admin");  
                
            
                break;
            
            default:
                this.responseStr(response, "Tidak Ditemukan !!!");
                break;
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
