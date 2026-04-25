package educative.programs.practice;

public class FizzBuzzProblem {

	public static void main(String[] args) {
		FizzBuzzPrinter printer = new FizzBuzzPrinter(20);
		Thread fizz = new Thread(new FizzBuzzRUnnable(printer,"fizz"));
		Thread buzz = new Thread(new FizzBuzzRUnnable(printer,"buzz"));
		Thread fizzbuzz =new Thread( new FizzBuzzRUnnable(printer,"fizzbuzz"));
		Thread number = new Thread(new FizzBuzzRUnnable(printer,"number"));
		fizz.start();
		buzz.start();
		fizzbuzz.start();
		number.start();
		
		
	}

}

class FizzBuzzRUnnable implements Runnable{
	FizzBuzzPrinter printer ;
	String type;
	FizzBuzzRUnnable(FizzBuzzPrinter p,String t){
		this.printer = p;
		this.type = t;
	}
	public void run() {
		
		if("fizz".equals(type))
			try {
				printer.fizz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if("buzz".equals(type))
			try {
				printer.buzz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else if("fizzbuzz".equals(type))
			try {
				printer.fizzbuzz();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				printer.nubmer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
class FizzBuzzPrinter{
	int num ;
	int n = 0;
	
	FizzBuzzPrinter(int limit){
		this.num = limit;
	}
	public synchronized void fizz() throws InterruptedException {
		while(n < num) {
			if(n%3 == 0 && n%5 !=0) {
				System.out.println("fizz");;
				n++;
				notifyAll();
			}else {
				wait();
			}
		}
	}
	public synchronized void buzz() throws InterruptedException {
		while(n < num) {
			if(n%3 != 0 && n%5 ==0) {
				System.out.println("buzz");;
				n++;
				notifyAll();
			}else {
				wait();
			}
		}
	}
	public synchronized void fizzbuzz() throws InterruptedException {
		while(n < num) {
			if(n%3 == 0 && n%5 ==0) {
				System.out.println("fizzbuzz");;
				n++;
				notifyAll();
			}else {
				wait();
			}
		}
	}
	public synchronized void nubmer() throws InterruptedException {
		while(n < num) {
			if(n%3 != 0 && n%5 !=0) {
				System.out.println(""+n);;
				n++;
				notifyAll();
			}else {
				wait();
			}
		}
	}
}