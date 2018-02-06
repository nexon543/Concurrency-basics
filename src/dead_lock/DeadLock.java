
public class DeadLock {
	
	
	
	public static void main(String[] args) throws Exception {
		
		String str1="one";
		String str2="two";
		new Thread (()-> {
			synchronized (str1) {
				Thread.sleep(1000);
				
				
			}
		}).start();
	}

}
