package com.davis.design_pattern.behavioral.Observer.exam001;

public interface ClientListener {
	void clientAdded(ClientEvent event);

	void clientRemoved(ClientEvent event);
}
