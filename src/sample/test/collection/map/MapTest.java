package sample.test.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	public static void main(String[] args) {
//
//		HashMap<String,String> map = new HashMap();
//		map.put(null, null);
//		map.put(null,null);
//		map.put("a",null);
//		map.put("b",null);
//		map.put(null,"c");
//		System.out.println(map);
//		
//		ConcurrentHashMap<String,String> cmap = new ConcurrentHashMap();
//	 	//cmap.put("a",null);
//		
//		
//		System.out.println(cmap);
//		
//		LinkedHashMap<String, String> lhmap  = new LinkedHashMap<>();
//		lhmap.put("a", "a");
//		lhmap.put("b", "b");
//		lhmap.put("c", "c");
//		lhmap.put("d", "d");
//		System.out.println(lhmap.values());
//		Set<Map<String, String>.Entry<String, String> > s = lhmap.entrySet();
//		for(Map<String, String>.Entry<String, String> me :s) {
//			
//		}
		 Scanner s = new Scanner(System.in);
		  System.out.print(NumberStream(s.nextLine())); 
	}
	
	  public static String NumberStream(String str) {
		    // code goes here  
		    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		    for( int i = 0 ;i<str.length(); i++){
		      int a = str.charAt(i);
		      a = a-48;
		     
		      if(hm.containsKey(a)){
		        hm.put(a, hm.get(a)+1);
		      }else{
		        hm.put(a , 1);
		      }
		    }
		  Set<Map.Entry<Integer,Integer>> set = hm.entrySet();
		   boolean s = false;
		      for(Map.Entry<Integer,Integer> me : set){
		          if(me.getKey() <= me.getValue()){
		            s = true;
		          }
		      }
		    
		    if(s) {
		      return "true";
		    }
		    else{
		      return "false";
		    } 
		    
		  }

}


