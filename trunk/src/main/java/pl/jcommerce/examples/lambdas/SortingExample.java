package pl.jcommerce.examples.lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sorting in Java 8 practice examples
 * 
 * @author Michal Orlowski
 *
 */
public class SortingExample {

	/**
	 * Sorting method using earlier Java version
	 * 
	 * @return
	 */
	public List<String> oldSchoolSorting(List<String> stringList) {
		Collections.sort(stringList, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});

		return stringList;
	}

	/**
	 * Sorting method using Java 8 with 3 level optimization example
	 * 
	 * @param stringList
	 * @return
	 */
	public List<String> java8Sorting(List<String> stringList) {
		// Collections.sort(stringList, (String a, String b) -> {
		// return b.compareTo(a);
		// });

		// Collections.sort(stringList, (String a, String b) -> b.compareTo(a));

		Collections.sort(stringList, (a, b) -> b.compareTo(a));

		return stringList;
	}

}
