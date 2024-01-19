package designguru.fastndslowpointer;

public class HappNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappyNumber(20));

	}
	
	public static int squareNum(int n) {
		int square = 0;
		while (n != 0) {
			square += (n%10)*(n%10);
			n /=10;
		}
		return square;
	}
	
	public static boolean isHappyNumber(int n) {
		
		int slow , fast;
		fast = slow = n;
		do {
			slow = squareNum(slow);
			fast = squareNum(squareNum(fast));
		}while(slow != fast);
		return slow ==1;
	}

}
