package sample.test.searchingAndSorting;

public class MergeSort {

	public static void main(String[] args) {

		int []array= {53,30,3,8,6,10};
		int [] sorted = mergeSort(array,0,5);
		 for(int i=0;i<sorted.length;i++){
				System.out.println(sorted[i]);
		}
	}
	
	public static int [] mergeSort(int a[] , int p , int r) {
	
	  if(p < r) {
		  int  q  = (p+ r)/2;
		  mergeSort(a,p,q);
		  mergeSort(a,q+1,r);
		  merge(a ,p,q,r);
		  
	  }
	  return a;
	}
	
	
	public static void merge(int []a ,int p , int q , int r) {
		try {
		int l1 = q-p+1;
		int l2 = r-q;
		int [] L1 = new int [l1];
		int [] R1 = new int [l2];
		int i,j;
		//System.out.println("L1 length="+L1.length+"\t R1="+R1.length+"\t a[] length="+a.length);
		for( i = 0 ; i <l1 ; i ++) {
		//	System.out.println("copieng from a["+( p+i) +"]\t into L1["+i+"]");
			L1[i] = a[p+i];
		}
		
		for( i = 0 ; i <l2 ; i++) {
			//System.out.println("copieng from a["+ (q+1+i) +"]\t into R1["+i+"]");
			R1[i] = a[q+1+i];
		}
		
	    i = 0;
	    j = 0;
	    int k = p;
	   while(k <= r) {
		   
		   if( (((i+1)<= L1.length && (j+1) <= R1.length) && L1[i] <= R1[j]) || j == R1.length) {
			   a[k] = L1[i];
			   i++;
		   }else if ((j+1) <= R1.length){
			   a[k] = R1[j];
			   j++;
		   }
		   k++;
	   }
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}