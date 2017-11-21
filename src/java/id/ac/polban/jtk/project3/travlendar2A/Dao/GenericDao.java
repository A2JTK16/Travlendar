/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.buf.StringUtils;

/**
 *
 * @author mufidjamaluddin
 * @param <T>
 */
public class GenericDao<T> extends DaoManager implements IDao<T>
{
    /**
     * List String dari atribut class objek yang digunakan dao
     */
    private List<String> fields;
    /**
     * Class yang menggunakan jasa dao ini
     */
    Class T;
    
    /**
     * Konstruktor
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     */
    public GenericDao(String jdbcURL, String jdbcUsername, String jdbcPassword) 
    {
        super(jdbcURL, jdbcUsername, jdbcPassword);
        
        this.setAttrFields();
        //this.setModelMethods();
    }
    
    /**
     * Menyimpan nama nama atribut yang ada dalam class model
     */
    private void setAttrFields()
    {
        Field[] attrClass;
        attrClass = T.getDeclaredFields();
        List<String> attributesStr = new ArrayList<>();
        
        for(Field attribute : attrClass)
        {
            attribute.setAccessible(true); // Mengubah modifier menjadi publik
            attributesStr.add(attribute.getName().toLowerCase());
        }
        
        this.setFields(attributesStr);
    }
    
    /**
     * Method untuk mengeksekusi setter method suatu objek
     * 
     * @param obj
     * @param variableName
     * @param variableValue 
     */
    private void invokeSetter(Object obj, String attributeName, Object attributeValue)
    {
        /* attributeValue menggunakan objek Object karena dapat menggunakan Integer, String, etc... */
        try 
        {
            /**
            * Mendapatkan objek PropertyDescriptor menggunakan nama atribut dan class
            * Note: Untuk menggunakan PropertyDescriptor untuk field/atribute, field/atribute harus mempunyai `Setter` dan `Getter` method.
            */
            PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(attributeName, T);
            /* Set field/variable nilai menggunakan getWriteMethod() */
            objPropertyDescriptor.getWriteMethod().invoke(obj, attributeValue);
        } 
        catch (IntrospectionException | IllegalAccessException | InvocationTargetException ex) 
        {
            // e.printStackTrace();
        }
    }
    
    /**
     * Mendapatkan objek atribut dari Getter suatu objek
     * 
     * @param obj
     * @param attributeName
     * @return 
     */
    private Object invokeGetter(Object obj, String attributeName)
    {
        try 
        {
            /**
            * Mendapatkan objek PropertyDescriptor menggunakan nama atribut dan class
            * Note: Untuk menggunakan PropertyDescriptor untuk field/atribute, field/atribute harus mempunyai `Setter` dan `Getter` method.
            */
            PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(attributeName, obj.getClass());
            /**
            * Mendapatkan nilai field/atribut using getReadMethod()
            * attributeValue menggunakan objek Object karena dapat menggunakan Integer, String, etc... 
            */
            Object attributteValue = objPropertyDescriptor.getReadMethod().invoke(obj);
            
            return attributteValue;
        } 
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) 
        {
            // e.printStackTrace();
            return false;
        }
    }
      
    /**
     * Mendapatkan list objek T dari database
     * @return 
     */
    @Override
    public List<T> getList() 
    {
        /**
         * List penampung data dari database
         */
        List<T> listObj;
        /**
         * sql query nya
         */
        String sql;
        ResultSet rs;
        Statement stmt;
        /**
         * Objek yang akan ditambahkan ke list
         */
        T objModel;
        
        listObj = new ArrayList<>();
        
        sql = "SELECT * FROM " + T.getSimpleName().toLowerCase();
        
        /**
         * Koneksi ke Database
         */
        super.connect();
        
        try 
        {
            stmt = super.getJdbcConnection().createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                objModel = (T) T.newInstance();
                
                /**
                 * Setter object
                 */
                int i = 0;
                for (String attribute : this.fields) 
                {
                    i++;
                    this.invokeSetter(objModel, attribute, rs.getString(i));
                }
                
                listObj.add(objModel);
            }
            stmt.close();
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException ex) 
        {
            // e.printStackTrace();
        }
        
        super.disconnect();
        
        return listObj;
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
        String sql;
        int maxLength = this.fields.size();
        sql = "INSERT INTO " + T.getSimpleName() + "( " + this.getFieldsStr() + " ) VALUES ( ";
        
        for(int i=0; i<maxLength-1; i++)
        {
            sql += " ? ,";
        }
        sql += " ? ";
        /**
         * Buat Koneksi ke DBMS
         */
        super.connect();
        /**
         * Buat Statement
         */
        PreparedStatement stmt;
        try 
        {
            stmt = super.getJdbcConnection().prepareStatement(sql);
            
            int i=0;
            for(String lst : this.fields)
            {
                i++;
                stmt.setString(i, (String) this.invokeGetter(object, lst));
            }
            
            stmt.executeUpdate();
            /**
             * Tutup Koneksi
             */
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.disconnect();
    }

    @Override
    public void edit(Object object, int id) 
    {
        
    }

    @Override
    public void delete(int id) 
    {
        String sql;
        int maxLength = this.fields.size();
        sql = "DELETE FROM " + T.getSimpleName() + "( " + this.getFieldsStr() + " ) WHERE ( id = ? )";
        
        /**
         * Buat Koneksi ke DBMS
         */
        super.connect();
        /**
         * Buat Statement
         */
        PreparedStatement stmt;
        try 
        {
            stmt = super.getJdbcConnection().prepareStatement(sql);
            
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            /**
             * Tutup Koneksi
             */
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.disconnect();
    }

    /**
     * 
     * @return 
     */
    public String getFieldsStr() 
    {
        String fieldStr = StringUtils.join(this.fields, ',');  
        return fieldStr;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<String> fields) 
    {
        this.fields = fields;
    }
    
}
