package pl.jcommerce.examples.streams;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.Language;

public class GroupByLanguageExample {

	public Map<Language, List<Developer>> groupByLanguageOldWay(List<Developer> developers) {
		Map<Language, List<Developer>> developersByLanguage = new HashMap<>();
		for (Developer dev : developers) {
			for (Language lang : dev.getProgrammingLanguages()) {
				List<Developer> langDevelopers = developersByLanguage.get(lang);
				if (langDevelopers == null) {
					langDevelopers = new ArrayList<>();
					developersByLanguage.put(lang, langDevelopers);
				}
				langDevelopers.add(dev);
			}
		}
		return developersByLanguage;
	}
	
	public Map<Language, List<Developer>> groupByLanguageNewWay(List<Developer> developers) {
		// I don't like this solution because:
		// - it was not easy to figure it out
		// - hacking lack of Tuples in Java 
		// - transformed to one-line gives compile error 
		Stream<Entry<Language, Developer>> langDevPairs = developers.stream()
				.flatMap(dev -> dev.getProgrammingLanguages().stream().map(lang -> pair(lang, dev)));
		return langDevPairs.collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));
	}
	
   private static <T,U> AbstractMap.SimpleEntry<T,U> pair(T t, U u) {
        return new AbstractMap.SimpleEntry<T,U>(t,u);
   }
}
