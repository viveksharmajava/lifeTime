package sample.test.designPatterns.structural.proxy;

public class CommandExecutorImpl implements CommandExecutor {

	
	@Override
	public void runCommand(String cmd) throws Exception {
		//some heavy implementation
		Runtime.getRuntime().exec(cmd);
		System.out.println(" Command "+cmd+" Executed");
	}

}
