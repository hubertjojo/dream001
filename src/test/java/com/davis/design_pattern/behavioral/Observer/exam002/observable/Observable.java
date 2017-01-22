package com.davis.design_pattern.behavioral.Observer.exam002.observable;

import com.davis.design_pattern.behavioral.Observer.exam002.observer.Observer;

/**
 * Observable/Subject(被觀察對象).
 *
 */
public interface Observable {
	public void register(Observer reader);

	public void unregister(Observer reader);

	void notify(boolean isLatestNews);
}
