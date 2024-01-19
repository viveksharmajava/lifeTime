package educative.programs;

import java.util.Arrays;
import java.util.Collections;

/*
 *  educative pdf  #244
 *  Suppose we have a machine that creates molecules by combining atoms. 
 *  We are creating water molecules by joining one Oxygen and two Hydrogen atoms. 
 *  The atoms are represented by threads. The machine will wait for the required atoms (threads), then group one Oxygen and two Hydrogen threads to simulate the creation of a molecule. The molecule then exists the machine. You have to ensure that one molecule is completed before moving onto the next molecule. If more than the required number of threads arrive, they will have to wait.
 *  The figure below explains the working of our machine:
 */
public class H2OMachineProblem {

	public static void main(String[] args) {
		H2OMachine machine = new H2OMachine();
		H2OThread h2 = new H2OThread("Oxygen", machine);
		H2OThread o = new H2OThread("Hydrogen", machine);
		
		new Thread(h2).start();
		new Thread(o).start();
		
	}

}

class H2OThread implements Runnable {
	String type;
	H2OMachine machine;
	H2OThread(String s,H2OMachine m ){
		this.type = s;
		machine = m;
	}
	public void run() {
	 
		if(type == "Oxygen")	{
		  try {
			while(true)
			{
				machine.OxygenAtom();
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 }else {
		 try {
			while(true) {
				machine.HydrogenAtom();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	}
	
}
class H2OMachine{
	int index;
	String h2o[];
	Object sync;
	H2OMachine(){
		h2o = new String[3];
		index = 0;
		sync = new Object();
	}
	public  void HydrogenAtom() throws InterruptedException {
		synchronized(sync) {
			while(Collections.frequency(Arrays.asList(h2o), "H") == 2) {
				sync.wait();
			}
			h2o[index] = "H";
			index++;
			sync.notifyAll();
			// if molecule is full, then exit.
			if(index == 3) {
			for (String element: h2o) {
			System.out.print(element); 
			}
			System.out.println();
			Arrays.fill(h2o,null);
			index = 0; 
			}
			sync.notifyAll();
		}
	}
	public  void OxygenAtom() throws InterruptedException {

		synchronized(sync) {
			while(Collections.frequency(Arrays.asList(h2o), "O") == 1) {
				sync.wait();
			}
			h2o[index] = "O";
			index++;
			sync.notifyAll();
			// if molecule is full, then exit.
			if(index == 3) {
			for (String element: h2o) {
			System.out.print(element); 
			}
			System.out.println();
			Arrays.fill(h2o,null);
			index = 0; 
			}
			sync.notifyAll();
		}
	
	}
	
}
