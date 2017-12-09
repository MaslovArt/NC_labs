package NC_lab1.myCollection;

import NC_lab1.sorters.sortInterface.ISorterT;
import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class MyArrayListV2<T> implements Iterable<T>{

    protected T[] items;
    protected int count = 0;
    protected int capacity = 0;
    private Class colClass;
    private ISorterT sorter;

    public <T> MyArrayListV2(int capacity) {
        this.capacity = capacity;
        sorter = new BubbleSorterT();
    }

    public T get(int index) {
        return items[index];
    }

    public int size() {
        return count;
    }

    public void add(T item) {
        if(items == null) {
            colClass = item.getClass();
            items = (T[]) Array.newInstance(colClass, capacity);
        }
        if (count == capacity) {
            T[] newArr = (T[]) Array.newInstance(colClass, capacity * 2);
            capacity = capacity * 2;
            System.arraycopy(items, 0, newArr , 0, items.length);
            items = newArr;
        }
        items[count++] = item;
    }

    public boolean contains(T obj) {
        for (int i = 0; i < count; i++) {
            if((items[i]).equals(obj))
                return true;
        }
        return false;
    }

    public T[] toArray() {
        T[] result = (T[]) Array.newInstance(colClass, count);
        System.arraycopy(items, 0, result, 0, count);
        return  result;
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
        T[] newArr = (T[]) Array.newInstance(colClass, capacity - 1);
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
            if ((items[i]).equals(obj)) {
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
            if (predicate.test(items[i]))
                return items[i];
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
        return items;
    }

    public void clear() {
        items = (T[]) Array.newInstance(colClass, capacity);
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [Емкость " + capacity + " размер " + count + "]";
    }
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].toString());
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
            return items[currentIndex++];
        }
    }
}
