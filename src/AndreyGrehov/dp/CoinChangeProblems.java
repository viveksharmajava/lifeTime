package AndreyGrehov.dp;

import java.util.Arrays;

public class CoinChangeProblems {

	public static void main(String[] args) {
      System.out.println(coinChange(0));
      System.out.println(coinChange(3));
      System.out.println(coinChange(4));
      System.out.println(coinChangeWithDenomination(4,new int[] {1,3,5,10}));
      
      System.out.println("coinChangeExactlyTCoins ="+coinChangeExactlyTCoins(7,3,new int[] {1,2,3,5}));
	//coinChangeNoMoreTCoins
      System.out.println("coinChangeNoMoreTCoins ="+coinChangeNoMoreTCoins(7,3,new int[] {1,2,3,5}));
      System.out.println("coinChangeEvenNumberOfCoins ="+coinChangeEvenNumberOfCoins(6,new int[] {1,3,5,10}));
	//Input: coins = [1,2,5], amount = 11
     // Output: 3
    //  Explanation: 11 = 5 + 5 + 1
      System.out.println("Coin change ="+coinChange(new int[] {1,2,5},11));
	}
	/* Problem : find the number of ways we can form the given sum.
	 *  conditions: infinite number of coins.
	 *              1,3,5,10 denominators.
	 *  
	 * https://github.com/andreygrehov/dp/blob/master/lecture12/coin_change_test.go
	 * assumed denominators are : 1,3,5,10
	 * 
	 */
    public static int coinChange(int sum ) {
    	int [] dp = new int [sum+1];
    	//base case
    	dp[0] = 1;
    	for(int i = 1 ; i <=sum ; i ++) {
    		if(i-1 >= 0 ) dp[i] += dp[i-1]; // 1 denominator 
    		if(i-3 >= 0 ) dp[i] += dp[i-3]; // 3 denominator 
    		if(i-5 >= 0 ) dp[i] += dp[i-5]; // 5 denominator 
    		if(i-10 >= 0 ) dp[i] += dp[i-10]; //10  denominator 
    	}
    	System.out.println("dp coinChange="+Arrays.toString(dp));
    	return dp[sum];
    }
    
    public static int coinChangeWithDenomination(int sum ,int [] coins ) {
    	int [] dp = new int [sum+1];
    	//base case
    	dp[0] = 1;
    	for(int i = 1 ; i <=sum ; i ++) {
    		for(int coin: coins) {
    			if (i-coin >= 0) dp[i] += dp[i-coin];
    		}
    	}
    	System.out.println("dp coinChangeWithDenomination ="+Arrays.toString(dp));
    	return dp[sum];
    }
    /*
     * https://github.com/andreygrehov/dp/tree/master/lecture13
     * /*
	Problem:
		Coin change
	
		Given an unlimited supply of coins of given denominations,
		find the total number of ways to make a change of size n, by
		using excatly t coins.
	
		f(i,t) = f(i-1, t-1) + f(i-2, t-1) + f(i-3, t-1) + f(i-5, t-1)
*/
    public static int coinChangeExactlyTCoins(int n , int t,int []coins) {
    	 int [][] dp = new int[n+1][t+1];
    	 //base case
    	 dp[0][0] = 1;//make sum 0 possible only 1 way don't use coin.
    	 for(int i=1; i  <=n ; i++) {
    		 
    		 for(int j=0; j <=t; j++) {
    			 if( i > 0 && j ==0) {//coin count become 0
    				 dp[i][j] =0;
    				 continue;
    			 }
    			 //if i >= 1 {
    				//	dp[i][j] += dp[i-1][j-1]
    				//}
    				//
    				//if i >= 2 {
    				//	dp[i][j] += dp[i-2][j-1]
    				//}
    				//
    				//if i >= 3 {
    				//	dp[i][j] += dp[i-3][j-1]
    				//}
    				//
    				//if i >= 5 {
    				//	dp[i][j] += dp[i-5][j-1]
    				//}
    			 //we can convert above code in for loop
    			 for(int coin : coins) {
    				 if(i-coin >=0 ) dp[i][j] +=dp[i-coin][j-1];
    			 }
    			 
    		 }
    		
    	 }
    	 return dp[n][t];
     }
    //coinChangeNoMoreTCoins , its another version of above problem ,where count can be less
    //while finding the solution , in above solution we had to match the count..
    
    public static int coinChangeNoMoreTCoins(int n , int t,int []coins) {
   	 int [][] dp = new int[n+1][t+1];
   	 //base case
   	 dp[0][0] = 1;//make sum 0 possible only 1 way don't use coin.
   	 for(int i=1; i  <=n ; i++) {
   		 
   		 for(int j=0; j <=t; j++) {
   			 if( i > 0 && j ==0) {//coin count become 0
   				 dp[i][j] =0;
   				 continue;
   			 }
   			 if( i == 0 && j >0) {//this is only additonal condtion we required.
   				 dp[i][j] =1;
   				 continue;
   			 }
   			 //if i >= 1 {
   				//	dp[i][j] += dp[i-1][j-1]
   				//}
   				//
   				//if i >= 2 {
   				//	dp[i][j] += dp[i-2][j-1]
   				//}
   				//
   				//if i >= 3 {
   				//	dp[i][j] += dp[i-3][j-1]
   				//}
   				//
   				//if i >= 5 {
   				//	dp[i][j] += dp[i-5][j-1]
   				//}
   			 //we can convert above code in for loop
   			 for(int coin : coins) {
   				 if(i-coin >=0 ) dp[i][j] +=dp[i-coin][j-1];
   			 }
   			 
   		 }
   		
   	 }
   	 return dp[n][t];
    }
    
    /*
     * Lecture 14:
     * https://github.com/andreygrehov/dp/blob/master/lecture14/coin_change_even_coins.go
     * https://www.youtube.com/watch?v=nbh8kfCJcb0
     */
    /*
    Problem:
    	Coin change

    	Given an unlimited supply of coins of given denominations,
    	find the total number of ways to make a change of size n, by
    	using an even number of coins.

    	// 1, 3, 5, 10
    	f[i][0] = f[i-1][1] + f[i-3][1] + f[i-5][1] + f[i-10][1]
    	f[i][1] = f[i-1][0] + f[i-3][0] + f[i-5][0] + f[i-10][0]
    */
     public static int coinChangeEvenNumberOfCoins(int n , int []coins) {
    	 int [][] dp = new int [n+1][2];
    	 dp[0][0] = 0;
    	 dp[0][1] = 1;
    	 for(int i=1 ;i <= n ; i++) {
    		 
    		 for(int coin : coins) {
    			 if( i-coin < 0) {
    					continue;
    				}
    			            dp[i][0] += dp[i-coin][1];
    						dp[i][1] += dp[i-coin][0];
    					}
    		 }
    	 return dp[n][1];
     }
     
     /*
      * Problem: 322(leetcode )
      * https://leetcode.com/problems/coin-change/solutions/6132593/11-ms-runtime-beats-98-39-user-code-idea-algorithm-solving-step/
      * 
      * Description: 
      * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

		Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
		
		You may assume that you have an infinite number of each kind of coin.
      */
     public static int coinChange(int [] coins , int amount) {
    	 int [] dp = new int[amount+1];
    	 Arrays.fill(dp, Integer.MAX_VALUE);
    	 dp[0] = 0;//base case : 0 coin to make 0 amount
    	 for(int coin : coins) {
    		 for(int i = coin ; i <=amount; i++) {
    			 if(dp[i-coin] != Integer.MAX_VALUE) {
    				 dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    			 }
    			 
    		 }
    	 }
    	  return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
     }
}
