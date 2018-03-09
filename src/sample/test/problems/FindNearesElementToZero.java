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
		
		Integer [] array = new Integer []{-2 ,-5 ,-1 , 0 , 2 ,4 ,7};
		Integer pivot = 0;
		SortedSet <Integer> sortedSet  = new TreeSet<Integer>();
		for(int i= 0; i < array.length ; i++){
			
			sortedSet.add(array[i]);
		}
		
		System.out.println(sortedSet);
		Object [] sortedArray =( Object []) sortedSet.toArray();
         for(int i= 0; i < sortedArray.length ; i++){
			if(pivot == (Integer)sortedArray[i]){
				
				if( i > 0 && i <sortedArray.length-2){
					if( (Integer)sortedArray[i-1]+ (Integer)sortedArray[i+1]>0){
						System.out.println(sortedArray[i-1]);
					}else{
						
						System.out.println(sortedArray[i+1]);
					}
				}
				else if ( i <sortedArray.length-2) {
					System.out.println(sortedArray[i+1]);
				}
				
			}
		}
	}

}
