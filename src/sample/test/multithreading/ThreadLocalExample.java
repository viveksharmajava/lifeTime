package sample.test.multithreading;

import java.util.Date;

//Why this does not work with person class
public class ThreadLocalExample {
	
	private static final ThreadLocal<Date> localDate = new ThreadLocal<Date>() {
		 protected Date initialValue() {
			return new Date();
		};
	};
	ThreadLocalExample(Date d){
		localDate.set(d);
	}
	public Date getDate(){
		return localDate.get();
	}
	public  void setDate(Date d){
		localDate.set(d);
	}
	
	
	public static void main(String []args){
		Person p = new Person("Vivek", "33");
		ThreadLocalExample threadLocal = new ThreadLocalExample(new Date());
		System.out.println(ThreadLocalExample.localDate.get());
		System.out.println(threadLocal.getDate());
		Thread1 t1  = new Thread1(threadLocal,4);
		Thread1 t2  = new Thread1(threadLocal,8);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
		System.out.println(threadLocal.getDate());
		
	}
}


class Thread1  extends Thread{
	ThreadLocalExample tl ;
	private int m ;
	Thread1(ThreadLocalExample threadLocal,int month){
		this.tl = threadLocal;
		m = month;
	}
	public void run(){
		
		System.out.println("I'm Thread "+Thread.currentThread().getName()+"\t and default date time is ="+tl.getDate());
		Date nd = new Date();
		nd.setMonth(m);
		tl.setDate(nd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("I'm Thread "+Thread.currentThread().getName()+"\t and after changing date month is ="+tl.getDate());
	}
}

class Person{
	String name;
	String age;
	Person(String n, String a){
		this.name = n;
		this.age = a;
	}
	
}

