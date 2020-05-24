package sample.test.designPatterns.structural.adapter;

public class AdapterPatternTest {

	public static void main(String[] args) {
		SocketAdapter sockAdapter = new SocketObjectAdapter();
		System.out.println("get 120 Volts ="+sockAdapter.get120Volt().getVolts());
		System.out.println("get 12 Volts ="+sockAdapter.get12Volt().getVolts());
		System.out.println("get 3 Volts ="+sockAdapter.get3Volt().getVolts());
		
		SocketAdapter sockClassAdapter = new SocketSubClassAdapter();
		System.out.println("get 120 Volts ="+sockClassAdapter.get120Volt().getVolts());
		System.out.println("get 12 Volts ="+sockClassAdapter.get12Volt().getVolts());
		System.out.println("get 3 Volts ="+sockClassAdapter.get3Volt().getVolts());
	}

}
