package designguru.cyclesort;

public class CycleSort {

	public static void main(String[] args) {
		int arr[] = { 1, 8, 3, 9, 10, 10, 2, 4 };
        int n = arr.length;
        cycleSort(arr);
        //cyclicSort2(arr); not working
        System.out.println("After sort : ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
	}
 /*
  * https://www.geeksforgeeks.org/cycle-sort/
  * Explanation : 

	 arr[] = {10, 5, 2, 3}
	 index =  0   1   2   3
	cycle_start = 0 
	item = 10 = arr[0]
	
	Find position where we put the item  
	pos = cycle_start
	i=pos+1
	while(i<n)
	if (arr[i] < item)  
	    pos++;
	
	We put 10 at arr[3] and change item to 
	old value of arr[3].
	arr[] = {10, 5, 2, 10} 
	item = 3 
	
	Again rotate rest cycle that start with index '0' 
	Find position where we put the item = 3 
	we swap item with element at arr[1] now 
	arr[] = {10, 3, 2, 10} 
	item = 5
	
	Again rotate rest cycle that start with index '0' and item = 5 
	we swap item with element at arr[2].
	arr[] = {10, 3, 5, 10 } 
	item = 2
	
	Again rotate rest cycle that start with index '0' and item = 2
	arr[] = {2, 3,  5, 10}  
	
	Above is one iteration for cycle_stat = 0.
	Repeat above steps for cycle_start = 1, 2, ..n-2
  */
	public static void cycleSort(int [] arr) {
		int n = arr.length;
		//count the number of memory writes
		int writes = 0;
		//traverse the elements and put it on right place.
		for(int cycle_start = 0 ;cycle_start < n-2 ; cycle_start++ ) {
			//initialize the item at first point
			int item = arr[cycle_start];
			
			//find the position where we put the item
			// we basically count all the smallest element on the right side 
			int pos = cycle_start;
			for(int  i= cycle_start+1 ; i < n; i++) {
				if(arr[i] < item) pos++;
			}
			//if item is already at correct positon
			if( pos == cycle_start) continue;
			//ignore all the duplicate elements
			while(item == arr[pos]) pos+=1;	
			
			//put the item to its right positon
			if(pos != cycle_start) {
				int temp = item  ;
				item = arr[pos];
				arr[pos] = temp;
				writes++;
			}
			// Rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;
 
                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++)
                    if (arr[i] < item)
                        pos += 1;
 
                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;
 
                // put the item to it's right position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
			
		}
		
	}
	  
}
