public class DeadRun {

	public static void main(String[] args) {
		Object a = new Object();
		Thread t = new Thread() {
			public void run() {
				synchronized (a) {
					try {
						System.out.println("t before wait()");
						a.wait();
						System.out.println("t after wait()");
					} catch (InterruptedException e) {
						System.out.println("t was interupted");
					}
				}
				System.out.println("t after wait()2");
			}
		};
		t.start();
		Thread t1 = new Thread() {
			public void run() {
				synchronized (a) {
					try {
						System.out.println("t1 before wait()");
						a.wait();
						System.out.println("t1 after wait()");
					} catch (InterruptedException e) {
						System.out.println("t1 was interupted");
					}
					a.notify();
				}
				System.out.println("t1 after wait()2");
			}
		};
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();//to go out from deadlock
	}

}
