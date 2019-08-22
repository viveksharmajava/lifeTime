package sample.test.problems.array;

public class ArrangeNumbers {

	/**
	 * ,@param args an array having element like  0,1,0,0,0,1,1,0   arrange all 0 from left and all 1 from right
	 * so the out put should be 0,0,0,0,0 ,1,1,1
	 */
	public static void main(String[] args) {

		Integer []input ={1, 1, 0,1,0,1,1,0,1};
		input = reArrangeArray(input,0,input.length-1);
		for(int i =0 ;i < input.length ;i++){
			System.out.println(i+" ="+ input[i]);
		}
	}

	static Integer[] reArrangeArray(Integer []inputArray, int start ,int end){
		
		if (start == end || start > end)
		{
			return inputArray;
		}
		while(inputArray[start] != 1) {
			start++;
		}
		while(inputArray[end] != 0){
			end--;
		}
		
		if( start < end){
			swap(inputArray , start , end);
			start++;
			end --;
			
		}
		
	  reArrangeArray(inputArray,  start , end);
	
	return inputArray;
	}
	
	private static void swap(Integer []inputArray, int a ,int b ){
		 int temp ;
		temp = inputArray[a];
		inputArray[a] = inputArray[b];
		inputArray[b] = temp;
	}
}
