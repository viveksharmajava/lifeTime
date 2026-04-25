package leetcode.blind75;
/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 */
public class Problem_2_maxProfit {

	public static void main(String[] args) {

	}
	 public int maxProfit(int[] prices) {
	        int min_so_far = prices[0]; //Integer.MAX_VALUE;
	        int max_profit = Integer.MIN_VALUE;
	        for(int i = 1 ; i < prices.length;i++){
	        	if(prices[i] - min_so_far > max_profit) max_profit = prices[i] - min_so_far;
	        	if( min_so_far > prices[i]) min_so_far = prices[i];
	        }
	        if(max_profit > 0 ) return max_profit;
	        else return 0;
	    }
}