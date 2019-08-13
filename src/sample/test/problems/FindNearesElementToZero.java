package sample.test.problems;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class FindNearesElementToZero {

	/**
	 * @param args an Array having  positive and negative number  we need to find nearest element to 0
	 * for example -2 ,-5 ,-1 , 0 , 2 ,4 ,7   output will be -1 
	 *         -3 ,-5 , , 0 , 2 ,4 ,7   output will be 2
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Approach :1  
		   (a) Sort given array and then find the closer to zero
		   
		 Approach : 2
		   (a) traverse array   and closer element to zero in temp variable 
		  */ 
		
		approach1();
	
	}
	
	public static void approach1() {
		int [] array = new int [] //{-3 ,-5 ,-8 , 1 , 2 ,4 ,7};
				{-2 ,-5 ,-1 , 5 , 2 ,4 ,7};
		Integer closer ;
		SortedSet <Integer> sortedSet  = new TreeSet<Integer>();
		for(int i= 0; i < array.length ; i++){
			
			sortedSet.add(array[i]);
		}
		System.out.println(sortedSet);
		
		Object [] sortedArray =( Object []) sortedSet.toArray();
		closer =  (Integer)sortedArray[0];
		int temp;
         for(int i= 1; i < sortedArray.length ; i++){
        	 
			temp = (Integer) sortedArray[i];
			//temp = Math.abs(temp);
			if(Math.abs(closer) > Math.abs(temp)) {
				closer = temp;
			}
		}
         
         System.out.println("The Closer element is ="+closer);
	}

}
