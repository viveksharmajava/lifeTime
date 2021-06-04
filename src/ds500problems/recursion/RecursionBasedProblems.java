package ds500problems.recursion;

public class RecursionBasedProblems {

	public static void main(String[] args) {
    printPattern(16, 16, -1);
    System.out.println();
    printPattern(10, 10, -1);
	}
	
	//Print a pattern without using any loop
	/*
	 * Given a number n, print following a pattern without using any loop.

	Examples : 

	Input: n = 16
	Output: 16, 11, 6, 1, -4, 1, 6, 11, 16
	
	Input: n = 10
	Output: 10, 5, 0, 5, 10
	Solution:We basically first reduce 5 one by one until we reach a negative or 0. After we reach 0 or negative,
	 we one add 5 until we reach n.
	 */
	
	 public static void printPattern(int orginal, int n, int exit ) {
		
		 System.out.print(n +"\t");
		 if ( exit == 1) return ;
		 if(exit < 0 && n > 0)
		 {
			 n = n-5;
		 }
		 else {
			 exit = 0;
			 n = n +5;
			 if ( n >= orginal ) exit = 1;
		 }
		 printPattern( orginal,  n,  exit );
		 
	 }

}
