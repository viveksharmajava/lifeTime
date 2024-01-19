package javabasics;

import java.io.FileNotFoundException;

public class SuperSubClassAndModifier {

	public static void main(String[] args) {

		 A a = new B();
		 a.call();
		 StringBuffer  s = new StringBuffer("Hello ");
		 a.m1(s);
		 System.out.println(s);
		 
		 String str = new String("abc");
		 
		 C2 c = new C2();
		// c.m1(null);
	}

	
  
}
class A{

	volatile static int x = 10;
	final  int a;
	private void printA() {
		System.out.println("A = "+a);
		System.out.println("A.x = "+A.x);
	}
	void call() {
		printA();
	}
	void m1(StringBuffer s) {
		System.out.println(s);
		s.append("in m1");
	}
	A(){
		this.a = 2;
	}
}

class B extends A{
	 int a = 3;
	private void printA() {
		System.out.println("B = "+a);
		System.out.println("A.x = "+A.x);
	}
	void call() {
		printA();
	}
}
 interface  i{
	 void m5() throws FileNotFoundException ;
 }
 abstract class c {
  abstract void m1();
}
 
 class D extends c implements i{
	 void m1() {
		 
	 }
	public  void m5() throws ArithmeticException {
		 
	 }
 }
 abstract class e extends D{
	abstract void m2(); 
 }
 
 
 
 class C1{
	 
//	 void m1(String s) {
//		 System.out.println(s); 
//	  
//      }
//	 void m1(Integer a) {
//		 System.out.println(a);
//	 }
 }
 
 class C2 extends C1{
	 void m1(String s) {
		 System.out.println("C2 "+s); 
	  
      }
	 void m1(Object s) {
		 System.out.println("C2 Ojbect "+s); 
	  
      }
	 void m1(Number s) {
		 System.out.println("C2 Integer "+s); 
	  
      }
 }
 