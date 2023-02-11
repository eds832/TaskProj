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
		if(ints == null || position < 0 || position >= ints.size()) {
			throw new IllegalArgumentException("array are null or position doesn't exist in array");
		}
		int i = position;
		int valToReplace = ints.get(position);
		ints.set(position, value);
		while(true) {
			int nextValue = 0;
			i++;
			if(i != ints.size()) {
				nextValue = ints.get(i);
				ints.set(i, valToReplace);
			} else {
				ints.add(valToReplace);
				break;
			}
			valToReplace = nextValue;
		}
		return ints;
	}

}
