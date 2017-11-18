/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Dao;

import java.util.List;

/**
 *
 * @author mufidjamaluddin
 * @param <T>
 */
public class GenericDao<T> extends DaoManager implements IDao<T>
{
    private List<String> fields;
    Class T;

    public GenericDao(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    @Override
    public List<T> getList() 
    {
        // WRITE CODE HERE!
        return null;
    }

    @Override
    public T getObj(String name) 
    {
        // WRITE CODE HERE!
        return null;  
    }

    @Override
    public void create(Object object) 
    {
        
    }

    @Override
    public void edit(Object object, int id) 
    {
        
    }

    @Override
    public void delete(int id) 
    {
        
    }

    /**
     * 
     * @return 
     */
    public String getFieldsStr() 
    {
        // WRITE  CODE HERE
        return null;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<String> fields) 
    {
        this.fields = fields;
    }
    
}
