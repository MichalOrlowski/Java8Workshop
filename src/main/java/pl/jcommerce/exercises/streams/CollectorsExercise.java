package pl.jcommerce.exercises.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import pl.jcommerce.examples.model.Developer;

/**
 * Exercies with integer fields.
 * 
 * @author Michal Orlowski
 *
 */
public class CollectorsExercise {

	private static List<Developer> developers = Arrays.asList(new Developer("John",
			"Scott", 25), new Developer("Robert", "Carter", 33), new Developer(
			"Yolo", "Swaggins", 36), new Developer("Sandra", "Parker", 36));

	public static void main(String[] args) {
		exercise5();
	}
	
	/**
	 * 1. Group developers by age
	 */

	private static void exercise1() {
		Map<Integer, List<Developer>> developersByAge = developers
			.stream()
			.collect(Collectors.groupingBy(d -> d.getAge()));
		
		developersByAge.forEach((age, d) -> System.out.format("age %s : %s\n", age, d)); 
	}

	/**
	 * 3. Determine average age of developers
	 */

	private static void exercise2() {
		Double averangeAge = developers
			.stream()
			.collect(Collectors.averagingInt(d -> d.getAge()));
		
		System.out.println(averangeAge);
	}

	/**
	 * 4. Determine min, max, averange and sum
	 * 
	 * @see IntSummaryStatistics
	 */

	private static void exercise3() {
		IntSummaryStatistics ageSummary = developers
			.stream()
			.collect(Collectors.summarizingInt(d -> d.getAge()));
			
		System.out.println(ageSummary);	
	}

	/**
	 * 5. Return string with additional info
	 * Collectors.joining
	 */

	private static void exercise4() {
		String info = developers
			.stream()
			.filter(d -> d.getAge() >= 30)
			.map(d -> d.getLastName())
			.collect(Collectors.joining(" and ", "In out company ", " started burn out."));
		
		System.out.println(info);
	}

	/**
	 * 6. Implement own Collector Example: DEV1 <> DEV3 <> DEV4
	 */

	private static void exercise5() {
		Collector<Developer, StringJoiner, String> devNameCollector =
			Collector.of(
				() -> new StringJoiner(" <> "), 
				(j, d) -> j.add(d.getLastName().toUpperCase()),
				(j1, j2) -> j1.merge(j2),
				StringJoiner::toString);
		
		String names = developers
			.stream()
			.collect(devNameCollector);
			
		System.out.println(names);
	}
}
