package sample.test.searchingAndSorting;

public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array= {53,30,3,8,6,10,2};
		 int temp=0;
		 
		 for(int i=1 ;i< array.length; i++){
	       for(int j=0; j<i ;j++ ){
	    	   if(array[j] > array[i]){
	    		   temp = array[i];
	    		   for (int k=i ;k>j ;k--){
		    		   array[k] = array[k-1];
		    	   }
		    	   array[j] = temp;
	    	   }
	    	   
	    	   
	    		   
	       }
	       
	}
		 
	//EOF sorting
		 for(int i=0;i<array.length;i++){
				System.out.println(array[i]);
			}
		 

}
}
