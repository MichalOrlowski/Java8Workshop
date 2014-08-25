package pl.jcommerce.examples.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.Language;

/**
 * Developer predicates
 * 
 * @author Michal Orlowski
 *
 */
public class DeveloperPredicates {

	/**
	 * Is developer older than 18 years
	 * 
	 * @return
	 */
	public static Predicate<Developer> isAdult() {
		return d -> d.getAge() >= 18;
	}
	
	/**
	 * Is developer older than @param age
	 * 
	 * @return
	 */
	public static Predicate<Developer> isOlderThan(Integer age) {
		return d -> d.getAge() > age;
	}

	/**
	 * Produces a predicate that tests if given developer
	 * is a Java developer.
	 */
	public static Predicate<Developer> isJavaDeveloper() {
		return d -> d.getProgrammingLanguages().contains(Language.JAVA);
	}
	
	/**
	 * Filter developers with custom predicate
	 * 
	 * @param developers
	 * @param predicate
	 * @return
	 */
	public static List<Developer> filterDevelopers(List<Developer> developers, Predicate<Developer> predicate) {
		return developers.stream().filter(predicate).collect(Collectors.toList());
	}
}
