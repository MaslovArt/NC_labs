package NC_lab1.myCollection;

import NC_lab1.sorters.sortInterface.ISorterT;
import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

import java.util.Comparator;
import java.util.function.Predicate;

public class MyArrayListT<T> extends MyAbstractArrayList<T>{

    private ISorterT sorter;

    public <T> MyArrayListT(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        sorter = new BubbleSorterT();
    }

    public void setSorter(ISorterT sorter) {
        this.sorter = sorter;
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
    public void remove(Object obj) {
        for (int i = 0; i < count; i++) {
            if (((T)items[i]).equals(obj)) {
                removeAt(i);
                return;
            }
        }
    }

    /**
     * Сортирует по заданному условию
     * @param compare Правило сравнения
     * @return Возвращает отсортированный массив
     */
    public T[] sort(Comparator<T> compare) {
        sorter.sort(compare, items, count);
        return (T[])items;
    }

    public T[] toArray() {
        Object[] result = new Person[count];
        System.arraycopy(items, 0, result, 0, count);

        return  (T[])result;
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
