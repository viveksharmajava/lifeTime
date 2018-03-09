package sample.test.collection;

import java.util.HashMap;

public class CountDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array = {2,4,2,1,4,4};
    int duplicateRecords = countDuplicates(array);
    System.out.println("Duplicate Records ="+duplicateRecords);
	}
	static int countDuplicates(int[] numbers) {
	      Integer org = null;
	       int count=0;
	      HashMap <String ,Integer> hm = new HashMap<String,Integer>();
	        for(int i=0;i<numbers.length;i++){
	           if(hm.containsKey(new Integer(numbers[i]).toString())){
	              org=  hm.get(new Integer(numbers[i]).toString());
	              hm.put(new Integer(numbers[i]).toString(), org+1);
	           }
	            else {
	               hm .put(new Integer(numbers[i]).toString(), 1);
	              
	            }
	        }
	        for(int i=0;i<numbers.length;i++){
	        	
	        	if(hm.get(new Integer(numbers[i]).toString())>1)count++;
	        }
	       return count;
	        
	       
	        
	    }
}
