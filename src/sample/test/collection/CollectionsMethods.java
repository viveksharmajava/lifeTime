package sample.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsMethods {

	public static void main(String[] args) {

		ArrayList<String>  aList =  new ArrayList<String>();
		ArrayList<String>  aList2 =  new ArrayList<String>();
		aList.add("a");
		aList.add("c");
		aList.add("d");
		aList.add("b");
	    System.out.println("before any operations ="+aList);
	    
	    Collections.sort(aList);
	    System.out.println("after Collections.sort()="+aList);
	    
	    aList2.add("e");
	    aList2.add("e");
	    aList2.add("e");
	    aList2.add("e");
	    aList2.add("e");
	    Collections.copy(aList2, aList); //Note destination list The destination list must be at least as long as the source list. If it is longer, the remaining elements in the destination list are unaffected. 
	    System.out.println("after Collections.copy() from aList to aList2="+aList2);
	    
	    Collections.addAll(aList, "e","f");
	    System.out.println("after Collections.addAll()="+aList);
	    
	    int index = Collections.binarySearch(aList, "e");
	    System.out.println("after Collections.binarySearch() index="+index);
	    
	   List <String> immutableList = Collections.unmodifiableList(aList);
	 //  immutableList.add("g");
	   
	   Collections.swap(aList, 1, 5);
	   System.out.println("after Collections.swap(aList, 1, 5)="+aList);
	   Collections.synchronizedList(aList);
	    
	    
	    
	}

}
