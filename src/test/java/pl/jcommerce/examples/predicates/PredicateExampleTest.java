package pl.jcommerce.examples.predicates;

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
			new Developer("John", "Scott", 20),
			new Developer("Betty", "Scott", 32),
			new Developer("Robert", "Carter", 32),
			new Developer("Tom", "Wood", 41),
			new Developer("Yolo", "Swaggins", 17));
	}
	
	@Test	
	public void shouldReturnAdultDevelopers() {
		List<Developer> expectedDevelopers = Arrays.asList(
			new Developer("John", "Scott", 20),
			new Developer("Betty", "Scott", 32),
			new Developer("Robert", "Carter", 32),
			new Developer("Tom", "Wood", 41));
		
		Assert.assertEquals(expectedDevelopers, predicateExample.filterAdultDevelopers(actualDevelopers));
	}
	
	@Test	
	public void shouldReturnDevelopersOlderThan40() {
		List<Developer> expectedDevelopers = Arrays.asList(
			new Developer("Tom", "Wood", 41));
		
		Assert.assertEquals(expectedDevelopers, predicateExample.filterDevelopersOlderThan(40, actualDevelopers));
	}
}
