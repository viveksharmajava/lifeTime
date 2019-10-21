package sample.test.runtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandRun {

	public static void main(String[] args) {
		

		try {
			//Thread.sleep(100000);
			String process;
			int isCommandRunRunning =0;
			// getRuntime: Returns the runtime object associated with the current Java application.
			// exec: Executes the specified string command in a separate process.
			Process p = Runtime.getRuntime().exec("jps");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((process = input.readLine()) != null) {
				System.out.println(process); // <-- Print all Process here line
												// by line
				if(process.contains("CommandRun")) {
					isCommandRunRunning++;
					//break;
				}
			}
			if( isCommandRunRunning<2) {
				while(true) {
					System.out.println("I'm printing here !");
				}
			
			}
			else {
				System.out.println("I'm  already printing in other window !");
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}

	}

}
