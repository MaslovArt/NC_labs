package NC_lab1;

import java.util.Comparator;
import java.util.function.Predicate;

public class MyArrayList<T> {
    private Object[] items;
    /**
     * Кол-во элементов в коллекции
     */
    private int count = 0;
    /**
     * Емкость коллекции
     */
    private int capacity = 0;

    public <T> MyArrayList(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];

    }

    public int Count() {
        return count;
    }

    public T get(int index) {
        return (T)items[index];
    }

    /**
     * Добавление в коллекцию
     * @param pers новый объект
     */
    public void add(T pers) {
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
        Object[] newArr = new Object[capacity - 1];
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
    public void remove(Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i])) {
                removeAt(i);
                return;
            }
        }
    }

    /**
     * Находит первый элемент, удовлетворяющий условиям указанного предиката
     * @param predicate Условие поиска
     */
    public T find(Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i]))
                return (T)items[i];
        }
        return null;
    }

    /**
     * Сортирует по заданному условию
     * @param compare Правило сравнения
     * @return Возвращает отсортированный массив
     */
    public T[] sort(Comparator<T> compare) {
        Object[] sorted = bubbleSort(items, compare);
        items = sorted;
        return (T[])sorted;
    }

    private T[] bubbleSort(Object[] arr, Comparator<T> compare) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (compare.compare((T)arr[j], (T)arr[j + 1]) >= 1) {
                    Object t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return (T[])arr;
    }

    @Override
    public String toString() {
        return capacity + " " + count;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println((T)items[i].toString());
        }
    }
}
