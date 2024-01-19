package jenkov.concurrencyutil;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayElement  implements Delayed{

	String name;
	Long delay;
	DelayElement(String elem , long timeinMilliseconds){
		delay =  System.currentTimeMillis() + timeinMilliseconds;
		this.name = elem;
	}
	@Override
	public int compareTo(Delayed o) {
		DelayElement d = (DelayElement)o;
		return this.delay.compareTo(d.delay);
		//return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff =   delay - System.currentTimeMillis()  ;
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

}
