package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeConvert {
    public static String convertToString(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(time);
    }
    public static Date converToDate(String time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(time);
        } catch (ParseException ex) {
            Logger.getLogger(TimeConvert.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
