package leetcode.blind75;

import java.util.LinkedList;
import java.util.Stack;

class InsertInterval {
	public static void main(String [] args) {
		
		int [][] a = {{1,3},{6,9} };
		int [] b = {2,5};
		int [][]result = insert(a,b);
		System.out.println(result);
	}
	public static int[][] insert2(int[][] intervals, int[] newInterval) {
	
		Stack <int []> stack = new Stack<>();
		//base case 1 : if new interval should be first interval
		if(intervals[0][0] > newInterval[1]) {
			stack.add(newInterval);
		}//base case 2 : if new interval is last interval
		else if(intervals[intervals.length-1][1] < newInterval[0]){
			
		}
		else{ 
		int i = 0;
		stack.add(intervals[i]);
		for( i = 1 ; i< intervals.length;i++) {
			int [] interval = intervals[i];
			int [] popped = stack.peek();
			if(popped[1] < newInterval[0] && interval[0] > newInterval[1] ) {
				stack.add(newInterval);
				stack.add(interval);
				break;
			}else if(popped[1] < newInterval[0] && interval[0] < newInterval[0] 
					&& interval[1] > newInterval[1]) {
				stack.add(interval);
				break;
			}
			else if(popped[1] < newInterval[0] && interval[0] > newInterval[0] 
					&& interval[1] < newInterval[1]) {
				newInterval[1] = interval[1];
				stack.add(newInterval);
				break;
			}
			else if(popped[1] < newInterval[0] && interval[0] < newInterval[0] 
					&& interval[1] > newInterval[1]) {
				interval[1] = newInterval[1] ;
				stack.add(newInterval);
				break;
			}
			}
		}
	return intervals;
	}
	
    public static int[][] insert(int[][] intervals, int[] newInterval) {
       
//        Stack <Interval> stack = new Stack<>();
//       stack.push(new Interval(newInterval));
//         for(int i =0 ; i < intervals.length; i++){
        
//             Interval current = new Interval(intervals[i]);
//              if(stack.empty() || current.begin > stack.peek().end){
//                  stack.push(current);
//              }
//               if(stack.peek().end < current.end){
//              stack.peek().end = current.end;
//          }
            
//         }
//        int[][] results = new int[stack.size()][2];
//         // // print all non-overlapping intervals
//          int s = stack.size()-1;
//          while (!stack.empty()) {
//              Interval i = stack.pop();
//              int [] out = {i.begin, i.end};
//              results[s]= out;
//          }
//     return results;
        LinkedList<int[]> merged = new LinkedList<>();
        boolean isMerged =false;
        int i=0;
        for( i=0 ; i <  intervals.length ; i++){
           int [] interval = intervals[i];
            if(!isMerged && interval[0] < newInterval[0] && interval[1] < newInterval[0]){
               merged.add(interval);
           }else if(!isMerged && interval[0] < newInterval[0] && interval[1] > newInterval[0]  && interval[1] < newInterval[1]){
               interval[1] = newInterval[1];
                merged.add(interval);
               isMerged=true;
                break;
           }
           }
        if( i++ < intervals.length-1){
           
            while(i < intervals.length){
               int [] interval = intervals[i];
                if( ( merged.getLast()[0] < interval[0] ) && merged.getLast()[1] > interval[1]){
                   i++;
                   continue;
               }else if(merged.getLast()[1] < interval[1]) {
                 merged.getLast()[1] = interval[1];
                  i++;
               }else{
                   merged.add(interval ) ;
                    i++;
                }
                
            }
        }
        else if(!isMerged){
            merged.add(newInterval);
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}

 
// A class to represent an interval
class Interval
{
    int begin, end;
 
    Interval(int [] interval)
    {
        this.begin = interval[0];
        this.end = interval[1];
    }
 
   
}