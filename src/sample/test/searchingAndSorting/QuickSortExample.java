package sample.test.searchingAndSorting;

public class QuickSortExample {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortExample sorting= new QuickSortExample();
		 Integer []array= {53,30,3,8,6,10,2};
		sorting.quickSort(array,0,6);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
	}
	
	public void quickSort(Integer []array, int i ,int j){
		
		int lowerIndex = i;
		int hightIndex =j;
		int pivot = array[(hightIndex + lowerIndex)/2];
		while(array[i] < pivot) i++;
		while(array[j] > pivot) j--;
		if(i < j){
			swap(array,i,j);
			i++;
			j--;
		}else {
			return;
		}
		if(lowerIndex <  j) quickSort(array,lowerIndex ,j);
		if(i <hightIndex) quickSort(array,i,hightIndex);
	}
 public void swap(Integer []array,int i , int j){
	 
	 int temp = array[i];
	 array[i] = array[j];
	 array[j] = temp;
 }
}
