package com.davis.design_pattern.behavioral.Observer.exam004;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestExam004 {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(TestExam004.class);
	
	@Test
	public void test001(){
		FactoryObservable factory=new FactoryObservable();
		MachineObserver m001=new MachineObserver("127.0.0.1",PingAction.Start);
		MachineObserver m002=new MachineObserver("127.0.0.2",PingAction.Start);
		MachineObserver m003=new MachineObserver("127.0.0.3",PingAction.Start);
		logger.info("\n"+m001+"\n"+m002+"\n"+m003);
		factory.addObserver(m003);
		factory.addObserver(m002);
		factory.addObserver(m001);
		factory.start();
		while (true) {
			try {
				Thread.sleep(7000);
				logger.info("\n"+m001+"\n"+m002+"\n"+m003);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
