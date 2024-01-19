package designguru.twopointers;

public class CompareStringsBackspaces {

	public static void main(String[] args) {
    System.out.println(backspaceCompare("xy#z","xzz#"));
    System.out.println(backspaceCompare("xy#z","xyz#"));
    System.out.println(backspaceCompare("xp#","xyz##"));

	}
	public static boolean backspaceCompare(String s, String t) {
       
		int i =0;
		StringBuffer s1 = new StringBuffer();
		while(i < s.length()) {
			if(s.charAt(i) !='#') {
			 s1.append(s.charAt(i));
			}else {
				s1 = s1.deleteCharAt(s1.length()-1);
			}
			i++;
		}
		
		i =0;
		StringBuffer s2 = new StringBuffer();
		while(i < t.length()) {
			if(t.charAt(i) !='#') {
			s2.append(t.charAt(i));
			}else {
				s2 = s2.deleteCharAt(s2.length()-1);
			}
			i++;
		}
		if(s1.toString().equals(s2.toString())) return true;
		else return false;
    }
}
