package sample.test.designPatterns.creational.absFactory;

import sample.test.designPatterns.model.Computer;

public class ComputerFactory {

	public Computer getComputer(ComputerAbstractFactory cFactory) {
		return cFactory.createComputer();
	}
}
