package pl.jcommerce.utils;

import java.util.ArrayList;
import java.util.List;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.Language;

/**
 * Developers POJO generator
 * 
 * @author Michal Orlowski
 *
 */
public class DevelopersGenerator {	
	

	
	/**
	 * Generate developers list with specified languages and Dev(N) names
	 * 
	 * @param languages
	 * @return
	 */
	public static List<Developer> generateDevsWithSpecifiedLanguages(Language... languages) {
		List<Developer> developersList = new ArrayList<Developer>();
		for (Language lang : languages) {
			String firstName = lang.name();
			String lastName = "Dev";
			developersList.add(new Developer(firstName, lastName, null, languages));
		}
		return developersList;
	}
}
