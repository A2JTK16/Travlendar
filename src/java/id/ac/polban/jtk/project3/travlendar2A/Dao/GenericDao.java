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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private final List<PropertyDescriptor> propertyClass;
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
         * Property Class
         */
        this.propertyClass = new ArrayList<>();
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
        if(this.propertyClass.isEmpty())
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
        if(this.propertyClass.isEmpty())
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
    public int create(Object objModel) 
    {
        if(this.propertyClass.isEmpty())
            return 0;
        /**
         * ID 
         */
        int idPK = 0;

        /**
         * Untuk membuat string sql
         */
        StringBuilder mtSql = new StringBuilder();
        /**
         * Mendapatkan Map Fields
         */
        Map<String, Object> fieldsMap = this.getFieldsMap(objModel);
        Set<String> keySet = fieldsMap.keySet();
        /**
         * Membat SQL Sintaks
         */
        mtSql.append("INSERT INTO ");
        mtSql.append(this.classModel.getSimpleName().toLowerCase());
        mtSql.append("( ");
        mtSql.append(String.join(",", keySet));
        mtSql.append(" ) VALUES ( ");
        
        for(int i=0; i<fieldsMap.size(); i++)
        {
            mtSql.append(" ? ,");
        }
        
        mtSql.delete(mtSql.length()-1, mtSql.length()); // hapus koma
        mtSql.append(" ) ");
        //System.out.println(mtSql.toString());
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
            stmt = super.getJdbcConnection().prepareStatement(mtSql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            /**
             * Mendapatkan attribut dari objek objModel
             */
            //for(Field field : this.classModel.getDeclaredFields())
            int count = 1;
            for(String attrName : keySet)
            {
                stmt.setObject(count, fieldsMap.get(attrName));
                count++;
            }
            /**
             * Eksekusi update
             */
            int affectedRow = stmt.executeUpdate();
            /**
             * Mendapatkan PK auto_increment 
             */
            if(affectedRow > 0)
            {
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next())
                    idPK = rs.getInt(1);
                else
                    idPK = affectedRow;
            }
            /**
             * Tutup Statement
             */
            stmt.close();

        } 
        catch (SQLException | IllegalArgumentException ex)
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.disconnect();
        
        return idPK;
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
    public int edit(Object object, String paramName, String paramValue) 
    {
        /**
         * Jika tidak diset
         */
        if(this.propertyClass.isEmpty())
            return 0;
        /**
         * Jika parameter nya null
         */
        if(paramName == null || paramValue == null)
            return 0;
        /**
         * SQL Sintaks
         */        
        StringBuilder mtSql = new StringBuilder();
        int affectedRow = 0;
        
        mtSql.append("UPDATE ");
        mtSql.append(this.classModel.getSimpleName().toLowerCase());
        mtSql.append(" SET ");
        /**
         * Mendapatkan field yang tidak Null
         */
        Map<String, Object> fieldsMap = this.getFieldsMap(object);
        
        for(String attrName : fieldsMap.keySet())
        {
            mtSql.append(attrName);
            mtSql.append(" = ? ,");
        }
        
        mtSql.delete(mtSql.length()-1, mtSql.length()); // hapus koma
        
        mtSql.append(" WHERE ");
        mtSql.append(paramName);
        mtSql.append(" = ? ");
        
        //System.out.println(mtSql.toString());
        
        super.connect();
        
        PreparedStatement stmt;
        
        try 
        {
            stmt = super.getJdbcConnection().prepareStatement(mtSql.toString());
            
            int count = 1;
            for(Object valOb : fieldsMap.values())
            {
               stmt.setObject(count, valOb);
               count++;
            }
            stmt.setString(count, paramValue);
            
            affectedRow = stmt.executeUpdate();
            
            stmt.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.disconnect();
        
        return affectedRow;
    }
    
    /**
     * Menghapus data di database
     * 
     * @param paramName
     * @param paramValue
     * @return 
     */
    @Override
    public int delete(String paramName, String paramValue) 
    {
        if(this.propertyClass.isEmpty())
            return 0;
        
        if(paramName == null || paramValue == null)
            return 0;
        
        int affectedRow = 0;
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
             
            affectedRow = stmt.executeUpdate();
            
            stmt.close();
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /**
         * Disconnect
         */
        super.disconnect();
        
        return affectedRow;
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
    
    /**
     * Mendapatkan Map dengan Key Nama Atribut dan Value nya Isi Atribut
     * Tidak Akan Ada Atribut yang Null
     * 
     * @param obj
     * @return 
     */
    private Map<String, Object> getFieldsMap(Object obj)
    {
        /**
         * Penampung nama 
         */
        Map<String, Object> fields = new HashMap<>();
        /**
         * Mendapatkan nama field dan isinya
         */
        for(PropertyDescriptor property : this.propertyClass)
        {
            Object fieldValue = this.invokeGetter(property, obj);
            if(fieldValue != null)
            {
                /**
                 * Menambahkan key : Field Name dan Value = fieldValue
                 */
                fields.put(property.getName(), fieldValue);
            }
        }
        /**
         * Mengembalikan Object Map
         */
        return fields;
    }
}
