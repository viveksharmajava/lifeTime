package sample.test.ds.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  create a max heap
 *  Problems can be solved : supposed you have a huge file storing cordinates(x,y)  you need to return n cordinates
 *  which are farthes from (0,0).
 */
public class MaxHeap {
	
	Integer [] maxHeap;
	MaxHeap(int heapSize){
		maxHeap = new Integer[heapSize];
	}
	
	public static void main(String []args){
		System.out.println("Enter Array Size");
		BufferedReader input = new BufferedReader( new InputStreamReader(System.in));
		String in ="";
	
		MaxHeap mh ;
		
		try {
			in = input.readLine();
			int arrySize  = Integer.parseInt(in);
			mh = new MaxHeap(arrySize+1);
			int i =0;
			while( ! "end".equals(in)){
				in = input.readLine();
				mh.maxHeap[arrySize] = Integer.parseInt(in);
				mh.heapify(arrySize);
				i++;
				
			}
			mh.print();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void print(){
		for(int i=0;i<maxHeap.length; i++){
			System.out.print(maxHeap[i]+"\t");
		}
	}
	private void heapify( int lastInsert){
		
		while(lastInsert >0 && maxHeap[lastInsert] > maxHeap[lastInsert/2]  ) {
			swap(lastInsert , lastInsert/2 );
			lastInsert = lastInsert/2;
			
		}
	}
	
	public void swap(int a , int b){
		int temp = maxHeap[a];
		maxHeap[a] = maxHeap[b];
		maxHeap[b] =temp;
		
	}
}


