package sample.test.designPatterns.creational.builder;

public class BuilderTest {

	public static void main(String[] args) {
    Computer c = new Computer.ComputerBuilder("1 TB", "32 GB").setIsBluetoothEnabled(true).setIsGraphicsCardEnabled(false).build();
    System.out.println(c);
	}

}
