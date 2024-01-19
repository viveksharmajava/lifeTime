package designguru.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

/* https://leetcode.com/problems/fruit-into-baskets/
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/6385d2dae25dea6343fd8b19
 * 
 */
public class MaxFruitsintoKBaskets {

	public static void main(String[] args) {
       char [] str = {'0', '1', '2', '2', '2', '2' };
       int k = 1;
       System.out.println(Arrays.toString(maxfruits(str,k)));
	}
    public static char[] maxfruits( char [] str , int k) {

		
		//char [] subStr = null;
		int s =0 ,start=0;
		int e = 0, end = -1;
		int max = -1;
		
		HashMap < Character, Integer > map = new HashMap<>();
		for(int i = 0 ; i < str.length; i++) {
			Character c = str[i];
			if(map.size() < k || map.containsKey(c) ) {
				if(map.containsKey(c)) {
					map.put(c,map.get(c)+1);
				}
				else {
					map.put(c,1);
				}
				end = i;
			}else {
			  	
			  	if(max < (end- start+1)) {
			  		max = end -start+1;
			  		s = start;
			  		e = end;
			  		
			  	}
			  	int m = start;
			  	while( map.size() == k) {
			  		Character cc = str[m];
			  		if(map.get(cc) == 1) map.remove(cc);
			  		else {
			  			map.put(cc, map.get(cc)-1);
			  		}
			  		m++;
			  	}
			  	if(m <= i && map.size() < k) {
			  		start  = m;
			  		map.put(c, 1);
			  		end = i;
			  	}
			  }//end of else;
		
		
		}
		if(max < (end- start)) {
	  		max = end -start+1;
	  		s = start;
	  		e = end;
	  		
	  	}
		if(max > 0) {
			return Arrays.copyOfRange(str, s, e+1);
		}
		return null;
		
	
    }
}
