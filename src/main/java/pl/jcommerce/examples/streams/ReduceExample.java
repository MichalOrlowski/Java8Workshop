package pl.jcommerce.examples.streams;

import java.util.List;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.DevelopersRepository;

/**
 * Example with reduce() method
 *
 * @author Michal Orlowski
 */
public class ReduceExample {

    List<Developer> developers = DevelopersRepository.getSampleList();

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
