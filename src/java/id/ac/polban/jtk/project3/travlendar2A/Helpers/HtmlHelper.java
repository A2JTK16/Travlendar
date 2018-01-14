/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import id.ac.polban.jtk.project3.travlendar2A.Models.ViewEvent;
import java.util.List;

/**
 *
 * 
 */
public class HtmlHelper 
{
    DateTHelper helper;
    
    public HtmlHelper(DateTHelper helper)
    {
        this.helper = helper;
    }
    /**
     * Mengubah List menjadi String Html Body Table
     * @param list
     * @return 
     */
    public String listToHtmlBodyTable(List<ViewEvent> list)
    {
        StringBuilder html = new StringBuilder();
        String temp;
        for(ViewEvent event : list)
        {
            html.append("<tr><td style=\"display:none\">");
            html.append(event.getEvent_id());
            html.append("</td><td>");
            html.append(event.getEvent_name());
            html.append("</td><td>");
            temp = helper.changeDateStrFormat(event.getStart_event());
            html.append(temp);
            html.append("</td><td>");
            html.append(event.getTransportation_mode());
            html.append("</td><td>");
            temp = helper.changeDateStrFormat(event.getDepature_time());
            html.append(temp);
            html.append("</td><td>");
            html.append(event.getEnd_location_name());
            html.append("</td><td><button class=\"v-more\"> View More </button> <button class=\"v-del\"> Delete </button></td>");
        }
        
        return html.toString();
    }
    
}
