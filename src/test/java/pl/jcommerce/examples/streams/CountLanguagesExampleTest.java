package pl.jcommerce.examples.streams;

import static java.util.Arrays.asList;
import static pl.jcommerce.examples.model.Language.GROOVY;
import static pl.jcommerce.examples.model.Language.JAVA;
import static pl.jcommerce.examples.model.Language.JAVA_SCRIPT;
import static pl.jcommerce.examples.model.Language.RUBY;
import static pl.jcommerce.examples.model.Language.SCALA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.Language;

public class CountLanguagesExampleTest {

	private CountLanguagesExample countLanguagesExample;
	private List<Developer> developers;
	private Map<Language, Long> expectedCounts;

	@Before
	public void init() {
		countLanguagesExample = new CountLanguagesExample();
		developers = Arrays.asList(
				new Developer("John", "Scott", "john.scott@gmail.com", asList(JAVA, SCALA)),
				new Developer("Betty", "Scott", "betty.scott@yahoo.com", asList(RUBY, JAVA_SCRIPT)),
				new Developer("Robert", "Carter", "robert.carter@gmail.com", asList(GROOVY, JAVA)),
				new Developer("Tom", "Wood", "tom.wood@hotmail.com", asList(JAVA, JAVA_SCRIPT)));
		expectedCounts = new HashMap<>();
		expectedCounts.put(GROOVY, (long) 1);
		expectedCounts.put(JAVA, (long) 3);
		expectedCounts.put(JAVA_SCRIPT, (long) 2);
		expectedCounts.put(RUBY, (long) 1);
		expectedCounts.put(SCALA, (long) 1);
	}
	
	@Test
	public void shouldCountLanguagesUsingLoops() {
		Assert.assertEquals(expectedCounts, countLanguagesExample.countLanguagesUsingLoops(developers));
	}
	
	@Test
	public void shouldCountLanguagesUsingStream() {
		Assert.assertEquals(expectedCounts, countLanguagesExample.countLanguagesUsingStream(developers));
	}
	
	@Test
	public void shouldCountLanguagesUsingLoopsAndMapEnhancements() {
		Assert.assertEquals(expectedCounts, countLanguagesExample.countLanguagesUsingLoopsAndMapEnhancements(developers));
	}
}