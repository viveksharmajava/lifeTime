import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Hello {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
     
		HashMap <String, Stock> hm = new HashMap<String, Stock>();
		
		@Override
		public void putNewPrice(String symbol, double price) {
			// YOUR CODE HERE
			if(!hm.containsKey(symbol)) {
				Stock s = new Stock(symbol,price , 1);
				hm.put(symbol,s );
			}
			else{
				Stock s = hm.get(symbol);
				s.total = s.total + price;
				s.ticks = s.ticks + 1;
			}
			
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			Stock s = hm.get(symbol);
			if(s != null) {
				return s.total/s.ticks;
			}
			else {
				return 0.0;
			}
		}

		@Override
		public int getTickCount(String symbol) {
			// YOUR CODE HERE
			Stock s = hm.get(symbol);
			if(s != null) {
				return s.ticks;
			}
			else {
				return 0;
			}
		}
	}
	
	  

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {
		System.out.println("Hello");
		final Set<String> symbols = new TreeSet<>();
		final StatisticsAggregator stats = new StatisticsAggregatorImpl();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			
			String line = scanner.nextLine();
			if("break".equalsIgnoreCase(line)) break;
			String[] inputs = line.split(",");
			for (int i = 0; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);

				stats.putNewPrice(symbol, price);

			}

			
		}
		scanner.close();
		for (String symbol : symbols) {
			System.out.println(
					String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
		}

	}
}

class Stock {
	
	String symbol;
	double total;
	int ticks;
	
	Stock(String s , double t , int ticks){
		this.symbol = s;
		this.total = t;
		this.ticks = ticks;
	}
	
}