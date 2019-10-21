package sample.test.designPatterns.creational.absFactory;

import sample.test.designPatterns.model.Computer;

public class AbsFactoryMain {

	public static void main(String[] args) {
      Computer pc = new ComputerFactory().getComputer(new PCFactory("16 GB", "1TB", "8 Cores"));
      Computer server = new ComputerFactory().getComputer(new ServerFactory("32 GB", "10TB", "16 d Cores"));
      System.out.println(pc);
      System.out.println(server);
  	
	
	}

}
