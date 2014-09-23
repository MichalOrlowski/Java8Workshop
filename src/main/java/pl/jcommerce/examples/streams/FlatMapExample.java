package pl.jcommerce.examples.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.DevelopersRepository;

/**
 * Examples with flatMap() exercises
 *
 * @author Michal Orlowski
 */
public class FlatMapExample {

    List<Developer> developers = DevelopersRepository.getSampleList();


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
