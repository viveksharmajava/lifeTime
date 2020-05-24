package sample.test.designPatterns.behavior.observer;

public class MyTopicSubscriber implements Observer {

	Subject sbj;// object/Topic which need to observe by Observer class.

	@Override
	public void update() {
		if(sbj.getUpdate(this) == null) {
			System.out.println("Nothing happen in Topic state");
		}
		else{
			System.out.println("I have observ some new changes in Topic="+sbj.getUpdate(this));
		}
	}

	@Override
	public void setSubject(Subject s) {
		this.sbj = s;
	}

}
