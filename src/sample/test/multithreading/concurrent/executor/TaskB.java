package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.Callable;

public class TaskB  implements ITask ,Callable<AbsClass>{

	  private ClassB b;
	  TaskB(ClassB b){
		  this.b=b;
	  }
	@Override
	public AbsClass call(){
		
		System.out.println("task b call()");
		return b;
	}
}
