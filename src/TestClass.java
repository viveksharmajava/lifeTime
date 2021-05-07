import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
public class TestClass {

	public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  String size = br.readLine();
	  String [] array = br.readLine().split(" ");
	  HashMap <String,Integer>  map = new HashMap<>();
	  int max_count=0 , num1=Integer.MAX_VALUE;
	  for(String a :array) {
		if(map.containsKey(a)) {
			int val = map.get(a);
			if(val > max_count) {
				max_count = val; 
			    num1 = Integer.parseInt(a);
			}
			else if (val == max_count && num1 > Integer.parseInt(a) ) {
				max_count = val; 
				num1 = Integer.parseInt(a) ;
			}
			map.put(a, val+1);
		}
		else {
			map.put(a, 1);
		}
	  }
	  System.out.println(num1);
	  String [] ar = br.readLine().split(" ");
	  int mode = Integer.parseInt(ar[1]); 
	  int len = Integer.parseInt(ar[0]);
	  String input = br.readLine();
	  int i = 0 ;
	  while(i < len) {
		  
	  }
	  
	}

}
