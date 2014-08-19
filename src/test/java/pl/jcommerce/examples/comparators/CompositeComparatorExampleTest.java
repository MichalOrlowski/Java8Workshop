package pl.jcommerce.examples.comparators;

import static java.util.Arrays.asList;
import static junitx.framework.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static pl.jcommerce.examples.model.Language.CLOJURE;
import static pl.jcommerce.examples.model.Language.GROOVY;
import static pl.jcommerce.examples.model.Language.JAVA;
import static pl.jcommerce.examples.model.Language.JAVA_SCRIPT;
import static pl.jcommerce.examples.model.Language.PYTHON;
import static pl.jcommerce.examples.model.Language.RUBY;
import static pl.jcommerce.examples.model.Language.SCALA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.jcommerce.examples.model.Developer;

public class CompositeComparatorExampleTest {

	private CompositeComparatorExample compositeComparatorExample;
	private List<Developer> unsortedDevelopers;
	private List<Developer> sortedDevelopers;

	@Before
	public void init() {
		compositeComparatorExample = new CompositeComparatorExample();
		Developer dev1 = new Developer("John", "Scott", "john.scott@gmail.com", asList(JAVA, SCALA));
		Developer dev2 = new Developer("Betty", "Scott", "betty.scott@yahoo.com", asList(RUBY, JAVA_SCRIPT));
		Developer dev3 = new Developer("Robert", "Carter", "robert.carter@gmail.com", asList(GROOVY, JAVA));
		Developer dev4 = new Developer("Sandra", "Parker", "sandra.parker@hotmail.com", asList(PYTHON));
		Developer dev5 = new Developer("Sandra", "Parker", "sandra.parker@gmail.com", asList(CLOJURE));
		unsortedDevelopers = new ArrayList<>(asList(dev1, dev2, dev3, dev4, dev5));
		sortedDevelopers = new ArrayList<>(asList(dev3, dev5, dev4, dev2, dev1));
	}
	
	@Test
	public void shouldSortUsingOldCompositeComparator() {
		assertNotEquals(sortedDevelopers, unsortedDevelopers);
		
		Collections.sort(unsortedDevelopers, compositeComparatorExample.createCompositeComparatorOldWay());
		
		assertEquals(sortedDevelopers, unsortedDevelopers);
	}
	
	@Test
	public void shouldSortUsingNewCompositeComparator() {
		assertNotEquals(sortedDevelopers, unsortedDevelopers);
		
		unsortedDevelopers.sort(compositeComparatorExample.createCompositeComparatorNewWay());
		
		assertEquals(sortedDevelopers, unsortedDevelopers);
	}
}
