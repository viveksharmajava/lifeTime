package sample.test.designPatterns.behavior.observer;
/*
 * https://www.journaldev.com/1739/observer-design-pattern-in-java
 */
public class ObserverPatterDemo {

	public static void main(String[] args) {
    
		Observer observer1 = new MyTopicSubscriber("Subscriber 1");
		Observer observer2 = new MyTopicSubscriber("Subscriber 2");
		Observer observer3 = new MyTopicSubscriber("Subscriber 2");
		
		MyTopic subject = new MyTopic();
		subject.register(observer1);
		subject.register(observer2);
		subject.register(observer2);
		
		observer1.setSubject(subject);
		observer2.setSubject(subject);
		observer3.setSubject(subject);
		
		//check if any update available
		observer1.update();
		subject.postMessage("Hello Dear!");
	}

}
