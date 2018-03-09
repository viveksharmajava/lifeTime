package sample.test;

public class OverridingExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OverridingExample  or = new OverridingExample();
		A a = new B();
		System.out.println(a.a);
		or.add(new Integer(53));
		or.add((Object)new Integer(53));
		or.add( new String());
		or.add( (Object) (new String()));
		//or.add(null); mehtod ambiguity with add(Integer a) if remove add(Integer a) then it will call add(String a) method not add(Ojbect a).
		
	}

	public void add(Integer a){
		System.out.println(" Integer wala called ");
	}
	
	public void add(String a){
		System.out.println(" String wala called "+a);
	}
	public void add(Object a){
		System.out.println("Object  wala called ");
	}
	
	public void m1(Integer a){
		System.out.println(" int wala called ");
	}
	
	public void m1(Long a){
		System.out.println(" long wala called ");
	}
	
}

class A {
	int a =5;
	
}
class B extends A{
	int a =10;
	
	public void m1(){
		
	}
}