package sample.test.designPatterns.behavior.observer;

public class MyTopicSubscriber implements Observer {

	Subject sbj;// object/Topic which need to observe by Observer class.
    private String name;
	public MyTopicSubscriber(String string) {
		// TODO Auto-generated constructor stub
		this.name = string;
	}

	public String getName() {
		return this.name;
	}
	@Override
	public void update() {
		if(sbj.getUpdate(this) == null) {
			System.out.println("Nothing happen in Topic state");
		}
		else{
			System.out.println(this.name+" have observed some new changes in Topic="+sbj.getUpdate(this));
		}
	}

	@Override
	public void setSubject(Subject s) {
		this.sbj = s;
	}

}
