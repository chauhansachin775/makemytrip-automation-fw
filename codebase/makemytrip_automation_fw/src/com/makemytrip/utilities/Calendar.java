//author : sachin singh chauhan


package com.makemytrip.utilities;

import java.text.DateFormatSymbols;

public class Calendar {
	
	public static String parseMonthNumToMonthName(Object obj) {
		String str = String.valueOf(obj);
		Integer month = Integer.valueOf(str);
		
		DateFormatSymbols dt = new DateFormatSymbols();
		String[] months = dt.getMonths();
		String monthName=null;
		if(month <= 12 && month > 0 ) {
			monthName = months[month-1]; 
			}
			return monthName;	
	}

}
