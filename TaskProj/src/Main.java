import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * We have a class Person(name, nationality, age) it has all getters.
 * Task: Compute average age per nationality. Sample output: {American: 25, German: 27, Polish: 20}
 */
class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Julia", "Polish", 20),
            new Person("Joe", "American", 24),
            new Person("Tom", "American", 26),
            new Person("Robbin", "German", 27)
        );
		System.out.println(getAverageAgePerNationality(people));
		System.out.println(getAverageAgePerNationality1(people));
		System.out.println(getAverageAgePerNationality2(people));
	}

	private static String getAverageAgePerNationality(List<Person> people) {
		if (people == null) {
			throw new IllegalArgumentException("list of people is null");
		}
		Map<String, Double> averageAges = people.stream().peek(p -> {
			if (p.getAge() < 0 || p.getNationality() == null) {
				throw new IllegalArgumentException("Incorrect Person data: age below zero or nationality is null");
			}
		}).collect(
				Collectors.groupingBy(Person::getNationality, TreeMap::new, Collectors.averagingInt(Person::getAge)));
		
		return averageAges.toString().replaceAll("=", ": ").replaceAll("\\.0", "");
	}

	private static String getAverageAgePerNationality1(List<Person> people) {
		if (people == null) {
			throw new IllegalArgumentException("list of people is null");
		}
		StringBuilder sb = new StringBuilder("{");

		Map<String, List<Person>> nationalityPeopleMap = people.stream()
				.collect(Collectors.groupingBy(Person::getNationality));

		if (!nationalityPeopleMap.isEmpty()) {
			nationalityPeopleMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(me -> {
				sb.append(me.getKey() + ": ");
				long[] agesSum = new long[1];
				int[] numOfPeople = new int[1];
				me.getValue().forEach(p -> {
					if (p.getAge() < 0 || p.getNationality() == null) {
						throw new IllegalArgumentException(
								"Incorrect Person data: age below zero or nationality is null");
					}
					agesSum[0] += p.getAge();
					numOfPeople[0]++;
				});
				sb.append(agesSum[0] / numOfPeople[0] + ", ");
			});
			sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" ") + 1);
		}
		sb.append("}");
		return sb.toString();
	}

	static String getAverageAgePerNationality2(List<Person> people) {
		if (people == null) {
			throw new IllegalArgumentException("list of people is null");
		}
		StringBuilder sb = new StringBuilder("{");
		
		if (!people.isEmpty()) {
			TreeMap<String, Integer> peopleNumByCounty = new TreeMap<>();
			Map<String, Long> agesSum = new HashMap<>();
			people.stream().forEach(p -> {
				if (p.getAge() < 0 || p.getNationality() == null) {
					throw new IllegalArgumentException("Incorrect Person data: age below zero or nationality is null");
				}
				peopleNumByCounty.merge(p.getNationality(), 1, (old, newVal) -> old + newVal);
				agesSum.merge(p.getNationality(), (long) p.getAge(), (old, newVal) -> old + newVal);
			});
			peopleNumByCounty.forEach((country, numOfPeople) -> {
				sb.append(country);
				sb.append(": " + agesSum.get(country) / numOfPeople + ", ");
			});
			sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(" ") + 1);
		}
		sb.append("}");
		return sb.toString();
	}
}

class Person {
	private final String name;
	private final String nationality;
	private final int age;

	public Person(String name, String nationality, int age) {
		this.name = name;
		this.nationality = nationality;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public int getAge() {
		return age;
	}
}
