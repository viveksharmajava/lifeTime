package sample.test.designPatterns.behavior.observer;

public interface Observer {

	//method to update the Observer by Subject
	 public void update();
	 
	 //attach with Subject to observe
	 public void setSubject(Subject s);
}
