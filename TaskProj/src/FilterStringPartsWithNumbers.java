import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterStringPartsWithNumbers {
	
	private static Predicate<String> filterWithIsDigit = part -> {

		char[] chars = part.toCharArray();

		boolean filterResult = true;

		if (chars.length == 0) {

			filterResult = false;

		} else {

			for (char ch : chars) {

				if (!Character.isDigit(ch)) {

					filterResult = false;
				}
			}
		}
		return filterResult;
	};
	
	private static Predicate<String> filterWithIntegerParseInt = part -> {

		try {

			Integer.parseInt(part);

			return true;

		} catch (NumberFormatException ex) {

			return false;
		}
	};

	public static void main(String[] args) {

		String entry = "a1,2,3r,33,o1,,";

		printGoodEntriesWithInegerParseInt(entry);

		printGoodEntriesWithIsDigit(entry);
	}

	private static void printGoodEntriesWithIsDigit(String entry) {
		
		printGoodEntries("With isDigit", entry, filterWithIsDigit);		
	}

	private static void printGoodEntriesWithInegerParseInt(String entry) {

		printGoodEntries("With ParseInt", entry, filterWithIntegerParseInt);
	}


	private static void printGoodEntries(String prompt, String entry, Predicate<String> filter) {
		
		long start = System.currentTimeMillis();
		
		List<String> goodEntries = Arrays.stream(entry.split(",")).filter(filter).collect(Collectors.toList());
		
		long duration = System.currentTimeMillis() - start;

		System.out.println(prompt + " result: " + goodEntries + ", spent time(ms): " + duration);		
	}
}