import ru.test.git.entitties.Person;
import ru.test.git.service.PersonService;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();

        System.out.println("call show method");
        personService.showAllPersons();

        System.out.println("work with list of Persons in circle");
        Collection list = personService.getAllPersons();
        for (Object p : list){
            System.out.println(((Person)p).getName());
        }

    }

}
