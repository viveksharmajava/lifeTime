package sample.test.collection;

import java.util.HashMap;

public class ObjectReferenceInMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1= "vivek";
		HashMap<String ,String> hm = new HashMap<String,String>();
		hm.put(s1, "Thermo");
		s1=null;
		System.out.println(hm.get("vivek"));

	}

}
