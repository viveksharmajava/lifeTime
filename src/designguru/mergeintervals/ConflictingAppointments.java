package designguru.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639363de4599b3e5714ab022
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
	
	Example 1:
	
	Appointments: [[1,4], [2,5], [7,9]]
	Output: false
	Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
	Example 2:
	
	Appointments: [[6,7], [2,4], [8,12]]
	Output: true
	Explanation: None of the appointments overlap, therefore a person can attend all of them.
	Example 3:
	
	Appointments: [[4,5], [2,3], [3,6]]
	Output: false
 */
public class ConflictingAppointments {

	public static void main(String[] args) {

		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(6, 7));
	    input.add(new Interval(2, 4));
	    input.add(new Interval(8, 12));
	    
	    System.out.println(canProcessAllAppointment(input));
	}
	
	public static boolean canProcessAllAppointment(List <Interval> intevals) {
		
		Collections.sort(intevals, (a,b)-> Integer.compare(a.start, b.start));
		Iterator <Interval> it = intevals.iterator();
		Interval interval = it.next();
		int s = interval.start;
		int e = interval.end;
		while(it.hasNext()) {
			interval = it.next();
			if(e > interval.start) return false;
		}
		
		return true;
	}

}
