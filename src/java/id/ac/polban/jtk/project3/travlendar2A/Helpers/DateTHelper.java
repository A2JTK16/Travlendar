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
     * Tanggal Sekarang
     */
    Date currentDate;
    
    /**
     * Formatter
     */
    SimpleDateFormat datetimeformatter; // Sunday 10-10-2018 10:18 AM
    SimpleDateFormat dateformatterSql; // 2018-10-10 09:00:00
    
    /**
     * Konstruktor
     */
    public DateTHelper()
    {
        this.currentDate = new Date();
        this.datetimeformatter = new SimpleDateFormat("EEEE dd-MM-yyyy HH:mm a");
        this.dateformatterSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    }
    
    /**
      * Mengecek kebenaran format waktu 24 jam
      * skala jam dan menit
      * 
      * @param timeValStr
      * @return
      */
    public boolean isTimeFormat(String timeValStr) 
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
    public Date parseDateM(String dateValStr)
    {
		// Jika String bernilai null, maka dikembalikan nilai null
        if(dateValStr == null)
            return null; 
        
        try 
        {  
            return this.dateformatterSql.parse(dateValStr);
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
    public Date parseDate(String format, String dateValStr)
    {
		// Jika String bernilai null, maka dikembalikan nilai null
        if(dateValStr == null)
            return null;
		
	SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(format); 
        
        try 
        {  
            return formatter.parse(dateValStr);
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
    public String toStringM(Date date)
    {
        String dateStr;
        this.dateformatterSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        dateStr = this.dateformatterSql.format(date);
        
        return dateStr;
    }
    
    /**
     *	Parsing Date Format
     *	Sesuai Format :: Sunday 10-10-2018 10:18 AM
     * @param date type String
     * @return
     */
    public String changeDateStrFormat(String date)
    {
        String dateStr;
        
        dateStr = this.datetimeformatter.format(parseDateM(date));
        
        return dateStr;
    }
    
    /**
     *	Parsing Date Format
     *	Sesuai Format :: Sunday 10-10-2018 10:18 AM
     * @param date tanggal type date
     * @return
     */
    public String changeDateFormat(Date date)
    {
        String dateStr;
        
        dateStr = this.datetimeformatter.format(date);
        
        return dateStr;
    }
    
    /**
     * Selisih Waktu dalam Hari
     * @param date tanggal yg akan dicari selisihnya dr sekarang
     * @param title judul 
     * @return 
     */
    public String getDiffFutureFromNow(Date date, String title)
    {
        long diff = date.getTime() - this.currentDate.getTime();
        //float days = (diff / (1000*60*60*24));
        float days = (diff / 86400000); // hasil 1000*60*60*24
        String text;
        if(days > 0)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(title);
            sb.append(" : The Next ");
            sb.append(String.format("%.0f", days));
            sb.append(" Days");
            text = sb.toString();
        }
        else
            text = null;
        return text;
    }
}