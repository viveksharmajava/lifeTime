package sample.test.designPatterns;

public class ProductFactory {

	private static final ProductFactory factory = new ProductFactory();
	private ProductFactory(){};
	
	public static ProductFactory getInstance(){
		return factory;
	}
	
	public Product getProduct(){
		return new Product();
	}
	
}
