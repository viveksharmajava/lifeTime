package designguru.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/*
 * We are given a list schedule of employees, which represents the working time for each employee.

	Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
	
	Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
	
	Example 1:
	
	Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
	Output: [[3,4]]
	Explanation:
	There are a total of three employees, and all common
	free time intervals would be [-inf, 1], [3, 4], [10, inf].
	We discard any intervals that contain inf as they aren't finite.
	
	Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
	Output: [3,5]
	Explanation: All the employees are free between [3,5].
	Example 2:
	
	Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
	Output: [4,6], [8,9]
		
 */
public class EmployeeFreeTime {

	public static void main(String[] args) {
     
		List < List<Interval> > employeeHours = new ArrayList < List<Interval> > ();
		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 3));
	    input.add(new Interval(9, 12));
	    
	    employeeHours.add(input);
	    
	    input = new ArrayList<Interval>();
	    input.add(new Interval(2, 4));
	    input.add(new Interval(6, 8));
	    
	    employeeHours.add(input);
	    freeTime(employeeHours);
	    System.out.println("employeeFreeTime ="+employeeFreeTime(employeeHours));
	}
	
  
	 public static void freeTime(List < List<Interval>> empWorkingList) {
		
		 
		 
		 List<Interval> workingHours = new ArrayList<Interval>();
		 for(List <Interval> workingHour : empWorkingList) {
			 workingHours.addAll(workingHour);
		 }
		 
		 Collections.sort(workingHours, (a,b)-> Integer.compare(a.start,b.start));
		 System.out.println(workingHours);
		 Iterator < Interval> it = workingHours.iterator();
		 Interval in = it.next();
		 int start = in.start;
		 int end = in.end;
		 
		 List<Interval> freeHours = new ArrayList<Interval>();
		 while(it.hasNext()) {
			 in = it.next();
			 if(end < in.start) {
				 freeHours.add(new Interval(end,in.start));
				 
			 }
				 end = in.end;
			
		 }
		 System.out.println(freeHours);
	 }
	
	    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
	        List<Interval> allSchedules = new ArrayList<Interval>();
	        for (List<Interval> list : schedule)
	            allSchedules.addAll(list);
	        Collections.sort(allSchedules, (a,b)-> Integer.compare(a.start,b.start));
	        List<Interval> sorted = new ArrayList<Interval>();
	        Interval interval0 = allSchedules.get(0);
	        int curStart = interval0.start, curEnd = interval0.end;
	        int size = allSchedules.size();
	        for (int i = 1; i < size; i++) {
	            Interval interval = allSchedules.get(i);
	            if (interval.start <= curEnd)
	                curEnd = Math.max(curEnd, interval.end);
	            else {
	                sorted.add(new Interval(curStart, curEnd));
	                curStart = interval.start;
	                curEnd = interval.end;
	            }
	        }
	        sorted.add(new Interval(curStart, curEnd));
	        List<Interval> freeTimeList = new ArrayList<Interval>();
	        int sortedSize = sorted.size();
	        for (int i = 1; i < sortedSize; i++)
	            freeTimeList.add(new Interval(sorted.get(i - 1).end, sorted.get(i).start));
	        return freeTimeList;
	    }
}
