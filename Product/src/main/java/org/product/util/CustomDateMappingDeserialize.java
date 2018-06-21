package org.product.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.product.exception.InternalErrorException;
import org.product.logger.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomDateMappingDeserialize extends JsonDeserializer<Date> {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
    public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
//         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String date = paramJsonParser.getText();
//            try {
//                Date formattedDate= format.parse(date);
//              return formattedDate;
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }

            String input = paramJsonParser.getText();
            DateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ"); // this has to be like your input
            Date date;
			try {
				date = inputFormatter.parse(input);
				DateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd");
	           // String output = outputFormatter.format(date); // Output : yyyy-MM-dd
	            return date;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.error(logger, e.getMessage(),e);
				throw new InternalErrorException(e.getMessage());
			}
			

            

    }
}
