import java.util.ArrayList;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

	public static void main(String[] args) {
		String str = "I know Java";
		StringBuilder sb = new StringBuilder(str);
		System.out.println(sb.reverse().toString());
		String[] strArr = str.split("");
		String s = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			s += strArr[i];
		}
		System.out.println(s);
		ArrayList<Character> charList = new ArrayList<>();
		IntStream chars = str.chars();
		chars.forEach(c -> charList.add(new Character((char) c)));
		ListIterator<Character> it = charList.listIterator(charList.size());
		s = "";
		while (it.hasPrevious()) {
			s += String.valueOf(it.previous());
		}
		System.out.println(s);
		char[] charArr = new char[str.length()];
		IntStream.rangeClosed(0, str.length() - 1).forEach(i -> charArr[i] = str.charAt(str.length() - 1 - i));
		System.out.println(new String(charArr));
		s = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			s += String.valueOf(str.charAt(i));
		}
		System.out.println(s);
		s = "";
		charList.clear();
		for (int i = str.length() - 1; i >= 0; i--) {
			charList.add(str.charAt(i));
		}
		System.out.println(charList.stream().map(String::valueOf).collect(Collectors.joining("")));
		s = "";
		for (int i = str.length(); i > 0; i--) {
			s += str.substring(i - 1, i);
		}
		System.out.println(s);
		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}

}
