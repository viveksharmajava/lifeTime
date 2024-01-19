package ds500problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class CountPrimeInGivenArray {

	public static void main(String[] args) {
		
		int [] arr3 = new int [1000000];
		for(int i=0 ; i < 1000000 ; i++) {
			arr3[i] = i+1;
		}
		long start = (new Date()).getTime();
		
		System.out.println("Total Prime = "+primeCount(arr3));
		long  end = (new Date()).getTime();
		System.out.println("Execution time="+(end-start));
		start = (new Date()).getTime();
		System.out.println("Total unqiue Prime = "+uniquePrimeCount(arr3));
		end = (new Date()).getTime();
		System.out.println("Execution time="+(end-start));
		start = (new Date()).getTime();
		System.out.println("Total Prime = "+primeCountParrallel(arr3));
		  end = (new Date()).getTime();
		  System.out.println("Execution time="+(end-start));
	}
	//using Sieve of Eratosthenes
    static int primeCount(int [] arr) {
    	//Find the max element in given array.
    	int max_val = Arrays.stream(arr).max().getAsInt();
    	
    	//I want to make sure that given array size is not too small
    	//as compare to max other wise Sieve of Eratosthenes solution won't be 
    	//be optimum approach
    	// for example input array: { 345353,234234,8900 } it doesn't make any sense to create
    	// a boolean array of size 345353
    	 int count = 0;
    	if (max_val/arr.length <= 12 ) { // insertion sort works best for small input.

            // USE SIEVE TO FIND ALL PRIME NUMBERS LESS
            // THAN OR EQUAL TO max_val
            // Create a boolean array "prime[0..n]". A
            // value in prime[i] will finally be false
            // if i is Not a prime, else true.
            Boolean[] prime = new Boolean[max_val + 1];
            for (int i = 0; i < max_val + 1; i++)
            {
                prime[i] = true;
            }
     
            // Remaining part of SIEVE
            prime[0] = false;
            prime[1] = false;
            for (int p = 2; p * p <= max_val; p++)
            {
     
                // If prime[p] is not changed, then
                // it is a prime
                if (prime[p] == true)
                {
     
                    // Update all multiples of p
                    for (int i = p * 2; i <= max_val; i += p)
                    {
                        prime[i] = false;
                    }
                }
            }
     
            // Find all primes in arr[]
           
            for (int i = 0; i < arr.length; i++)
            {
                if (prime[arr[i]])
                {
                    count++;
                }
            }
     
            return count;
    	}else {
    		//don't use Sieve of Eratosthenes solution 
    		// loop till sqaure root of n
    		for(int i = 0 ; i < arr.length ; i++) {
    			boolean prime  = true;
    			for(int p = 2 ; p*p < arr[i]; p++) {
    				if(arr[i]%p == 0) {
    					prime = false;
    					break;
    				}
    			}
    			if(prime)count++;
    		}
    	  return count;	
    	}
    }

    
    //using Sieve of Eratosthenes
    static int uniquePrimeCount(int [] arr) {
    	//Find the max element in given array.
    	int max_val = Arrays.stream(arr).max().getAsInt();
    	
    	//I want to make sure that given array size is not too small
    	//as compare to max other wise Sieve of Eratosthenes solution won't be 
    	//be optimum approach
    	// for example input array: { 345353,234234,8900 } it doesn't make any sense to create
    	// a boolean array of size 345353
    	HashSet <Integer> primeSet = new HashSet<>();
    	if (max_val/arr.length <= 12 ) { // insertion sort works best for small input.

            // USE SIEVE TO FIND ALL PRIME NUMBERS LESS
            // THAN OR EQUAL TO max_val
            // Create a boolean array "prime[0..n]". A
            // value in prime[i] will finally be false
            // if i is Not a prime, else true.
            Boolean[] prime = new Boolean[max_val + 1];
            for (int i = 0; i < max_val + 1; i++)
            {
                prime[i] = true;
            }
     
            // Remaining part of SIEVE
            prime[0] = false;
            prime[1] = false;
            for (int p = 2; p * p <= max_val; p++)
            {
     
                // If prime[p] is not changed, then
                // it is a prime
                if (prime[p] == true)
                {
     
                    // Update all multiples of p
                    for (int i = p * 2; i <= max_val; i += p)
                    {
                        prime[i] = false;
                    }
                }
            }
     
            // Find all primes in arr[]
           
            for (int i = 0; i < arr.length; i++)
            {
                if (prime[arr[i]])
                {
                	primeSet.add(arr[i]);
                }
            }
     
            return primeSet.size();
    	}else {
    		//don't use Sieve of Eratosthenes solution 
    		// loop till sqaure root of n
    		for(int i = 0 ; i < arr.length ; i++) {
    			boolean prime  = true;
    			for(int p = 2 ; p*p < arr[i]; p++) {
    				if(arr[i]%p == 0) {
    					prime = false;
    					break;
    				}
    			}
    			if(prime)primeSet.add(arr[i]);;
    		}
    	  return primeSet.size();	
    	}
    }
    
  //using Sieve of Eratosthenes
    static int primeCountParrallel(int [] arr) {
    	//Find the max element in given array.
    	int max_val = Arrays.stream(arr).max().getAsInt();
    	
    	//I want to make sure that given array size is not too small
    	//as compare to max other wise Sieve of Eratosthenes solution won't be 
    	//be optimum approach
    	// for example input array: { 345353,234234,8900 } it doesn't make any sense to create
    	// a boolean array of size 345353
    	
            // USE SIEVE TO FIND ALL PRIME NUMBERS LESS
            // THAN OR EQUAL TO max_val
            // Create a boolean array "prime[0..n]". A
            // value in prime[i] will finally be false
            // if i is Not a prime, else true.
            Boolean[] prime = new Boolean[max_val + 1];
            for (int i = 0; i < max_val + 1; i++)
            {
                prime[i] = true; //we can avoid this loop by flipping 
            }
             int count = 0;
            // Remaining part of SIEVE
            prime[0] = false;
            prime[1] = false;
            for (int p = 2; p * p <= max_val; p++)
            {
     
                // If prime[p] is not changed, then
                // it is a prime
                if (prime[p] == true)
                {
     
                    // Update all multiples of p
                    for (int i = p * 2; i <= max_val; i += p)
                    {
                        prime[i] = false;
                    }
                }
            }
     
            // Find all primes in arr[]
           
//            for (int i = 0; i < arr.length; i++)
//            {
//                if (prime[arr[i]])
//                {
//                    count++;
//                }
//            }
            ExecutorService executor = Executors.newFixedThreadPool(5);
            AtomicInteger total_count = new AtomicInteger(0);
            for(int i= 0 ; i<10; i++) {
    		    int start = i*10000;
    		    int  end = start+99999;
    		   
    			WorkerThread worker = new WorkerThread(arr,start,end,prime,total_count,false);
    			//worker.setName("worker-"+i);
    			executor.execute(worker);
    		}
    		
    		executor.shutdown();
    		while(!executor.isTerminated()) {
    			//System.out.println("Waiting for termination !");
    		}
            return total_count.get();
    	
    }
 
}

 class WorkerThread  implements Runnable{
	
	int [ ] arr;
	int start,end;
	Boolean [] prime;
	List <Integer> primes = new ArrayList<>();
	boolean unqiuePrime = false;
	AtomicInteger count ;
	WorkerThread(int [] input , int s ,int e, Boolean[] prime2
			,AtomicInteger counts,boolean unqiue){
		this.arr = input;
		this.start = s;
		this.end = e;
		this.prime = prime2;
		this.count = counts;
		this.unqiuePrime = unqiue;
		
	}
	public void run() {
		for(int i = start ; i <= end ; i++ ) {
			if(prime[arr[i]]) {
				primes.add(arr[i]);
			}
		}
	   if(unqiuePrime) {
		  primes = new ArrayList<Integer>(new HashSet<Integer>(primes));
		  
	  }
	  count.addAndGet(primes.size());
	}
}

