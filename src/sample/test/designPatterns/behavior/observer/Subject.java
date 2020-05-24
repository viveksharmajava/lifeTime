package sample.test.designPatterns.behavior.observer;

public interface Subject {

	//method to register and unregister objserver.
	public void register(Observer obj);
	public void unregister(Observer obj);
	
	//method to notify observers of  change
	public void notifyObservers();
	
	//method to get update from the Subject
	public Object getUpdate(Observer obj);
	
}
