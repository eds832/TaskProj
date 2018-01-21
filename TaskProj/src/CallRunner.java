import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallRunner {
	public static void main(String ...args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> future = es.submit(new Callable<String>() {
			@Override
			public String call() throws Exception { 
				return "La-la";
			}		
		});
		es.shutdown();
		try {
		System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
		e.printStackTrace();
		}
	}
}
