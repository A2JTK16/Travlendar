/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Models;

import java.util.List;

/**
 *
 * 
 */
public class Content 
{
    private String htmlTable;
    private List<ViewEvent> listEvent;

    /**
     * @return the htmlTable
     */
    public String getHtmlTable() {
        return htmlTable;
    }

    /**
     * @param htmlTable the htmlTable to set
     */
    public void setHtmlTable(String htmlTable) {
        this.htmlTable = htmlTable;
    }

    /**
     * @return the listEvent
     */
    public List<ViewEvent> getListEvent() {
        return listEvent;
    }

    /**
     * @param listEvent the listEvent to set
     */
    public void setListEvent(List<ViewEvent> listEvent) {
        this.listEvent = listEvent;
    }
}
