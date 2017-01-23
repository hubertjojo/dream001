package com.davis.design_pattern.behavioral.Observer.exam004;

import java.util.Observable;

public class FactoryObservable extends Observable implements Runnable {

	public void start() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		long time=System.currentTimeMillis();
		while (true) {
			setChanged();
			this.notifyObservers(time);
			try {
				Thread.sleep(5000);
				time+=5000;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
