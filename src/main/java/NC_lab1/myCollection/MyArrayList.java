package NC_lab1.myCollection;

import NC_lab1.myUtil.function.MyComparator;
import NC_lab1.myUtil.function.MyPredicate;
import NC_lab1.sorters.sortInterface.ISorter;
import NC_lab1.sorters.sorter.BubbleSorter;
import NC_lab1.entity.Person;

public class MyArrayList {
    private Person[] items;
    private ISorter sorter;
    /**
     * Кол-во элементов в коллекции
     */
    private int count = 0;
    /**
     * Емкость коллекции
     */
    private int capacity = 0;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        items = new Person[this.capacity];
        sorter = new BubbleSorter();
    }

    public int size() {
        return count;
    }
    public Person get(int index) {
        return items[index];
    }

    public void setSorter(ISorter sorter) {
        this.sorter = sorter;
    }

    public boolean contains(Person item) {
        for (int i = 0; i < count; i++) {
            if(items[i].equals(item))
                return true;
        }
        return false;
    }
    /**
     * Добавление в коллекцию
     * @param pers новый объект
     */
    public void add(Person pers) {
        if (count == capacity) {
            Person[] newArr = new Person[capacity * 2];
            capacity = capacity * 2;
            System.arraycopy(items, 0, newArr , 0, items.length);
            items = newArr;
        }
        items[count++] = pers;
    }
    /**
     * Удаление из коллекции по индексу
     * @param index Индекс
     */
    public void removeAt(int index){
        Person[] newArr = new Person[capacity - 1];
        System.arraycopy(items, 0, newArr, 0, items.length - index - 1);
        System.arraycopy(items, index + 1, newArr, index, items.length - index - 1 );
        items = newArr;
        count--;
        capacity--;
    }

    /**
     * Удаляет первый элемент, удовлетворяющий условиям указанного предиката
     * @param predicate Условие поиска
     */
    public void remove(MyPredicate predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test(items[i])) {
                removeAt(i);
                return;
            }
        }
    }

    /**
     * Находит первый элемент, удовлетворяющий условиям указанного предиката
     * @param predicate Условие поиска
     */
    public Person find(MyPredicate predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test(items[i]))
                return items[i];
        }
        return null;
    }

    /**
     * Находит все элементы, удовлетворяющий условиям предиката
     * @param predicate Условие поиска
     */
    public Person[] findAll(MyPredicate predicate) {
        MyArrayList result = new MyArrayList(10);
        for (int i = 0; i < count; i++) {
            if (predicate.test(items[i]))
                result.add(items[i]);
        }
        return result.toArray();
    }

    /**
     * Сортирует по заданному условию
     * @param compare Правило сравнения
     * @return Возвращает отсортированный массив
     */
    public Person[] sort(MyComparator compare) {
        sorter.sort(compare, items, count);
        return items;
    }

    public Person[] toArray() {
        Person[] result = new Person[count];
        System.arraycopy(items, 0, result, 0, count);

        return  result;
    }

    @Override
    public String toString() {
        return MyArrayList.class.getSimpleName() + " [Емкость " + capacity + " размер " + count + "]";
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].toString());
        }
    }
}

