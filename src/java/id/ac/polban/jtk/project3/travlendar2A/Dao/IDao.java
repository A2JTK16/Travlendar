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
     * Mendapatkan data dalam object dari database berdasarkan nama
     * @param name
     * @return 
     */
    public T getObj(String name);
    
    /**
     * Menyimpan nilai atribut object ke database
     * @param object 
     */
    public void create(Object object);
    
    /**
     * Menyunting data database berdasarkan id
     * @param object
     * @param id 
     */
    public void edit(Object object, int id);
    
    /**
     * Menghapus data database berdasarkan id
     * @param id 
     */
    public void delete(int id);
}
