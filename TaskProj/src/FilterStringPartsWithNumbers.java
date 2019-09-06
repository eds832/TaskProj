import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FilterStringPartsWithNumbers {

	private static Predicate<String> filterWithIsDigit1 = part -> {

		char[] chars = part.toCharArray();

		boolean filterResult = true;

		if (chars.length == 0) {

			filterResult = false;

		} else {

			int counter = 0;

			while (counter < chars.length) {

				if (!Character.isDigit(chars[counter])) {

					filterResult = false;

					break;
				}
				counter++;
			}
		}
		return filterResult;
	};

	private static Predicate<String> filterWithIsDigit2 = part -> {

		char[] chars = part.toCharArray();

		if (chars.length == 0) {

			return false;

		} else {

			return !IntStream.range(0, chars.length).mapToObj(i -> chars[i]).filter(ch -> !Character.isDigit(ch)).findFirst().isPresent();
		}
	};

	private static Predicate<String> filterWithIntegerParseInt = part -> {
		
		if(part.isEmpty()) {
			
			return false;
		}

		try {

			Integer.parseInt(part);

			return true;

		} catch (NumberFormatException ex) {

			return false;
		}
	};

	private static Predicate<String> filterWithMatches = part -> {

		if (part.matches("^\\d+$")) {

			return true;

		} else {

			return false;
		}

	};

	public static void main(String[] args) {

		String entry = "a1,2,3r3r,33,o1,,";

		printGoodEntriesWithInegerParseInt(entry);

		printGoodEntriesWithIsDigit1(entry);

		printGoodEntriesWithIsDigit2(entry);

		printGoodEntriesWithMatches(entry);
	}

	private static void printGoodEntriesWithMatches(String entry) {

		printGoodEntries("With matches", entry, filterWithMatches);
	}

	private static void printGoodEntriesWithIsDigit1(String entry) {

		printGoodEntries("With isDigit1", entry, filterWithIsDigit1);
	}

	private static void printGoodEntriesWithIsDigit2(String entry) {

		printGoodEntries("With isDigit2", entry, filterWithIsDigit2);
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
