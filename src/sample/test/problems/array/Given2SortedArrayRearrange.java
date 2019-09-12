package sample.test.problems.array;

/**
 * 
 * @author viveksharma
 * 
 * Given 2 sorted array, you need to re-arrange the elements so that one should have all its elements
 * lesser than other array elements.
 *  you can user O(1) extra space.
 * 
 * For Example  : arr1 = { 10}
 *                arr2 = { 2,3}
 *     OUtput:
 *     arr1 = {2}
 *     arr2 = {3,10}
 *
 */
public class Given2SortedArrayRearrange {

	public static void main(String[] args) {
	 
		int [] a = { 8,12,16};
		int [] b=  { 3,7,15,20};
		//Expected output {3,7,8} and { 12,15,16,20}
		 reArrange(a, b);
		int  [] a1 = {10};
		int [] a2 = {2,3};
		System.out.println();
		 reArrange(a1,a2);
		

	}
	
	public static void reArrange(int []a , int b[]) {
		int i = 0;
		int temp;
		while(i < a.length && b[0]< a[i]  ) {
			temp = a[i];
			a[i] = b[0];
			b[0] = temp; // place this element at its place so that array b will be again sorted
			int j = 0;
			while( (j+1)< b.length && b[j] > b[j+1]) {
				temp = b[j+1];
				b[j+1] = b[j];
				b[j] = temp;
				j++;
			}
		i++;	
		}
		
	for( i= 0 ; i < a.length ; i++) {
		System.out.print(a[i]+" ");
	}
	System.out.println();
	for( i= 0 ; i < b.length ; i++) {
		System.out.print(b[i]+" ");
	}
	}

}
