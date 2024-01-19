package designguru.warmup;

import java.util.HashMap;

public class NumberOfGoodPairs {

	public static void main(String[] args) {
           int [] input = {1,2,3,1,1,3};
		System.out.println(nubmerOfGoodPairs(input));
		int [] input2 = {1,1,1,1};
		System.out.println(nubmerOfGoodPairs(input2));
		int [] a = {1,2,3};
		System.out.println(nubmerOfGoodPairs(a));
	}
	
	private static int nubmerOfGoodPairs(int [] input) {
		int n = 0 ; 
		 HashMap <Integer, Integer>  counts = new HashMap<>();
		for(int i = 0; i  < input.length; i++) {
			if(counts.containsKey(input[i])) {
				counts.put(input[i], counts.get(input[i])+1);
			}else {
				counts.put(input[i], 1);
			}
		}
		for(Integer a : counts.values()) {
			if( a > 1) {
				n = n+ ( a*(a-1)/2);
			}
		}
		 return n;
		
	}

}
