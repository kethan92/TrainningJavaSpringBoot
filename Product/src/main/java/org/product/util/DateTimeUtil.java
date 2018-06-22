package org.product.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.product.exception.InternalErrorException;
import org.product.logger.LoggerUtil;
import org.product.repository.JpaProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class DateTimeUtil {

	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
	
	public static final String DATE_TIME_FOMATER= "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_TIME_FOMATER_TIMEZONE = "yyyy-MM-dd HH:mm:ssZ";
	
	
	public static Date toFoMaterDateTime(DateTime dateTime) throws java.text.ParseException {
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
	public static Date toFomaterDateUTCFromDateString(String dateString, String dateTimeFomater)
    {
        try {
        	DateTime toDateTimeUTCFromDateString=DateTime.parse(
        			dateString, DateTimeFormat.forPattern(dateTimeFomater).withZoneUTC());
        	
            return toFoMaterDateTime(toDateTimeUTCFromDateString);
        } catch (ParseException e) {
        	LoggerUtil.error(logger, e.getMessage(),e);
        
        	e.printStackTrace();
        }
		return null;
    }
	
	
    
	
	public static void main(String[] args) {
		String dateTimeString = "2013-11-22T18:37:55.645+0000";
//		org.joda.time.DateTime myDateTime = org.joda.time.format.ISODateTimeFormat.dateTime().withZoneUTC().parseDateTime( dateTimeString );
//		
//		Long millisSinceEpoch = 1385495463L;
//		org.joda.time.DateTime myDateTime1 = new org.joda.time.DateTime( millisSinceEpoch );
		DateTimeUtil dtime=new DateTimeUtil();
		
//		Date dateTimeUtil=dtime.toUtilDateUTC(dateTimeString, DATE_TIME_FOMATER);
//		System.out.println(dateTimeUtil);
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
		        .withLocale(Locale.ROOT)
		        .withChronology(ISOChronology.getInstanceUTC());

		DateTime dt = formatter.parseDateTime(dateTimeString);
		
		
		
		//Date converToDate=dtime.toUtilDate(dt);
		//String date=converToDate.toString();
		System.out.println(1);
		
	}
}
