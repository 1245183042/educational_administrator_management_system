package com.edu.util;

import java.text.DateFormat;
import java.util.Date;

public class DateUtil {
	public static String getTime(){
		Date d = new Date();
		return DateFormat.getDateInstance().format(d);
	}
}
