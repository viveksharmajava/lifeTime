package sample.test.multithreading;

public class StaticVsInstanceSynchronizedMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		A t1 = new A();
		A t2 = new A();
		A t3 = new A();
		
		new Thread(t1, "t1").start();
		new Thread(t1, "t2").start();
		new Thread(t1, "t3").start();
		
		
	}
	
	
	static class A implements Runnable{
		
		static synchronized  void a2(){
			try{
				System.out.println(" current Thread "+Thread.currentThread().getName()+" has called a2 and going for sleep");
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
			
		}
		
		public void run(){
			a1();
			a2();
		}
		
		private synchronized  void a1(){
			
			try{
				System.out.println(" current Thread "+Thread.currentThread().getName()+" has called a1 and going for sleep");
				Thread.sleep(10000);
			}catch(InterruptedException e){
				
			}
			
		}
		
    
	}
	
	/*static class B  {
		
		static synchronized  void a2(){
			try{
				System.out.println(" current Thread "+Thread.currentThread().getName()+" has called a1 and going for sleep");
				Thread.sleep(2000);
			}catch(InterruptedException e){
				
			}
			
		}
}*/

}
