package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListMap;
public class ClassExamples {

	public static void main(String[] args) {

		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(1);
		ar.add(4);
		ar.add(5);
		ar.add(6);
		Iterator <Integer> it = ar.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			try{
				//ar.add(3);
			//it will throw concurrent modification exception.
			}catch(java.util.ConcurrentModificationException e) {
				System.out.println("java.util.ConcurrentModificationException occured!");
			//continue;
			}
		}
		//listiterator example
		System.out.println("listiterator");
		ListIterator<Integer> lit = ar.listIterator(ar.size());
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
		CopyOnWriteArrayList<Integer> car = new CopyOnWriteArrayList<>();
		car.add(1);
		car.add(4);
		System.out.println(car);
		Iterator <Integer> writableIterator = car.iterator();
		while(writableIterator.hasNext()) {
			System.out.println(writableIterator.next());
			//car.add(3);//it will not throw concurrent modification exception.
		}
		
		// ConcurrentSkipListMap
		concurrentSkipListMapTest();
		
		//Exchnger exampler 
		Exchanger <String> exchange = new Exchanger();
		Runnable r1 = () -> {
			String msg;
			try {
				msg = exchange.exchange("From r1",2,TimeUnit.SECONDS );
				System.out.println("Im in r1 and received msg"+msg);
			} catch (InterruptedException  e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (java.util.concurrent.TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		Runnable r2 = () -> {
			
			String msg;
			try {
				//Thread.sleep(432488); uncomment to see the timeout
				msg = exchange.exchange("From r2" );
				System.out.println("Im in r2 and received msg"+msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		};
		new Thread(r1).start();
		new Thread(r2).start();
	}

	 static void concurrentSkipListMapTest() {
		 ConcurrentSkipListMap<String, String> csl = new  ConcurrentSkipListMap<>();
		 csl.put("3","c");
		 csl.put("10","h");
		 csl.put("4","d");
		 csl.put("1","a");
		 csl.put("8","e");
		 csl.put("9","s");
		 
		 System.out.println(csl);
		 System.out.println(csl.ceilingKey("7"));
		 System.out.println(csl.higherKey("3"));
		 System.out.println(csl.lowerKey("3"));
	 }
}
