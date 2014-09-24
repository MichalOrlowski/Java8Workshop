package pl.jcommerce.examples.defaultmethods;

import java.util.Iterator;
import java.util.List;

import pl.jcommerce.examples.model.Developer;
import pl.jcommerce.examples.model.DevelopersRepository;
import pl.jcommerce.examples.model.Language;

public class RemoveIfExample {

    public static void main(String[] args) {
        
        List<Developer> developers1 = DevelopersRepository.getSampleList();
        
        // old way
        for (Iterator<Developer> it = developers1.iterator(); it.hasNext(); ) {
            Developer d = it.next();
            if (!d.getProgrammingLanguages().contains(Language.JAVA)) {
                it.remove();
            }
        }
        
        System.out.println(developers1);

        List<Developer> developers2 = DevelopersRepository.getSampleList();
        
        // new way
        developers2.removeIf(d -> !d.getProgrammingLanguages().contains(Language.JAVA));
        
        System.out.println(developers2);
        
        
        
    }
}
