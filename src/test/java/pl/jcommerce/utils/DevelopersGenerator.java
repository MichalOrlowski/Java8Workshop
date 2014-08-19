package pl.jcommerce.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

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
		int i = 1;
		for (Language lang : languages) {
			developersList.add(new Developer("Dev" + i++, Lists.newArrayList(lang)));
		}
		return developersList;
	}
}
