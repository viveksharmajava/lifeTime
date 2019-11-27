package sample.test.problems.string;
 /*
  *  input :geegsforgeegs
  *  result : sfors
  *   After 1st iteration : ggsforggs
  *   After 2nd iteration:sfors
  *  
  */
public class RemoveAdjacentDuplicate {

	public static void main(String[] args) {
		
        String input ="agggbbc"; 
        String s = removeAdjacent(input);
        System.out.println(s);
	}
	
	public static String removeAdjacent( String input) {
		String result;
		if(input == null || "".equals(input) || input.length()==1) return input;
		 char c = input.charAt(0);
		 int cIndx = 0;
		 boolean found  = false;
		 int i =1;
		 for( ;i < input.length(); i++) {
			 char ch = input.charAt(i);
			 if(ch == c) {
				 continue;
			 }
			 else if(cIndx != (i-1)) {
			  result = input.substring(0, cIndx) + input.substring((i), input.length()) ;
			  input = result; 
			  found = true;
			 }
			 cIndx = i;
			 c = ch;
		 }
		 //handle case when matching char is last char in given string or all characters are matching 'gggg'
		  if(cIndx != (i-1)) {
			  result = input.substring(0, cIndx) + input.substring((i), input.length()) ;
			  input = result; 
			  found = true;
		 }
		 
		if(!found)  return input;
		else return removeAdjacent(input);
	}

}
