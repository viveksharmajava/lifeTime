package sample.test.problems.array;

import java.util.LinkedList;

/**
 * 
 * @author viveksharma
 * 
 * Problem statment : you have given an string contains only 0,1  you need to return substrings which starts from 1 and ends with 0 with no repeated substring 
 *   All substring must be unique.
 *   
 *   For Example : 0011001
 *   Output : 110,1100,10,100
 *
 */

public class SubArrayStartWith_1_AndEndWith_0 {

	public static void main(String[] args) {
		int input[] = {0,0,1,0,0,1,0,1,0,0,0,1,0,1};
	}
	
	public void subArray(int [] input) {
		
		LinkedList<Integer> ones = new LinkedList<Integer>();
		LinkedList<Integer> zeros = new LinkedList<Integer>();
		int i = 0 ,j = input.length-1;	
		//remove leading 0's and trailing 1's but it's not required for below approach
		//while(input[i++]==0) 
		//while(input[j--]==1) ;
		for( i=0; i <input.length ; i++) {
			if(input[i] == 1) {
				ones.add(0, i);
			}
			else {
				zeros.add(0, i);
			}
		}
		String sb = "";
		int zero;
		for(i = 0 ; i < zeros.size(); i++) {
		  	
			zero = zeros.get(i);
			for(j = ones.getFirst() ; j>=0 ; j--) {
			  if( zero < j) continue;
			  
			}
				
		}
		
		
		
		
	}

}
