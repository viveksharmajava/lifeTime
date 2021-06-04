package sample.test.multithreading.concurrent.executor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolSample {

	public static void main(String[] args) {
		//RecursiveAction does not returns the result.
		MyRecursiveAction action = new MyRecursiveAction(128);
		ForkJoinPool pool = new ForkJoinPool(4);
		pool.invoke(action);
		
		//RecursionTaskReturns the Result
		
		MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
		ForkJoinPool pool2 = new ForkJoinPool(4);
		long mergedResult = (Long)pool2.invoke(myRecursiveTask);

		System.out.println("mergedResult = " + mergedResult);  
	}

}
 
class MyRecursiveAction extends RecursiveAction{
	
  long workLoad = 0;
  MyRecursiveAction(long load){
	  this.workLoad = load;
  }
	@Override
	protected void compute() {
	  if(workLoad > 16) {
		  System.out.println("Splitting workload "+workLoad);
		  List <MyRecursiveAction> subtasks = new ArrayList<>();
		  subtasks.addAll(createSubtasks());
		  for(MyRecursiveAction task : subtasks) {
			  task.fork();
		  }
		  
	  }
	}
	private Collection<? extends MyRecursiveAction> createSubtasks() {
		 List<MyRecursiveAction> subtasks =
		            new ArrayList<MyRecursiveAction>();

		        MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
		        MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);

		        subtasks.add(subtask1);
		        subtasks.add(subtask2);
		        
		        return subtasks;
	}
}


class MyRecursiveTask extends RecursiveTask{
	
 long workLoad = 0;
 MyRecursiveTask(long load){
	  this.workLoad = load;
 }
	@Override
	protected Long compute() {
		List <MyRecursiveTask> subtasks  = null;
	  if(workLoad > 16) {
		  System.out.println("Splitting workload "+workLoad);
		  subtasks  = new ArrayList<>();
		  subtasks.addAll(createSubtasks());
		  for(MyRecursiveTask task : subtasks) {
			  task.fork();
		  }
	  }
	  long result = 1l;
	  if(subtasks != null) {
         for(MyRecursiveTask subtask : subtasks) {
          result =  result + (Long) subtask.join();
         }
	  }
      return result;
	}
	private Collection<? extends MyRecursiveTask> createSubtasks() {
		 List<MyRecursiveTask> subtasks =
		            new ArrayList<MyRecursiveTask>();

		 MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
		 MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);

		        subtasks.add(subtask1);
		        subtasks.add(subtask2);
		        
		        return subtasks;
	}
}

