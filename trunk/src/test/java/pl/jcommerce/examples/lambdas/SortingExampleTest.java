package pl.jcommerce.examples.lambdas;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Michal Orlowski
 *
 */
public class SortingExampleTest {

	private SortingExample sortingExample;
	private List<String> expectedLanguageNames;

	@Before
	public void init() {
		sortingExample = new SortingExample();
		expectedLanguageNames = Arrays.asList("Scala", "Java", "Groovy",
				"Clojure");
	}

	@Test
	public void shouldReturnSortedNamesUsingOldSchoolSorting() {
		List<String> actualLanguageNames = Arrays.asList("Java", "Scala",
				"Groovy", "Clojure");

		sortingExample.sortStringList(actualLanguageNames);

		Assert.assertEquals(expectedLanguageNames, actualLanguageNames);
	}
	
	@Test
	public void shouldReturnSortedNamesUsingJava8Sorting() {
		List<String> actualLanguageNames = Arrays.asList("Java", "Scala",
				"Groovy", "Clojure");

		sortingExample.sortStringListLikeABoss(actualLanguageNames);

		Assert.assertEquals(expectedLanguageNames, actualLanguageNames);
	}

}
