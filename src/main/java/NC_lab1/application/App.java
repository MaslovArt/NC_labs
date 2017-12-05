package NC_lab1.application;

import NC_lab1.myCollection.MyArrayList;
import NC_lab1.entity.Person;
import NC_lab1.myCollection.MyArrayListT;
import org.joda.time.LocalDate;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

    private static Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        MyArrayListT<Person> People = new MyArrayListT<>(15);
        //MyArrayList People = new MyArrayList(15);

        for (int i = 0; i < 10; i++) {
            Person pNew = Person.CreateRandPerson();
            People.add(pNew);
            log.info("Add to collection " + pNew.toString());
        }
        log.info(People.toString());

        Person p1 = new Person(new LocalDate(2010, 10, 20), "Artik");
        People.add(p1);
        log.info("Add to collection " + p1.toString());
        log.info(People.toString());

        People.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        log.info("Sort collection by id.");

        People.sort((o1, o2) -> o2.getAge() - o1.getAge());
        log.info("Sort collection by age.");
        People.print();

        People.sort((o1, o2)->o1.getSurname().compareTo(o2.getSurname()));
        log.info("Sort collection by surname.");

        Person pf = People.find((o1)->(o1.getSurname().equals("Artik")));
        if(pf != null) {
            log.info("Found person " + pf.toString());
        }

        People.removeAt(1);
        log.info("Delete by index 1. ");
        log.info(People.toString());

        People.remove((o1)->(o1.getSurname().equals("Artik")));
        log.info("Delete by surname 'Artik'.");
        log.info(People.toString());
    }
}