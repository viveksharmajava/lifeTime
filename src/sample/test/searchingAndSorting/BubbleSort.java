package sample.test.searchingAndSorting;

//in bubble sort big will be buble to end means each iteration of outer for loop will push one highest element to the end
public class BubbleSort {


	public static void main(String[] args) {
		 int []array= {53,30,3,8,6,10,2};
		 int temp;
		 for(int i=0; i< array.length; i++){
			 for(int j=0 ;j<array.length-i-1 ;j++){
				 if(array[j] > array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] =temp;
				 }
			 }
		 }
		 
		 for(int i=0;i<array.length;i++){
				System.out.println(array[i]);
			}

	}

}
