package neetcode;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * https://neetcode.io/problems/generate-parentheses
	 * https://walkccc.me/LeetCode/problems/22/#__tabbed_1_2 	
	 */
	  public List<String> generateParenthesis(int n) {
		  List<String> ans = new ArrayList<>();
		  dfs(n,n,new StringBuffer(),ans);
		  return ans;
		  
	    }
	   public  void dfs(int l , int r , StringBuffer sb, List<String> ans){
		   if(l==0 && r==0) {
			   ans.add(sb.toString());
			   return;
		   }
		   if( l > 0)
		   {   
			   sb.append("(");
			   dfs(l-1,r,sb,ans);
			   sb.deleteCharAt(sb.length()-1);
		   }
		   if(l < r) {
			   sb.append(")");
			   dfs(l,r-1,sb,ans);
			   sb.deleteCharAt(sb.length()-1);
		   }
		   
	}

}
