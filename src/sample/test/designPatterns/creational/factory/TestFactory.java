package sample.test.designPatterns.creational.factory;
import sample.test.designPatterns.model.Computer;

public class TestFactory {

	public static void main(String[] args) {

	 ComputerFactory cf = ComputerFactory.getInstace();
	 Computer c = cf.getComputer("PC", "500GB", "8GB", "dual core");
	 System.out.println(c);	
	}

}
