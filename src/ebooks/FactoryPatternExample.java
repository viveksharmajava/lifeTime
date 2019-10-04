package sample.test.designPatterns;

public class FactoryPatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductFactory productFactory = ProductFactory.getInstance();
		Product  product  = productFactory.getProduct();
	}

}
