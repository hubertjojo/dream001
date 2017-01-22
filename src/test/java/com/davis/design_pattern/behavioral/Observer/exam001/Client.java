package com.davis.design_pattern.behavioral.Observer.exam001;

public class Client {
	private String ip;
    private String name;
    
	public Client(String ip, String name) {
		super();
		this.ip = ip;
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
