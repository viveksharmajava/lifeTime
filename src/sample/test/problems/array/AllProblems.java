package sample.test.problems.array;

import sample.test.searchingAndSorting.QuickSortExample;

public class AllProblems {

	/**
	 * @param args
	 * Array:

Given an array A[] and a number x, check for pair in A[] with sum as x
Majority Element
Find the Number Occurring Odd Number of Times
Largest Sum Contiguous Subarray
Find the Missing Number
Search an element in a sorted and pivoted array
Merge an array of size n into another array of size m+n
Median of two sorted arrays
Write a program to reverse an array
Program for array rotation
Reversal algorithm for array rotation
Block swap algorithm for array rotation
Maximum sum such that no two elements are adjacent
Leaders in an array
Sort elements by frequency | Set 1
Count Inversions in an array
Two elements whose sum is closest to zero
Find the smallest and second smallest element in an array
Check for Majority Element in a sorted array
Maximum and minimum of an array using minimum number of comparisons
Segregate 0s and 1s in an array
k largest(or smallest) elements in an array | added Min Heap method
Maximum difference between two elements
Union and Intersection of two sorted arrays
Floor and Ceiling in a sorted array
A Product Array Puzzle
Segregate Even and Odd numbers
Find the two repeating elements in a given array
Sort an array of 0s, 1s and 2s
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Find duplicates in O(n) time and O(1) extra space
Equilibrium index of an array
Linked List vs Array
Which sorting algorithm makes minimum number of memory writes?
Turn an image by 90 degree
Next Greater Element
Check if array elements are consecutive | Added Method 3
Find the smallest missing number
Count the number of occurrences in a sorted array
Interpolation search vs Binary search
Given an array arr[], find the maximum j � i such that arr[j] > arr[i]
Maximum of all subarrays of size k (Added a O(n) method)
Find whether an array is subset of another array | Added Method 3
Find the minimum distance between two numbers
Find the repeating and the missing | Added 3 new methods
Median in a stream of integers (running integers)
Find a Fixed Point in a given array
Maximum Length Bitonic Subarray
Find the maximum element in an array which is first increasing and then decreasing
Count smaller elements on right side
Minimum number of jumps to reach end
Implement two stacks in an array
Find subarray with given sum
Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
Longest Monotonically Increasing Subsequence Size (N log N)
Find a triplet that sum to a given value
Find the smallest positive number missing from an unsorted array
Find the two numbers with odd occurrences in an unsorted array
The Celebrity Problem
Dynamic Programming | Set 15 (Longest Bitonic Subsequence)
Find a sorted subsequence of size 3 in linear time
Largest subarray with equal number of 0s and 1s
Dynamic Programming | Set 18 (Partition problem)
Maximum Product Subarray
Find a pair with the given difference
Replace every element with the next greatest
Dynamic Programming | Set 20 (Maximum Length Chain of Pairs)
Find four elements that sum to a given value | Set 1 (n^3 solution)
Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)
Sort a nearly sorted (or K sorted) array
Maximum circular subarray sum
Find the row with maximum number of 1s
Median of two sorted arrays of different sizes
Shuffle a given array
Count the number of possible triangles
Iterative Quick Sort
Find the number of islands
Construction of Longest Monotonically Increasing Subsequence (N log N)
Find the first circular tour that visits all petrol pumps
Arrange given numbers to form the biggest number
Pancake sorting
A Pancake Sorting Problem
Tug of War
Divide and Conquer | Set 3 (Maximum Subarray Sum)
Counting Sort
Merge Overlapping Intervals
Find the maximum repeating number in O(n) time and O(1) extra space
Stock Buy Sell to Maximize Profit
Rearrange positive and negative numbers in O(n) time and O(1) extra space
Sort elements by frequency | Set 2
Find a peak element
Print all possible combinations of r elements in a given array of size n
Given an array of of size n and a number k, find all elements that appear more than n/k times
Find the point where a monotonically increasing function becomes positive first time
Find the Increasing subsequence of length three with maximum product
Find the minimum element in a sorted and rotated array
Stable Marriage Problem
Merge k sorted arrays | Set 1
Radix Sort
Move all zeroes to end of array
Find number of pairs such that x^y > y^x
Count all distinct pairs with difference equal to k
Find if there is a subarray with 0 sum
Smallest subarray with sum greater than a given value
Sort an array according to the order defined by another array
Maximum Sum Path in Two Arrays
Sort an array in wave form
K�th Smallest/Largest Element in Unsorted Array
K�th Smallest/Largest Element in Unsorted Array in Expected Linear Time
K�th Smallest/Largest Element in Unsorted Array in Worst Case Linear Time
Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
Find the closest pair from two sorted arrays
Given a sorted array and a number x, find the pair in array whose sum is closest to x
Count 1�s in a sorted binary array
Print All Distinct Elements of a given integer array
Construct an array from its pair-sum array
Find common elements in three sorted arrays
Find the first repeating element in an array of integers
Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
Rearrange an array such that �arr[j]� becomes �i� if �arr[i]� is �j�
Find position of an element in a sorted array of infinite numbers
Can QuickSort be implemented in O(nLogn) worst case time complexity?
Check if a given array contains duplicate elements within k distance from each other
Find the element that appears once
Replace every array element by multiplication of previous and next
Check if any two intervals overlap among a given set of intervals
Delete an element from array (Using two traversals and one traversal)
Find the largest pair sum in an unsorted array
Online algorithm for checking palindrome in a stream
Pythagorean Triplet in an array
Maximum profit by buying and selling a share at most twice
Find Union and Intersection of two unsorted Arrays
Count frequencies of all elements in array in O(1) extra space and O(n) time
Generate all possible sorted arrays from alternate elements of two given sorted arrays
Minimum number of swaps required for arranging pairs adjacent to each other
Trapping Rain Water 
Convert array into Zig-Zag fashion
Find maximum average subarray of k length  
Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed  
Reorder an array according to given indexes  
Find zeroes to be flipped so that number of consecutive 1�s is maximized  
Count triplets with sum smaller than a given value  
Find the subarray with least average  
Count Inversions of size three in a give array
Longest Span with same Sum in two Binary arrays
Merge two sorted arrays with O(1) extra space
Form minimum number from given sequence
Subarray/Substring vs Subsequence and Programs to Generate them
Count Strictly Increasing Subarrays
Rearrange an array in maximum minimum form
Find minimum difference between any two elements
Find lost element from a duplicated array
Count pairs with given sum
Count minimum steps to get the given desired array
Find minimum number of merge operations to make an array palindrome
Minimize the maximum difference between the heights
	 */
	public static void main(String[] args) {

		Integer [] result = findPair(11);
		System.out.println(result[0]+"\t "+result[1]);
	}
	
	
	//1. Given an array A[] and a number x, check for pair in A[] with sum as x
	//2. Count pairs with given sum
  
	static Integer[] findPair(int sum){
		Integer []output = new Integer[2];
		//sort input array 
        QuickSortExample sorting= new QuickSortExample();
        sorting.array[0]= 53;
        sorting.array[1]= 30;
        sorting.array[2]= 3;
        sorting.array[3]= 8;
        sorting.array[4]= 6;
        sorting.array[5]= 10;
        sorting.array[6]= 2;
        //{53,30,3,8,6,10,2};
		sorting.quickSort(0,6);
		int l =0;
		int r=6;
		while(l <r){
			if( (sorting.array[l] + sorting.array[r]) == sum){
				output[0] =sorting.array[l];
				output[1] =sorting.array[r];
				return output;
			}
			else if( (sorting.array[l] + sorting.array[r]) > sum)  r--;
			else if( (sorting.array[l] + sorting.array[r]) < sum)  l++;
			
		}
		
		
		return  null;
	}
	
	

}
