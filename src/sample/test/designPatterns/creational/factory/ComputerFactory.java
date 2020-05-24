package sample.test.designPatterns.creational.factory;

import sample.test.designPatterns.model.*;

public class ComputerFactory {
 
//you can also make factory object as singleton
 private  static final 	ComputerFactory computerFactory = new  ComputerFactory();
 
  private ComputerFactory() {
	  
  }
  public static ComputerFactory getInstace() {
	  return computerFactory;
  }
  
  public Computer getComputer(String type , String hdd , String ram, String cpuCores) {
	  
	  Computer c = null;
	  if("PC".equals(type)) {
		  c = new PC(ram, hdd, cpuCores);
	  }
	  else if ("Server".equals(type)){
	  }
	  
	  return c;
	  
  }
}
