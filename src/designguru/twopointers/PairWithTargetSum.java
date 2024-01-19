package designguru.twopointers;
/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/638ca0aa5b41522e8a2e3395
 * Input: [1, 2, 3, 4, 6], target=6
   Output: [1, 3]
   Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */
public class PairWithTargetSum {

	public static void main(String[] args) {

		int []arr = {1, 2, 3, 4, 6};
		findPairWithTargetSum(arr,6);
		int []arr2 = {2, 5, 9, 11};
		findPairWithTargetSum(arr2,11);
	}

	public  static void findPairWithTargetSum(int [] input , int sum) {
		
		int start=0,  end = input.length-1;
		while(start < end) {
			int s = input[start]+input[end];
			if(sum == s)
		     {
				System.out.println("Pair is at index =["+start+","+end+"]");
		        start++;
		        end--;
		     }
			else if (s > sum) end--;
			else  start++;
		}
	}
}
