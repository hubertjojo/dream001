package com.davis.design_pattern.behavioral.Observer.exam003;

import java.util.Observable;
import java.util.Observer;

public class ObserverPatternMultipleObserversUsingThreads {

	public static void main(String[] args) {
		ObservableValue observableObj = new ObservableValue(10);

		MyObserver observer1 = new MyObserver(observableObj);
		MyObserver observer2 = new MyObserver(observableObj);

		observableObj.addObserver(observer1);
		observableObj.addObserver(observer2);

		observableObj.start();

		System.out.println("Calling Listeners");

		observer1.printObservablesValue();
		observer2.printObservablesValue();

		System.out.println("Main thread says: Sleeping for 3 second(s)");

		try {
			Thread.sleep(3000);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main thread says: Going to change Observables Value");

		observableObj.setValue(20);
	}

}

class MyObserver implements Observer {
	static int numberOfObservers = 0;
	private ObservableValue obsValObj = null;
	private int observerNumber;

	public MyObserver(ObservableValue obsVal) {
		numberOfObservers++;
		observerNumber = numberOfObservers;
		this.obsValObj = obsVal;
	}

	public void printObservablesValue() {
		System.out.println("MyObserver" + observerNumber + " says: [" + obsValObj.getValue() + "]");
	}

	public void update(Observable o, Object arg) {

		if (o instanceof ObservableValue) {
			ObservableValue obs = (ObservableValue) o;
			System.out.println("MyObserver" + observerNumber + " says: Value changed to: [" + obs.getValue() + "] ["+arg+"]");
		} else {
			System.out.println("The observable object was not of the correct type");
		}

	}
}

class ObservableValue extends Observable implements Runnable {
	private int n = 0;

	public ObservableValue(int x) {
		this.n = x;
	}

	public int getValue() {
		return n;
	}

	public void setValue(int x) {
		this.n = x;
		setChanged();
		System.out.println("ObservableValue says: setChanged() has been called");

		
		// notifyObservers(new Integer(this.n));
		notifyObservers(); // makes the observers print null
		System.out.println("ObservableValue says: notifyObservers() has been called");
	}

	public void start() {
		new Thread(this).start();
	}

	public void run() {
		int count = -1;
		int a = 0, b = 0;

		while (a == b) {
			if (count != n) {
				count = n;
				System.out.println("ObservableValue says: My count is: [" + count + "]");

				count++;
				System.out.println("ObservableValue says: Now my count is: [" + count + "]");
				setChanged();
				System.out.println("ObservableValue says: setChanged() has been called");

				notifyObservers(new Integer(count));
				System.out.println("ObservableValue says: notifyObservers() has been called");

				System.out.println("ObservableValue says: Sleeping for 5 second(s)");

				try {
					Thread.sleep(5000);
				}

				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}