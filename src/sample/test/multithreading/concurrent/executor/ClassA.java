package sample.test.multithreading.concurrent.executor;

public class ClassA extends AbsClass {

	@Override
	public Object call() throws Exception {
		System.out.println("Class A finished");
		return "A";
	}

}
