package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
class Lattice{
	int x ;
	int y;
	Lattice(int a , int b){
		this.x = a;
		this.y = b;
	}
	
	@Override
	public int hashCode() {
		return this.x+this.y;
	}
	@Override
	public boolean equals(Object o) {
		Lattice l = (Lattice) o;
		return this.x == l.x &&  this.y ==l.y;
	}
	@Override 
	public String toString() {
		return "["+this.x+","+this.y+"]";
	}
}
public class BusStopDistance {
	
	 private static Set<Lattice> getAllLattice(int x,int y, int r){
		 
		 Set<Lattice> lattice = new  HashSet <>();
		 lattice.add(new Lattice(x,y+r));
		 lattice.add(new Lattice(x+r,y));
		 
		 lattice.add(new Lattice(x,y-r));
		 lattice.add(new Lattice(x-r,y));
		 
		 return lattice;
	 }
	
	 public static int countLatticePoints(int[][] circles) {
	        int lattice =0;
	        Set<Lattice> Alllattice = new  HashSet <>();
	        for(int i= 0 ; i <  circles.length; i++){
	            int circle[] = circles[i];
	        	int x = circle[0];
	        	int y = circle[1];
	        	int r = circle[2];
	        	Alllattice.add(new Lattice(x,y));
	        	Alllattice.addAll(getAllLattice(x,y,r));
	        	System.out.println(Alllattice);
	        	
	        }
	        return Alllattice.size();
	    }

public static List<Integer> intersection(int[][] nums) {
    
    TreeMap<Integer,Set<Integer>> intersectMap = new TreeMap<>();
   for(int i= 0 ; i <  nums.length; i++){
       for(int j=0; j <nums[i].length; j++){
           intersectMap.putIfAbsent(nums[i][j], new HashSet<Integer>());
            intersectMap.get(nums[i][j]).add(i);
           
       }
   }

   List <Integer> intersectList = new LinkedList<>();
   intersectMap.forEach((key,value ) ->{
	   if(value.size() == nums.length) intersectList.add(key);
   });
   return intersectList;
   
}

public static boolean containsDuplicate(int[] nums) {
//    Arrays.sort(nums);
//    System.out.println(Arrays.toString(nums));
//    return hasDuplicates(nums,0,nums.length-1);
//    
	
	 HashSet<Integer> set = new HashSet<>();
     for(int i = 0 ; i<nums.length; i++) {
    	 set.add(nums[i]);
     }
     return set.size() == nums.length;
}
public static int maxSubArray(int[] nums) {
    
    int max_sum = Integer.MIN_VALUE;
    int sum = 0;
    for(int i = 0 ; i < nums.length ; i++ ){
         sum += nums[i];
        if( sum > max_sum) {
        	max_sum = sum;
        }
        if(sum < 0) {
            sum = 0;
        }
        
    }
    return max_sum;
}
public static int[] productExceptSelf(int[] nums) {
    
    int [] answer = new int [nums.length];
    //count 0
    int zeros= 0;
    int first_zero_indx= -1;
    for(int i=0; i < nums.length; i++) {
    	if(nums[i] == 0 && zeros ==0) {
    		zeros =1;
    		first_zero_indx = i;
    	}
    	else if(nums[i] == 0 && zeros >0) {
    		zeros = zeros + 1;
    		break;
    	}
    }
    
    if(zeros > 1) {
    	return answer;
    }
    else if ( zeros == 1) {
    	int product , start_indx;
    	if(first_zero_indx != 0) {
    		product = nums[0]; 
    		answer[0] = 0;
    		start_indx=1;
    		for(int i  = start_indx; i < nums.length; i++) {
    			if(first_zero_indx == i) continue;
    			else {
    				answer[i] = 0;
    				product *=nums[i];
    			}
    			
    		}
    		answer[first_zero_indx] =product;
    	}
    	else {
    		product = nums[1]; 
    		start_indx= 2;
    		answer[1] = 0;
    		for(int i  = start_indx; i < nums.length; i++) {
    				answer[i] = 0;
    				product *=nums[i];
    			}
    			answer[0] =product;
    		}
    	}
    	
    else if ( zeros == 0) {
    	int product = nums[0];
    	for(int i = 1 ;i < nums.length ; i++) {
    		product *= nums[i];
    	}
    	for(int i = 0 ;i < nums.length ; i++) {
    		answer[i]= product/nums[i];
    	}
    	
    }
    return answer;
}

private static boolean hasDuplicates(int [] nums, int start, int end){
    if(start >= end ) return false;
     int mid = (start+end)/2;
    if(mid > 0) {
        if (nums[mid] == nums[mid-1]) return true;
    }
     if ( mid < nums.length-1){
        if (nums[mid] == nums[mid+1]) return true;
    }
    
    return hasDuplicates(nums, 0, mid-1) || hasDuplicates(nums,mid+1, end);
}

public static int maxProduct(int[] prices) {
   int max_product =  prices[0];
   int min_product_sofar = prices[0];
   int max_product_sofar = prices[0];
   
   for(int i = 1 ; i < prices.length; i++){
       int temp = max_product_sofar ;
       max_product_sofar = Integer.max(prices[i], Integer.max(max_product_sofar*prices[i],
    		   			   min_product_sofar*prices[i]));
    min_product_sofar = Integer.min(prices[i], Integer.min(temp*prices[i],min_product_sofar*prices[i]));   
    max_product = Integer.max(max_product, max_product_sofar);                        
   }
return max_product;      
}
public static int findMin(int[] nums) {
    if(nums[0] > nums[nums.length-1]){
        
        int  mid = (0+nums.length-1)/2;
        while(mid > 0 && mid < nums.length){
          if( nums[mid-1] > nums[mid] && nums[mid] < nums[mid+1]) return nums[mid];
         if(nums[mid] < nums[nums.length-1]){
             mid = (mid)/2;
         }else{
             mid = (mid + nums.length-1)/2;
         }
         
        }  //eof while   
        return nums[nums.length-1];
    }//eof if
      else{
        return nums[0];
    }
}


	public static void main(String[] args) {
		
		int [] min = {2,3,1};
		System.out.println(findMin(min));
		int max[] = {-2,1,-3,4,-1,2,1,-5,4 }; 
		System.out.println(maxSubArray(max));
		int []product= {1,2,3,4};//{-1,1,0,-3,3};
		int [] answer = productExceptSelf(product);
		System.out.println(Arrays.toString(answer));
		int duplicate[] = {2,14,18,22,22};
		System.out.println(containsDuplicate(duplicate));
		
//		int [][]circles = {{2,2,2},{3,4,1}};
//		//System.out.println("countLatticePoints ="+countLatticePoints(circles));
//		int a [][] = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
//		int b [][] = {{1,2,3},{4,5,6}};
//		System.out.println("intersection="+intersection(a));
//		
	int []in ={2,3,-2,4};
	System.out.println("maxProduct ="+maxProduct(in));
//	  int []distance = {7,10,1,12,11,14,5,0};
//     //System.out.println(distanceBetweenBusStops(distance ,7,2));
	}
	  public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		  int s, e ;
		  int n = distance.length;
		  if( start > destination) {
			  s = destination;
			  e = start;
		  }
		  else {
			  s = start;
			  e = destination;
		  }
		  int distance1 = 0;
		  for(int i = s; i <= e; i++) {
			  distance1 +=distance[i%n];
		  }
		  if( start > destination) {
			  s = destination;
			  e = start;
		  }
		  else {
			  s = start;
			  e = destination;
		  }
		  int distance2 = 0;
		  for(int i = e; i >=s ; i--) {
			  distance2 +=distance[i];
		  }
		  return Integer.max(distance1, distance2);
	  }
}
