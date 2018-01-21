import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringSort {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("first", "frequent", "second", "third", "frequent", "fourth", "second",
				"second");
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; list.size() > i; i++) {
			map.merge(list.get(i), 1, (iOld, iNew) -> (iOld + iNew));
		}
		Map.Entry<String, Integer> me = map.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
				.orElse(null);
		if (me != null) {
			System.out.println("The most frequent string: " + me.getKey() + ", number = " + me.getValue());
		}
	}
}