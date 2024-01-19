package designguru.kwaymerge;

import java.util.PriorityQueue;

public class FindKthSmallestInMsortedLists {

	public static void main(String[] args) {
		int[][] arr = { { 2, 6, 12 }, { 1, 9 }, { 23, 34, 90, 2000 } }; 
        int m = 4; 
        System.out.println(findKthSmallest(arr, m)); 
	}
	
	public static int findKthSmallest(int[][] arr, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(); 
		 int elem = -1;
		 for(int i=0; i < arr.length;i++) {
			 pq.add(new Pair(arr[i][0],i,0));
		 }
		 
		 int count = 0;
		 int i=0; //i ==> Array Number 
		 int j =0; // j ==> Index in the array number 
		
		            
		 while(count < k && !pq.isEmpty()) {
			 Pair p  = pq.poll();
			 i = p.arrayNumber;
			 j= p.index;
			 if( j+ 1 < arr[i].length) {
				 pq.add(new Pair(arr[i][j+1],i,j+1));
			 }
			 count++;
		 }
		 return  arr[i][j]; 
		 
	}

	static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
 
            node = node.next;
        }
        System.out.println();
    }
 

}


//Class to store array number and index 
class Pair implements Comparable<Pair> { 
  int value; 
  int arrayNumber; 
  int index; 
 
  // Constructor 
  public Pair(int v, int i, int j) { 
      value = v; 
      arrayNumber = i; 
      index = j; 
  } 
 
  // Compare two pair according to their values. 
  public int compareTo(Pair o) { 
      return this.value - o.value; 
  } 
}

