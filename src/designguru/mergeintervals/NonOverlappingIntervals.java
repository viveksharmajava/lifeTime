package designguru.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
       int [][] arr = {{1,100},{11,12},{1,11},{2,12}}; //[[1,100],[11,22],[1,11],[2,12]]
		System.out.println(eraseOverlapIntervals(arr));
	}
	 public static int eraseOverlapIntervals(int[][] intervals) {
		 List<Interval> list = new ArrayList<Interval>();
		 Interval interval =null;
		 for(int i = 0 ; i < intervals.length; i++) {
			 interval = new Interval(intervals[i][0],intervals[i][1]);
		     list.add(interval);
		 }
		 
		 System.out.println(list);
		 Collections.sort(list, (a,b)-> Integer.compare(a.start,b.start));
		 
		 System.out.println(list);
		 int count =0;
		 Iterator <Interval> it = list.iterator();
		 interval  = it.next();
		 int s = interval.start;
		 int e = interval.end;
		 int local =0;
		 while(it.hasNext()) {
			 interval = it.next();
			 if(e > interval.start) {
				 local++;
			 }else {
				 if(local > 0) {
					 count ++;
					 local = 0;
				 }
				 s = interval.start;
				 e = interval.end;
			 }
		 }
		 if(local > 0) {
			 count +=local;
		 }
		 return count;
	    }
}
