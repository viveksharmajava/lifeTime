package jenkov.concurrencyutil;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Exchanger e = new Exchanger();
       ExchangeRunnable er1 = new ExchangeRunnable(e, "A");
       ExchangeRunnable er2 = new ExchangeRunnable(e, "B");
       new Thread(er1).start();
       new Thread(er2).start();
	}

}

class ExchangeRunnable implements Runnable{
	Exchanger exchange;
	Object obj;
	ExchangeRunnable(Exchanger e , Object o){
		this.exchange  = e;
		this.obj  = o;
	}
	@Override
	public void run() {
		
		Object prev= obj;
		try {
			  this.obj =	this.exchange.exchange(this.obj);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() +" exchanged  "+prev +" for"+this.obj);
	}
	
}
