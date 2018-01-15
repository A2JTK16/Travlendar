/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import id.ac.polban.jtk.project3.travlendar2A.Models.ViewEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * 
 */
public class HtmlHelper 
{
    /**
     * Tanggal
     */
    DateTHelper helper;
    /**
     * Notifikasi Html
     */
    StringBuilder notifHtml;
    
    private int notifCount;
    
    /**
     * Konstruktor
     * @param helper 
     */
    public HtmlHelper(DateTHelper helper)
    {
        this.helper = helper;
        this.notifHtml = null;
        this.notifCount = 0;
    }
    
    /**
     * Mengubah List menjadi String Html Body Table
     * @param list
     * @return 
     */
    public String listToHtmlBodyTable(List<ViewEvent> list)
    {
        StringBuilder html = new StringBuilder();
        this.notifHtml = new StringBuilder();
        this.notifCount = 1; // mulai dari satu
        this.helper.setCurrentDate(new Date()); // set ke tgl terbaru
        String temp;
        Date date;
        for(ViewEvent event : list)
        {
            html.append("<tr><td style=\"display:none\">");
            html.append(event.getEvent_id());
            html.append("</td><td>");
            temp = event.getEvent_name();
            html.append(temp);
            html.append("</td><td>");
            date = helper.parseDateM(event.getStart_event());
            this.writeNotif(temp, date); // untuk notif
            temp = helper.changeDateFormat(date);
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
    
    /**
     * HTML Notif
     * @param title
     * @param date 
     */
    public void writeNotif(String title, Date date)
    {
        String text = this.helper.getDiffFutureFromNow(date, title);
        if(text != null)
        {
            this.notifHtml.append("<a href=\"#\">");
            this.notifHtml.append(text);
            this.notifHtml.append("</a>");
            this.notifCount++;
        }
    }
    
    /**
     * Notif
     * @return 
     */
    public String getHtmlNotif()
    {
        return this.notifHtml.toString();
    }

    /**
     * @return the notifCount
     */
    public int getNotifCount() {
        return notifCount;
    }
}
