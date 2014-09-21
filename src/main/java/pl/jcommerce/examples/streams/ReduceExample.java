package pl.jcommerce.examples.streams;

import pl.jcommerce.examples.model.Developer;

import java.util.Arrays;
import java.util.List;

import static pl.jcommerce.examples.model.Language.*;

/**
 * Example with reduce() method
 *
 * @author Michal Orlowski
 */
public class ReduceExample {

    List<Developer> developers = Arrays.asList(
            new Developer("John", "Scott", 20, JAVA, SCALA),
            new Developer("Betty", "Scott", 32, RUBY, JAVA_SCRIPT),
            new Developer("Robert", "Carter", 32, GROOVY, JAVA),
            new Developer("Tom", "Wood", 41, JAVA, JAVA_SCRIPT),
            new Developer("Michael", "Beer", 36, JAVA));

    public static void main(String[] args) {
        ReduceExample re = new ReduceExample();
        re.getSumOfAge();
    }

    /**
     * Get the youngest dev
     */
    public void getTheYoungestDev() {
        developers
                .stream()
                .reduce((d1, d2) -> d1.getAge() < d2.getAge() ? d1 : d2)
                .ifPresent(System.out::println);
    }

    /**
     * Get sum of developers age
     */
    public void getSumOfAge() {
        Integer ageSum = developers
                .stream()
                .reduce(0, (sum, d) -> sum += d.getAge(), (sum1, sum2) -> sum1 + sum2);

        System.out.println(ageSum);
    }

}
