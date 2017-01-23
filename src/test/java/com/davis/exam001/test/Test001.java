package com.davis.exam001.test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;

public class Test001 {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(Test001.class);
	
	@Test
	public void test001(){
		logger.debug("Here is some DEBUG");  
        logger.info("Here is some INFO");  
        logger.warn("Here is some WARN");  
        logger.error("Here is some ERROR");  
        logger.fatal("Here is some FATAL");  
	}

}
