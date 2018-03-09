package sample.test.multithreading.concurrent.executor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExecutorServiceImpl {
	
	
	
	public static void main(String []args){
		AbsClass a =	new ClassA();
		AbsClass b =	new ClassB();
		HashMap<String,AbsClass> hm=new HashMap<String,AbsClass>();
		hm.put("A",a);
		hm.put("B",b);
		CustomExecutor executor = new CustomExecutor(2);
		executor.sumbitTasks(hm);
		executor.processAllTasks(hm);
	}
	
}
