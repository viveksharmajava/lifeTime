package sample.test.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDuplicateFromArrayList {

	public static void main(String[] args) {
	   List <String> list = new ArrayList<String>();
	  
	   list.add("vivek");
	   list.add("vivek");
	   list.add("Jay");
	   
	   System.out.println(list);
	   Collections.sort(list);
	   // not  working
	   System.out.println(list);
	}

}
