package sample.test.searchingAndSorting;

public class QuickSortExample {

	/**
	 * @param args
	 */
	public Integer []array= {53,30,3,8,6,10,2};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortExample sorting= new QuickSortExample();
		
		sorting.quickSort(0,6);
		for(int i=0;i<sorting.array.length;i++){
			System.out.println(sorting.array[i]);
		}
		
	}
	
	public void quickSort(int i ,int j){
		
		int lowerIndex = i;
		int hightIndex =j;
		int pivot = array[(hightIndex + hightIndex)/2];
		while(array[i] < pivot) i++;
		while(array[j] > pivot) j--;
		if(i <= j){
			swap(i,j);
			i++;
			j--;
		}
		if(lowerIndex <  j) quickSort(lowerIndex ,j);
		if(i <hightIndex) quickSort(i,hightIndex);
	}
 public void swap(int i , int j){
	 
	 int temp = array[i];
	 array[i] = array[j];
	 array[j] = temp;
 }
}
