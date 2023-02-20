import java.util.ArrayList;
import java.util.LinkedList;
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
		test = new LinkedList<Integer>();
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
		if(ints.getClass().getName().equals("java.util.LinkedList")) {
			System.out.print("LinkedList");
			ints.add(position, value);
		} else {
			System.out.print("ArrayList");
			int valToReplace = ints.get(position);
			ints.set(position, value);
			for(int i = position + 1; i < ints.size(); i++) {
				int nextValue = ints.get(i);
				ints.set(i, valToReplace);
				valToReplace = nextValue;
			}
			ints.add(valToReplace);
		}
		return ints;
	}

}
