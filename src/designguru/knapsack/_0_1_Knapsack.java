package designguru.knapsack;

/*
 * Problem  : https://www.techiedelight.com/0-1-knapsack-problem/
 * Solution : https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
 * value = [ 20, 5, 10, 40, 15, 25 ]
 * weight = [ 1, 2, 3, 8, 7, 4 ]
 * int W = 10 
 * Output: Knapsack value is 60 
 * value = 20 + 40 = 60
 * weight = 1 + 8 = 9 < W
 */
public class _0_1_Knapsack {

	public static void main(String[] args) {
     int [] val = { 20, 5, 10, 40, 15, 25};
     int [] weight  = {1, 2, 3, 8, 7, 4 };
     int W = 10;
     int len = val.length-1;
     System.out.println("Knapsack value is  "+knapsack(val,weight,W,len));
	}

	public static int knapsack(int [] val, int [] w, int W , int n ) {
		if( W == 0 || n < 0) return 0;
		if( w[n] <= W) {
		int include = val[n] + knapsack(val,w, W-w[n],n-1);
		int exlcude = knapsack(val,w, W,n-1);
		return Math.max(include, exlcude);
		}else {
			return knapsack(val,w, W,n-1);
		}
	}
}


