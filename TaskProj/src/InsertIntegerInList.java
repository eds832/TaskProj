import java.util.ArrayList;
import java.util.List;

public class InsertIntegerInList {
	
	public static void main(String [] arg) {
		List<Integer> test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		System.out.println(insertInt(test, 2, 8));
		test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(5);
		System.out.println(insertInt(test, 2, 8));
		test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		test.add(3);
		System.out.println(insertInt(test, 2, 8));
		test = new ArrayList<Integer>();
		test.add(1);
		test.add(2);
		System.out.println(insertInt(test, 2, 8));
	}

	private static List<Integer> insertInt(List<Integer> ints , int position, int value) {
		if(ints.size() - 1 < position) {
			throw new UnsupportedOperationException("position doesn't exist in array");
		}
		int i = position;
		int valToReplace = ints.get(position);
		ints.set(position, value);
		while(i < ints.size()) {
			int nextValue = 0;
			if(i != ints.size() - 1) {
				nextValue = ints.get(i + 1);
				ints.set(i + 1, valToReplace);
			} else {
				ints.add(valToReplace);
				break;
			}
			valToReplace = nextValue;
			i++;
		}
		return ints;
	}

}
