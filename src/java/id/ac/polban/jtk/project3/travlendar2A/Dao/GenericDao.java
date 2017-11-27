/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.project3.travlendar2A.Dao;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final Class classModel;
    /**
     * String gabungan nama-nama fields yg dipisah koma
     * untuk SQL SELECT, UPDATE, dan INSERT 
     */
    private final String fieldsStr;
    /**
     * List untuk menyimpan property dari class model
     */
    private List<PropertyDescriptor> propertyClass;
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
         * Class model yg akan digunakan dao ini
         */
        this.classModel = classModel;
        /**
         * Mendapatkan String nama-nama atribut yang dipisah oleh delimiter koma
         */
        StringJoiner joiner = new StringJoiner(", ");
        try
        {
            /**
             * Mendapatkan propery Class
             */
            PropertyDescriptor[] props = Introspector.getBeanInfo(classModel).getPropertyDescriptors();
            this.propertyClass = new ArrayList<>();

            for(PropertyDescriptor property : props) 
            {
                if(!property.getName().equals("class"))
                {
                    /**
                     * Join nama-namanya dengan delimiter koma
                     */
                    joiner.add(property.getName());
                    /**
                     * Menambahkan property ke ArrayList
                     */
                    this.propertyClass.add(property);
                }
            }
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
            this.propertyClass = null;
        }

        /**
         * Menyimpah string hasil join
         */
        this.fieldsStr = joiner.toString();
}
    
    /**
     * Method untuk mengeksekusi setter method suatu objek
     * 
     * @param objPropertyDescriptor sebagai property dari class
     * @param targetObj sebagai target objek yang akan disetter
     * @param attributeValue sebagai nilai yang akan dimasukkan
     */
    private void invokeSetter(PropertyDescriptor objPropertyDescriptor, Object targetObj, Object attributeValue)
    {
        /* attributeValue menggunakan objek Object karena dapat menggunakan Integer, String, etc... */
        try 
        {
            if(attributeValue != null)
            {
                /*  Set field/variable nilai menggunakan getWriteMethod() */
                objPropertyDescriptor.getWriteMethod().invoke(targetObj, objPropertyDescriptor.getPropertyType().cast(attributeValue));
            }
        }
        catch (IllegalAccessException | InvocationTargetException ex) 
        {
             ex.printStackTrace();
        }
    }
    
    /**
     * Mendapatkan objek atribut dari Getter suatu objek
     *
     * @param objPropertyDescriptor sebagai property
     * @param sourceObj sebagai objek sumber yg akan digetter salahsatu propertynya
     * @return nilai object
     */
    private Object invokeGetter(PropertyDescriptor objPropertyDescriptor, Object sourceObj)
    {
        try 
        {
           /**
            * Mendapatkan nilai field/atribut using getReadMethod()
            * attributeValue menggunakan objek Object karena dapat menggunakan Integer, String, etc... 
            */
            Object attributteValue = objPropertyDescriptor.getReadMethod().invoke(sourceObj);
            
            return attributteValue;
        } 
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
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
         * Jika propertynya tdk diset
         */
        if(this.propertyClass == null)
            return null;
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
        
        //sql = String.format("SELECT * FROM %s", this.classModel.getSimpleName().toLowerCase());
        sql = String.join(" ", "SELECT", this.getFieldsStr(), "FROM", this.classModel.getSimpleName().toLowerCase());
        //System.out.println(sql);
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
                objModel = (T) classModel.newInstance();
                
                /**
                 * Setter object
                 */
                //int i=0;
                //for (Field attribute : this.classModel.getDeclaredFields()) 
                for (PropertyDescriptor descriptor : propertyClass) 
                {
                    //i++;
                    //attribute.setAccessible(true);
                    //this.invokeSetter(objModel, attribute.getName(), attribute.getType(), rs.getObject(i));
                    //attribute.set(objModel, attribute.getType().cast(rs.getObject(i)));
                    this.invokeSetter(descriptor, objModel, rs.getObject(descriptor.getName()));
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
     * @author Reza Dwi Kurniawan
     * @param paramName
     * @param paramValue
     * @return 
     */
    @Override
    public T getObj(String paramName, String paramValue) 
    {        
        /**
         * Jika propertynya tdk diset
         */
        if(this.propertyClass == null)
            return null;
        /**
         * Model Objek
         */
        T objModel = null;
        /**
         * SQL nya
         */
        String sql;
        ResultSet rs;
        PreparedStatement stmt;
        
        //sql = String.format("SELECT * FROM %s WHERE %s = ? ", this.classModel.getSimpleName().toLowerCase(), paramName);
        sql = String.join(" ", "SELECT", this.getFieldsStr(), "FROM", this.classModel.getSimpleName().toLowerCase(),"WHERE", paramName, "= ?");
        //System.out.println(sql);
        super.connect();
        
        try 
        {
            stmt = super.getJdbcConnection().prepareStatement(sql);
            stmt.setString(1, paramValue);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                objModel = (T) classModel.newInstance();
                //int i = 0;
                //for (Field attribute : this.classModel.getDeclaredFields()){
                for (PropertyDescriptor descriptor : propertyClass) 
                {
                    //i++;
                    //attribute.setAccessible(true);
                    //this.invokeSetter(objModel, attribute.getName(), attribute.getType(), rs.getObject(i));
                    this.invokeSetter(descriptor, objModel, rs.getObject(descriptor.getName()));
                }            
            }
            stmt.close();            
        } 
        catch (SQLException | InstantiationException | IllegalAccessException ex) 
        {
            //Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        super.disconnect();
        
        return objModel;  
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
        /**
         * Jika propertynya tdk diset
         */
        if(this.propertyClass == null)
            return false;
        
        boolean isSuccess;
        String sql;
        StringBuilder sb;
        
        sb = new StringBuilder();
        /**
         * Query
         */
        sb.append("INSERT INTO ");
        sb.append(this.classModel.getSimpleName().toLowerCase());
        sb.append(" ( ");
        sb.append(this.getFieldsStr());
        sb.append(" ) VALUES ( ");
        
        for(int i=1; i<this.classModel.getDeclaredFields().length; i++)
        {
            sb.append(" ? ,");
        }
        sb.append(" ? )");
        
        sql = sb.toString();
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
            //for(Field field : this.classModel.getDeclaredFields())
            for (PropertyDescriptor descriptor : propertyClass) 
            {
                i++;
                /**
                 * Memasukkan atribut ke prepareStatement
                 */
                //field.setAccessible(true);
                //stmt.setObject(i, this.invokeGetter(objModel, field.getName()));
                //stmt.setObject(i, field.get(objModel));
                stmt.setObject(i, this.invokeGetter(descriptor, objModel));
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
        catch (SQLException | IllegalArgumentException ex)
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql;        
        StringBuilder sb = new StringBuilder();
        boolean isSuccess; // sukses tidaknya edit
        
        sb.append("UPDATE ");
        sb.append(this.classModel.getSimpleName().toLowerCase());
        sb.append(" SET ");
        //for (int i=0; i<this.getFieldsStr().length()-1;i++){
        for (PropertyDescriptor descriptor : propertyClass)
        {
            sb.append(descriptor.getName());
            sb.append(" = ? ,");
        }
      
        sb.delete(sb.length()-1, sb.length()); // hapus koma
        
        sb.append(" WHERE ");
        sb.append(paramName);
        sb.append(" = ? ");
        
        sql = sb.toString();
        
        super.connect();
        
        PreparedStatement stmt;
        
        try 
        {
            stmt = super.getJdbcConnection().prepareStatement(sql);
            
            for (int i=0; i<this.propertyClass.size(); i++)
            {
                PropertyDescriptor property = this.propertyClass.get(i);
                stmt.setObject(i+1, this.invokeGetter(property, object));
            }
            
            stmt.setString(this.propertyClass.size()+1, paramValue);
            //int i = 0;
            //for (Field field : this.classModel.getDeclaredFields())
            this.propertyClass.forEach((descriptor) -> {
                //i++;
                //field.setAccessible(true);
                //stmt.setObject(i, this.invokeGetter(object, field.getName()));
                this.invokeGetter(descriptor, object);
            });
            
            stmt.executeUpdate();
            stmt.close();
            isSuccess = true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            isSuccess  = false;
        }
        super.disconnect();
        
        return isSuccess;
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
        sql = String.format("DELETE FROM %s WHERE ( %s = ? )",this.classModel.getSimpleName().toLowerCase(), paramName);
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
        return this.fieldsStr;
    }
    
}
