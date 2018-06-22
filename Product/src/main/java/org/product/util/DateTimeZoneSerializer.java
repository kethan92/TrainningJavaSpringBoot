package org.product.util;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateTimeZoneSerializer extends StdSerializer<Date> {

	private static final long serialVersionUID = 1L;
	public static final String DATE_TIME_FOMATER_TIMEZONE = "yyyy-MM-dd HH:mm:ssZ";


    public DateTimeZoneSerializer() { super(DateTimeZone.class, false); }

    

	@Override
	public void serialize(Date date, JsonGenerator json, SerializerProvider serial) throws IOException {
		// TODO Auto-generated method stub
		try
        {
            Date dateTimeUTC = DateTimeUtil.toFoMaterDateTime(DateTimeUtil.toDateTimeUTC(date));
            json.writeString(dateTimeUTC.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}
