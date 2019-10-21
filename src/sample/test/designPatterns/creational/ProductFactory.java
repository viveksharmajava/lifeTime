package sample.test.designPatterns.creational;

import sample.test.designPatterns.model.Product;

public class ProductFactory {

	private static final ProductFactory factory = new ProductFactory();
	private ProductFactory(){};
	
	public static ProductFactory getInstance(){
		return factory;
	}
	
	public Product getProduct(String type){
		return new Product();
	}
	
}
