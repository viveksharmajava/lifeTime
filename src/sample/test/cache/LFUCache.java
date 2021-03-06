package sample.test.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
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
		/*
		 * Note Priority queue is arbitrary it may or may not maintain insertion order while dequeue happen
		 * hence in below case  3 is most recent  then 2 and least recent is 1 
		 * but it still removed 2 because while shifting array after remove it removed 2 instead of 1.
		 */
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(4));
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
		
		
		//Test if an object stored in collection and after that if modify the object will 
		//it also modify object state which is stored in list.
		Cache c = new Cache();
		c.Key = 2;
		c.frequency = 10;
		c.value = 2;
		HashMap<Integer,Cache> hm = new HashMap<Integer,Cache>();
		hm.put(2,c);
		LinkedList <Cache> l = new LinkedList<Cache>();
		l.add(c);
		PriorityQueue <Cache> pq = new PriorityQueue<Cache>(new Comparator<Cache>() {
			
			public int compare(Cache c1 , Cache c2) {
				return c1.frequency.compareTo(c2.frequency);
			}
		});
		pq.add(c);
		c.value = 10;
		c.frequency = 5;
		
		System.out.println(((Cache)hm.get(2)).value);
		System.out.println(l.get(0).value);
		System.out.println(pq.poll().frequency);
		
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
//	    	  Cache old = cacheMap.get(key);
//	    	  this.pq.remove(old);
//	    	  old.value = value;
//	    	  cacheMap.put(key, old);
//	    	  pq.add(old);
//	    	  
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

class LFUCacheUsingList{
	   int cap ;
	    HashMap<Integer,LFUCache.Cache> cacheMap = new HashMap<Integer,LFUCache.Cache>();
	    LinkedList cached = new LinkedList();
	    LFUCacheUsingList(int cap){
		  this.cap  = cap;
  }
} //end of LFUCacheUsingList
