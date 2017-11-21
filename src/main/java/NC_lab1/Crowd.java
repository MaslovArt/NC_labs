package NC_lab1;

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
    public Person getAt(int index) {
        return people[index];
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
    public void removeById(int id) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id) {
                removeAt(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return capacity + " " + _count;
    }
}
