package sample.test.collection.queue;;

public class QueueSample {

	public static void main(String[] args) {

		
		Queue<Integer> queue  = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		Integer i =null;
		while(( i = queue.dequeue()) !=null){
			System.out.println(i);
		}
		
		
		PriorityQueue<Integer> pq  = new PriorityQueue();
		pq.enqueue(1,1);
		pq.enqueue(2,2);
		pq.enqueue(3,3);
		pq.enqueue(4,4);
		 i =null;
		while(( i = pq.dequeue()) !=null){
			System.out.println(i);
		}
		
	}

}
