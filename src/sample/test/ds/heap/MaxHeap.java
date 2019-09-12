package sample.test.ds.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/*
 *  create a max heap
 *  Problems can be solved : supposed you have a huge file storing cordinates(x,y)  you need to return n cordinates
 *  which are farthes from (0,0).
 */

public class MaxHeap {
	
	int [] maxHeap;
	int i=0;
	MaxHeap(int heapSize){
		maxHeap = new int[heapSize+1];
	}
	
	public static void main(String []args){
		System.out.println("Enter Array Size");
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		String in ="";
	
		MaxHeap mh = new MaxHeap(5);
		Random r = new Random();
//		for(int i=0 ; i <= 5 ;i++) {
//			int random = r.nextInt(100);
//			System.out.println(random);
//			mh.insert(random);
//		}
		mh.insert(81);
		mh.insert(13);
		mh.insert(14);
		mh.insert(50);
		mh.insert(45);
		mh.insert(32);
		System.out.println("MaxHeap before sorted");
		mh.printMaxHeap();
		System.out.println("\n MaxHeap after sorted");
		mh.printSortedMaxHeap();
//		try {
//			in = input.readLine();
//			int arrySize  = Integer.parseInt(in);
//			mh = new MaxHeap(arrySize+1);
//			int i =0;
//			while( i <= arrySize){
//				in = input.readLine();
//				mh.insert(Integer.parseInt(in));
//				i++;
//				
//			}
//			mh.printMaxHeap();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	public void printSortedMaxHeap() {
		//update MaxHeap.i( which holds last position).
		int counter = this.i=this.maxHeap.length-2;  // maxHeap has one size extra to hold temp element
		while(counter >= 0) {
		  System.out.println(this.maxHeap[0]);	
		  this.maxHeap[0] = this.maxHeap[counter];
		  counter--;
		  i--;
		  heapifyForMin();
		}
		
		
	}
	public void printMaxHeap(){
		for(int i=0;i<maxHeap.length-1; i++){
			System.out.print(maxHeap[i]+"\t");
		}
	}
	private void heapify( int lastInsert){
		int parent = (lastInsert-1)/2;
		while(lastInsert >0 && maxHeap[lastInsert] > maxHeap[parent]  ) {
			swap(lastInsert , parent);
			lastInsert = parent;
			
		}
	}
	
	private void heapifyForMin() {
		int c= 0;
		while(c <= this.i   ) {
			if(((2*c+1) <= this.i) && (maxHeap[c] < maxHeap[2*c+1])) {
				swap(c , 2*c+1);
				c = 2*c+1;
			}
			else if (((2*c+2) <= this.i) && maxHeap[c] < maxHeap[2*c+2] ) {
				swap(c , 2*c+2);	
				c = 2*c+2;
			}
			else {
				break;
			}
			
			
		}
	}
	
	private void swap(int a , int b){
		int temp = maxHeap[a];
		maxHeap[a] = maxHeap[b];
		maxHeap[b] =temp;
		
	}
	public void insert(int element) {
		
		this.maxHeap[i] = element;
		this.heapify(i);
		if(! (i+1 ==this.maxHeap.length))i++; // it has reached to the arraysize+1 so now keep replacing last index value since it is temporary variable
	}
	
	
}


