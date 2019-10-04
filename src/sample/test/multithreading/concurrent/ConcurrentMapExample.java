package sample.test.multithreading.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
//Where is multi-Threading in below example? this can be done using hashMap also rit?
public class ConcurrentMapExample {
	public static void main(String []args) {
		ConcurrentMap <String,String> concurrent = new ConcurrentHashMap<String, String>();
		concurrent.put("Name", "Vivek");
		concurrent.put("Company","Thermo");
	   System.out.print(" is vivek Name exist="+concurrent.containsValue("Vivek"));
	   System.out.print(" is vivek Name exist="+concurrent.putIfAbsent("Name", "Sharma"));
	}
	

}
