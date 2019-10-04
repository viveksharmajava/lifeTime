package sample.test.multithreading;

//example uses sleep to print messages at four-second intervals:
public class SleepMessages {
public static void main(String[] args) throws InterruptedException {
		
	String [] messageInfo = {
			
			"My office is Thermo" ,"Preeti office is Synchronos" ,"Arun Office is School"
	};
	
	for(int i=0;i<messageInfo.length;i++)
	{	Thread.sleep(1000);
	    //Print message
	     System.out.println(messageInfo[i]);
	}

}
}