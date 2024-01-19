import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
class T implements Runnable{
	public void run() {
		System.out.println("i'm done!");
		}
}

 class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
}
//    public static void main(String[] args) {
//        new ReaderThread().start();
//        number = 42;
//        ready = true;
//}
    
 }
public class Test {
	static int x = 10;
	static {
		System.out.println("from static");
	}
	{
	System.out.println("from non-static");	
	}
	public static void main(String [] args) throws ParseException {
	
             Properties p = new Properties();
             p.setProperty("b", "a");
             System.out.println(p.get("a"));
	        SimpleDateFormat FORMATTER = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
	        TimeZone etTimeZone = TimeZone.getTimeZone("Asia/Bangkok"); 
		       
	        FORMATTER.setTimeZone(etTimeZone);
	        Calendar calendar = Calendar.getInstance(etTimeZone);
	        Date currentDate = FORMATTER.parse("Oct 18, 2021 08:30:30 AM");
	        calendar.setTime(currentDate);
	        System.out.println("before adjusting = "+ calendar.getTime());
	        System.out.println(etTimeZone.getOffset(currentDate.getTime()));
	        long offset = etTimeZone.getOffset(currentDate.getTime()) ;
		    
	        if(offset > 0 ){
		    	offset = offset/(1000*60);//convert to  minutes
		    	Long hours = offset/60;
		    	Long minutes = offset%60;
		    	calendar.add(Calendar.HOUR_OF_DAY,- hours.intValue());
				calendar.add(Calendar.MINUTE, - minutes.intValue());
		    }
	        else  if(offset < 0 ){
	        	offset = -offset;
		    	offset = offset/(1000*60);//convert to  minutes
		    	Long hours = offset/60;
		    	Long minutes = offset%60;
		    	calendar.add(Calendar.HOUR_OF_DAY, hours.intValue());
				calendar.add(Calendar.MINUTE, minutes.intValue());
		    }
		    System.out.println("UTC equavalent = "+ calendar.getTime());
	}
}

 

