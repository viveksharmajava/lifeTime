package sample.test.multithreading.concurrent.executor;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class CustomExecutor {
	
	private ExecutorService executorService=null;
	private CompletionService completionService=null;
	
	CustomExecutor(int numberOfThreads){
		executorService = Executors.newFixedThreadPool(numberOfThreads);
		completionService = new ExecutorCompletionService(executorService);
	}
	
	public <T> void sumbitTasks(Map<String , T> taskMap){
		System.out.println("sumbitTasks called ");
		String key = null;
		for(Map.Entry<String, T> entry : taskMap.entrySet()) {
			try {
				key = entry.getKey();
				ITask task = TaskFactory.getInstance().getTask(key,entry.getValue());
				executorService.submit((Callable<T>)task);
			}catch(Exception e){
				
			}
		}
		
	}
	public <T> T processTask(String requestType , T taskObject) {
		System.out.println("processTask called");
		try{
			Future <T> futureObj = completionService.take();
			if(futureObj !=null){
				System.out.println("Future object is not null");
				taskObject = futureObj.get();
				System.out.println("Future object completed task ="+taskObject.getClass().getName());
			}
		}catch(ExecutionException e){
			
		}
		catch(Exception e){
			
		}
	
		return taskObject;
	}
	
	public <T> Map<String , T> processAllTasks(Map<String , T > taskMap){
		System.out.println("processAllTasks called");
		try{
			List<Future <T>> futureObjs	= executorService.invokeAll( (Collection<? extends Callable<T>>) taskMap.values());
//		for(Map.Entry<String, T> entry :taskMap.entrySet()){
//			
//			processTask(entry.getKey(), entry.getValue());
//		}
			
			for(Future <T> futureObj : futureObjs ) {
				if(futureObj !=null){
					Object taskObject =  futureObj.get();
					System.out.println("Future object completed task ="+taskObject);
				}
			}
			
		executorService.shutdown();
		if(executorService.isTerminated()) {
			return null;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			executorService.shutdown();
		}
		return taskMap;
	}

}
