package pl.jcommerce.examples.function;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.DevelopersRepository;

import java.util.List;
import java.util.function.Function;

/**
 * Funtions example
 *
 * @author Michal Orlowski
 *
 */
public class FunctionExample {

    /**
     * Find sum of arbitrary property
     *
     * @param entries
     * @param mapper
     * @param <T>
     * @return
     */
    public static <T> Integer mapSum(List<T> entries, Function<T, Integer> mapper) {
        Integer sum = 0;
        for(T entry : entries) {
            sum += mapper.apply(entry);
        }

        return sum;
    }

    /**
     * Count languages
     *
     * @return
     */
    public static Function<Developer, Integer> countDevelopersSalaryInEuro() {
        // TODO change to salary
        return d -> d.getAge() * 2;
    }

    public static void main(String[] args) {
        List<Developer> developers = DevelopersRepository.getSampleList();
        int sumOfAge = mapSum(developers, Developer::getAge);
        int sumOfProgrammingLanguages = mapSum(developers, countDevelopersSalaryInEuro());
        System.out.println(sumOfAge);
        System.out.println(sumOfProgrammingLanguages);

    }

}
