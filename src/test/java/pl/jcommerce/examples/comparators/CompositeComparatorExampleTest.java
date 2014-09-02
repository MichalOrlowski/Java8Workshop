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
		Developer dev1 = new Developer("John", "Scott", 20, JAVA, SCALA);
		Developer dev2 = new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT);
		Developer dev3 = new Developer("Robert", "Carter", 32, GROOVY, JAVA);
		Developer dev4 = new Developer("Sandra", "Parker", 27, PYTHON);
		Developer dev5 = new Developer("Sandra", "Parker", 24, CLOJURE);
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
