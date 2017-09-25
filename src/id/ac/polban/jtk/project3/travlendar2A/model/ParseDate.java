/**
 * Kelas ParseDate Dibuat untuk Objek yang Bertujuan 
 * Mendapatkan Tanggal yang Telah Diparsing 
 * Sesuai Format yang Telah Ditentukan
 * 
 */
package id.ac.polban.jtk.project3.travlendar2A.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class ParseDate {
    /** 
     * Format Date 
     */
    private final SimpleDateFormat datetimeFormatter;
    /**
     * Format Date for check
     */
    private final SimpleDateFormat dateFormat;
    /**
     * Check the range of time
     */
    private final Pattern timePattern;
    /**
     * Accommodates Date in String
     */
    private String dateValStr;
    /**
     * Accommodates Time in String
     */
    private String timeValStr;
    
    /**
     * Constructor
     */
    public ParseDate()
    {
       datetimeFormatter = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss");
       dateFormat = new SimpleDateFormat("dd-MM-yyyy");
       timePattern = Pattern.compile("([01]?[0-9]|2[0-3]).[0-5][0-9].[0-5][0-9]"); // Range of Time
       dateValStr = null;
       timeValStr = null;
    }

    /**
     * @param dateValStr
     * @return 
	 * boolean
     * 
     */
    public boolean setDateValue(String dateValStr) {
        try{
            dateFormat.parse(dateValStr);
            this.dateValStr = dateValStr;
            return true;
        }
        catch(ParseException e)
        {
            System.out.println("The date are incorrect. Please fill the right date!");
            return false;
        }
    }
    
    /**
     * @param timeValStr
     * @return
     * 
     */
    public boolean setTimeValStr(String timeValStr) {

        if(timePattern.matcher(timeValStr).matches()) 
        {
            this.timeValStr = timeValStr;
            return true;
        }     
        else 
        {
            System.out.println("The time are incorrect. Please fill the right time!");
            return false;
        }    
    }
    
    /**
     *
     * @return
     * @throws ParseException
     * 
     */
    public Date getDateValue() throws ParseException
    {
        try{
            return datetimeFormatter.parse(this.dateValStr + "."+  this.timeValStr);
        }
        catch(ParseException e){
        //  e.printStackTrace();
            return null;
        }
    }
    
}