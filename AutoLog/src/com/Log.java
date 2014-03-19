package com;

import org.apache.log4j.Logger;

public class Log {

static org.apache.log4j.Logger log = Logger.getLogger(Log.class);
	
	public static void main(String[] args) {
	
		for (int i = 0; i <10; i++) {
			
			log.debug(i);
		
			
		}
		//Log4JDataGenerator ld=new Log4JDataGenerator();
		//ld.generateData();
			
		
	}
}
