package restart;
import java.util.*;
public class HotelTableAllocation {
  static LinkedList<Integer> customers = new LinkedList();
  static SortedMap <Integer, Integer> tables = new TreeMap();
   static {
	   tables.put(4,4); // table size , count of tables.
	   tables.put(6,3);
	   tables.put(2,6);
   }
	public static void main(String[] args) {
       
		new Thread("Group of Customers") {
			public void run() {
				Random rm = new Random();
				while(true) {
				int people = rm.nextInt(6)+1;
				synchronized(customers) {
				customers.add(people);
				System.out.println(customers);
				customers.notifyAll();
				}
				try {
				Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//end of while
			}
		}.start();
		
		
		new Thread("Table-2") {
			public void run() {
				
				while(true) {
				
				if(customers.size()> 0 && tables.get(2) > 0) {
					System.out.println("before allocation to table-2 customers ="+customers);
					
					int pos=-1;
					for(int i = 0; i < customers.size();i++) {
						
						if(customers.get(i) <= 2) {
							pos = i;
							break;
						}
					}
					if(pos != -1) {
						synchronized(customers) {
						customers.remove(pos);
						tables.put(2,tables.get(2)-1);
						System.out.println("after allocation to table-2 customers ="+customers);
						System.out.println("after allocation tables ="+tables);
						}
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
					else {
						try{
							synchronized(customers) {
							customers.wait();
							}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				
				try {
				Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}//end of while
			}
		}.start();
		
		
		new Thread("Table-6") {
			public void run() {
				
				while(true) {
				
				if(customers.size()> 0 && tables.get(6) > 0) {
					System.out.println("before allocation to table-6 customers ="+customers);
					
					   customers.removeFirst();
					   tables.put(6,tables.get(6)-1);
					   
						System.out.println("after allocation to table-6 customers ="+customers);
						System.out.println("after allocation  tables ="+tables);
						
						try {
							Thread.sleep(4000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
					else {
						try{
							synchronized(customers) {
								customers.wait();
								}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				
				try {
				Thread.sleep(3000);
				System.out.println(Thread.currentThread()+" table released ");
			    tables.put(6,tables.get(6)+1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}//end of while
			}
		}.start();
		
		new Thread("Table-4") {
			public void run() {
				
				while(true) {
				
				if(customers.size()> 0 && tables.get(4) > 0) {
					System.out.println("before allocation to table-4 customers ="+customers);
					
					int pos=-1;
					for(int i = 0; i < customers.size();i++) {
						
						if(customers.get(i) <= 4) {
							pos = i;
							break;
						}
					}
					if(pos != -1) {
						customers.remove(pos);
						tables.put(4,tables.get(4)-1);
						System.out.println("after allocation to table-4 customers ="+customers);
						System.out.println("after allocation  tables ="+tables);
						
						try {
							Thread.sleep(4000);
							tables.put(4,tables.get(4)+1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}else {
						try{
							synchronized(customers) {
								customers.wait();
								}
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				
				try {
				Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}//end of while
			}
		}.start();
	}

}
