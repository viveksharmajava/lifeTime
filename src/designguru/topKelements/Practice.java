package designguru.topKelements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Practice {

	public static void main(String[] args) {

		 int [] ropes = {1, 3, 11, 5};
		 System.out.println(connectRope(ropes));
		 int  [] maxdistinct = {7, 3, 5, 8, 5, 3, 3};
		 System.out.println(maxdistinctafterKRemove(maxdistinct,2));
		int [ ] sumofelements = {1, 3, 12, 5, 15, 11};
		int K1=3, K2=6;
		System.out.println("SumofElementsk1k2(arr, k1, k2)\n ");
		
		System.out.println(SumofElementsk1k2(sumofelements, K1, K2));

		System.out.println("rearrange");
		System.out.println(rearrange("aappp"));
		System.out.println(rearrange("Programming"));
		System.out.println(rearrange("aapa"));
		
		System.out.println("\n kDistanceApart \n ");
		System.out.println(kDistanceApart("mmpp",2));
		System.out.println(kDistanceApart("Programming",3));
		System.out.println(kDistanceApart("aab",3));

	}
	public static int connectRope(int [] ropes) {
		int cost= 0;
		PriorityQueue <Integer> q = new PriorityQueue<>();
	    for(int i = 0 ; i < ropes.length ; i++) {
	    	q.add(ropes[i]);
	    }
	    int sum=0;
	    while(q.size() > 1) {
	    	sum = q.poll() + q.poll();
	    	cost = cost + sum;
	    	q.add(sum);
	    }
		return cost;
	}
    public static int maxdistinctafterKRemove(int [] arr, int k) {
    HashMap <Integer,Integer> map = new HashMap();
		 
		 for(int i = 0 ; i < arr.length; i++) {
			 map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		 }
		int count= 0;
		PriorityQueue <Integer> q = new PriorityQueue<>();
	    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	    	if(entry.getValue() == 1) count++;
	    	else q.add(entry.getValue());
	    }
	    while(k > 0  && !q.isEmpty()) {
	    	int freq = q.poll();
	    	if(freq == 1)count++;
	    	else{
	    		
	    		freq--;
	    		k--;
	    		q.add(freq);
	    	}
	    }
		return count;
	
    }
    
    public static int SumofElementsk1k2(int [] arr, int k1, int k2) {
    	

        HashMap <Integer,Integer> map = new HashMap();
    		 

   		int sum= 0;
    		PriorityQueue <Integer> q = new PriorityQueue<>();
    	    for(int i=0; i < arr.length; i++) {
    	    	//if(entry.getValue() == 1) count++;
    	    	 q.add(arr[i]);
    	    }
    	    System.out.println(" queue =" +q);
    	    int m1 = k1 > k2 ? k2 :k1;
    	    int m2 = k1 > k2 ? k1 : k2;
    	    int i = 0;
    	    while( !q.isEmpty() && i < m1) {
    	    	 q.poll();
    	    	 i++;
    	    	 
    	    }
    	    int k = m2-m1-1;
    	    while( !q.isEmpty() && k > 0) {
    	    	sum = sum + q.poll();
    	    	k--;
   	    	 
   	    }
    		return sum;
    	
    }
    
    public static String rearrange(String str) {
     HashMap <Character , Integer> map = new HashMap<>();
  	  for(int i = 0 ; i < str.length(); i++) {
  		  map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
  	  }
  	 PriorityQueue <Key> queue = new PriorityQueue<>();
	  for(Map.Entry<Character, Integer>entry : map.entrySet()){
		  queue.add(new Key(entry.getValue(),entry.getKey()));
	  }
	  
	  Key prev = new Key(-1, '#');
	  StringBuffer sb = new StringBuffer();
	  while(queue.size() > 0) {
		  Key k = queue.poll();
		  sb.append(k.ch);
		  if(prev.freq > 0) queue.add(prev);
		  k.freq = k.freq -1;
		  prev= k;
	  }
	  if(sb.length() != str.length()) return "Not Possible";
	  return sb.toString();
    }
    
    public static String kDistanceApart(String str,int k) {
        HashMap <Character , Integer> map = new HashMap<>();
     	  for(int i = 0 ; i < str.length(); i++) {
     		  map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
     	  }
     	 PriorityQueue <Key> queue = new PriorityQueue<>();
   	  for(Map.Entry<Character, Integer>entry : map.entrySet()){
   		  queue.add(new Key(entry.getValue(),entry.getKey()));
   	  }
   	  
   	  char [] result = new char[str.length()];
   	  Arrays.fill(result, '\0');
   	  
   	  while(queue.size() != 0) {
   		 int p = 0;//find next 
   		 Key key = queue.poll();
   		 while(result[p] !='\0') {
   			 p++;
   		 }
   		
   		 for(int i = 0 ; i < key.freq ; i++) {
   			if((p + i*k) >= result.length ) {
   				return "Not Possible";
   			}
   			 result[p + i*k] = key.ch;
   		 }
   	  }
   	  return new String(result);
       }
    
    
}
