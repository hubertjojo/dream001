package com.davis.design_pattern.behavioral.Observer.exam002.observable;

import java.util.ArrayList;

import com.davis.design_pattern.behavioral.Observer.exam002.observer.Observer;

public class News implements Observable {

	private ArrayList<Observer> readerList = new ArrayList<Observer>();

	private boolean latestNews = true;

	public boolean isLatestNews() {
		return latestNews;
	}

	public void setLatestNews(boolean latestNews) {
		this.latestNews = latestNews;
		notify(latestNews);
	}

	@Override
	public void register(Observer reader) {
		readerList.add(reader);
	}

	@Override
	public void unregister(Observer reader) {
		readerList.remove(reader);
	}

	@Override
	public void notify(boolean isLatestNews) {
		// notify all readers
		for (Observer reader : readerList) {
			reader.update(latestNews);
		}

	}
}
