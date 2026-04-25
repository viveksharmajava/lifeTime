package AndreyGrehov.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
/*
 * https://github.com/andreygrehov/dp/tree/master
 * https://www.youtube.com/watch?v=hekG82t4U_M&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=8
 */
public class ClimbingStairsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         System.out.println("climbingStairs ="+climbingStairs(5));
         System.out.println("ClimibingStairs.climibingStair ="+ClimibingStairs.climibingStair(5));
         System.out.println("climbingStairsRecursion ="+climbingStairsRecursion(5));
         System.out.println("climbingStairsKSteps = "+climbingStairsKSteps(5,2));
         System.out.println("climbingStairs3Steps = "+climbingStairs3Steps(5));
         System.out.println("climbingStairsKSteps = "+climbingStairsKSteps(5,3));
         System.out.println("climbingStairsKStepsWithReducedSpace = "+climbingStairsKStepsWithReducedSpace(5,3));
         
         System.out.println("climbingStairsKSteps = "+climbingStairsKSteps(15,3));
         System.out.println("climbingStairsKStepsWithReducedSpace = "+climbingStairsKStepsWithReducedSpace(15,3));
         
         //climbing Stairs KSteps Skip Red stairs
         System.out.println("climbingStairsKStepsSkipRed "+climbingStairsKStepsSkipRed(7,3,new boolean [] {false,true,false,true,true,false,false,false}));
       
         System.out.println("Climibing paid stairs");
    	 int stairs  = 3;
    	 int []cost = {3,2,4};
    	 System.out.println("Minimum Cost to reach to top ="+paidStairCaseMinCost(stairs, cost));
    	 System.out.println("Minimum cost and min space ="+paidStairCaseMinCostMinSpace(stairs, cost));
    	 System.out.println("Minimum cost path and min cost ="+paidStairCaseMinCostPath(stairs, cost));
    	 
    	 //problem 9 a
    	 System.out.println("uniquePath1 = "+uniquePath1(4,3));
    	 //problem 9 b
    	 System.out.println("uniquePath when there are obstacles on the path ="+uniquePathWithObjstacle(3, 4, new int [][]{
				{0, 0, 0, 0},
				{0, 0, 1, 1},
				{0, 0, 0, 0},
			}));
    	 
       //problem 9 c,10
        System.out.println(" maximumProfitInGripd  ="+ maximumProfitInGrid(3,4,new int[][]{
			{0, 2, 2, 50},
			{113, 1, 1, 0},
			{4, 4, 2, 0}
		}));
	 //Program 11 , painting..
       System.out.println("numOfWaysPaints="+numOfWaysPaints(4));
	}
	
	/*
	 * Climbing stairs:
	 * Problem statement: return the total number of ways you can climb from bottom to top:
	 * constraint: you can climb either 1 step or 2 steps.
	 * 
	   1. Define the objective of function.
	    f(i) is the function to determine the number of distinct way to reach ith stairs.
	   2. Base cases:
	      f(0) = 1 ; //do nothing.
	      f(1) = 1; 1 step only.
	   3. Recurrence function/relation: 
	      f(n) = f(n-1) + f(n-2)
	   4. Where to check for solution.
	      f(n)
	   5. Order of execution:
	      bottom-up
	   6. Time complexity
	      O(n)
	   7. Space complexity
	      O(1)
	 */
   public static int climbingStairs(int stairs) {
	   //define base case
	    int d0=1 , d1 = 1,c=0;
	    //define recurrence function..
	    for(int i= 2 ;i <=stairs ; i++) {
	    	c = d0 + d1;
	    	d0 = d1;
	    	d1 = c;
	    }
	    return c;
   }
   public static int climbingStairsRecursion(int n) {
	   if( n==1 || n == 0) return 1;
	   return climbingStairsRecursion(n-1) + climbingStairsRecursion(n-2);
	   
   }
   
   /*
	 * Climbing stairs: 3 steps
	 * Problem statement: return the total number of ways you can climb from bottom to top:
	 * constraint: you can climb either 1 step or 2  or 3 steps.
	 * 
	   1. Define the objective of function.
	    f(i) is the function to determine the number of distinct way to reach ith stairs.
	   2. Base cases:
	      f(0) = 1 ; //do nothing.
	      f(1) = 1; 1 step only.
	      f(2) = 2; 2 steps
	   3. Recurrence function/relation: 
	      f(n) = f(n-1) + f(n-2) + f(n-3)
	   4. Where to check for solution.
	      f(n)
	   5. Order of execution:
	      bottom-up
	   6. Time complexity
	      O(n)
	   7. Space complexity
	      O(1)
	 */
  public static int climbingStairs3Steps(int stairs) {
	 
	    int [] dp = new int[stairs + 1];
	    //define base case
	    dp[0] = 1;//0 do nothing
	    dp[1] = 1; //1st stair only 1 way
	    dp[2] = 2; //2nd stair  , 2 way.. since 
	    //define recurrence function..
	    for(int i= 3 ;i <=stairs ; i++) {
	    	dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
	    }
	    // 
	   return dp[stairs];//last
  }
  /*
   * 
   * Make Generic solution..
   * Climbing stairs K steps
   * youtube: 
   * https://www.youtube.com/watch?v=7vM_RZEGUcw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=6
   * * Problem statement: return the total number of ways you can climb from bottom to top:
	 * constraint: you can climb either k steps.
	 * 
	   1. Define the objective of function.
	    f(i) is the function to determine the number of distinct way to reach ith stairs.
	   2. Base cases:
	      f(0) = 1 ; //do nothing.
	      f(1) = 1; 1 step only.
	      f(2) = 2; 2 steps
	      ...
	      
	      ..
	      f(k) = f(k-1)+ f(k-2).....+ f(0)
	   3. Recurrence function/relation: 
	      f(n) = f(n-1) + f(n-2) + f(n-3)...... +f(n-k)
	   4. Where to check for solution.
	      f(n)
	   5. Order of execution:
	      bottom-up
	   6. Time complexity
	      O(n*k)
	   7. Space complexity
	      O(n+1)
	      we will reduce space upto of size k in next solution..
   */
  public static int climbingStairsKSteps(int n,int k) {
	  int [] dp = new int[n + 1];
	    //define base case
	    dp[0] = 1;//0 do nothing
	    for(int i=1; i <=n; i++) {
	    	for(int j= 1; j <=k; j++) { 
	    		//this for loop is replacement for  dp[i] = dp[i-1] + dp[i-2] + dp[i-3]..............dp[i-k]
	    		if(i-j < 0) {
	    			continue;
	    		}
	    		dp[i] += dp[i-j];
	    		System.out.println("i ="+i+",dp ="+dp[i]);
	    	}
	    }
	    return dp[n];
  }
  /*  optimized  k steps
   * https://www.youtube.com/watch?v=7vM_RZEGUcw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=6
   * watch from 4 minutes...
   * Optimized solution with only K space complexity instead of O(n+1)
   * 
   */
  public static int climbingStairsKStepsWithReducedSpace(int n,int k) {
	  int [] dp = new int[k];
	    //define base case
	    dp[0] = 1;//0 do nothing
	    for(int i=1; i <=n; i++) {
	    	for(int j= 1; j <k; j++) { 
	    		//this for loop is replacement for  dp[i] = dp[i-1] + dp[i-2] + dp[i-3]..............dp[i-k]
	    		if(i-j < 0) {
	    			continue;
	    		}
	    		dp[i%k] += dp[(i-j)%k];
	    		//System.out.println("i ="+i+",dp ="+dp[i]);
	    	}
	    }
	    return dp[n%k];
  }
  
  /* Climbing Stairs : Skip red stairs or skip paid stairs
   *  optimized  k steps
   * 
   * https://www.youtube.com/watch?v=7vM_RZEGUcw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=6
   * watch from 4 minutes...
   * Optimized solution with only K space complexity instead of O(n+1)
   * 
   */
  public static int climbingStairsKStepsSkipRed(int n,int k,boolean [] isRedStair) {
	  int [] dp = new int[k];
	    //define base case
	    dp[0] = 1;//0 do nothing
	    for(int i=1; i <=n; i++) {
	    	for(int j= 1; j <k; j++) { 
	    		//this for loop is replacement for  dp[i] = dp[i-1] + dp[i-2] + dp[i-3]..............dp[i-k]
	    		if(i-j < 0) {
	    			continue;
	    		}
	    		if(isRedStair[i-1]) {
	    			dp[i%k]  = 0;
	    		}
	    		else{
	    			dp[i%k] += dp[(i-j)%k];
	    		}
	    		//System.out.println("i ="+i+",dp ="+dp[i]);
	    	}
	    }
	    
	    System.out.println("Arrays ="+Arrays.toString(dp));
	    return dp[n%k];
  }
  /*
   * 07 - Optimization Problem (Dynamic Programming for Beginners)
   * source:Andrey Greh
   *  https://www.youtube.com/watch?v=hekG82t4U_M&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=7
   * 
   * /*
  * Paid staircase 
  * 
  * Problem statement:
  * You are climbing a paid stairs it takes n steps to reach to the top.
  * pay[i] contains the cost to  reach to ith stair.
  * you can climb max 1 or 2 stairs/steps at a time .
  * what is the minimum cost you have to pay to reach to top of the staircase.
  * 1.  Define the objective of function.
     f(i)  is the number of distinct ways to reach ith stairs.
    2. Base case
      f(0) = 0 , cost 0 when you don't climb any stairs.
    3. write down the recurrence relation for optimized function.
      f(n) = Pay(n) +MinCost(f(n-1),f(n-2), since we can climb only 2 stairs.
    4. 
    
    /*
Problem:https://github.com/andreygrehov/dp/blob/master/lecture7/lecture7.go
	Paid Staircase

	You are climbing a paid staircase. It takes n steps to reach to the top and you have to
	pay p[i] to step on the i-th stair. Each time you can climb 1 or 2 steps.
	What's the cheapest amount you have to pay to get to the top of the staircase?

// Time complexity: O(n)
// Space complexity: O(n)
     
   */
  
  public static int paidStairCaseMinCost(int stairs,int [] price) {
	  int [] dp = new int[stairs+1];
	  //base case
	  dp[0] = 0;//do nothing stay at ground
	  dp[1]  = price[0];
	  for(int i = 2 ; i<= stairs; i++ ) {
		  dp[i] = price[i-1] +Integer.min(dp[i-1], dp[i-2]);
	  }
	  return dp[stairs];
  }
  
  // optimized of above problem
  // we need only O(k) extra space,
  //if we are allow to step 2 stairs we need dp[2] size extra..
  
  public static int paidStairCaseMinCostMinSpace(int stairs,int [] price) {
	  int total_cost  = 0,a,b;
	  //base case
	  a= 0;//do nothing stay at ground
	  b = price[0];
	  for(int i = 2 ; i<= stairs; i++ ) {
		 // dp[i] = price[i] +Integer.min(dp[i-1], dp[i-2]);
		  total_cost  = price[i-1] +Integer.min(a,b);
		  a = b;
		  b  = total_cost;
	  }
	  return total_cost;
  }
  
/*
 * Print path (stairs number) from 0 ... to n stairs which has min cost..
  * Problem 8: 
  * https://www.youtube.com/watch?v=3hHmUszRXjw&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=8
  * https://github.com/andreygrehov/dp/blob/master/lecture8/lecture8.go
  * Paid Staircase II

	You are climbing a paid staircase. It takes n steps to reach to the top and you have to
	pay p[i] to step on the i-th stair. Each time you can climb 1 or 2 steps.
	Return the cheapest path to the top of the staircase.
     
 */
  
 public static int paidStairCaseMinCostPath(int stairs,int [] price) {
	  int total_cost  = 0,a,b;
	  //base case
	  a= 0;//do nothing stay at ground
	  b = price[0];
	  ArrayList <Integer> path = new ArrayList<>();
	  for(int i = 2 ; i<= stairs; i++ ) {
		 // dp[i] = price[i] +Integer.min(dp[i-1], dp[i-2]);
		  total_cost  = price[i-1] +Integer.min(a,b);
		  if(a < b)path.add(a);
		  else path.add(b);
		  a = b;
		  b  = total_cost;
	  }
	 path.add(stairs);
	  System.out.println("Path ="+path);
	  return total_cost;
 }
  
 /*
  * Problem :Unique Paths
  * https://github.com/andreygrehov/dp/blob/master/lecture9/lecture9_prob1.go
  * https://www.youtube.com/watch?v=YcrXBDAeTCs&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=9
  * watch :16:25 to understand watch from 11:40..
  * 
  * Problem statement: 
  * A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).

	How many possible unique paths are there?

	+---+---+---+---+
	| S |   |   |   |
	+---+---+---+---+
	|   |   |   |   |
	+---+---+---+---+
	|   |   |   | E |
	+---+---+---+---+

	Above is a 3 x 4 grid. How many possible unique paths are there?
	objective function: f(i,j) = f(i-1,j)+f(i,j-1)
  */
  public static int uniquePath1(int m,int n) {
	  int [][] dp = new int[m][n];
	  dp[0][0] = 1;
	  for(int i = 0 ; i < m ; i++) {
		  for(int j=0; j < n; j++) {
			  if( i > 0 && j > 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
			  else if( i > 0)  dp[i][j] = dp[i-1][j];
			  else if( j > 0) dp[i][j] = dp[i][j-1];
			  
		  }
	  }
	  return dp[m-1][n-1];
  }
  /*
   * Problem: https://github.com/andreygrehov/dp/blob/master/lecture9/lecture9_prob2.go
   * https://www.youtube.com/watch?v=YcrXBDAeTCs&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=9
   * watch from :21:20
   * Problem:
	Unique Paths with Obstales

	A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
	The robot can only move either down or right at any point in time.
	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).

	Now consider if some obstacles are added to the grids.
	How many unique paths would there be?

	+---+---+---+---+
	| S |   |   |   |
	+---+---+---+---+
	|   | 1 | 1 | 1 |
	+---+---+---+---+
	|   |   |   | E |
	+---+---+---+---+

	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
   */
  public static int uniquePathWithObjstacle(int m,int n, int [][] obstacle) {
	  int [][] dp = new int[m][n];
	  dp[0][0] = 1;
	  for(int i = 0 ; i < m ; i++) {
		  for(int j=0; j < n; j++) {
			 if(obstacle[i][j] != 0) {
				 dp[i][j] = 0;
				 continue;
			 }
			  if( i > 0 && j > 0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
			  else if( i > 0)  dp[i][j] = dp[i-1][j];
			  else if( j > 0) dp[i][j] = dp[i][j-1];
			  
		  }
	  }
	  return dp[m-1][n-1];
  }
  /*
  Problem:
  	Maximum Profit in a Grid
    source: https://github.com/andreygrehov/dp/blob/master/lecture9/lecture9_prob3.go
    youtube: https://www.youtube.com/watch?v=YcrXBDAeTCs&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=9
    start: 25 min..
    
  	A robot is located at the top-left corner of a m x n grid (marked 'S' in the diagram below).
  	The robot can only move either down or right at any point in time.
  	The robot is trying to reach the bottom-right corner of the grid (marked 'E' in the diagram below).
  	Each cell contains a coin the robot can collect.

  	What is the maximum profit the robot can accumulate?

  	+---+---+---+---+
  	| S | 2 | 2 | 1 |
  	+---+---+---+---+
  	| 3 | 1 | 1 | 1 |
  	+---+---+---+---+
  	| 4 | 4 | 2 | E |
  	+---+---+---+---+
  */

  // Time complexity:
  // Space complexity:
  // f(i,j) = max(f(i-1, j), f(i, j-1)) + grid(i,j)
  public static int maximumProfitInGrid(int m,int n, int [][] grid) {
	  int [][] dp = new int[m][n];
	  for(int i = 0 ; i < m ; i++) {
		  for(int j=0; j < n; j++) {
			  dp[i][j] = grid[i][j];
			  if( i > 0 && j > 0) {
				  dp[i][j] += Integer.max(dp[i-1][j] , dp[i][j-1]);
				  if(dp[i-1][j] > dp[i][j-1]) {
				  }
				  else {
					  System.out.println(i+" "+(j-1));
				  }
			  }
			  else if( i > 0) {
				  dp[i][j] += dp[i-1][j];
			  }
			  else if( j > 0) {
				  dp[i][j] += dp[i][j-1];
			  }
			  
		  }
	  }
	  int [][] path = new int[m][n];
	  System.out.println("before path="+Arrays.toString(path));
	   getPath(m-1,n-1,dp,path);
	   System.out.println("after path="+Arrays.toString(path));
	  return dp[m-1][n-1];
  }
  
  public static void getPath(int i,int j , int [][] dp, int [][] path) {
	 if(i ==0 && j == 0 ) {
		 path [i][j] = 1;
		// return Arrays.toString(path);
		 System.out.println("i "+i+"\t j="+j);
		 return;
	 }
	 else if ( i == 0) getPath(i,j-1,dp,path);
	 else if ( j ==0) getPath(i-1,j,dp,path);
	 else {
		 if(dp[i-1][j] > dp[i][j-1]) {
			 getPath(i-1,j,dp,path);
		 }else {
			 getPath(i,j-1,dp,path);
		 }
	 }
	 System.out.println("i "+i+"\t j="+j);
	 path[i][j] = 1;
	 return ;
  }
  
  //Chapter 10 :
  //https://www.youtube.com/watch?v=MSRTLzJDfag&list=PLVrpF4r7WIhTT1hJqZmjP10nxsmrbRvlf&index=10
  /*
  Problem:
  	Paint Fence With Two Colors

  	There is a fence with n posts, each post can be painted with either green or blue color.
  	You have to paint all the posts such that no more than two adjacent fence posts have the same color.
  	Return the total number of ways you can paint the fence.
  */
   public static int numOfWaysPaints(int n) {
	 int [][]  dp = new int [n+1][2];
	   //base case
	   // green = 1
	   // blue = 0
	  dp[1][0] = 1;
	  dp[1][1] = 1;
	  dp[2][0] = 2 ;// 10, 00
	 dp[2][1] = 2; // 01, 11
	   
	 for(int i=3; i <=n; i++) {
		 for(int j=0; j <=1;j++) {
			dp[i][j] = dp[i-1][1-j]+dp[i-2][1-j]; 
		 }
	 }
	 return dp[n][0] + dp[n][1];
   }
}
