package sample.test;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseSignlyLinkedList {

	 /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList <String> input = new LinkedList<String>();
		input.add("1");
		input.add("2");
		input.add("3");
		input.add("4");
		LinkedList <String> output = new LinkedList<String>();
		
		Iterator <String> it = input.iterator();
		while(it.hasNext()){
			output.addFirst(it.next());
		}
      System.out.println("input="+input+"\n output ="+output);
	}

}
