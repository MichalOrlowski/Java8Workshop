package pl.jcommerce.examples.streams;

import java.util.List;

import junitx.framework.ListAssert;

import org.junit.Before;
import org.junit.Test;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.Language;
import pl.jcommerce.utils.DevelopersGenerator;

/**
 * 
 * @author Michal Orlowski
 *
 */
public class SimpleListFilterExampleTest {

	private SimpleListFilterExample simpleListFilterExample;
	private List<Developer> expectedDevsList;

	@Before
	public void init() {
		simpleListFilterExample = new SimpleListFilterExample();
		expectedDevsList = DevelopersGenerator
				.generateDevsWithSpecifiedLanguages(Language.JAVA);
	}

	@Test
	public void shouldReturnOnlyJavaDevsUsingOldSchoolSorting() {
		List<Developer> actualDevsList = DevelopersGenerator
				.generateDevsWithSpecifiedLanguages(Language.JAVA,
						Language.GROOVY);

		actualDevsList = simpleListFilterExample.filterJavaDevelopers(actualDevsList);

		ListAssert.assertEquals(expectedDevsList, actualDevsList);
	}

	@Test
	public void shouldReturnOnlyJavaDevsUsingJava8Sorting() {
		List<Developer> actualDevsList = DevelopersGenerator
				.generateDevsWithSpecifiedLanguages(Language.JAVA,
						Language.GROOVY);

		actualDevsList = simpleListFilterExample.filterJavaDevelopersLikeABoss(actualDevsList);
		
		ListAssert.assertEquals(expectedDevsList, actualDevsList);
	}

}
