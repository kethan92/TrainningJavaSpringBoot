package org.product.util;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateTimeZoneDeserializer extends StdDeserializer<Date> {

	protected DateTimeZoneDeserializer(Class<?> vc) {
		super(vc);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	public static final String DATE_TIME_FOMATER_TIMEZONE = "yyyy-MM-dd HH:mm:ssZ";
	@Override
	public Date deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		String stringDateTime=arg0.getText();
		return DateTimeUtil.toFomaterDateUTCFromDateString(stringDateTime, DATE_TIME_FOMATER_TIMEZONE);
	}


   

    

	
}
