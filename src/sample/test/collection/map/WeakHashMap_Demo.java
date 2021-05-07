package sample.test.collection.map;

import java.util.WeakHashMap;

public class WeakHashMap_Demo {
 
	public static void main(String []args) {
		
		WeakHashMap<String, String> weakMap = new WeakHashMap<>();
		weakMap.put(new String("WeakKey"), new String("Value for WeaklyKey"));
		
		Runnable r  = new Runnable () {
			public void run() {
				while(weakMap.containsKey("WeakKey")) {
					try {
						Thread.sleep(500);
					}catch(InterruptedException ie) {
						ie.printStackTrace();
					}
					System.out.println("Thread waiting");
					System.gc();
				}
			}
		};
		
		Thread t  = new Thread(r);
		t.start();
		System.out.println("Main Thread waiting");
		try {
			t.join();
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
