package sample.test.designPatterns.structural.adapter;
/*
 * Two Way Adapter Pattern
   While implementing Adapter pattern, there are two approaches – class adapter and object adapter – however both these approaches produce same result.

   Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.
   Object Adapter – This form uses Java Composition and adapter contains the source object see SocketObjectAdapter.
 */
public class SocketSubClassAdapter extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volt() {
		return super.getVolt();
	}

	@Override
	public Volt get12Volt() {
		return new Volt(super.getVolt().getVolts()/10);
	}

	@Override
	public Volt get3Volt() {
		return new Volt(super.getVolt().getVolts()/40);
	}

}
