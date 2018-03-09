package sample.test.collection;

public class FindStringhavingAllUniqueCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input ="abcde";
		boolean [] charSet = new boolean [256];
		for(int i=0;i<input.length();i++){
			int c = input.charAt(i);
			if(charSet[c] ) {
				System.out.println("not unique String");
				break;
			}else{
				charSet[c]=true;
			}
			
		}

	}

}
