package com.davis.design_pattern.behavioral.Observer.exam001;

public class ClientEvent {
	final String ip;
	final String name;

	ClientEvent(Client client) {
		this.ip = client.getIp();
		this.name = client.getName();
	}
}
