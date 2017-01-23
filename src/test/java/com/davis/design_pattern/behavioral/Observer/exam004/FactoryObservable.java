package com.davis.design_pattern.behavioral.Observer.exam004;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class FactoryObservable extends Observable implements Runnable {
	
	private Vector<Observer> obs1;
	
	private String id;
	
	public FactoryObservable(String id) {
		super();
		obs1=new  Vector<>();
		this.id=id;
	}

	public synchronized void addObserver(Observer o) {
        super.addObserver(o);
        if (o == null)
            throw new NullPointerException();
        if (!obs1.contains(o)) {
            obs1.addElement(o);
        }
    }
	
	public synchronized Observer getObserver(Observer o){
		if (obs1.contains(o)) {
			return obs1.get(obs1.indexOf(o));
		}
		return null;
	}

	public String getId(){
		return this.id;
	}
	public void start() {
		new Thread(this).start();
		new Thread(this).start();
	}

	@Override
	public void run() {
		long time=System.currentTimeMillis();
		time=0;
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
