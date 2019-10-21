package sample.test.designPatterns.structural.decorator;

public class CarDecorator  implements Car{

	Car car ;
	CarDecorator(Car carType){
		this.car = carType;
	}
	
	@Override
	public void assemble() {
		System.out.println("CarDecorator");
		car.assemble();
	}
	

}
