package sample.test.collection.list;

public class Main {

	public static void main(String[] args) {

		 LinkedList<Integer> list = new LinkedList<Integer>();
		
		 list.add(4); list.add(1);
		// list.add(4);
		// list.printAll();
		 list.deleteEven();
		 System.out.println("After deleting Node having Even Data");
		 list.printAll();
	}

}
