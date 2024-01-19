package designguru.mergeintervals;

import java.util.*;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/63936a049634a0fa11c91b2b
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
	Example 1:
	Jobs: [[1,4,3], [2,5,4], [7,9,6]]
	Output: 7
	Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the jobs are running at the same time i.e., during the time interval (2,4).
	Example 2:
	
	Jobs: [[6,7,10], [2,4,11], [8,12,15]]
	Output: 15
	
 */
public class MaximumCPULoad {

	public static void main(String[] args) {
     List < Job> jobs = new ArrayList<Job>();
     jobs.add(new Job(1,4,3));
     jobs.add(new Job(2,5,4));
     jobs.add(new Job(7,9,6));
     System.out.println(maxCPULoad(jobs));
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
	    	 if(j.start < end) {//overlapped
	    		 if((j.load + load) > max) max = j.load + load;
	    	 }
	    	 else {//no overlapped
	    		 if(max < j.load) {
	    			max = j.load; 
	    		 }
	    	 }
	    	 end = j.end;
	    	 load = j.load;
	    	 
	     }
	     
		 return max;
	 }
}

class Job{
	int start;
	int end;
	int load;
	Job(int s , int e, int l){
		this.start = s;
		this.end = e;
		this.load =l;
	}
}
