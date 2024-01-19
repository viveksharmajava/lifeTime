package designguru.mergeintervals;
import java.util.ArrayList;
/*
 * https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/639366c54599b3e5714ab178
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.

	Example 1:
	
	Meetings: [[1,4], [2,5], [7,9]]
	Output: 2
	Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can occur in any of the two rooms later.
	Example 2:
	
	Meetings: [[6,7], [2,4], [8,12]]
	Output: 1
	Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
	Example 3:
	
	Meetings: [[1,4], [2,3], [3,6]] 
	
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MinimumMeetingRooms {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 3));
	    input.add(new Interval(3, 6));
	    
	    System.out.println(minRooms(input));
	}

	public static int minRooms(List <Interval> meetings) {
		Integer rooms= 0;
		Collections.sort(meetings,(a,b)->Integer.compare(a.start, b.start));
		
		//TreeMap <Integer,Integer> map = new TreeMap<>();
		Iterator <Interval> it = meetings.iterator();
		Interval interval = it.next();
		int s = interval.start;
		int e = interval.end;
		rooms++;
		//map.put(e,1);
		while(it.hasNext()) {
			interval = it.next();
			if(e > interval.start) {
				rooms++;
				//map.put(interval.end,map.getOrDefault(interval.end,0)+1);
			}
			// SortedMap <Integer, Integer > entry = map.headMap(interval.start);
//			 for(Integer k : entry.keySet()) { //what will happen for vacant rooms when collison occur after certain hours.
//				 rooms -=map.get(k);
//				 map.put(k,0);
//			 }
			 
		}		
	    
		return rooms;
		
	}
}
