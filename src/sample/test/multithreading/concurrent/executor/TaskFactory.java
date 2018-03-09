package sample.test.multithreading.concurrent.executor;

public class TaskFactory {
	
	public static final TaskFactory taskFactory = new TaskFactory();
	
	public synchronized static TaskFactory getInstance(){
		return taskFactory;
	}
	
	public ITask getTask(String inputType,Object obj){
		System.out.println("get task called ");
		ITask task=null;
		if(inputType.equals("A")){
			System.out.println("get task called for TaskA");
			task= new TaskA((ClassA)obj);
		}
		else if (inputType.equals("B")){
			System.out.println("get task called for TaskB");
			task= new TaskB((ClassB)obj);
		}
		
		return task;
	}

}
