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

public class GroupByLanguageExampleTest {

	private GroupByLanguageExample groupByLanguageExample;
	private List<Developer> developers;
	private Map<Language, List<Developer>> expecteGroupedByLanguage;
	
	@Before
	public void init() {
		groupByLanguageExample = new GroupByLanguageExample();
		Developer dev1 = new Developer("John", "Scott", "john.scott@gmail.com", asList(JAVA, SCALA));
		Developer dev2 = new Developer("Betty", "Scott", "betty.scott@yahoo.com", asList(RUBY, JAVA_SCRIPT));
		Developer dev3 = new Developer("Robert", "Carter", "robert.carter@gmail.com", asList(GROOVY, JAVA));
		developers = Arrays.asList(dev1, dev2, dev3);
		expecteGroupedByLanguage = new HashMap<>();
		expecteGroupedByLanguage.put(GROOVY, asList(dev3));
		expecteGroupedByLanguage.put(JAVA, asList(dev1, dev3));
		expecteGroupedByLanguage.put(JAVA_SCRIPT, asList(dev2));
		expecteGroupedByLanguage.put(RUBY, asList(dev2));
		expecteGroupedByLanguage.put(SCALA, asList(dev1));
		
		
	}
	
	@Test
	public void shouldGroupByLanguageOldWay() {
		Map<Language, List<Developer>> actualGroupedByLanguage = groupByLanguageExample.groupByLanguageOldWay(developers); 
		Assert.assertEquals(expecteGroupedByLanguage, actualGroupedByLanguage);
	}
	
	@Test
	public void shouldGroupByLanguageNewWay() {
		Map<Language, List<Developer>> actualGroupedByLanguage = groupByLanguageExample.groupByLanguageNewWay(developers); 
		Assert.assertEquals(expecteGroupedByLanguage, actualGroupedByLanguage);
	}
}
