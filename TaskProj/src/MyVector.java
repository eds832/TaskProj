public class MyVector<T> {

	@SuppressWarnings("unchecked")
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
		
		MyVector<Integer> vector1 = new MyVector<>();
		vector1.add(1);
		vector1.add(2);
		vector1.add(3);
		vector1.add(10);
		System.out.println(vector1.get(2));
		System.out.println(vector1.getLast());
		System.out.println(vector1.size());
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
		if(size >= data.length) {
			@SuppressWarnings("unchecked")
			T[] newData = (T[])new Object[data.length * 2];
			for(int i = 0; i < size; i++) {
				newData[i] = data[i];
			}
			data = newData;
		}
		data[size] = entry;
		size++;
	}

}
