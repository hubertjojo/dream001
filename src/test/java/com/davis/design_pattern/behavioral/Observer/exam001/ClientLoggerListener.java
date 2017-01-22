package com.davis.design_pattern.behavioral.Observer.exam001;

public class ClientLoggerListener implements ClientListener {
	public void clientAdded(ClientEvent event) {
		System.out.println(event.ip + " added...");
	}

	public void clientRemoved(ClientEvent event) {
		System.out.println(event.ip + " removed...");
	}
}
