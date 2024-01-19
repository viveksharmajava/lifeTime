package ds500problems.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 *   
 *   
 */
public class ClimibingStairs {

	public static void main(String[] args) {
		System.out.println("3 stairs stair ="+climibingStair(3));
//		System.out.println("4 stairs stair ="+climibingStair(4));
//		System.out.println("5 stairs stair ="+climibingStair(5));
//	
//	    //without recursion
//		climibingStairNORecursion(3);
//		climibingStairNORecursion(4);
//		climibingStairNORecursion(5);
//		
//		//user can climb 3 stairs 1,2,3
//		System.out.println("When user can climb 3 stairs 1,2,3");
//		System.out.println(climibingStair3Steps(3));
//		System.out.println(climibingStair3Steps(2));
		//System.out.println(climibingStair3Steps(3));
		System.out.println(climibingStair3Steps(13));
		//System.out.println("Optimized k steps ="+climibingStairKStepsOptimized(3, 2));
		
		System.out.println("Optimized k steps ="+climibingStairKStepsOptimized(13, 3));
		boolean [] red = { true ,false ,true ,true , false , false,false };
	  System.out.println("Red marked stairs climbing ="+climibingStairKStepsWithRedMarkedStaires(7,3,red));
	
	 System.out.println("Climibing paid stairs");
	 int stairs  = 3;
	 int []cost = {3,2,4};
	 System.out.println("Minimum Cost to reach to top ="+paidStairCaseMinCost(stairs, cost));
	 System.out.println("Minimum cost and reverse path to reach to top ="+paidStairCaseMinCostReversePath(stairs, cost));
	 
	 //matrix 
	 System.out.println("Matrix problems");
	 System.out.println(numberOfPaths(2,3));
	 System.out.println(numberOfPaths(2,2));
	 //numberOfPathsWithObstacles
	 

	 System.out.println("maximumCoinRobotCanCollectInMatrix=");
	 int [][] coin1 =  {{0,2,2,1},{3,1,1,1},{4,4,2,0}};//output shoud be 15 = 0 , 3 ,4, 4,2(13 total)
	 System.out.println("maximumCoinRobotCanCollectInMatrix ="+maximumCoinRobotCanCollectInMatrix(3,4,coin1));
	 int [][] coin2 =  {{0,2,2,50},{3,1,1,100},{4,4,2,0}};//154
	 System.out.println("maximumCoinRobotCanCollectInMatrix ="+maximumCoinRobotCanCollectInMatrix(3,4,coin2));
	
	 
	}
 /*
  *  Problem Statement:
  *  you are climbing a stair case , it takes n stairs(stair) to reach to top
 *   each time you can climb either 1 or 2 stairs.
 *   total how many ways you can climb to the top.
  * Framework for solving DP problem.

	1. Define the objective of function.
	    f(i) is the number of distinct  way to reach to ith stair.
	2. Identify base cases.
	   f(0) = 1(when you are at floor no need to do anything
	   f(1) = 1 ( to climb to stair 1 you can climb only 1 step)
	3. write down the recurrence relation for the optimized objective fucntion.
	   f(n) = f(n-1) + f(n-2)
	4. what is the order of execution.
	    bottom up
	5. where to look for the answer.
	   f(n).
 
  */

   public static int climibingStair(int stairs) {
	   
	   if( stairs == 0 || stairs == 1) return 1;
	   
	   return climibingStair(stairs-1)+ climibingStair(stairs-2);
	   
   }
   
   //without using recursion
public static void climibingStairNORecursion(int stairs) {
	   
	  int [] dp = new int[stairs+1];
	  //base cases
	  dp[0] = 1;
	  dp[1] = 1;
	  for(int i = 2 ; i <= stairs ; i++) {
		  dp[i] = dp[i-1] +dp[i-2];
	  }
	   
	  System.out.println("Number of different way to climb to stairs "+stairs+"\tare "+dp[stairs]); 
     //we can solve it without using array also.
	 int prev_1 = 1; // step 1
	 int prev_2 =1; // for step 0
	 if( stairs  <= 1) {
		 System.out.println(" total number of way is "+1);
	 }
	 int total = 0;
	 for(int i = 2 ; i <= stairs ; i++) {
		  total = prev_1 + prev_2;
		  prev_2 = prev_1;
		  prev_1 = total;
		  
	  }
	 System.out.println("Number of different ways without extra array  "+stairs+"\tare "+total); 
	}
	/*
	 *  Problem Statement:
	 *  you are climbing a stair case , it takes n stairs(stair) to reach to top
	*   each time you can climb either 1 or 2  or 3 stairs.
	*   total how many ways you can climb to the top.
	 * Framework for solving DP problem.
	
		1. Define the objective of function.
		    f(i) is the number of distinct  way to reach to ith stair.
		2. Identify base cases.
		   f(0) = 1(when you are at floor no need to do anything
		   f(1) = 1 ( to climb to stair 1 you can climb only 1 step)
		   f(2) = 2 ( to climb up to stair 2 , can use 1,1 or 2  stairs to reach at stair 2).
		3. write down the recurrence relation for the optimized objective fucntion.
		   f(n) = f(n-1) + f(n-2)+ f(n-3)
		4. what is the order of execution.
		    bottom up
		5. where to look for the answer.
		   f(n).
	
	 */

public static int climibingStair3Steps(int stairs) {
	   if( stairs == 0 || stairs == 1) return 1;
	   if( stairs == 2) return 2;
	   return climibingStair3Steps(stairs-1)+ climibingStair3Steps(stairs-2) + climibingStair3Steps(stairs-3);
}

/*
 *  Problem Statement:
 *  you are climbing a stair case , it takes n stairs(stair) to reach to top
 *  each time you can climb up to K stairs.
 *  total how many ways you can climb to the top.
 * Framework for solving DP problem.

	1. Define the objective of function.
	    f(i) is the number of distinct  way to reach to ith stair.
	2. Identify base cases.
	   f(0) = 1(when you are at floor no need to do anything
	   f(1) = 1 ( to climb to stair 1 you can climb only 1 step)
	    
	3. Write down the recurrence relation for the optimized objective fucntion.
	   f(n) = f(n-1) + f(n-2)+ f(n-3)+...... +f(n-k)
	4. What is the order of execution.
	    bottom up
	5. Where to look for the answer.
	   f(n).
	6. time complexity O(n*k)
	7. space complexity O(n)

 */
public static int climibingStairKSteps(int stairs, int k) {
	if ( stairs ==0 || stairs == 1) return 1;
	int [] dp = new int[stairs+1]; //we can optimize it by just keeping it of size dp[k] then
	dp[0] = 1;
	dp[1] = 1;
	for(int i = 2 ; i <= stairs ; i++) {
		//dp[i] = dp[i-1] + dp[i-2]+dp[i-3]+ .... dp[i-k]
		//we can convert above into below loop
		
		for(int j= 1 ; j <=k ; j++) {
			if(i-j < 0) break;
			dp[i] += dp[i-j];
		}
	}
	return dp[stairs];
	
}

//we can optimize above problem, need to maintain array only of size k,
public static int climibingStairKStepsOptimized(int stairs, int k) {
	if ( stairs ==0 || stairs == 1) return 1;
	int [] dp = new int[k]; 
	dp[0] = 1;
	//dp[1] = 1;
	for(int i = 1 ; i <= stairs ; i++) {
		//dp[i] = dp[i-1] + dp[i-2]+dp[i-3]+ .... dp[i-k]
		//we can convert above into below loop
		
		for(int j= 1 ; j <k ; j++) {
			if(i-j < 0 ) break;
			dp[i%k] += dp[(i-j)%k];
		}
	}
	return dp[stairs%k];
}

/*
 *  Problem Statement:
 *  you are climbing a stair case , it takes n stairs(stair) to reach to top
 *  each time you can climb up to K stairs.
 *  but you can not climb/put step on red marked stair.
 *  Total how many ways you can climb to the top.
 *  Framework for solving DP problem.

	1. Define the objective of function.
	   f(i) is the number of distinct  way to reach to ith stair.
	2. Identify base cases.
	   f(0) = 1(when you are at floor no need to do anything
	   f(r) = 0 , 0 steps to climb a stair which is marked as red.
	    
	3. Write down the recurrence relation for the optimized objective fucntion.
	   f(n) = f(n-1) + f(n-2)+ f(n-3)+...... +f(n-k)
	4. What is the order of execution.
	    bottom up
	5. Where to look for the answer.
	   f(n).
	6. time complexity O(n*k)
	7. space complexity O(k)

 */
 public static int climibingStairKStepsWithRedMarkedStaires(int stairs, int k,boolean [] redMarked) {
	int [] dp = new int[k]; 
	dp[0] = 1;
	for(int i = 1 ; i <= stairs ; i++) {
		//dp[i] = dp[i-1] + dp[i-2]+dp[i-3]+ .... dp[i-k]
		//we can convert above into below loop
		
		for(int j= 1 ; j <k ; j++) {
			if(i-j < 0 ) break;
			if(redMarked[i-1]) {//stair is marked as red
				dp[i%k]= 0;
			}
			else{
				dp[i%k] += dp[(i-j)%k];
			}
		}
	}
	return dp[stairs%k];
}

 /*
  * Paid staircase 
  * 
  * Problem statement:
  * You are climbing a paid stairs it takes n steps to reach to the top.
  * pay[i] contains the cost to  reach to ith stair.
  * you can climb max 1 or 2 stairs/steps at a time .
  * what is the minimum cost you have to pay to reach to top of the staircase.
  * 
  * 1. Define the objective of function.
	   f(i) is the number of distinct  way to reach to ith stair.
	2. Identify base cases.
	   f(0) = 0(when you are at floor no need to do anything
	     
	3. Write down the recurrence relation for the optimized objective fucntion.
	   f(n) = pay(n) + Min(fun(n-1),f(n-2)) // since we can climb at a time either 1 or 2 steps.
	4. What is the order of execution.
	    bottom up
	5. Where to look for the answer.
	   f(n).
  */
 
 public static int paidStairCaseMinCost(int stairs,int [] cost) {
	 int [] dp  = new int [stairs+1];
	 dp[0] = 0;
	 dp[1] = cost[0];
	 int c = 0;
	 for(int i = 2 ; i <= stairs ; i++) {
		 dp[i] = cost[++c] + Math.min(dp[i-1], dp[i-2]);
	 }
	 return dp[stairs];
	 
 }
 
 public static int paidStairCaseMinCostReversePath(int stairs,int [] cost) {
	 int [] dp  = new int [stairs+1];
	 dp[0] = 0;
	 dp[1] = cost[0];
	 int c = 0,f=0;
	 int []from = new int [stairs+1];
	 from[1] = 0;
	 for(int i = 2 ; i <= stairs ; i++) {
		 dp[i] = cost[++c] + Math.min(dp[i-1], dp[i-2]);
		 if( dp[i-1] < dp[i-2]) {
			 from [i] = i-1;
		 }
		 else {
			 from [i] = i-2;
		 }
	 }
	// from[stairs-1] = stairs;
	 ArrayList<Integer> reversePath = new ArrayList<>();
	 int current = stairs;
	 reversePath.add(current);
	 //current = current-1; //since array index start from 0
	 while(current > 0) {
		  f = from[current];
		 reversePath.add(f);
		 current = f;
	 }
	 System.out.println("reversePath = "+reversePath);
	 return dp[stairs];
	 
 }
 
    /*
	 * Count all possible paths from top left to bottom right 
	 * you can take only one step to right or bottom 
	 * of a mXn matrix
	 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	 *Input :  m = 2, n = 2;
		Output : 2
		There are two paths
		(0, 0) -> (0, 1) -> (1, 1)
		(0, 0) -> (1, 0) -> (1, 1)
		
		Input :  m = 2, n = 3;
		Output : 3
		There are three paths
		(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
		(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
		(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
	 */
	
  public static int numberOfPaths(int m , int n) {
	 int dp[][] = new  int[m][n];
	 dp[0][0] = 1;
	 for(int i = 0 ; i < m ; i++) {
		 for(int j = 0; j < n ; j++) {
			 if( i > 0 && j > 0) {
				 dp[i][j] = dp[i-1][j] + dp[i][j-1];
			 }
			 else if( i > 0) {
				 dp[i][j] = dp[i-1][j];
			 }
			 else if( j > 0) {
				 dp[i][j] = dp[i][j-1];
			 }
		 }
	 }
	 return dp[m-1][n-1];
 }
  
  /*
 	 * Count all possible paths from top left to bottom right  of a mXn matrix
 	 * you can take only one step to right or bottom , 
 	 * you can not continue of you found obstacles in the path.
 	 * 
 	 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 	 *Input :  m = 2, n = 2; // obstacles denoted by 1
 	 *   [0, 1]
 	 *   [0,0]
 		Output : 1
 		There are two paths but on has obstacle a[0][1] =1
 		(0, 0) -> (0, 1) ->X
 		(0, 0) -> (0, 0) -> (1, 0) = 1 PATH
 		
 		Input :  m = 3, n = 4;
 		+---+---+---+---+
 		| s |   |   |   |
 		|   | 1 | 1 | 1 |
 		|   |   |   |   |
 		+---+---+---+---+
 		
 		
 		Output : 1 
 		There are three paths but 2 are blocked by obstacles 1
 		
 		(0, 0) -> (1, 0) -> (2, 0) -> (2, 1)->(2,2)-->(2,3)
 	 */
  public static int numberOfPathsWithObstacles(int m , int n,int [][] obstacle) {
		 int dp[][] = new  int[m][n];
		 dp[0][0] = 1;
		 for(int i = 0 ; i < m ; i++) {
			 for(int j = 0; j < n ; j++) {
				 if(obstacle[i][j] == 1) {
					 dp[i][j] = 0;
					 break;
				 }
				 if( i > 0 && j > 0) {
					 dp[i][j] = dp[i-1][j] + dp[i][j-1];
				 }
				 else if( i > 0) {
					 dp[i][j] = dp[i-1][j];
				 }
				 else if( j > 0) {
					 dp[i][j] = dp[i][j-1];
				 }
			 }
		 }
		 return dp[m-1][n-1];
	 }
  /*
   *   a robot is located at top left of the grid mxn as marked s in the grid.
   *   the robot can move either down or right in the grid at any moment of the time.
   *   the robot is trying to reach to the bottom right to the grid (marked as 'E' in the diagrma below
   *   each cell contain a coin the robot can collect.
   *   what is the maximum coin robot can collect?
   */
  public static int maximumCoinRobotCanCollectInMatrix(int m , int n,int [][] coingrid) {
	     HashMap<String,String> pathMap = new HashMap<>();
		 int dp[][] = new  int[m][n];
		 //dp[0][0] = 0;
		 pathMap.put("00","00");
		 for(int i = 0 ; i < m ; i++) {
			 for(int j = 0; j < n ; j++) {
				 dp[i][j] = coingrid[i][j];
				 if( i > 0 && j > 0) {
				    //dp[i][j] += Math.max( dp[i-1][j], dp[i][j-1]);
					 if(dp[i-1][j]> dp[i][j-1]) {
						 dp[i][j] += dp[i-1][j];
						 pathMap.put(i+""+j,(i-1)+""+j);
					 }else {
						 dp[i][j] += dp[i][j-1];
						 pathMap.put(i+""+j,i+""+(j-1));
					 }
				 }
				 else if( i > 0) {
					 dp[i][j] += dp[i-1][j] ;
					 pathMap.put(i+""+j,(i-1)+""+j);
				 }
				 else if( j > 0) {
					 dp[i][j] += dp[i][j-1];
					 pathMap.put(i+""+j,i+""+(j-1));
				 }
			 }
		 }
		// path.add(new Path(m-1, n-1));
		// System.out.println(path);
		 String key = (m-1)+""+(n-1);
		 System.out.println("Path is");
		 System.out.print(key+"<--");
		 while(!key.equalsIgnoreCase("00")) {
			 key = pathMap.get(key);
			 System.out.print(key+"<--");
		 }
		 //System.out.print("00<--"); 
		 //System.out.println(pathMap);
		 System.out.println();
		 return dp[m-1][n-1];
	 }
}
  