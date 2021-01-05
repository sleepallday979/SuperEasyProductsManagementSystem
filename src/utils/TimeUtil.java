package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	public static String timeGet(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		String current = df.format(System.currentTimeMillis());  
		return current; 
	}
}
