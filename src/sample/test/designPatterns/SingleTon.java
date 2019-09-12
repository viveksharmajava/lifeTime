package sample.test.designPatterns;

public class SingleTon {

	
	private SingleTon(){
		System.out.println("singleton called");
	}
	private static volatile SingleTon singleTon =null;
	public static void main(String[] args) {
		SingleTon.getSingleTonObject();
	}
 
	/*
	 * This will create extra overhead by making full method synchronized
	 * so for each call it will aquire lock on full mehod.
	 */
	public static synchronized  SingleTon getSingleTonObject(){
		if(singleTon == null){
			singleTon = new SingleTon();
		}
		return singleTon;
	}
	
	/*
	 * 
		This will bring us to double checked locking pattern, where only critical section of code is locked. Programmer call it double checked locking because there are two checks for _instance == null, one without locking and other with locking (inside synchronized) block.
		Here is how double checked locking looks like in Java :
		Read more: https://javarevisited.blogspot.com/2014/05/double-checked-locking-on-singleton-in-java.html#ixzz5zIcfUsuY
	    Note: 
        On surface this method looks perfect, as you only need to pay price for synchronized block one time, but it still broken, 
        until you make _instance variable volatile.
        Without volatile modifier it's possible for another thread in Java to see half initialized
        state of _instance variable, but with volatile variable guaranteeing happens-before relationship,
        all the write will happen on volatile _instance before any read of _instance variable.
	 */
	public static SingleTon getSingleTonDC() {
		if(singleTon == null){  //Single Check 
			synchronized(SingleTon.class){ 
			   if(singleTon == null)  //Double check 
				{
				   singleTon = new SingleTon();
				}
			}
		}
		return singleTon;
	}
	
}
