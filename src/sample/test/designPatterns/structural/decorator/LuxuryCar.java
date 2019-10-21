package sample.test.designPatterns.structural.decorator;

public class LuxuryCar extends CarDecorator {

	LuxuryCar(Car carType) {
		super(carType);
	}
	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Add Luxury Car feature");
	}

}
