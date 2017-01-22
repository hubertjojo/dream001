package com.davis.design_pattern.behavioral.Observer.exam002.observer;

import com.davis.design_pattern.behavioral.Observer.exam002.observable.Observable;

/**
 * Observer/Listener(觀察者)
 *
 */
public interface Observer {
	void subscribe(Observable news);

	void unsubscribe();

	void update(boolean isLastestNews);
}
