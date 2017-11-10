/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author mufidjamaluddin
 */
@WebServlet(name = "json", urlPatterns = {"/json"}) /* URL Controllernya */
public class TestjsonController extends HttpServlet
{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        JSONArray jsonArrObj;
        List<String> list;
        
        list = new ArrayList<>();
        jsonArrObj = new JSONArray();
        
        list.add("Bandung");
        list.add("Jakarta");
        list.add("Serang");
        list.add("New York");
        list.add("Manhattan");
        list.add("Las Vegas");
        
        jsonArrObj.put(list);
        
        try {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonArrObj.toString());

        } catch (IOException ex) {
            Logger.getLogger(TestjsonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
