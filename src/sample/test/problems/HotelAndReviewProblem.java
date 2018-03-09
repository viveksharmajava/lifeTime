package sample.test.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/*
 * We have list of Hotels(hotel_id ,hotel_name,rating ,user_id) need to find list of hotel satisfy rating score
 */
public class HotelAndReviewProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel("101","u1",5));
		hotels.add(new Hotel("101","u1",4));
		hotels.add(new Hotel("100","u2",2));
		hotels.add(new Hotel("104","u3",8));
		getHotels(hotels,5.5d);
	}
	
	static List<Hotel> getHotels(List <Hotel> hotels , double avgRating){
		
		HashMap<String,Double> hotelRatings = new HashMap<String,Double>();
		HashMap<String,Double> hotelCounts = new HashMap<String,Double>();
		Iterator <Hotel> hotelIt = hotels.iterator();
		while(hotelIt.hasNext()){
			Hotel hotel = hotelIt.next();
			if(hotelRatings.containsKey(hotel.hotelId)){
				hotelRatings.put(hotel.hotelId,(Double) hotelRatings.get(hotel.hotelId)+hotel.rating);
				hotelCounts.put(hotel.hotelId,(Double) hotelCounts.get(hotel.hotelId)+1);
			}else{
				hotelRatings.put(hotel.hotelId,hotel.rating);
				hotelCounts.put(hotel.hotelId,1d);
			}
		}
		
		Set <Map.Entry<String, Double> >set = hotelCounts.entrySet();
		for(Map.Entry<String, Double> me  :set){
			hotelRatings.put(me.getKey(),(Double) hotelRatings.get(me.getKey())/me.getValue());
			
		}
	 List <Map.Entry<String, Double>>	list = new ArrayList <Map.Entry<String, Double>>(hotelRatings.entrySet());
	
	  Collections.sort(list,new Comparator<Map.Entry<String, Double>>()
        {
            public int compare( Map.Entry<String, Double> o1, Map.Entry<String, Double> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
	  
		for(Map.Entry<String, Double> me  :list){
			
			if(me.getValue() < avgRating) break;
			System.out.println("key="+me.getKey() +"\t value ="+me.getValue());
			
		}
	  
		return null;
	}

}

class Hotel{
	String hotelId;
	//String hotelName;
	String userId;
    double rating;
	public Hotel(String hotelId, String userId, double rating) {
		super();
		this.hotelId = hotelId;
		this.userId = userId;
		this.rating = rating;
	}
	
	public Hotel(){
		
	}
   
}

// h1, u1, 5
//h1,u2,4
//h3/u10,3
//h1 ,u4, 6

