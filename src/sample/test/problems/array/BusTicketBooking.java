package sample.test.problems.array;

import java.util.ArrayList;

/*
 * you have given list of given bus station( from start to destination)
 *  for given bus route
 *  user has booked a seat from one point to another 
 *  find all points which can not be booked
 *  example  A--->B--->C-->D--E--->F-->G-->H if  user has booked bus from  B--->D then another user can't book same seat
 *  for A-E, A-C,A-F,A-G,A-H ,C-E,C-F,C-G,C-H 
 *  
 */
public class BusTicketBooking {
   static int [] routePoints = {0, 1, 2, 3, 4 ,5 ,6 ,7 };
	public static void main(String []args){
		System.out.println(blockedStation(1,3));
	}
	
	static ArrayList<String> blockedStation(int bookingSource, int bookingDestination){
		ArrayList <String> blocked = new ArrayList<String>();
		for(int j=0 ; j < bookingDestination ;j++){
		for(int i=bookingSource+1 ;i < routePoints.length; i++){
			
				if( i== bookingSource) continue;
				
				blocked.add(""+j+","+i);
				
			}
		}
		return blocked;
	}
}
