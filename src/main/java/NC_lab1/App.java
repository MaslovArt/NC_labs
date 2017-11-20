package NC_lab1;

import org.joda.time.LocalDate;

public class App {

    private static void show(Crowd crowd) {
        for (int i = 0; i < crowd.Count(); i++) {
            System.out.println(crowd.getAt(i).toString());
        }
    }

    public static void main(String[] args) {
        Crowd People = new Crowd(2);

        for (int i = 0; i < 10; i++) {
            People.add(new Person(new LocalDate(2010, 10, 20), "Surname" + i));
        }
        show(People);
        System.out.println("Del at index 0");
        People.removeAt(0);
        System.out.println("Del with id 5");
        People.removeById(5);
        show(People);
        System.out.println("Add new");
        People.add(new Person(new LocalDate(2010, 10, 20), "Artik"));
        show(People);
        
        int i = 0;
    }
}