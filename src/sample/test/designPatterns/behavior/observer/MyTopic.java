package sample.test.designPatterns.behavior.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTopic implements Subject {
    List <Observer> observers ;
    String message;
    boolean change;
    Object mutex  = new Object();
    public MyTopic() {
    	this.observers = new ArrayList();
    }
	@Override
	public void register(Observer obj) {
		synchronized(mutex) {
			observers.add(obj);
		}
		
	}

	@Override
	public void unregister(Observer obj) {
		synchronized(mutex) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List <Observer> local  = null;
		
		synchronized(mutex) {
			if(!change) return;
		local  = new ArrayList(this.observers);
			this.change = false;
		}
		for(Observer ob : local) {
			ob.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	public void postMessage(String msg) {
		System.out.println("Message posted to topic="+msg);
		this.message = msg;
		this.change = true;
		this.notifyObservers();
	}

}
