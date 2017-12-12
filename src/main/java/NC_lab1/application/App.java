package NC_lab1.application;

import NC_lab1.entity.Car;
import NC_lab1.entity.Person;
import NC_lab1.myCollection.MyArrayList;
import NC_lab1.myCollection.MyArrayListV2;
import NC_lab1.myCollection.MyLinkedList;
import NC_lab1.myCollection.PersonRepository;
import org.joda.time.LocalDate;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

    private static Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        MyArrayList<Person> People = new MyArrayList<>(15);
        //MyPersonArrayList People = new MyPersonArrayList(15);

        for (int i = 0; i < 10; i++) {
            Person pNew = Person.CreateRandPerson();
            People.add(pNew);
            log.info("Add to collection " + pNew.toString());
        }
        for (Person p: People) {
            p.print();
        }

        Person p1 = new Person(new LocalDate(2010, 10, 20), "Artik");
        People.add(p1);
        log.info("Add to collection " + p1.toString());
        log.info(People.toString());

        People.sort((o1, o2) -> o1.getId().compareTo(o2.getId()));
        log.info("Sort collection by id.");
        //System.out.println("id");
        //People.print();

        People.sort((o1, o2) -> o2.getAge() - o1.getAge());
        log.info("Sort collection by age.");
        //System.out.println("age");
        //People.print();

        People.sort((o1, o2)->o1.getSurname().compareTo(o2.getSurname()));
        log.info("Sort collection by surname.");
        //System.out.println("id");
        //People.print();

        Person pf = People.find((o1)->(o1.getSurname().equals("Artik")));
        if(pf != null) {
            log.info("Found person " + pf.toString());
        }

        People.removeAt(1);
        log.info("Delete by index 1. ");
        log.info(People.toString());


        MyArrayList<Car> cars = new MyArrayList<>(10);
        cars.add(new Car("Toyota", "rav4", 2007, 38000));
        cars.add(new Car("Toyota", "carolla", 2012, 45000));
        cars.add(new Car("Toyota", "ls200", 2007, 38000));
        cars.add(new Car("LandRover", "discovery", 1998, 143000));

        Car landRovar = cars.find((o1)->o1.getModel().equals("discovery"));
        if (landRovar != null)
            System.out.println(landRovar.toString());


        System.out.println("PersonREpa");
        PersonRepository persons = new PersonRepository(5);
        for (int i = 0; i < 5; i++)
            persons.add(Person.CreateRandPerson());

        persons.sortBySurname();
        persons.print();

        //----------------LinkedList------------------//
/*        Person pArt = new Person(new LocalDate(2010, 10, 20), "Artik");

        MyLinkedList<Person> peopleList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++)
            peopleList.add(Person.CreateRandPerson());
        peopleList.add(pArt);

        peopleList.get(3).print();

        System.out.println();
        for (Person p : peopleList) {
            p.print();
        }*/
    }
}