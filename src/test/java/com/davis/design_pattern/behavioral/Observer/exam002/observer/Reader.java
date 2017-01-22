package com.davis.design_pattern.behavioral.Observer.exam002.observer;

import com.davis.design_pattern.behavioral.Observer.exam002.observable.Observable;

public class Reader implements Observer{
	
	private String name = null;
	private Observable news = null;
	
	public Reader(String name){
		this.name = name;
	}
	
	@Override
	public void update(boolean latestNews) {
		read(latestNews);
	}
	
	
	@Override
	public void subscribe(Observable news){
		this.news = news;
		news.register(this);
	}
	
	@Override
	public void unsubscribe(){
		news.unregister(this);
	}
	
	private void read(boolean latestNews){
		if(latestNews){
			System.out.println(name + " read latest news");
		} else {
			System.out.println(name + " read old news");
		}
	}
}
