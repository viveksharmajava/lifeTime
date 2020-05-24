package sample.test.designPatterns.structural.adapter;

public class SocketObjectAdapter implements SocketAdapter {

	Socket s = new Socket();
	@Override
	public Volt get120Volt() {
		// TODO Auto-generated method stub
		return new Volt(s.getVolt().getVolts());
				
	}

	@Override
	public Volt get12Volt() {
		// TODO Auto-generated method stub
		return new Volt(convertVolt(s.getVolt().getVolts(),10));
	}

	@Override
	public Volt get3Volt() {
		// TODO Auto-generated method stub
		return new Volt(convertVolt(s.getVolt().getVolts(),40));
	}
	
	private int convertVolt(int v , int c) {
		return v/c;
	}

}
