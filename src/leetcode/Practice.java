package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Practice {
       /* Find matching elements in sorted array
        * Input:
			ar1 = {1, 5, 5}
			ar2 = {3, 4, 5, 5, 10}
			ar3 = {5, 5, 10, 20}
			Output: 5, 5
        */
	
	public static List<Integer> allMatches(){
		List<Integer> out = new ArrayList<>();
		int []ar1 = {4, 5, 5,20};
		int []ar2 = {1, 4, 5, 5, 10,30};
		int []ar3 = {5, 5, 10, 20};
		
		int  a,b,c;
		a = b = c = 0;
		while( a < ar1.length && b < ar2.length && c < ar3.length) {
			while(a < ar1.length && b < ar2.length && ar1[a] != ar2[b]  ) {
				if(ar1[a] < ar2[b]) a++;
				else b++;
			}
			
			if (a >= ar1.length || b >= ar2.length || ar1[a] != ar2[b]  ) break;
			
			if( ar1[a] > ar3[c]) {
				while(ar3[c] < ar1[a] && c < ar3.length) {
					c++;
				}
			}
			if( a < ar1.length && c < ar3.length && ar1[a] == ar3[c]) {
				out.add(ar1[a]);
				a++;
				b++;
				c++;
			}else {
				a++;
				b++;
			}
			
		}
		System.out.println("All matches ="+out);
		return out;
	}
	
	public static void main(String[] args) {
		allMatches();
	}

}
