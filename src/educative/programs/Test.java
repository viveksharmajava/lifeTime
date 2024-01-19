package educative.programs;

import java.util.*;
import java.util.concurrent.Semaphore;

public class Test {
 public static void main(String [] args) {
	 HashMap m = new HashMap();
	 m.put(null,"abc");
	 System.out.println(m.get(null));
	 m.put(null,null);
	 
	 Hashtable mt = new Hashtable();
	 mt.put(null,"efg");
	 System.out.println(mt.get(null));
	
	 
	 Semaphore   s = new Semaphore(0);
	System.out.println(s.availablePermits());
	 s.release();
	 s.release();
	 System.out.println(s.availablePermits());
 }
}
