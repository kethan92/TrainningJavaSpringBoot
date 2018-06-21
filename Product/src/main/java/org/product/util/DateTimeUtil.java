package org.product.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class DateTimeUtil {

	public static final String DATE_TIME_FOMATER= "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_TIME_FOMATER_TIMEZONE = "yyyy-MM-dd HH:mm:ssZ";
	
	
	public static Date toUtilDate(DateTime dateTime) throws java.text.ParseException {
        DateFormat formatter = new SimpleDateFormat(DATE_TIME_FOMATER);
        return formatter.parse(dateTime.toString(DATE_TIME_FOMATER));
    }
	
	public static String toStringFromUtilDate(Date date) {
        DateFormat df = new SimpleDateFormat(DATE_TIME_FOMATER);
        return df.format(date);
    }
	
	public static DateTime toDateTimeUTC(Date date)
    {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(DATE_TIME_FOMATER);
        DateTime dateTime = fmt.withZone(DateTimeZone.UTC).parseDateTime(toStringFromUtilDate(date));
        
        return dateTime;
    }
//	public static void main(String[] args) {
//		String dateTimeString = "2013-11-22T18:37:55.645+0000";
//		org.joda.time.DateTime myDateTime = org.joda.time.format.ISODateTimeFormat.dateTime().withZoneUTC().parseDateTime( dateTimeString );
//		
//		Long millisSinceEpoch = 1385495463L;
//		org.joda.time.DateTime myDateTime1 = new org.joda.time.DateTime( millisSinceEpoch );
//		
//		System.out.println(myDateTime1);
//	}
}
