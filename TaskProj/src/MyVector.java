import java.util.Arrays;

public class MyVector<T> {

	private T [] data = (T[])new Object[3];
	private int size = 0;
	
	public static void main(String[] args) {
		MyVector<String> vector = new MyVector<>();
		vector.add("1");
		vector.add("2");
		vector.add("three");
		vector.add("one_more");
		System.out.println(vector.get(2));
		System.out.println(vector.getLast());
		System.out.println(vector.size());
	}

	public int size() {
		return size;
	}

	public T getLast() {
		if(size == 0) return null;
		return data[size - 1];
	}

	public T get(int i) {
		return data[i];
	}

	public void add(T entry) {
		if(size >= data.length - 1) {
			T[] newData = (T[])new Object[data.length * 2];
			for(int i = 0; i < size; i++) {
				newData[i] = data[i];
				data = newData;
			}
		}
		data[size] = entry;
		size++;
	}

}
