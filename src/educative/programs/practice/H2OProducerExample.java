package educative.programs.practice;

import java.util.Arrays;
import java.util.Collections;

public class H2OProducerExample {

	public static void main(String[] args) {
		H2oMachine machine = new H2oMachine();
		Thread h = new Thread(new H2OThread(machine, "H"));
		Thread o = new Thread(new H2OThread(machine, "O"));
		h.start();
		o.start();
	}

}

class H2OThread implements Runnable{
	H2oMachine machine;
	String type;
	H2OThread(H2oMachine m,String t){
		this.machine  = m;
		this.type= t;
	}
	public void run() {
		while(true) {
			if("H".equals(type))
				try {
					machine.hydrogenAtom();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else if("O".equals(type))
				try {
					machine.oxygenAtom();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
class H2oMachine{
	String [] h2o = new String[3];
	int count = 0;
	Object sync = new Object();
	H2oMachine(){ };
	
	public void hydrogenAtom() throws InterruptedException {
		synchronized(sync){
			while(Collections.frequency(Arrays.asList(h2o), "H") == 2) {
				sync.wait();
			}
			h2o[count] = "H";
			count++;
			sync.notifyAll();
			if(count == 3) {
				System.out.println(Arrays.toString(h2o));
				Arrays.fill(h2o, null);
				count = 0;
			}
			sync.notifyAll();
		}
	}

	public void oxygenAtom() throws InterruptedException {
		synchronized(sync){
			while(Collections.frequency(Arrays.asList(h2o), "O") == 1) {
				sync.wait();
			}
			h2o[count] = "O";
			count++;
			sync.notifyAll();
			if(count == 3) {
				System.out.println(Arrays.toString(h2o));
				Arrays.fill(h2o, null);
				count = 0;
			}
			sync.notifyAll();
			
		}
	}
}
