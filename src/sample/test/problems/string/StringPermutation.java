package sample.test.problems.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Java Program to find all permutations of a String
 * @author sharmav
 *
 */
public class StringPermutation {


	    public static Set<String> permutationFinder(String str) {
	        Set<String> perm = new HashSet<String>();
	        //Handling error scenarios
	        if (str == null) {
	            return null;
	        } else if (str.length() == 0) {
	            perm.add("");
	            return perm;
	        }
	        char initial = str.charAt(0); // first character
	        String rem = str.substring(1); // Full string without first character
	        Set<String> words = permutationFinder(rem);
	        for (String strNew : words) {
	        	System.out.println("strNew ="+strNew);
	            for (int i = 0;i<=strNew.length();i++){
	                perm.add(charInsert(strNew, initial, i));
	            }
	        }
	        return perm;
	    }

	    public static String charInsert(String str, char c, int j) {
	        String begin = str.substring(0, j);
	        String end = str.substring(j);
	        return begin + c + end;
	    }

	    public static void main(String[] args) {
	       // String s = "AAC";
	        String s1 = "ABC";
	       // String s2 = "ABCD";
	       // System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
	        System.out.println("\nPermutations for " + s1 + " are: \n" + permutationFinder(s1));
	      //  System.out.println("\nPermutations for " + s2 + " are: \n" + permutationFinder(s2));
	        permutations("ABC".toCharArray(),0);
	    }
	    
	    public static void permutations(char [] ch, int currentIndex) {
	    	   if(currentIndex == ch.length-1) 	System.out.println(String.valueOf(ch));
	    	   
	    	   for(int i = currentIndex; i < ch.length ; i++) {
	    		   swap(ch, i ,currentIndex);
	    		   permutations(ch ,currentIndex+1);
	    		   swap(ch,i, currentIndex );
	    	   }
	    	}
	  private static void swap(char [] ch , int x, int y) {
		  char c = ch[x];
		  ch[x]  = ch[y];
		  ch[y] = c;
	  }
	}