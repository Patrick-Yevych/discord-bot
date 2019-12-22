package observe;

import java.util.ArrayList;

public abstract class Observable {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void attach(Observer o) { this.observers.add(o); } 
	public void detach(int i) { this.observers.remove(i); }
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}
}
