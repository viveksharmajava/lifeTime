package sample.test.problems.array;

public class CountSubArrayStartAndEndsWith1 {

	public static void main(String[] args) {

		int input[] = {0,0,1,0,0,1,0,1,0,0,0,1,0,1};
		System.out.println(subArrayCounts(input));
	}
	
	static int subArrayCounts(int [] input) {
		
		int count = 0,  start=-1;
		for(int i = 0 ; i< input.length; i++) {
			if(input[i] == 1) {
				if(start == -1) start=i;
				else {
					count+=1;
				}
			}
		}
		return count*(count+1)/2;
		
	}

}
