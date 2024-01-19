package ds500problems.heap;

public class HeapSort {
	public static void main(String[] args) {

		int [] a = {50,10,30,5,45};
		
		HeapSort hs = new HeapSort();
		hs.print(a);
		System.out.println();
		hs.sort(a);
		System.out.println();
		hs.print(a);
	}
	
	public void sort(int [] a) {
		buildMaxHeap(a);
		int heapSize = a.length-1;
		 for(int i = heapSize; i>=0;i--) {
			 swap(a,i,0);
			 maxHeapify(a, 0, heapSize-1);
			 heapSize = heapSize -1;
		  }
		print(a);
	}
	
	public void buildMaxHeap(int []a) {
	int heapSize = a.length-1;
	  for(int i = heapSize/2; i>=0; i--) {
		maxHeapify(a ,i,heapSize);
	  }
	}
	public void buildMinHeap(int []a) {
		int heapSize = a.length-1;
		  for(int i = heapSize/2; i>=0; i--) {
			minHeapify(a ,i,heapSize);
		  }
		}
  private void minHeapify(int []a ,int i , int heapSize ) {
		
		int l = 2*i+1;
		int r = 2*i + 2;
		int smallest =i ;
		if(l <= heapSize && a[l]< a[i]) smallest = l;
		
		if(r <= heapSize && a[r] < a[smallest]) smallest = r;
		
		if(smallest != i) {
			swap(a,i , smallest);
			maxHeapify(a, smallest, heapSize);
		}
		
	}
	
	private void print(int [] a) {
		for(int i = 0 ; i< a.length; i++) {
			 System.out.print(a[i]+"\t");
		  }
	}
	private void maxHeapify(int []a ,int i , int heapSize ) {
		
		int l = 2*i+1;
		int r = 2*i + 2;
		int largest =i ;
		if(l <= heapSize && a[l]> a[i]) largest = l;
		
		if(r <= heapSize && a[r] > a[largest]) largest = r;
		
		if(largest != i) {
			swap(a,i , largest);
			maxHeapify(a, largest, heapSize);
		}
		
	}
	
	private void swap(int [] a ,int i , int largest) {
		int temp = a[i];
		a[i]  = a[largest];
		a[largest] = temp;
	}

}
