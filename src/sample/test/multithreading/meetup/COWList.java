package sample.test.multithreading.meetup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWList {
public static void main(String []args) {
	
	ArrayList<String> arr = new ArrayList<String>();
	arr.add("a");
	arr.add("b");
	arr.add(0,"c");
	System.out.println(arr);
List<String> aList = new CopyOnWriteArrayList<String>();
aList.add("one");
aList.add("two");
aList.add("three");
Iterator listIter = aList.iterator();
while(listIter.hasNext()) {
System.out.println(listIter.next());
aList.add("four");
}
listIter = aList.iterator();
while(listIter.hasNext()) {
System.out.println(listIter.next());
}
}
}

