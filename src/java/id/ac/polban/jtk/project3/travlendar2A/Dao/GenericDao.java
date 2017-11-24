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
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author mufidjamaluddin
 * @param <T>
 */
public class GenericDao<T> extends DaoManager implements IDao<T>
{
    /**
     * Class model yang menggunakan jasa dao ini
     */
    private final Class<T> classModel;
    
    /**
     * Set dari nama field class objek yang digunakan dao
     */
    private final Set<String> namesOfFields;

    /**
     * Konstruktor
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     * @param classModel 
     */
    public GenericDao(String jdbcURL, String jdbcUsername, String jdbcPassword, Class<T> classModel) 
    {
        /**
         * Super class untuk koneksi
         */
        super(jdbcURL, jdbcUsername, jdbcPassword);
        /**
         * Mengisi class model
         */
        this.classModel = classModel;
        
        /**
         * Menyiman nama atribut kedalam Collection
         */
        Set<String> attrStr = new TreeSet();
        /**
         * Mendapatkan atribut dari class model
         * tidak termasuk atribut superclass
         */
        Field[] attrClass = this.classModel.getDeclaredFields();
        
        for(Field attribute : attrClass)
        {
            attribute.setAccessible(true); // Mengubah modifier menjadi publik
            attrStr.add(attribute.getName());
        }
        /**
         * Assignment
         */
        this.namesOfFields = attrStr;
    }
     
    /**
     * Method untuk mengeksekusi setter method suatu objek
     * 
     * @param obj
     * @param variableName
     * @param variableValue 
     */
    private void invokeSetter(Object obj, String attributeName, Class<?> attributeType, Object attributeValue)
    {
        /* attributeValue menggunakan objek Object karena dapat menggunakan Integer, String, etc... */
        try 
        {
            if(attributeValue != null)
            {
                /**
                 * Mendapatkan objek PropertyDescriptor menggunakan nama atribut dan class
                 * Note: Untuk menggunakan PropertyDescriptor untuk field/atribute, field/atribute harus mempunyai `Setter` dan `Getter` method.
                 */
                PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(attributeName, obj.getClass());
                /*  Set field/variable nilai menggunakan getWriteMethod() */
                objPropertyDescriptor.getWriteMethod().invoke(obj, attributeType.cast(attributeValue));           
            }
        }
        catch (IntrospectionException | IllegalAccessException | InvocationTargetException ex) 
        {
             ex.printStackTrace();
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
            e.printStackTrace();
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
        
        sql = String.join(" ", "SELECT * FROM", classModel.getSimpleName().toLowerCase());

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
                objModel = classModel.newInstance();
      
                /**
                 * Setter object
                 */
                int i=0;
                for (Field attribute : this.classModel.getDeclaredFields()) 
                {
                    i++;
                    this.invokeSetter(objModel, attribute.getName(), attribute.getType(), rs.getObject(i));
                }
                
                listObj.add(objModel);
            }
            stmt.close();
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException ex) 
        {
            // ex.printStackTrace();
        }
        
        super.disconnect();
        
        return listObj;
    }
    
    /**
     * Mendapatkan data dari database berdasarkan paramName
     * 
     * @param paramName
     * @param paramValue
     * @return 
     */
    @Override
    public T getObj(String paramName, String paramValue) 
    {
        // WRITE CODE HERE!
        return null;  
    }
    
    /**
     * Menyimpan data ke database
     * 
     * @param objModel
     * @return 
     */
    @Override
    public boolean create(Object objModel) 
    {
        boolean isSuccess;
        String sql;
        sql = String.join(" ","INSERT INTO",classModel.getSimpleName(),"(",this.getFieldsStr(),") VALUES (");
        
        for(int i=1; i<this.namesOfFields.size(); i++)
        {
            sql = sql.concat(" ? ,");
        }
        sql = sql.concat(" ? )");
        
        //System.out.println(sql);
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
            
            /**
             * Mendapatkan attribut dari objek objModel
             */
            int i=0;
            for(String attrName : this.namesOfFields)
            {
                i++;
                /**
                 * Memasukkan atribut ke prepareStatement
                 */
                stmt.setObject(i, this.invokeGetter(objModel, attrName));
            }
            
            /**
             * Eksekusi update
             */
            stmt.executeUpdate();
            /**
             * Tutup Statement
             */
            stmt.close();
            
            isSuccess = true;
        } 
        catch (SQLException ex) 
        {
           // Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            isSuccess = false;
        }
        super.disconnect();
        
        return isSuccess;
    }
    
    /**
     * Menyunting data yang ada dalam database
     * 
     * @param object
     * @param paramName
     * @param paramValue
     * @return 
     */
    @Override
    public boolean edit(Object object, String paramName, String paramValue) 
    {
        // TULIS CODE DISINI !!!
        return false;
    }
    
    /**
     * Menghapus data di database
     * 
     * @param paramName
     * @param paramValue
     * @return 
     */
    @Override
    public boolean delete(String paramName, String paramValue) 
    {
        boolean isSuccess;
        String sql;
        int maxLength = this.namesOfFields.size();
        sql = String.join(" ","DELETE FROM",classModel.getSimpleName(),"WHERE (",paramName,"= ?)");
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
            
            stmt.setString(1, paramValue);
            
            stmt.executeUpdate();
            
            stmt.close();
            
            isSuccess = true;
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            isSuccess = false;
        }
        
        /**
         * Disconnect
         */
        super.disconnect();
        
        return isSuccess;
    }

    /**
     *  Mendapatkan satu string nama-nama atribute class dengan delimiter (,)
     * 
     * @return 
     */
    public String getFieldsStr() 
    {
        String fieldStr;
        fieldStr = String.join(",", this.namesOfFields);
        return fieldStr;
    }
    
}
