package NC_lab1.myCollection;

import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

public class PersonRepository extends MyAbstractArrayList<Person> {

    public PersonRepository(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        sorter = new BubbleSorterT();
    }

    /**
     * Поиск по айди
     * @param id
     * @return
     */
    public Person findById(String id) {
        return find((o1)->o1.getId().equals(id));
    }
    /**
     * Поиск по имени
     * @param surname
     * @return
     */
    public Person findBySurname(String surname) {
        return find((o1)->o1.getSurname().equals(surname));
    }
    /**
     * Поиск по возрасту
     * @param age
     * @return
     */
    public Person[] findAllByAge(int age) {
        return findAll((o1)->o1.getAge() == age);
    }


    /**
     * Сортировка по имени
     */
    public void sortBySurname() {
        sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
    }

    /**
     * Сортировка по возрасту
     */
    public void sortByAge() {
        sort((o1, o2) -> o1.getAge() - o2.getAge());
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].toString());
        }
    }
}
