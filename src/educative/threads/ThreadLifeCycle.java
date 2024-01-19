package educative.threads;

public class ThreadLifeCycle {

	public static void main(String[] args) {
		
		new Thread() {
			public void run() {
				for(int i=0; i < 120 ; i ++) {
					ThreadLifeCycle tl = new ThreadLifeCycle();
					tl.method();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				for(int i=0; i < 120 ; i ++) {
					ThreadLifeCycle tl = new ThreadLifeCycle();
					tl.method();
				}
			}
		}.start();
		
	}
	int foo=0;
	public void method() {
		foo = 42;
		new Thread() {
			public void run() {
				if(foo!= 42) {
					System.out.println(foo);
				}
			}
		}.start();
	}

}
