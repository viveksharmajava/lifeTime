package educative.concurrency;

public class IncorrectSynchronization {
	Boolean flag = new Boolean(true);
	public void example() throws InterruptedException
	{
		Thread t1 = new Thread() {
			public void run() {
				synchronized(flag) {
					while(flag) {
					System.out.println(Thread.currentThread().getName()+"\t before going to sleep!");	
					try {
						Thread.sleep(50000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					try {
						flag.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					}
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				flag = false;
				System.out.println("Thread "+Thread.currentThread()+"\t changed the flag!");
			}
		};
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.join();
		t2.join();
	}
	public static void main(String[] args) throws InterruptedException{
		IncorrectSynchronization incorrectSyncronization = new IncorrectSynchronization();
		incorrectSyncronization.example();
	}

}
