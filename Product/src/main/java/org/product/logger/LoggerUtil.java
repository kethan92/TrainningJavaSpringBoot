package org.product.logger;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerUtil  {


	private LoggerUtil() {
	}


	public static void info(org.slf4j.Logger logger, String message) {
		// TODO Auto-generated method stub
		logger.info(message);
		
	}
	public static void info(org.slf4j.Logger logger, String message,Throwable t) {
		// TODO Auto-generated method stub
		logger.info(message,t);
		
	}
	
	public static void debug(org.slf4j.Logger logger, String message) {
		// TODO Auto-generated method stub
		logger.info(message);
		
	}
	public static void debug(org.slf4j.Logger logger, String message,Throwable t) {
		// TODO Auto-generated method stub
		logger.info(message,t);
		
	}
	
	public static void error(org.slf4j.Logger logger, String message) {
		// TODO Auto-generated method stub
		logger.error(message);
		
	}
	public static void error(org.slf4j.Logger logger, String message,Throwable t) {
		// TODO Auto-generated method stub
		logger.error(message,t);
		
	}
	
	public static void warning(org.slf4j.Logger logger, String message) {
		// TODO Auto-generated method stub
		logger.warn(message);
		
	}
	public static void warning(org.slf4j.Logger logger, String message,Throwable t) {
		// TODO Auto-generated method stub
		logger.warn(message,t);
		
	}
	
}
