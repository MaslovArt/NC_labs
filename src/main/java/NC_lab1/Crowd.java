package NC_lab1;

public class Crowd {

    private Person[] people;
    private int _count = 0;
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
    public void removeAt(int index){
        Person[] newArr = new Person[capacity - 1];
        System.arraycopy(people, 0, newArr, 0, people.length - index - 1);
        System.arraycopy(people, index + 1, newArr, index,people.length - index - 1 );
        people = newArr;
        _count--;
        capacity--;
    }
    public void removeById(int id) {
        int delInd = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id) {
                delInd = i;
                break;
            }
        }
        if (delInd != -1)
            removeAt(delInd);
    }

    @Override
    public String toString() {
        return capacity + " " + _count;
    }
}
