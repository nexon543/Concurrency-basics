
public class DeadLock {
	
	
	
	public static void main(String[] args) {
		
		String str1="one";
		String str2="two";
		new Thread (()-> {
			synchronized (str1) {
				System.out.println("Thread 1 started");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					synchronized (str2) {
						for (int i=0; i< 1000;i++) {
							System.out.println("Thread 1 access to resource 2. Iteration:"+i);
							}
					}
			}
		}).start();

		
		new Thread (()-> {
			synchronized(str2) {
				System.out.println("Thread 2 started");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (str1) {
					for (int i=0; i< 1000;i++) {
					System.out.println("Thread 2 access to resource 1. Iteration:"+i);
					}
				
			}
			}
		}).start();
		
		}
	
}
