package sample.test.searchingAndSorting;

public class InsertionSort {

	public static void main(String[] args) {
		int []array= {53,30,3,8,6,10,2};
		
		int [] sorted = insertionSort(array);
//		 int temp=0;
//		 
//		 for(int i=1 ;i< array.length; i++){
//	       for(int j=0; j<i ;j++ ){
//	    	   if(array[j] > array[i]){
//	    		   temp = array[i];
//	    		   for (int k=i ;k>j ;k--){
//		    		   array[k] = array[k-1];
//		    	   }
//		    	   array[j] = temp;
//	    	   }
//	    	   
//	    	   
//	    		   
//	       }
//	       
//	}
		 
	//EOF sorting
		 for(int i=0;i<sorted.length;i++){
				System.out.println(sorted[i]);
			}
		 
}
	
	public static int [] insertionSort(int [] input) {
		
		 if (input.length <=1) return input;
		
		 int key;
		 int i ,j ;
		 for( j= 1 ; j < input.length ; j++) {
			 key = input[j];
			 i = j- 1;
			 while( i >=0 && input[i] >= key) {
				 input[i+1] = input[i];
				 i--;
			 }
			 input[i+1] = key;
		 }
		return input;
	}
	
}
