package sample.test.designPatterns.structural.decorator;

public class DecoratorPatternTest {

	public static void main(String[] args) {

		 Car sportCar = new SportsCar(new BasicCar());
		 sportCar.assemble();
		 Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		 sportsLuxuryCar.assemble();
	}

}
