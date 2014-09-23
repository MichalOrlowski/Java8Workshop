package pl.jcommerce.examples.model;

import static pl.jcommerce.examples.model.Language.GROOVY;
import static pl.jcommerce.examples.model.Language.JAVA;
import static pl.jcommerce.examples.model.Language.JAVA_SCRIPT;
import static pl.jcommerce.examples.model.Language.RUBY;
import static pl.jcommerce.examples.model.Language.SCALA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevelopersRepository {
	
	public static List<Developer> getSampleList() {
		return new ArrayList<Developer>(Arrays.asList(
	            new Developer("John", "Scott", 20, JAVA, SCALA),
	            new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT),
	            new Developer("Robert", "Carter", 32, GROOVY, JAVA),
	            new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
	            new Developer("Michael", "Beer", 36, JAVA)));
	}
	
}