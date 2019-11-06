import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostModelsCarMaker {

	public static void main(String[] args) {
		List<Model> list = Arrays.asList(new Model("Audi", "A4"), new Model("BMW", "X3"), new Model("Audi", "A6"));
		HashMap<String, Integer> map = new HashMap<>();
		for (Model m : list) {
			map.merge(m.getMake(), 1, (iOld, iNew) -> (iOld + iNew));
		}
		Map.Entry<String, Integer> me = map.entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).orElse(null);
		if (me != null) {
			System.out.println("make: " + me.getKey() + ", number of models: " + me.getValue());
		} else { System.out.println("Not found"); }
	}
}

class Model {
	private String make;		
	private String model;
	
	public Model(String make, String model) {
		this.make = make;
		this.model = model;
	}
	String getMake() { return make; }
}
