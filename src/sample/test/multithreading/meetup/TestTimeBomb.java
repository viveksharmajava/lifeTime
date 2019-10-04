package sample.test.multithreading.meetup;

/*
 * Does it print �Boom!!!� after counting
 * down from Nine to Zero? If not, how
 * will you make it happen
 */
class TimeBomb implements Runnable {
String [] timeStr = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
"Eight", "Nine" };
public void run() {
for(int i = 9; i >= 0; i--) {
System.out.println(timeStr[i]);
}
}
}
public class TestTimeBomb{
	

public static void main(String []s) throws InterruptedException {
TimeBomb timer = new TimeBomb();
System.out.println("Starting 10 second count down... ");
Thread t = new Thread(timer);

t.start();
t.join(); // if t.join() not there below line may be printed before finishing thread t.
System.out.println("Boom!!! should be printed");
}
}

