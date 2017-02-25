package com.edu.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String getTime(){
		Date d = new Date();
		return DateFormat.getDateInstance().format(d);
	}
	
	public static String getTime(Date date){
		return sdf.format(date);
	}
}
