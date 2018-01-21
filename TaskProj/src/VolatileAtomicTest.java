import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicTest {
	public static void main(String [] args) {
		new VolatileThread().start();new VolatileThread().start();
		new VolatileThread().start();
		new AtomicThread().start();new AtomicThread().start();
		new AtomicThread().start();
	}
}
class VolatileThread extends Thread {
	static volatile int countInt;
	public void run() {
		for(int i = 0; i < 10_000_000; i++) {
			++countInt;
		}
		System.out.println("volatile " + countInt);
	}
}
class AtomicThread extends Thread {
	static AtomicInteger count = new AtomicInteger(0);
	public void run() {
		for(int i = 0; i < 10_000_000; i++) {
			count.incrementAndGet();
		}
		System.out.println("Atimic " + count);
	}
}