package sample.test.designPatterns.structural.adapter;

public class Socket {

	public Volt getVolt() {
		return new Volt(120);
	}
	
}

class Volt{
private int volts;
	
	public Volt(int v){
		this.volts=v;
	}

	public int getVolts() {
		return volts;
	}

	public void setVolts(int volts) {
		this.volts = volts;
	}
	
	
}
