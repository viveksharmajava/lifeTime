package sample.test.designPatterns.structural.decorator;

public class SportsCar extends CarDecorator {

	SportsCar(Car carType) {
		super(carType);
	}
	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Add Sport Car feature");
	}
	

}
