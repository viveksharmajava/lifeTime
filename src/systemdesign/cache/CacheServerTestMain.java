package systemdesign.cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;


public class CacheServerTestMain{
	private  Set <String> dataSource = new HashSet<String>();
	public static void main(String []args) {
		
		CacheInvalidatePolicy invalidation = CacheInvalidatePolicy.write_throgh;
		EvictionType etype = EvictionType.FiFO;
		CacheServer cs  = new CacheServer(3, etype);
		
		cs.put(1);
		cs.put(2);
		cs.put(3);
		
		System.out.println("FiFo get Key 2="+cs.get(2));
		cs.put(4);
		System.out.println("get Key 1 after insert key 4="+cs.get(1));
		
		cs  = new CacheServer(3, EvictionType.LiFO);
		
		cs.put(1);
		cs.put(2);
		cs.put(3);
		
		System.out.println("LiFo get Key 2="+cs.get(2));
		cs.put(4);
		System.out.println("get Key 3 after insert key 4="+cs.get(3));
		
		cs  = new CacheServer(3, EvictionType.LRU);
		
		cs.put(1);
		cs.put(2);
		cs.put(3);
		
		System.out.println("LRU get Key 1="+cs.get(1));
		cs.put(4);
		System.out.println("LRU get Key 1 after insert key 4="+cs.get(1));
		System.out.println("LRU get Key 2 after insert key 4="+cs.get(2));
		
		cs  = new CacheServer(3, EvictionType.MRU);
		
		cs.put(1);
		cs.put(2);
		cs.put(3);
		
		System.out.println("MRU get Key 1="+cs.get(1));
		cs.put(4);
		System.out.println("MRU get Key 1 after insert key 4="+cs.get(1));
		System.out.println("MRU get Key 2 after insert key 4="+cs.get(2));
		
		
		cs  = new CacheServer(3, EvictionType.LFU);
		
		cs.put(1);
		cs.put(2);
		cs.put(3);
		
		System.out.println("LFU get Key 1="+cs.get(1));
		System.out.println("LFU get Key 2="+cs.get(2));
		cs.put(4);
		System.out.println("LFU get Key 1 after insert key 4="+cs.get(1));
		System.out.println("LFU get Key 2 after insert key 4="+cs.get(2));
		System.out.println("LFU get Key 3 after insert key 4="+cs.get(3));
		
	}
}

 class CacheServer {
	
	  Eviction e  ;
	 //private  int capacity;
	CacheServer(int cap,EvictionType etype) {
	//	this.capacity = cap;
		switch(etype) {
		case FiFO :
			e = new FiFo(cap);
			break;
		case LiFO :
			e = new LiFo(cap);
			break;
		case  LRU :
			e = new LRU(cap);
			break;
		case MRU :
			e= new MRU(cap);
			break;
		case LFU :
			e = new LFU(cap);
			break;
		default :
			 e = new LRU(cap);
			 break;
			
		}	
	}
	public void put(Integer k) {
		this.e.put(k);
	}
	public Integer get(Integer k) {
		return this.e.get(k);
	}
	abstract class Eviction {
		  Integer Key;
		  public  abstract void put(Integer k);
		  public abstract Integer get(Integer k);
	}
	 class FiFo extends Eviction {//use queue or list
		private int capacity;
	    LinkedList <Integer> cache = new LinkedList();
	    Set <Integer> keySet = new HashSet();
	    FiFo(int cap){
	    	this.capacity = cap;
	    }
		@Override
		public void put(Integer k) {
			if(cache.size()== capacity) {
				//cache.removeFirst();
				keySet.remove(cache.removeFirst());
			}

			cache.add(k);
			keySet.add(k);
		}

		@Override
		public Integer get(Integer k) {
			 if(keySet.contains(k)) return k;
			 return null;
		}
	 }
	 class LiFo extends Eviction {//use stack or list
			private int capacity;
		    LinkedList <Integer> cache = new LinkedList();
		    Set <Integer> keySet = new HashSet();
		    LiFo(int cap){
		    	this.capacity = cap;
		    }
			@Override
			public void put(Integer k) {
				if(keySet.contains(k)) return; //return if key already exist.
				if(cache.size()== capacity)
				 {
					//cache.removeLast();
					keySet.remove(cache.removeLast());
				 }
				cache.addLast(k);
				keySet.add(k);
			}

			@Override
			public Integer get(Integer k) {
				 if(keySet.contains(k)) return k;
				 return null;
			}
	 }
	 class LRU extends Eviction {//use queue or list
			private int capacity;
		    LinkedList <Integer> cache = new LinkedList();
		    Set <Integer> keySet = new HashSet();
		    LRU(int cap){
		    	this.capacity = cap;
		    }
			@Override
			public void put(Integer k) {
				if(keySet.contains(k)) return; //return if key already exist.
				if(cache.size()== capacity) {
					//cache.removeFirst();
					keySet.remove(cache.removeFirst());
				}
				cache.add(k);
				keySet.add(k);
			}

			@Override
			public Integer get(Integer k) {
				 if(keySet.contains(k)) {
					 cache.remove(k);
					 cache.addLast(k);
					 return k;
				 }
				 return null;
			}
	 } 
	 
	 class MRU extends Eviction {//use queue or list
			private int capacity;
		    LinkedList <Integer> cache = new LinkedList();
		    Set <Integer> keySet = new HashSet();
		    MRU(int cap){
		    	this.capacity = cap;
		    }
			@Override
			public void put(Integer k) {
				if(keySet.contains(k)) return; //return if key already exist.
				if(cache.size()== capacity) {
					keySet.remove(cache.removeFirst());
				}
				cache.add(k);
				keySet.add(k);
			}

			@Override
			public Integer get(Integer k) {
				 if(keySet.contains(k)) {
					 cache.remove(k);
					 cache.addFirst(k);
					 return k;
				 }
				 return null;
			}
	 } 
	 private class Cache{
		 Integer Key;
		 Integer frequency;
		 Cache(int key){
			 this.Key = key;
			 this.frequency = 0;
		 }
		}
	 class LFU extends Eviction {//use priority queue and HashMap
			private int capacity;
			private HashMap<Integer,Cache> cacheMap = new HashMap<Integer,Cache>();
			PriorityQueue <Cache> pq = new PriorityQueue<Cache>(new Comparator<Cache>() {
				
				public int compare(Cache c1 , Cache c2) {
					return c1.frequency.compareTo(c2.frequency);
				}
			});
			
		    LFU(int cap){
		    	this.capacity = cap;
		    }
			@Override
			public void put(Integer k) {
				if(cacheMap.containsKey(k)) return; //return if key already exist.
				if(pq.size()== capacity) {
				   cacheMap.remove(pq.poll());
				}
				Cache c = new Cache(k);
				pq.add(c);
				cacheMap.put(k, c);
			}

			@Override
			public Integer get(Integer k) {
				 if(cacheMap.containsKey(k)) {
					 Cache old = cacheMap.get(k);
			    	  this.pq.remove(old);
			    	  old.frequency = old.frequency+1;
			    	  cacheMap.put(k, old);
			    	  pq.add(old);
					 return k;
				 }
				 return null;
			}
	 } 
}		
 


enum CacheInvalidatePolicy{
	  write_throgh,write_around, write_back
}
enum EvictionType{
	FiFO,LiFO,LRU,MRU,LFU
}
