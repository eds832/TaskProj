public class SynchroTask {
	public synchronized void print(int i) {
		System.out.println("  " + i);}

	public static synchronized void printS(int i) {
		System.out.println("S " + i);}

	public static void main(String[] args) {
		SynchroTask sy1 = new SynchroTask();
		SynchroTask sy2 = new SynchroTask();
		for (int i = 0; i < 5; i++) {
			new ThreadClass1(sy1, i).start();
			new ThreadClass2(i).start();
			new ThreadClass1(sy2, i + 10).start();}
	}
}
class ThreadClass1 extends Thread {
	public SynchroTask sy; public int i;

	public ThreadClass1(SynchroTask sy, int i) {
		this.sy = sy; this.i = i;}

	public void run() {
		sy.print(i); sy.print(i);} }

class ThreadClass2 extends Thread {
	public int i;

	public ThreadClass2(int i) { this.i = i;}

	public void run() {
		SynchroTask.printS(i); SynchroTask.printS(i);} }
