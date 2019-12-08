import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException {
		m1();
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
