package sample.test.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {
	
	int capacity;
	private HashMap<Integer,Cache> cacheMap = new HashMap<Integer,Cache>();
	PriorityQueue <Cache> pq = new PriorityQueue<Cache>(new Comparator<Cache>() {
		
		public int compare(Cache c1 , Cache c2) {
			return c1.frequency.compareTo(c2.frequency);
		}
	});
	
	public static void main(String[] args) {

		LFUCache lfu = new LFUCache(3);
		
		lfu.put(2,2);
		lfu.put(1,1);
		lfu.put(3,3);
		
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		
		lfu.put(4,4);
		
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(1));
//		Cache c = new Cache();
//		c.Key = 2;
//		c.frequency = 10;
//		c.value = 2;
//		lfu.pq.add(c);
//		Cache c2 = new Cache();
//		c2.Key = 4;
//		c2.frequency = 5;
//		c2.value = 4;
//		lfu.pq.add(c2);
//		
//		Cache c3 = new Cache();
//		c3.Key = 14;
//		c3.frequency = 5;
//		c3.value = 14;
//		lfu.pq.add(c3);
//		System.out.println(lfu.get(14));
//		System.out.println(lfu.pq.poll().Key);
//		System.out.println(lfu.pq.poll().Key);
	}
  
	 public LFUCache(int capacity) {
	        this.capacity = capacity;
	    }
	    
	    public Integer get(int key) {
	    	if(this.cacheMap.containsKey(key)) {
		    	  Cache old = cacheMap.get(key);
		    	  this.pq.remove(old);
		    	  old.frequency = old.frequency+1;
		    	  cacheMap.put(key, old);
		    	  pq.add(old);
		    	  return old.value;
		    	  
		    	}
	       return null; 
	    }
	    
	    public void put(int key, int value) {
	    	if(this.cacheMap.containsKey(key)) {
	    	  Cache old = cacheMap.get(key);
	    	  this.pq.remove(old);
	    	  old.value = value;
	    	  cacheMap.put(key, old);
	    	  pq.add(old);
	    	  
	    	}else {
	    	 if(cacheMap.size() == capacity) {
	    		 cacheMap.remove(pq.poll().Key);
	    	 }
	    	 Cache newCache = new Cache();
	    	 newCache.frequency = 1;
	    	 newCache.Key = key;
	    	 newCache.value = value;
	    	 cacheMap.put(key, newCache);
	    	 pq.add(newCache);
	    	}
	        
	    }
	    
	   static class Cache {
		  Integer Key;
		  Integer frequency;
		  Integer value;
	   }
}
