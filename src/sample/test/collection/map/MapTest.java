package sample.test.collection.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {

	public static void main(String[] args) {

		HashMap<String,String> map = new HashMap();
		map.put(null, null);
		map.put(null,null);
		map.put("a",null);
		map.put("b",null);
		map.put(null,"c");
		System.out.println(map);
		
		ConcurrentHashMap<String,String> cmap = new ConcurrentHashMap();
		cmap.put("a",null);
		
		
		System.out.println(cmap);
		
		
		
	}

}
