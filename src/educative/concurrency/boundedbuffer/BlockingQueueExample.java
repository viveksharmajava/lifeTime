package educative.concurrency.boundedbuffer;

public class BlockingQueueExample {

	public static void main(String[] args) {
	final BlockingQueue<Integer> q = new BlockingQueue<Integer>(5);
		Thread t1 = new Thread(new Runnable() {
		@Override
		   public void run() {
			try {
			for (int i = 0; i < 50; i++) {
			    q.enqueue(new Integer(i));
			    System.out.println("enqueued " + i);
			   }
			}catch (InterruptedException ie) {
			}
		  }
	});
	}
}

class BlockingQueue<T>{
	T [] array;
	int size;
	int capacity;
	int head;
	int tail;
	BlockingQueue(int capacity){
		array = (T[]) new Object[capacity]; this.capacity = capacity;
	}
	
	public synchronized void enqueue(T a) throws InterruptedException {
		if(capacity == size) {
			wait();
		}
		if(tail == capacity) tail = 0; //tail reached to end of the array
		array[tail]  = a;
		size++;
		tail++;
		notifyAll();
		
	}
	
	public synchronized T dequeue() throws InterruptedException {
		if(size == 0) {
			wait();
		}
		if(head == capacity) head = 0;
		T a = array[head];
		array[head] = null;
		head++;
		size--;
		notifyAll();
		return a;
		
	   
	}
	
}