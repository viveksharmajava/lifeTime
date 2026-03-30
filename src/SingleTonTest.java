import java.lang.reflect.Constructor;

public class SingleTonTest {
	private static final ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	private static  SingleTonTest singleTon ;
	 private final BISecurityMetricsWrapper metricsWrapper;
	public static void main(String[] args) {
		SingleTonTest test  = SingleTonTest.getInstance();
		SingleTonTest test2  = SingleTonTest.getInstance();
		System.out.println("test ="+test);
		System.out.println("test2 ="+test2);
	}
	public static synchronized SingleTonTest getInstance() {
		if(singleTon == null) singleTon = new SingleTonTest();
		return singleTon;
	}
	private SingleTonTest() {
		try
	    {
	       // logger.log(Level.WARNING,"Warning 1");
			System.out.println("test1");
	        Class<?> clazz = classLoader.loadClass(BISecurityMetricsWrapper.class.getName());
	        Constructor<?> constructor = clazz.getConstructor();
	        System.out.println("test2");
	        this.metricsWrapper = (BISecurityMetricsWrapper)constructor.newInstance();
	        System.out.println("test3");
	    }
	    catch (Exception e)
	    {
	       // logger.log(Level.WARNING,"Warning 2");
	    	System.out.println("From Exception");
	        throw new RuntimeException(e);
	        
	    }  
	}
}


class BISecurityMetricsWrapper{
	public BISecurityMetricsWrapper(){
		System.out.println("from BISecurityMetricsWrapper");
		
	}
}

   
