package sample.test.problems.array;

public class ReturnMaxSumSubArray {

	/**
	 * @param args you have input array with positive negative number your need to return sub array which is having max sum in the given array
	 *  example input: 1 ,-2 ,3,4 
	 *          output :3,4 
	 *          input : 3,4,6,-4,3,15,-1,18
	 *          output: ???? whole above array
	 *    
	 */
	public static void main(String[] args) {
           
		int [] input = {3,4,6,-4,3,-15,-1,18}; //it should be 18
		int [] output = maxSumSubArray(input);
		for(int i=0;i<output.length;i++){
			System.out.print(output[i]+"\t");
		}
		
	}
	
	static int [] maxSumSubArray(int [] input){
		int s1 ,s2 ,end;
		s1 = s2 = end =0;
		int sum,tempS = 0;
		sum = tempS;
		for(int i=0; i<input.length; i++){
			if((tempS+input[i])<=0){
				tempS = 0;
				s2 = i+1;
			}else{
				tempS += input[i];
				end = i;
			}
			
			if( sum < tempS){
				sum = tempS;
				if( s1 < s2) s1 = s2;
			}
		}
	int outSize = end-s1+1;
	int [] out = new int [end-s1+1];	
	for( int i =0;i <outSize ;i++){
		out[i] = input[s1++];
		//System.out.println(out[i] );
	}
	return out;
	}

}
