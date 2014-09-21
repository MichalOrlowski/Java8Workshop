package pl.jcommerce.examples.streams;

import pl.jcommerce.examples.model.Developer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.jcommerce.examples.model.Language.*;
import static pl.jcommerce.examples.model.Language.JAVA;

/**
 * Examples with flatMap() exercises
 *
 * @author Michal Orlowski
 */
public class FlatMapExample {

    List<Developer> developers = Arrays.asList(
            new Developer("John", "Scott", 20, JAVA, SCALA),
            new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT),
            new Developer("Robert", "Carter", 32, GROOVY, JAVA),
            new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
            new Developer("Michael", "Beer", 36, JAVA));


    public static void main(String[] args) {
        FlatMapExample fme = new FlatMapExample();
        fme.example1();;
    }

    /**
     * Get distinct languages used by developers
     */
    public void example1() {
        developers.stream()
                .flatMap(l -> l.getProgrammingLanguages().stream())
                .distinct()
                .forEach(d -> System.out.println(d.name()));
    }

    /**
     * Warmup example to get flatMap() idea
     */
    private static void warmupExample() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> mapped =
                numbers.stream()
                        .map(number -> Arrays.asList(number - 1, number, number + 1))
                        .collect(Collectors.toList());
        System.out.println(mapped);

        List<Integer> flattened =
                numbers.stream()
                        .flatMap(number -> Arrays.asList(number - 1, number, number + 1).stream())
                        .collect(Collectors.toList());
        System.out.println(flattened);
    }


}
