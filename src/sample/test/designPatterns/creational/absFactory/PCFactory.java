package sample.test.designPatterns.creational.absFactory;

import sample.test.designPatterns.model.Computer;
import sample.test.designPatterns.model.PC;

public class PCFactory implements ComputerAbstractFactory {

	private String ram ;
	private String hdd ;
	private String cpuCores;
	
	PCFactory(String ram, String hdd, String cpuCores) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpuCores = cpuCores;
	}

	@Override
	public Computer createComputer() {
		return new PC(ram, hdd, cpuCores);
	}

}
