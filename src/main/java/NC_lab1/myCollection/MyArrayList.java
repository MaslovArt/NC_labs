package NC_lab1.myCollection;

import NC_lab1.sorters.sortInterface.ISorterT;
import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyArrayList<T> extends MyAbstractArrayList<T>{
    /**
     * Конструктор
     * @param capacity Начальная емкость коллекции
     * @param <T>
     */
    public <T> MyArrayList(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        sorter = new BubbleSorterT();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [Емкость " + capacity + " размер " + count + "]";
    }
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println((T)items[i].toString());
        }
    }
}
