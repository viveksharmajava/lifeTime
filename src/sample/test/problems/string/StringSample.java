package sample.test.problems.string;

public class StringSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//TODO  1.  make first character to upper case of given string 
		String s= "vivek";
		Character c=Character.toUpperCase( s.charAt(0));
		s = c.toString()+s.substring(1);
		System.out.println(s);
		
		// TODO 2. check string pool concept
		
		String  s1 = "Vivek";
		String  s2= "Vivek";
		String  s3= new String("Vivek");
		String s4="Vivek Sharma";
		if(s1==s2){
			System.out.println("s1 and s2 are equals b/s they in string pool \n s1 hashCode="+s1.hashCode()+"\n s2 hashCode="+
		    s2.hashCode());
		}
		if(s1==s3){
			System.out.println("s1 and s3 are equals b/s there hashcode are equal s1 hashCode="+s1.hashCode()+"\t s3 hashCode="+
		    s3.hashCode());
		}
		//System.out.println("s3 has code before modifying="+s3.hashCode());
		
		s3 = s3 +" Sharma";
		if(s3==s4)
		{
			System.out.println("s3 hashCode="+s3.hashCode()+"\ns4 hashCode="+ s4.hashCode());
		}
		   
		System.out.println();

}
}
