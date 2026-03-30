package designguru.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<Interval>();
	    input.add(new Interval(1, 4));
	    input.add(new Interval(2, 5));
	    input.add(new Interval(7, 9));
	    System.out.print("Merged intervals: ");
	    for (Interval interval : merge(input))
	        System.out.print("[" + interval.start + "," + interval.end + "] ");
	    
	    
	    System.out.println("practiceMergeInterval");
	    for (Interval interval : practiceMergeInterval(input))
	        System.out.print("[" + interval.start + "," + interval.end + "] ");
	    
	    
	}

	public static  List<Interval> merge(List<Interval> intervals){
		if(intervals == null || intervals.size() < 2) return intervals;
		
		Collections.sort(intervals , (a,b)-> Integer.compare(a.start, b.start));
		
		List < Interval> mergedIntervals = new ArrayList < Interval>();
		Iterator <Interval> iterator = intervals.iterator();
		Interval interval = iterator.next();
		int start = interval.start;
		int end = interval.end;
		while(iterator.hasNext()) {
			interval = iterator.next();
			if( interval.start <= end) {//overlapping intervals
				end = Math.max(interval.end, end);
			}else {
				mergedIntervals.add(new Interval(start,end));
				start = interval.start;
				end = interval.end;
			}
		}
		// add the last interval
	    mergedIntervals.add(new Interval(start, end));
		return mergedIntervals;
	}
	
	public static List<Interval> practiceMergeInterval(List <Interval> inrervals){
		List <Interval> result = new ArrayList <>();
		ArrayList<Integer> min = new ArrayList<>();
		min.getLast();
		Collections.sort(inrervals, (a,b) -> Integer.compare(a.start, b.start) );
		
		Iterator <Interval> it = inrervals.iterator();
		Interval interval = it.next();
		int start = interval.start;
		int end = interval.end;
		while(it.hasNext()) {
			interval = it.next();
			if( interval.start <= end) {
				end = Math.max(end, interval.end);
			}
			else {
				result.add(new Interval(start,end));
				start = interval.start;
				end = interval.end;
			}
		}
		//add last interval
		result.add(new Interval(start,end));
		
		return result;
	}
	
}


