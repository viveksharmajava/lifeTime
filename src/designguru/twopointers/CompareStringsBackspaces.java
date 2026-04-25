package designguru.twopointers;

public class CompareStringsBackspaces {

	public static void main(String[] args) {
  //  System.out.println(backspaceCompare("xy#z","xzz#"));
  //  System.out.println(backspaceCompare("xy#z","xyz#"));
  //  System.out.println(backspaceCompare("xp#","xyz##"));
    
    System.out.println(compare("xy#z","xzz#"));
    System.out.println(compare("xy#z","xyz#"));
    System.out.println(compare("xp#","xyz##"));

	}
	public static boolean compare(String s, String t) {
        // Initialize pointers to traverse both strings from the end
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
      
        // Track the number of backspaces to skip for each string
        int sBackspaceCount = 0;
        int tBackspaceCount = 0;
      
        // Continue while at least one string has characters to process
        while (sPointer >= 0 || tPointer >= 0) {
          
            // Process string s: Skip characters affected by backspaces
            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    // Found a backspace, increment counter
                    sBackspaceCount++;
                    sPointer--;
                } else if (sBackspaceCount > 0) {
                    // Skip this character due to backspace
                    sBackspaceCount--;
                    sPointer--;
                } else {
                    // Found a valid character to compare
                    break;
                }
            }
          
            // Process string t: Skip characters affected by backspaces
            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    // Found a backspace, increment counter
                    tBackspaceCount++;
                    tPointer--;
                } else if (tBackspaceCount > 0) {
                    // Skip this character due to backspace
                    tBackspaceCount--;
                    tPointer--;
                } else {
                    // Found a valid character to compare
                    break;
                }
            }
          
            // Compare the current valid characters
            if (sPointer >= 0 && tPointer >= 0) {
                // Both strings have valid characters to compare
                if (s.charAt(sPointer) != t.charAt(tPointer)) {
                    return false;
                }
            } else if (sPointer >= 0 || tPointer >= 0) {
                // One string has a character while the other doesn't
                return false;
            }
          
            // Move to the next characters
            sPointer--;
            tPointer--;
        }
      
        // Both strings have been fully processed and match
        return true;
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
