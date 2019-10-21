package sample.test.designPatterns.structural.proxy;

public class CommandExecutorProxy extends CommandExecutorImpl {

	boolean isAdmin = false;
	CommandExecutorImpl cExec;
	
	public CommandExecutorProxy(String user , String pwd) {
		
		if("Vivek".equals(user) && "welcome1".equals(pwd)) isAdmin = true;
		cExec = new CommandExecutorImpl();
	}
	
	public void runCommand(String cmd) throws Exception {
		if(isAdmin){
			cExec.runCommand(cmd);
		}
		else {

			if(cmd.trim().startsWith("rm")){
				throw new Exception("rm command is not allowed for non-admin users.");
			}else{
				cExec.runCommand(cmd);
			}
		}
	}
	
}
