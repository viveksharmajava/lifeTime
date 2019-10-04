package sample.test.problems.array;

import java.util.HashMap;

public class SubArrayWithSumK {

	public static void main(String[] args) {
		
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
        int sum = 23;
        simpleSolution(arr, 100);
        efficientWay(arr,23);
        efficientWay(arr,40);
        
        subArraySum(arr,8,23);
        usingMap(arr,23);
        usingMap(arr,40);
        

	}
	
	public static void simpleSolution(int input[],int sum) {
		
		int curr_sum , i , j;
		for(i = 0 ; i < input.length ; i++) {
			curr_sum = input[i];
			for(j = i+1 ; j < input.length ;j++) {
				if(curr_sum == sum) {
					int p = j-1;
					System.out.println("The sum found between index "+i+" and "+p);
					return;
				}
				if(curr_sum > sum || j == input.length) {
					
				 break;
				}
				curr_sum += input[j];
			}
			
			
		}
		System.out.println("No subarray has sum ="+sum);
	}

public static void usingMap(int []input , int sum) {

		HashMap <Integer, Integer> hm =  new HashMap<Integer,Integer>();
		int curr_sum = 0 , i , start= 0,end=-1;
		for(i = 0 ; i < input.length ; i++) {
			curr_sum += input[i];
			if(curr_sum - sum ==0) {
				start = 0;
				end = i;
				break;
			}
          if(hm.containsKey(curr_sum- sum)) {
        	  start = hm.get(curr_sum-sum)+1;
        	  end = i;
        	  break;
          }
          hm.put(curr_sum,i);
		}
		if(end == -1) {
			
			System.out.println("No subarray has sum ="+sum);
		}else {
			System.out.println("The sum found between index "+start+" and "+end);
			
		}
		
}

public static void subArraySum(int[] arr, int n, int sum) { 
    //cur_sum to keep track of cummulative sum till that point 
    int cur_sum = 0; 
    int start = 0; 
    int end = -1; 
    HashMap<Integer, Integer> hashMap = new HashMap<>(); 

    for (int i = 0; i < n; i++) { 
        cur_sum = cur_sum + arr[i]; 
        //check whether cur_sum - sum = 0, if 0 it means 
        //the sub array is starting from index 0- so stop 
        if (cur_sum - sum == 0) { 
            start = 0; 
            end = i; 
            break; 
        } 
        //if hashMap already has the value, means we already  
        // have subarray with the sum - so stop 
        if (hashMap.containsKey(cur_sum - sum)) { 
            start = hashMap.get(cur_sum - sum) + 1; 
            end = i; 
            break; 
        } 
        //if value is not present then add to hashmap 
        hashMap.put(cur_sum, i); 

    } 
    // if end is -1 : means we have reached end without the sum 
    if (end == -1) { 
        System.out.println("No subarray with given sum exists"); 
    } else { 
        System.out.println("Sum found between indexes " 
                        + start + " to " + end); 
    } 

}
	public static void efficientWay(int []input , int sum) {

		
		int curr_sum = input[0] , i , start= 0;
		for(i = 1 ; i < input.length ; i++) {
			while(curr_sum >  sum  && start < i)
			{
				curr_sum = curr_sum - input[start];
			    start++;
			}
			if(curr_sum == sum) {
				System.out.println("The sum found between index "+start+" and "+(i-1));
			    return;
			}
			curr_sum += input[i];
			
			
		}
		System.out.println("No subarray has sum ="+sum);
	
	}
}
