public class ThreadCouncurency {

	private static int counter = 0;

	public static void main(String[] arg) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			synchronized (ThreadCouncurency.class) {//using synchronized blocks to 
				for (int i = 0; i < 100_000; i++) {//avoid 'race condition'
					counter++;
				}
			}
		});
		Thread t2 = new Thread(() -> {
			synchronized (ThreadCouncurency.class) {
				for (int i = 0; i < 100_000; i++) {
					counter--;
				}
			}
		});
		t1.start();
		t2.start();
		Thread.sleep(2000);
		System.out.println(counter);
	}

}
