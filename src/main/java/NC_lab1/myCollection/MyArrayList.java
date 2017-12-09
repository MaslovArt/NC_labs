package NC_lab1.myCollection;

import NC_lab1.sorters.sortInterface.ISorterT;
import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyArrayList<T> extends MyAbstractArrayList<T> implements Iterable<T>{

    private ISorterT sorter;

    public <T> MyArrayList(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        sorter = new BubbleSorterT();
    }

    /**
     * Устанавливает способ сортировки
     * @param sorter Метод сортировки
     */
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
     * Удаляет объект из коллекции
     * @param obj Объект
     */
    public boolean remove(Object obj) {
        for (int i = 0; i < count; i++) {
            if (((T)items[i]).equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Находит первый элемент по указанному предикату
     * @param predicate Предикат
     * @return
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
        sorter.sort(compare, items, count);
        return (T[])items;
    }

    /**
     *
     */
    @Override
    public void clear() {
        items = new Object[capacity];
        count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
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

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new MyArrayListIterator();
    }

    class MyArrayListIterator implements Iterator<T> {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < count;
        }
        @Override
        public T next() {
            return (T)items[currentIndex++];
        }
    }
}
