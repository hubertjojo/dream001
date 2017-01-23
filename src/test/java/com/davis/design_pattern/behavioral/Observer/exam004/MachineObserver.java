package com.davis.design_pattern.behavioral.Observer.exam004;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Observable;
import java.util.Observer;

public class MachineObserver implements Observer {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(MachineObserver.class);

	private String ip;
	private PingAction action;
	private int count = 0;
	private long sendTime;

	public MachineObserver(String ip, PingAction action) {
		super();
		this.ip = ip;
		this.action = action;
	}

	@Override
	public synchronized void update(Observable o, Object arg) {
		if (o instanceof FactoryObservable) {
			sendTime = (long) arg;
			switch (action) {
			case Start:
				_doRunPing();
				break;

			case Stop:
				_doNoPing();
				break;

			default:
				break;
			}
			logger.info("["+((FactoryObservable)o).getId()+"]"+this.toString());
		}
		
	}

	private void _doRunPing() {
		// logger.info("["+this.ip+"] Ping is "+PingAction.Start);
		count++;
		if (count > 999999) {
			count = 1;
		}
	}

	private void _doNoPing() {
		logger.info("[" + this.ip + "] Ping is " + PingAction.Stop);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MachineObserver @" + Integer.toHexString(hashCode()) + "[");
		if (ip != null) {
			// builder.append("ip=").append(ip).append(", ");
			builder.append(ip).append(", ");
		}

		if (action != null) {
			// builder.append("action=").append(action);
			builder.append(", ").append(action);
		}
		builder.append(", ").append(count);
		builder.append(", ").append(sendTime);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MachineObserver other = (MachineObserver) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		return true;
	}

}
