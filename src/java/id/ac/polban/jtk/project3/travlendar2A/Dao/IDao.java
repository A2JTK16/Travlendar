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
public interface IDao<T>
{
    /**
     * Mendapatkan list dari database
     * @return 
     */
    public List<T> getList();
    
    /**
     * Mendapatkan data dalam object dari database berdasarkan paramName
     * @param paramName
     * @param paramValue
     * @return 
     */
    
    public T getObj(String paramName, String paramValue);
    
    /**
     * Menyimpan nilai atribut object ke database
     * 
     * 
     * @param object 
     * @return  
     */
    public boolean create(Object object);
    
    /**
     *   Menyunting data database berdasarkan id
     *   SQL : INSERT INTO class-name ( class-attribute ) VALUES ( attribute-value-from-object )
     * 
     * @param object
     * @param paramName
     * @param paramValue
     * @return  
     */
    public boolean edit(Object object, String paramName, String paramValue);
    
    /**
     *  Menghapus data database berdasarkan paramName
     *  SQL : DELETE FROM class-name WHERE ( paramName = paramValue )
     * 
     * @param paramName
     * @param paramValue
     * @return  
     */
    public boolean delete(String paramName, String paramValue);
}