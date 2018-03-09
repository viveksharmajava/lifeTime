package sample.test.collection.queue;
/* URL:http://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
 * Find the first circular tour that visits all petrol pumps
 * Find the first circular tour that visits all petrol pumps
Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.

1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.

Calculate the first point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity). Expected time complexity is O(n). Assume for 1 litre petrol, the truck can go 1 unit of distance.

For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from where truck can make a circular tour is 2nd petrol pump. Output should be “start = 1” (index of 2nd petrol pump).
 */
public class CicularTourVisitsAllPumps {

	public static void main(String[] args) {
     
		PetrolPump [] pumps = new PetrolPump[4];
		pumps[0]  = new PetrolPump(4,6);
		pumps[1]  = new PetrolPump(6,5);
		pumps[2]  = new PetrolPump(7,3);
		pumps[3]  = new PetrolPump(4,5);
		CicularTourVisitsAllPumps circle = new CicularTourVisitsAllPumps();
		circle.findCircleStartPoint(pumps);
		
		pumps[0]  = new PetrolPump(4, 6);
		pumps[1]  = new PetrolPump(3, 6);
		pumps[2]  = new PetrolPump(7, 8);
		pumps[3]  = new PetrolPump(18,4);
		circle.findCircleStartPoint(pumps);
	}

	
	 static class PetrolPump{
		int petrol;
		int distance;
		PetrolPump(int petrol , int dist){
			this.petrol  = petrol;
			this.distance = dist;
		}
	}
	
	public void findCircleStartPoint(PetrolPump [] pumps){
		int start =0 ;
		int end =1;
		int curr_petrol = pumps[start].petrol - pumps[start].distance;
		while(start != end){
			
			if(curr_petrol <0){
				
				while(curr_petrol < 0 && ( start = (start+1)%pumps.length) !=0){
					 end = (end+1)%pumps.length;
					curr_petrol = pumps[start].petrol - pumps[start].distance;
				}
				
				if(start == 0){
					
					System.out.println(" There is no circle for truck with all pump");
					return;
				}
			}
			curr_petrol  += pumps[end].petrol - pumps[end].distance;
			end = (end+1)%pumps.length;
		}
		
		System.out.println(" the circle is starting from "+start);
	}
}
