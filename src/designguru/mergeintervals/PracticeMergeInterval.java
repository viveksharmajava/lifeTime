package designguru.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PracticeMergeInterval {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 5));
	    input.add(new Interval(7, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : mergeOverlapping(input))
	        System.out.print("[" + interval.start + "," + interval.end + "] ");
	
	    int arr1[][] = { { 0, 4 }, { 5, 10 },
                { 13, 20 }, { 24, 25 } };

		int arr2[][] = { { 1, 5 }, { 8, 12 },
		                { 15, 24 }, { 25, 26 } };
		
		intersectIntervals(arr1, arr2);
		System.out.println("\n minMeetingRooms \n");
		LinkedList<Interval> input2 = new LinkedList<Interval>();
		input2.add(new Interval(1, 4));
		input2.add(new Interval(2, 3));
		input2.add(new Interval(3, 6));
	    
		System.out.println(minMeetingRooms(input2));
		
		 List < Job> jobs = new ArrayList<Job>();
	     jobs.add(new Job(1,4,3));
	     jobs.add(new Job(2,5,4));
	     jobs.add(new Job(7,9,6));
	     System.out.println("maxCPULoad");
	     System.out.println(PracticeMergeInterval.maxCPULoad(jobs));
	
	}
	
	public static List<Interval> mergeOverlapping(List < Interval> intervals){
		
		LinkedList <Interval> result = new LinkedList<>();
		Collections.sort(intervals, (a,b)->  Integer.compare(a.start,b.start));
		Iterator <Interval> it = intervals.iterator();
		Interval interval = it.next();
		int start = interval.start;
		int end = interval.end;
		while(it.hasNext()) {
			interval = it.next();
			if( end  < interval.start) {
				end = Math.max(end, interval.end);
			}else {
				result.add(new Interval(start,end));
				start = interval.start;
				end = interval.end;
			}
		}
		return result;
	}
	//https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639249470cddc1617da1b889
	public static void intersectIntervals(int [][] arr1 , int [][] arr2) {
		int i=0;
		int j=0;
		int n = arr1.length;
		int m = arr2.length;
		while(i < n && j < m) {
			int l = Math.max(arr1[i][0], arr2[j][0]);
			int k = Math.min(arr1[i][1], arr2[j][1]);
			if(l <= k) {
				System.out.println("Intersect is {"+l+", "+k+"}");
			}
			if(arr1[i][1]< arr2[j][1]) i++;
		   else j++;
		}
	}
 // problem : Minimum Meeting Rooms
 public static int minMeetingRooms(LinkedList <Interval> meetings) {
	 Collections.sort(meetings, (a,b)->  Integer.compare(a.start,b.start));
	 Iterator <Interval> it = meetings.iterator();
		Interval meeting = it.next();
		int start = meeting.start;
		int end = meeting.end;
		int count =1;
		while(it.hasNext()) {
			meeting = it.next();
			if( end  > meeting.start) {
				count++;
				end = Math.max(end , meeting.end);
			}else {
				//start = meeting.start;
				end = Math.max(end , meeting.end);
			}
		}
		
	   	return count;
	 
 }
 public static int maxCPULoad(List<Job> jobs ) {
	 
	 
	 Collections.sort(jobs, (a,b)-> Integer.compare(a.start, b.start));
     Iterator < Job> it = jobs.iterator();
     Job j = it.next();
     int end = j.end;
     int load = j.load;
     int max= load;
     while(it.hasNext()) {
    	 j = it.next();
    	 if( j.start < end) { //overlapped
    		 max = Math.max(max, (load+j.load));
    		 end = Math.max(end, j.end);
    	 }else {
    		 load = j.load;
    		 end  = j.end;
    	 }
     }
     
     return max;
 } 
 /*
  * 1. Find the free time for first employee
  * 2. check remaining employee if there is common free time interval else return 
  *    no free time.
  * 3. keep updating common free time after processing each employee.
  * 4. Print the free time interval.
  */
 public static void employeeFreeTime(LinkedList < LinkedList<Interval>> empWorkingList) {
	 
	 if(empWorkingList == null || empWorkingList.size() < 2) return;
	 //find the free time for
 }
}

