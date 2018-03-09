package sample.test.problems.string;



/*
 * each character from a-z represent a numberic value (a=0 ,b=1,c=2,d=3 .... , z=25)  
 * write a method which take integer input and return number of possible  combination
 * for example : input :12  output:2(bc , j)
 */
public class StringPossibleCombination {

	
	public static void main(String[] args) {
	
      System.out.println(compute(1112));//bbbc ,HJ,HBC,BHC
	}
	
public static int compute(int input)	{
	int result =1;
	if(input < 0)
	 {
		return 0;
	 }
	if(input ==0) return 1;
	
	String inputS= Integer.toString(input);
	int i=0;
	while(i < inputS.length()-1){
		//System.out.println(i);
		int s = Integer.valueOf(inputS.substring(i,i+2));
		//System.out.println("subString="+s);
		if(s> 9 && s< 25) result++;
		i++;
		
	}
	return result;
	
}

}

