public class ThreadCouncurrency {

	private static int counter = 0;

	public static void main(String[] arg) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (ThreadCouncurrency.class) {//using synchronized blocks to 
				for (int i = 0; i < 100_000; i++) {//avoid 'race condition'
					counter++;					         //('Data races')
				}
			}
		});
		Thread t2 = new Thread(() -> {//synchronized on class to work with static 'counter'
			synchronized (ThreadCouncurrency.class) {//start of 'critical section'
				for (int i = 0; i < 100_000; i++) {
					counter--;
				}
			}//end of 'critical section'
		});
		t1.start();
		t2.start();
		Thread.sleep(2000);
		System.out.println(counter);
	}

}
