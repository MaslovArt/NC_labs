package NC_lab1;

import org.joda.time.LocalDate;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App {

    private static Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        MyArrayList<Person> People = new MyArrayList<>(2);

        for (int i = 0; i < 10; i++) {
            Person pNew = Person.CreateRandPerson();
            People.add(pNew);
            log.info("Add new " + pNew.toString());
        }

        //People.print();
        //System.out.println("Add new");
        People.add(new Person(new LocalDate(2010, 10, 20), "Artik"));
        //People.print();
        //System.out.println();

        People.sort((o1, o2) -> o2.getAge() - o1.getAge(), 1);
        //System.out.println("Sorted by age");
        //People.print();

        //System.out.println("Sorted by id");
        People.sort((o1, o2) -> o1.getId().compareTo(o2.getId()), 0);
        //People.print();

        //System.out.println("Sorted by surname");
        People.sort((o1, o2)->o1.getSurname().compareTo(o2.getSurname()), 0);
        //People.print();

        //System.out.println("Find person with name Artik");
        Person p1 = People.find((o1)->(o1.getSurname().equals("Artik")));
        if(p1 != null)
            //p1.print();

        //System.out.println("Remove by index 1");
        People.removeAt(1);
        //People.print();

        //System.out.println("Remove by name \"Artik\"");
        People.remove((o1)->(o1.getSurname().equals("Artik")));
       // People.print();
    }
}