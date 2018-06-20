package org.product.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;

public class DateTimeUtil {

	public static final String DATE_TIME_FOMATER= "yyyy-MM-dd HH:mm:ss";
	
	
	public static Date toUtilDate(DateTime dateTime) throws java.text.ParseException {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FOMATER);
        return formatter.parse(dateTime.toString(DATE_TIME_FOMATER));
    }
	
//	public static void main(String args[]) {
//		DateTimeUtil dt=new DateTimeUtil();
//		Date da=new Date();
//	
//		//dt.toUtilDate(new Date());
//	}

}
