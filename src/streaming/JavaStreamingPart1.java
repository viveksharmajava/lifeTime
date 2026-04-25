package streaming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;

/*
 * https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
 */
public class JavaStreamingPart1 {

	public static void main(String[] args) {
     
		List <Transaction> transactions = new ArrayList<>();
		for(int i = 1 ; i <= 10000; i++) {
			transactions.add(new Transaction(1,Transaction.TYPE.GROCERRY));
		}
		for(int i = 10001 ; i <= 20000; i++) {
			transactions.add(new Transaction(i,Transaction.TYPE.SHOES));
		}
		for(int i = 20001 ; i <= 30000; i++) {
			transactions.add(new Transaction(i,Transaction.TYPE.COSMETIC));
		}
		for(int i = 30001 ; i <= 40000; i++) {
			transactions.add(new Transaction(i,Transaction.TYPE.JWELLERY));
		}
		for(int i = 40001 ; i <= 41001; i++) {
			transactions.add(new Transaction(i,Transaction.TYPE.ELECTRONICS));
		}
		for(int i = 50001 ; i <= 60000; i++) {
			transactions.add(new Transaction(i,Transaction.TYPE.JWELLERY));
		}
	
		//System.out.println(transactions);
		long start = System.currentTimeMillis();
		List<Integer> ids = transactions.stream().filter(t -> t.getType() == Transaction.TYPE.ELECTRONICS).sorted(Comparator.comparingInt(Transaction::getId).reversed()).
		map(Transaction::getId).collect(Collectors.toList());
		long end = System.currentTimeMillis() -start;
		System.out.println("Time taken = "+end);
		System.out.println("ids ="+ids.size());
		 start = System.currentTimeMillis();
		ids = transactions.parallelStream().filter(t -> t.getType() == Transaction.TYPE.ELECTRONICS).sorted(Comparator.comparingInt(Transaction::getId).reversed()).
				map(Transaction::getId).collect(Collectors.toList());
		end = System.currentTimeMillis() -start;	
		System.out.println("Time taken by parallel = "+end);
		System.out.println("ids ="+ids.size()
				);
		
		start = System.currentTimeMillis();
		ids = transactions.parallelStream().filter(t -> t.getId()%2 == 0).
				map(Transaction::getId).limit(5).toList();
		end = System.currentTimeMillis() -start;	
		System.out.println("Time taken by parallel = "+end);
		System.out.println("ids ="+ids
				);
		
		
		 transactions.parallelStream().filter(t -> t.getId()%2 == 0).
				map(Transaction::getId).findAny().ifPresent(System.out::println);
		
		 List<Integer> list =Arrays.asList(1,2,3,4,5,6,7,8,9,100);
		 list.stream().map(a -> a*a).forEach( System.out::println);
		 
		 list =Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		 System.out.println(list.stream().reduce(0, (a,b)-> a+b).intValue()); 
		 list =Arrays.asList(1,2,3,4,5);
		 System.out.println(list.stream().reduce(1, (a,b)-> a*b).intValue()); 
		 
		 list =Arrays.asList(1,2,3,4,5,2000);
		 System.out.println(list.stream().reduce(0,Integer::max)); //simply returns max
		 System.out.println("Sum = "+Arrays.asList(1,2,3,4,5,2000).stream().mapToInt(a-> a).sum());
		 
		 IntStream.range(1, 5).forEach(System.out::println);
		 
		
	}

}

class Transaction{
	 TYPE t ;
	 Integer id;
	enum TYPE{
		GROCERRY,SHOES,ELECTRONICS,COSMETIC,JWELLERY;
	};
	Transaction(Integer id,TYPE type){
		this.t = type;
		this.id = id;
	}
	public TYPE getType() {
		return this.t;
	}
	public Integer getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.t.toString();
	}
}