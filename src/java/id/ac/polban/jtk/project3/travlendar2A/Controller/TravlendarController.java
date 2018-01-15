/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import id.ac.polban.jtk.project3.travlendar2A.Dao.GenericDao;
import id.ac.polban.jtk.project3.travlendar2A.Dao.IDao;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.DateTHelper;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.HashSHA1;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.HtmlHelper;
import id.ac.polban.jtk.project3.travlendar2A.Helpers.PdfHelper;
import id.ac.polban.jtk.project3.travlendar2A.Models.Content;
import id.ac.polban.jtk.project3.travlendar2A.Models.Event;
import id.ac.polban.jtk.project3.travlendar2A.Models.EventDesc;
import id.ac.polban.jtk.project3.travlendar2A.Models.Traveller;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import id.ac.polban.jtk.project3.travlendar2A.Models.Message;
import id.ac.polban.jtk.project3.travlendar2A.Models.Travel;
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
    IDao<Travel> travelDao;
    IDao<Location> locationDao;
    IDao<ViewEvent> vEventDao;
    /**
     * JSON Object Mapper
     */
    ObjectMapper jsonMapper;
    /**
     * Hash 
     */
    HashSHA1 hashpw;
    /**
     * Helper
     */
    DateTHelper dateTHelper;
    HtmlHelper htmlHelper;
    
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
        *
        * versi deployment
        *
        String jdbcURL = "jdbc:mysql://localhost:3306/a2db";
        String jdbcUsername = "a2";
        String jdbcPassword = "a2";
        */
        String jdbcURL = "jdbc:mysql://localhost:3306/travlendardb";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        
       /**
         * Instansiasi
         */
        
        this.eventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Event.class);
        this.travellerDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Traveller.class);
        this.travelDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Travel.class);
        this.locationDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Location.class);
        this.vEventDao = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, ViewEvent.class);
        this.jsonMapper = new ObjectMapper();
        this.dateTHelper = new DateTHelper();
        this.hashpw = new HashSHA1();
        this.htmlHelper = new HtmlHelper(dateTHelper);
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
            /*
            case "findEvent" :
                // TULIS CODE DISINI !!!
                String event_id = request.getParameter("event_id");
                
                Event event = this.eventDao.getObj("event_id", event_id);
                **
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 *
                try
                {
                    jsonString = this.jsonMapper.writeValueAsString(event);            
                    this.responseJson(response, jsonString);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                */
            /**
             * cara akses json 
             * kunjungi http://localhost:8080/index?action=getlistEvent
             * dengan ajax
             *
            case "getlistEvent" :
                **
                 * Mendapatkan list event
                 *                String username = this.getUsername(request);
                List<ViewEvent> list = this.vEventDao.getList("traveller_username", username);
                
                Content content = new Content();
                // masukkan list
                content.setListEvent(list);
                // masukkan html table
                String html = this.htmlHelper.listToHtmlBodyTable(list); 
                content.setHtmlTable(html);
                // masukkan html notifikasi
                html = this.htmlHelper.getHtmlNotif();
                content.setNotif(html);
                content.setNotifCount(this.htmlHelper.getNotifCount());
                // masukkan username
                content.setUser(username);
                
                try 
                {
                    **
                     * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                     *
                    jsonString = this.jsonMapper.writeValueAsString(content);
                    this.responseJson(response, jsonString);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
                */
                
            case "downloadPdf":
                /**
                 * Mendapatkan list event
                 */
                String username = this.getUsername(request);
                List<ViewEvent> list = this.vEventDao.getList("traveller_username", username);
                /**
                 * Mendapatkan data traveller
                 */
                Traveller traveller = this.travellerDao.getObj("traveller_username", username);
                /**
                 * Menulis Pdf
                 */
                Document doc = new Document();
        
                try 
                {
                    response.setHeader("Content-Disposition", "attachment; filename=" + username + "_travelplan.pdf");
                    response.setContentType("application/pdf");
                    // tulis lggs ke response client
                    PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
                    
                    PdfHelper pdf = new PdfHelper(writer, doc, traveller.getTraveller_fullname(), request.getServletContext().getRealPath("/WEB-INF/logo/logo2a.png"));
                    /**
                     * buka doc untuk write content
                     */ 
                    doc.open();
                    
                    pdf.addHeader();
                    
                    String[] theader = new String[]{"No", "Event Name", "Date & Time", "Use", "At", "Location", "Note"};
                    int[] relativeLength = new int[]{1, 4, 4, 2, 4, 8, 4};
                    pdf.generatedTable(theader, relativeLength);
                    
                    Font font = pdf.getNormalFont();
                    BaseColor color = pdf.getLightBasePdfColor();
                    
                    int i = 0;
                    for(ViewEvent ve : list)
                    {
                        i++;
                        String date = this.dateTHelper.changeDateStrFormat(ve.getStart_event());
                        String depature = this.dateTHelper.changeDateStrFormat(ve.getDepature_time());
                        pdf.addRow(font, color, String.valueOf(i), ve.getEvent_name(), date, ve.getTransportation_mode(), depature, ve.getEnd_location_name(), ve.getNote());
                    }
                    
                    pdf.addFooter();
                    
                    /**
                     * Tutup doc
                     */
                    doc.close();
                } 
                catch (IOException | DocumentException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
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
        Message message;
        message = new Message();
                
        //if(!this.isLogin(request))
        switch(param)
        {
            case "addEvent":
                // pesan
            
                int idLoc;
                        
                try 
                {
                    EventDesc eventdesc = jsonMapper.readValue(json, EventDesc.class);
                    // masukin lokasi
                    Location eventLoc = eventdesc.getStartLocation();
                    idLoc = this.locationDao.create(eventLoc);
                    
                    eventLoc = eventdesc.getEndLocation();
                    affectedRow = this.locationDao.create(eventLoc);
                    
                    // masukin event
                    Event objEvent = eventdesc.getEvent();
                    objEvent.setStart_location_id(idLoc);
                    objEvent.setEnd_location_id(affectedRow);
                    objEvent.setTraveller_username(this.getUsername(request));
                    idPK = this.eventDao.create(objEvent);
                    
                    // masukkin travel
                    Travel travelEvent = eventdesc.getTravel();
                    travelEvent.setEvent_id(String.valueOf(idPK));
                    travelEvent.setTraveller_username(this.getUsername(request));
                    travelEvent.setStart_location_id(idLoc);
                    travelEvent.setEnd_location_id(affectedRow);
                    
                    this.travelDao.create(travelEvent);
                    //idPK = 1;
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(idPK > 0)
                {
                    message.setStatus("OK");
                    message.setTitle("Success");
                    message.setMessage("Success add message!");
                    message.setGeneratedKey(idPK);
                }
                else
                {
                    message.setStatus("ERROR");
                    message.setTitle("Failed");
                    message.setMessage("Failed Add Event");
                }
                
                try 
                {
                    json = jsonMapper.writeValueAsString(message);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
                
            case "editEvent":
                try 
                {
                    EventDesc eventdesc = jsonMapper.readValue(json, EventDesc.class);
                    // masukin lokasi
                    //Location eventLoc = eventdesc.getStartLocation();
                    //idPK = this.locationDao.edit(eventLoc, "location_id", eventLoc.getLocation_id().toString());
                    
                    //eventLoc = eventdesc.getEndLocation();
                    //affectedRow = this.locationDao.edit(eventLoc, "location_id", eventLoc.getLocation_id().toString());
                   
                    // masukin event
                    Event objEvent = eventdesc.getEvent();
                    Travel trvl = eventdesc.getTravel();
                    
                    String username = this.getUsername(request);
                    
                    Event objWhereEvent = new Event();
                    Travel objWhereTravel = new Travel();
                    
                    objWhereEvent.setTraveller_username(username);
                    objWhereEvent.setEvent_id(objEvent.getEvent_id());
                    
                    objWhereTravel.setTraveller_username(username);
                    objWhereTravel.setEvent_id(trvl.getEvent_id());
                    
                    this.eventDao.edit(objEvent, objWhereEvent);
   
                    
                    trvl.setTraveller_username(username);
                    this.travelDao.edit(trvl, objWhereTravel);
                    
                    message.setStatus("OK");
                    message.setTitle("Success");
                    message.setMessage("Success edit event!");
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                    message.setStatus("ERROR");
                    message.setTitle("Failed");
                    message.setMessage("Failed edit event");
                }
                
                try 
                {
                    json = jsonMapper.writeValueAsString(message);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                break;
                    
            case "deleteEvent":
                               
                String id = request.getParameter("event_id");
                String username = this.getUsername(request);
                    
                Event event = new Event();
                Travel travel = new Travel();
                
                event.setEvent_id(id);
                event.setTraveller_username(username); 
                
                travel.setEvent_id(id);
                travel.setTraveller_username(username);
                
                affectedRow = this.eventDao.delete(event);
                affectedRow += this.travelDao.delete(event);
                
                message = new Message();
                
                if(affectedRow > 0)
                {
                    message.setStatus("OK");
                    message.setTitle("Success");
                    message.setMessage("Delete Event Success!");  
                }   
                else
                {
                    message.setStatus("Error");
                    message.setTitle("Failed");
                    message.setMessage("Delete Event Failed!");  
                }
                
                try 
                {
                    json = jsonMapper.writeValueAsString(message);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
                
            case "registerUser":
                try 
                {
                    Traveller traveller = jsonMapper.readValue(json, Traveller.class);
                    // hash password sebelum masukin ke database via dao
                    String hashpwd = this.hashpw.hash(traveller.getTraveller_password());
                    traveller.setTraveller_password(hashpwd);
                    
                    affectedRow = this.travellerDao.create(traveller);
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(affectedRow > 0)
                {
                    message.setMessage("Register Success, Login Now");
                    message.setTitle("Success");
                    message.setStatus("OK");
                }
                else
                {
                    message.setStatus("ERROR");
                    message.setTitle("Failed");
                    message.setMessage("Failed to register! If you have an account, please login !");
                }
                //    this.responseStr(response, "Gagal Registrasi User!\nUsername atau Email Terdaftar!\nJika Anda telah memiliki akun, Mohon login!");
                try 
                {
                    json = jsonMapper.writeValueAsString(message);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
                
           /* case "deleteUser":
                // TULIS CODE DISINI !!!
              String traveller_username = request.getParameter("traveller_username");
                
                int affectedRowEvent = this.eventDao.delete("traveller_username", traveller_username);
                affectedRow = this.travellerDao.delete("traveller_username", traveller_username);
                
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
               */ 
            case "editUser":
                try 
                {
                    Traveller traveller = jsonMapper.readValue(json, Traveller.class);
                    traveller.setTraveller_username(this.getUsername(request));
                    if(traveller.getTraveller_password() != null)
                    {
                        String securePass = this.hashpw.hash(traveller.getTraveller_password());
                        traveller.setTraveller_password(securePass);
                        Traveller travellerWhere = new Traveller();
                        travellerWhere.setTraveller_username(this.getUsername(request));

                        affectedRow = this.travellerDao.edit(traveller, travellerWhere);
                    }
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(affectedRow > 0)
                {
                    message.setMessage("Edit User Success");
                    message.setTitle("Success");
                    message.setStatus("OK");
                }
                else
                {
                    message.setMessage("Edit User Failed");
                    message.setTitle("Failed");
                    message.setStatus("ERROR");
                }
                try 
                {
                    json = jsonMapper.writeValueAsString(message);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "getlistEvent" :
                /**
                 * Mendapatkan list event
                 */
                username = this.getUsername(request);
                List<ViewEvent> list = this.vEventDao.getList("traveller_username", username);
                
                Content content = new Content();
                // masukkan list
                content.setListEvent(list);
                // masukkan html table
                String html = this.htmlHelper.listToHtmlBodyTable(list); 
                content.setHtmlTable(html);
                // masukkan html notifikasi
                html = this.htmlHelper.getHtmlNotif();
                content.setNotif(html);
                content.setNotifCount(this.htmlHelper.getNotifCount());
                // masukkan username
                content.setUser(username);
                
                try 
                {
                    /**
                     * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                     */
                    json = this.jsonMapper.writeValueAsString(content);
                    this.responseJson(response, json);
                } 
                catch (JsonProcessingException ex) 
                {
                    Logger.getLogger(TravlendarController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
                
            case "findUser":
                // TULIS CODE DISINI !!!
                //String username = request.getParameter("username");
                username = this.getUsername(request);
                Traveller traveller = this.travellerDao.getObj("traveller_username", username);
                traveller.setTraveller_password("");
                
                /**
                 * Mengubah ke bentuk json dan mengirimkan resonse json ke client
                 */
                try
                {
                    json = this.jsonMapper.writeValueAsString(traveller);            
                    this.responseJson(response, json);
                }
                catch (JsonProcessingException ex)
                {
                    
                }
                break;
                
            case "login":
                boolean isLogin = this.login(request);
                if(isLogin)
                    this.responseStr(response, "Sukses Login!\nSilakan Masuk");
                else
                    this.responseStr(response, "Gagal Login!\nUsername atau Password Salah!");
                break;
 
            case "logout":
                request.getSession().setAttribute("username", null);
                request.getSession().invalidate();    
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
    
    /**
     * Mehtod untuk login (eksekusi fungsi login di DBMS)
     * Mengembalikan boolean login tidaknya
     * @param request
     * @return 
     */
    private boolean login(HttpServletRequest request)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashpwd = this.hashpw.hash(password);
        // cari dengam hash password
        Integer num = this.travellerDao.executeFunction("isThereUser", Integer.class, username, hashpwd);
        // jika di database belum di hash
       /// if(num < 1)
       ///     num = this.travellerDao.executeFunction("isThereUser", Integer.class, username, password);
            
        if(num > 0)
        {
            request.getSession(true).setAttribute("username", username);
            return true;
        }
        else
            return false;
    }
    
    /**
     * Method untuk cek ada tidaknya session
     * @param request
     * @return 
     */
    private boolean isLogin(HttpServletRequest request)
    {
        return request.getSession().getAttribute("username") != null;
    }    
    
    /**
     * Method untuk mendapatkan username dari 
     * @param request
     * @return 
     */
    private String getUsername(HttpServletRequest request)
    {
        String username = (String) request.getSession().getAttribute("username");
        return username;
    }
}