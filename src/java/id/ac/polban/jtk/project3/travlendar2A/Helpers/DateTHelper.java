/**
 * Kelas DateHelper Dibuat untuk Objek yang Bertujuan 
 * Melakukan Proses Pengecekan Format Tipe Data,
 * Parsing dari Tipe Data String ke Date,
 * dan Sebaliknya.
 * 
 * @author : Mufid Jamaluddin
 */
package id.ac.polban.jtk.project3.travlendar2A.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class DateTHelper 
{   
    /**
      * Mengecek kebenaran format waktu 24 jam
      * skala jam dan menit
      * 
      * @param timeValStr
      * @return
      */
    public static boolean isTimeFormat(String timeValStr) 
    {
        Pattern timePattern; 
        timePattern = Pattern.compile("([01]?[0-9]|2[0-3]).[0-5][0-9]");
        
        return timePattern.matcher(timeValStr).matches();
    }
	

    /**
     *	Parsing String ke Date
     *	Sesuai Format MySQL
     *	Jika parameter tidak sesuai format,
     *  maka akan dikembalikan nilai null
     *
     * @param dateValStr
     * @return
     */
    public static Date parseDateM(String dateValStr)
    {
		// Jika String bernilai null, maka dikembalikan nilai null
        if(dateValStr == null)
            return null;
        
        SimpleDateFormat datetimeformatter;
        datetimeformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        
        try 
        {  
            return datetimeformatter.parse(dateValStr);
        } 
        catch (ParseException e) 
        {
            return null;
        }
    }
    
    /**
     *	Parsing String ke Date
     *	Sesuai Format yang Telah Ditentukan
     *	Jika parameter tidak sesuai format,
     *  maka akan dikembalikan nilai null
     * 
     * @param format
     * @param dateValStr
     * @return
     */
    public static Date parseDate(String format, String dateValStr)
    {
		// Jika String bernilai null, maka dikembalikan nilai null
        if(dateValStr == null)
            return null;
		
		SimpleDateFormat datetimeformatter;
        datetimeformatter = new SimpleDateFormat(format); 
        
        try 
        {  
            return datetimeformatter.parse(dateValStr);
        } 
        catch (ParseException e) 
        {
            return null;
        }
    }
    
    /**
     *	Parsing Date ke String
     *	Sesuai Format database engine mysql
     * @param date
     * @return
     */
    public static String toStringM(Date date)
    {
        String dateStr;
        SimpleDateFormat datetimeformatter;
        datetimeformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        dateStr = datetimeformatter.format(date);
        
        return dateStr;
    }
    
    /**
     *	Parsing Date Format
     *	Sesuai Format database engine mysql
     * @param date
     * @return
     */
    public static String changeDateStrFormat(String date)
    {
        String dateStr;
        SimpleDateFormat datetimeformatter;

        datetimeformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        dateStr = datetimeformatter.format(parseDateM(date));
        
        return dateStr;
    }
    
}