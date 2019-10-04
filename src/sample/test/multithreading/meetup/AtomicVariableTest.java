package sample.test.multithreading.meetup;

import java.util.concurrent.atomic.AtomicInteger;

class Count {
	public static Integer integer = new Integer(0);
	public static AtomicInteger atomicInteger = new AtomicInteger(0);
}
public class AtomicVariableTest {
	static class Incrementer extends Thread {
		public void run() {
			Count.integer ++;
			Count.atomicInteger .incrementAndGet();
	}
}
static class Decrementer extends Thread {
	public void run() {
		Count.integer --;
		Count.atomicInteger .decrementAndGet();
	}
}
public static void main(String []args) throws InterruptedException {
	Thread incremeterThread[] = new Incrementer[1000];
	Thread decrementerThread[] = new Decrementer[1000];
	for(int i = 0; i < 1000; i++) {
		incremeterThread[i] = new Incrementer();
		decrementerThread[i] = new Decrementer();
		incremeterThread[i].start();
		decrementerThread[i].start();
	}
//	for(int i = 0; i < 1000; i++) {
//		incremeterThread[i].join();
//		decrementerThread[i].join();
//	}
	System. out .printf("Integer value = %d AtomicInteger value = %d ",
	Count.integer , Count.atomicInteger .get());
}
}