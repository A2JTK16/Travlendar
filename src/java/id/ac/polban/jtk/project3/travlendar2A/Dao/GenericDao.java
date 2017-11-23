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
     * List type dari atribut class objek yang menggunakan dao
     */
    private final List<Class<?>> typesoffield;
    /**
     * Class yang menggunakan jasa dao ini
     */
    private final Class<T> classModel;
    
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
         * Menyimpan nama nama atribut yang ada dalam class model
         * dalam List
         */
        Field[] attrClass;
        attrClass = classModel.getDeclaredFields();
        List<String> attributesStr;
        List<Class<?>> attributesType;
        attributesStr = new ArrayList<>();
        attributesType = new ArrayList<>();
        
        for(Field attribute : attrClass)
        {
            attribute.setAccessible(true); // Mengubah modifier menjadi publik
            attributesStr.add(attribute.getName());
            attributesType.add(attribute.getType());
        }
        this.fields = attributesStr;
        this.typesoffield = attributesType;
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
        
        sql = "SELECT * FROM " + classModel.getSimpleName().toLowerCase();

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
                for (int i=0; i<this.fields.size(); i++) 
                {
                    String attribute = this.fields.get(i);
                    Class<?> typeof = this.typesoffield.get(i);
                    this.invokeSetter(objModel, attribute, typeof, rs.getObject(i+1));
                }
                
                listObj.add(objModel);
            }
            stmt.close();
        } 
        catch (SQLException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException ex) 
        {
             ex.printStackTrace();
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
     * @param object
     * @return 
     */
    @Override
    public boolean create(Object object) 
    {
        boolean isSuccess;
        String sql;
        int maxLength = this.fields.size();
        sql = "INSERT INTO " + classModel.getSimpleName() + "( " + this.getFieldsStr() + " ) VALUES ( ";
        
        for(int i=0; i<maxLength-1; i++)
        {
            sql += " ? ,";
        }
        sql += " ? )";
        System.out.println(sql);
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
                stmt.setObject(i, this.invokeGetter(object, lst));
            }
            
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
        int maxLength = this.fields.size();
        sql = "DELETE FROM " + classModel.getSimpleName() + " WHERE ( " + paramName + " = ? )";
        
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
        String fieldStr = String.join(",", this.fields);
        return fieldStr;
    }

    /**
     *  Menyimpan list nama-nama atribute class sesuai database
     * 
     *  @param fields the fields to set
     */
    public void setFields(List<String> fields) 
    {
        this.fields = fields;
    }
    
}
