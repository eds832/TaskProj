import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableF1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void> result = CompletableFuture.supplyAsync(() -> "First")
				.thenCombineAsync(CompletableFuture.supplyAsync(() -> {
					System.out.println(Thread.currentThread().getName());
					return "Second";					
				}), CompletableF1::pickFirst)
				.thenCombineAsync(CompletableFuture.supplyAsync(() -> "Third"), CompletableF1::pickFirst)
				.thenApply(String::toUpperCase)
				.thenAcceptAsync(System.out::println);
		System.out.println(result.isDone());
		
		CompletableFuture<String> firstRunner = CompletableFuture.supplyAsync(() -> "Runner #1")
				.thenApplyAsync(s -> {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return s + " wants to be the first";
				});
		CompletableFuture<String> secondRunner = CompletableFuture.supplyAsync(() -> "Runner #2")
				.thenApplyAsync(s -> s + " tries to overcome");
		firstRunner.acceptEitherAsync(secondRunner, System.out::println);
		CompletableFuture<Void> cf = CompletableFuture.allOf(firstRunner, secondRunner);
		System.out.println(cf.get());
		String two = Stream.of(firstRunner, secondRunner).map(CompletableFuture::join).collect(Collectors.joining(" + "));
		System.out.println(two);
	}
	public static String pickFirst(String s1, String s2) {
		return "First";		
	}
}
