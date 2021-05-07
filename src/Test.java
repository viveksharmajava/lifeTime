import java.io.IOException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;
class T implements Runnable{
	public void run() {
		System.out.println("i'm done!");
	}
}

 class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
}
//    public static void main(String[] args) {
//        new ReaderThread().start();
//        number = 42;
//        ready = true;
//}
    
 }
public class Test {

	void m2() {
		System.out.println("I'm in dfsdfds");
		Runtime.getRuntime().halt(5353);;
		
	}
	@Override
	public void finalize() {
		System.out.println("Finalize called");
	}
	public static void main(String[] args) throws IOException {
		
		
		Test test = new Test();
		test.m2();
		Runtime.getRuntime().gc();
		T t = new T();
		Thread thread = new Thread(t);
		thread.setName("Runnable Thread");
		thread.start();
		
		if(!thread.isAlive()) {
			thread.start();
		}
//		ArrayList<String> arr = new ArrayList<String>();
//		arr.add("a");
//		arr.add("b");
//		arr.add(0,"c");
//		System.out.println(arr);
//		
//		int h = 2^4;
//		System.out.println(h);
//		h = h >>>16;
//		System.out.println(h);
//		System.out.println((15&545345934594l));
//		m1();
//		int a = 761623661;
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	     String inputStr = br.readLine();
//	     int len = inputStr.length();
//	     int ones = 0;
//	     int zeros = 0;
//	     if(inputStr.charAt(len-1) != '0') {
//	    	 System.out.println("false");
//	    	 return;
//	     }
//	     for(int i=0;i < len ; i++) {
//	    	int c = inputStr.charAt(i);
//	    	c = c%48;
//	    	if(c == 0) {
//	    	 zeros++;
//	    	}else {
//	    	 ones++;
//	    	}
//	    	if(ones < zeros) {
//	    		System.out.println("false");
//	    		return;
//	    	}
//	     }
//	     
//	     System.out.println("true");
//	     
	   }

  static void m1() {
	  ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
	  ArrayList<Integer> a = new ArrayList<Integer>();
	  a.add(1);
	  a.add(2);
	  a.add(3);
	  a.add(4);
	  A.add(a);
	  a = new ArrayList<Integer>();
	  a.add(5);
	  a.add(6);
	  a.add(7);
	  a.add(8);
	  A.add(a);
	  
	 a = new ArrayList<Integer>();
	  a.add(9);
	  a.add(10);
	  a.add(11);
	  a.add(12);
	 A.add(a);
	  ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < A.size(); i++) {
        B.add(new ArrayList<Integer>());
    
        for (int j = 0; j < A.get(i).size(); j++) {
            B.get(i).add(0);
        }

        for (int j = 0; j < A.get(i).size(); j++) {
            B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
        }
    }
    for (int i = 0; i < B.size(); i++) {
        for (int j = 0; j < B.get(i).size(); j++) {
                System.out.print(B.get(i).get(j) + " ");
        }
    }
	        
	}

}
