package sample.test.collection;

public class RemoveDuplicateCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   boolean [] charSet = new boolean [256];
       String s ="vvvvvvvvvvvvvvvvIIIIIIIIIIIIIIIIIIIfdkfdkfidf";
       int len = s.length();
       StringBuilder  output = new StringBuilder();
       char  c ;
       int   ch;
       for(int i=0; i<len ;i++){
    	  ch= c = s.charAt(i);
    	   if(charSet[c]) continue;
    	   else{
    		   output= output.append(c);
    	   }charSet[c] = true;
       }
       System.out.println(output);
	}

}
