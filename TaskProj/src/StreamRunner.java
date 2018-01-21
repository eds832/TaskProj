import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
	public static void main(String... s) {
		LinkedList<StringBuilder> l = new LinkedList<StringBuilder>() {
			private static final long serialVersionUID = 1L;
			{
				this.add(new StringBuilder("1"));
				this.add(new StringBuilder("2"));
				this.add(new StringBuilder("3"));
			}
		};
		Stream<StringBuilder> st = l.stream();
		st.filter((p) -> p.toString().equals("1")).forEach((p) -> p.append("1"));//forEach - terminal operation!
		System.out.println(l);
		List<StringBuilder> list = l.stream().filter((p) -> p.toString().equals("2") || new Integer(p.toString()) > 10)
				.collect(Collectors.toList());
		System.out.println(list);
		list = l.stream().sorted((o1, o2) -> new Integer(o1.toString().length()).compareTo(o2.toString().length()))
				.collect(Collectors.toList());
		System.out.println(list);
		Optional<StringBuilder> max = l.stream().max((o1, o2) -> new Integer(o1.toString()).compareTo(new Integer(o2.toString())));
		StringBuilder maxValue = max.orElse(new StringBuilder().append("Not found"));
		System.out.println(maxValue.toString());
		System.out.println(l.stream().peek((p) -> p.append("3")).collect(Collectors.toList()));//peek - not terminal operation!
		System.out.println(String.join(" ", "Hello", "from", "Java", "8!"));
	}
}
