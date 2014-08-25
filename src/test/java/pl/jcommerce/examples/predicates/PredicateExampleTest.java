package pl.jcommerce.examples.predicates;

import static pl.jcommerce.examples.model.Language.GROOVY;
import static pl.jcommerce.examples.model.Language.JAVA;
import static pl.jcommerce.examples.model.Language.JAVA_SCRIPT;
import static pl.jcommerce.examples.model.Language.RUBY;
import static pl.jcommerce.examples.model.Language.SCALA;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.jcommerce.examples.model.Developer;

/**
 * 
 * @author Michal Orlowski
 *
 */
public class PredicateExampleTest {
	
	private PredicateExample predicateExample;
	private List<Developer> actualDevelopers;
	
	@Before
	public void init() {
		predicateExample = new PredicateExample();
		actualDevelopers = Arrays.asList(
			new Developer("John", "Scott", 20, JAVA, SCALA),
			new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT),
			new Developer("Robert", "Carter", 32, GROOVY, JAVA),
			new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
			new Developer("Yolo", "Swaggins", 17, RUBY, GROOVY),
			new Developer("Michael", "Beer", 36, JAVA));
	}
	
	@Test	
	public void shouldReturnAdultDevelopers() {
		List<Developer> expectedDevelopers = Arrays.asList(
			new Developer("John", "Scott", 20, JAVA, SCALA),
			new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT),
			new Developer("Robert", "Carter", 32, GROOVY, JAVA),
			new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
			new Developer("Michael", "Beer", 36, JAVA));
		
		Assert.assertEquals(expectedDevelopers, predicateExample.filterAdultDevelopers(actualDevelopers));
	}
	
	@Test	
	public void shouldReturnDevelopersOlderThan40() {
		List<Developer> expectedDevelopers = Arrays.asList(
			new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT));
		
		Assert.assertEquals(expectedDevelopers, predicateExample.filterDevelopersOlderThan(40, actualDevelopers));
	}
	
	@Test	
	public void shouldReturnOldJavaDevelopers() {
		List<Developer> expectedDevelopers = Arrays.asList(
				new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
				new Developer("Michael", "Beer", 36, JAVA));
		
		Assert.assertEquals(expectedDevelopers, predicateExample.filterOldJavaDevelopers(actualDevelopers));
	}
}
