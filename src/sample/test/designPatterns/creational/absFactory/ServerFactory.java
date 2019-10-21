package sample.test.designPatterns.creational.absFactory;

import sample.test.designPatterns.model.Computer;
import sample.test.designPatterns.model.Server;

public class ServerFactory implements ComputerAbstractFactory {
	private String ram ;
	private String hdd ;
	private String cpuCores;
	
	ServerFactory(String ram, String hdd, String cpuCores) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpuCores = cpuCores;
	}
	@Override
	public Computer createComputer() {
		return new Server(ram, hdd, cpuCores);
	}

}
