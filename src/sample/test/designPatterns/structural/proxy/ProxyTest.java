package sample.test.designPatterns.structural.proxy;

public class ProxyTest {

	public static void main(String[] args) throws Exception{

		CommandExecutorProxy proxy = new CommandExecutorProxy("Vivek", "welcome1");
		proxy.runCommand("ls -ltr");
		
		proxy = new CommandExecutorProxy("abc", "welcome1");
		proxy.runCommand("rm -ltr");
	}

}
