package sample.test.multithreading.concurrent.executor;
import java.util.concurrent.Callable;


public class TaskA  implements ITask ,Callable<AbsClass>{
  private ClassA a;
  TaskA(ClassA a){
	  this.a=a;
  }
	@Override
	public AbsClass call(){
		System.out.println("task A  call()");
		return a;
	}
}
