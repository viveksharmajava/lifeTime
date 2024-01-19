package educative.programs;

/*
 * Print Odd even using thread intercommunication
 * 
 */
public class PrintOddEvenNumber {

	public static void main(String[] args) throws InterruptedException {
		Printer print = new Printer();
	    Thread t1 = new Thread(new OddEvenTask(false, 20,print),"Odd");
	    Thread t2 = new Thread(new OddEvenTask(true,20,print),"Even");
	    t1.start();
	    Thread.sleep(1000);
	    t2.start();
	}

}

class OddEvenTask implements Runnable{
	private int max =0;
	private boolean isEven;
	private Printer printer;
	
	OddEvenTask(boolean isEven, int max , Printer p){
		this.isEven = isEven;
		this.max = max;
		this.printer = p;
	}
	public void run() {
		int num = isEven ? 2 :1;
		while(num <= max) {
			if(isEven) {
				printer.printEven(num);
				
			}else {
				printer.printOdd(num);
			}
			num +=2;
		}
	}
}
class Printer{
	private  volatile boolean isOdd =true;
	public synchronized void printEven(int number) {
		while(isOdd) {
			try {
				wait();
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName()+" printing even number "+number);
		isOdd=true;
		notify();
	}
	public synchronized void printOdd(int number) {

		while(!isOdd) {
			try {
				wait();
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(Thread.currentThread().getName()+" printing odd number "+number);
		isOdd=false;
		notify();
	
	}
}