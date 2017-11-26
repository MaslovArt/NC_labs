package NC_lab1;

import java.util.Comparator;

public class Crowd {

    private Person[] people;
    /**
     * Кол-во элементов в коллекции
     */
    private int _count = 0;
    /**
     * Емкость коллекции
     */
    private int capacity = 0;

    public Crowd(int capacity) {
        this.capacity = capacity;
        people = new Person[this.capacity];
    }

    public int Count() {
        return _count;
    }

    public Person getByIndex(int index) {
        return people[index];
    }
    public Person getById(String id) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id) {
                return people[i];
            }
        }
        return null;
    }
    public Person getByName(String surname) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSurname().toLowerCase().equals(surname.toLowerCase()))
                return people[i];
        }
        return null;
    }

    /**
     * Добавление в коллекцию
     * @param pers новый объект
     */
    public void add(Person pers) {
        if (_count == capacity) {
            Person[] newArr = new Person[capacity * 2];
            capacity = capacity * 2;
            System.arraycopy(people, 0, newArr , 0, people.length);
            people = newArr;
        }
        people[_count] = pers;
        _count++;
    }
    /**
     * Удаление из коллекции по индексу
     * @param index Индекс
     */
    public void removeAt(int index){
        Person[] newArr = new Person[capacity - 1];
        System.arraycopy(people, 0, newArr, 0, people.length - index - 1);
        System.arraycopy(people, index + 1, newArr, index,people.length - index - 1 );
        people = newArr;
        _count--;
        capacity--;
    }
    /**
     * Удаление из коллекции по id
     * @param id Айди
     */
    public void removeById(String id) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id) {
                removeAt(i);
                break;
            }
        }
    }


    /**
     * Сортирует по заданному условию
     * @param compare Правило сравнения
     * @return Возвращает отсортированный массив
     */
    public Person[] sort(Comparator<Person> compare) {
        Person[] sorted = bubbleSort(people, compare);
        people = sorted;
        return sorted;
    }

    private Person[] bubbleSort(Person[] arr, Comparator<Person> compare) {
        for (int i = _count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (compare.compare(arr[j], arr[j + 1]) >= 1) {
                    Person t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        return capacity + " " + _count;
    }

    public void Print() {
        for (int i = 0; i < _count; i++) {
            System.out.println(people[i].toString());
        }
    }
}
