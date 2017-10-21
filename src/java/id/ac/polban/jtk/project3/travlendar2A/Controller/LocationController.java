/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Controller;

import id.ac.polban.jtk.project3.travlendar2A.Models.DAO.LocationDAO;
import id.ac.polban.jtk.project3.travlendar2A.Models.Location;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mufidjamaluddin
 */
public class LocationController extends HttpServlet
{
    LocationDAO locDao;
    
    @Override
    public void init()
    {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL"); 
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername"); 
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        this.locDao;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {
        
    }
}
