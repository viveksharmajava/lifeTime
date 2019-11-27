package sample.test.multithreading.concurrent.executor;

public class ClassB extends AbsClass {
	@Override
	public Object call() throws Exception {
		System.out.println("Class B finished");
		return "B";
	}
}
