package NC_lab1.myCollection;

import NC_lab1.entity.Person;
import NC_lab1.sorters.sortInterface.ISorterT;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public abstract class MyAbstractArrayList<T> implements IMyCollection<T>, Iterable<T> {

    protected Object[] items;
    protected int count = 0;
    protected int capacity = 0;
    protected ISorterT sorter;

    public T get(int index) {
        return (T)items[index];
    }

    /**
     * Размерность
     * @return
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Добавление элемента
     * @param item
     */
    @Override
    public void add(T item) {
        if (count == capacity) {
            Object[] newArr = new Object[capacity * 2];
            capacity = capacity * 2;
            System.arraycopy(items, 0, newArr , 0, items.length);
            items = newArr;
        }
        items[count++] = item;
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
    public T[] findAll(Predicate<T> predicate) {
        MyArrayList<T> res = new MyArrayList<>(10);
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i]))
                res.add((T)items[i]);
        }
        return (T[])res.toArray();
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
    @Override
    public boolean remove(T obj) {
        for (int i = 0; i < count; i++) {
            if (((T)items[i]).equals(obj)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Очистка коллекции
     */
    @Override
    public void clear() {
        items = new Object[capacity];
        count = 0;
    }

    /**
     * Проверка на пустоту
     * @return
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Содержание элемента в коллекции
     * @param obj
     * @return
     */
    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < count; i++) {
            if(((T)items[i]).equals(obj))
                return true;
        }
        return false;
    }

    /**
     * Устанавливает способ сортировки
     * @param sorter Метод сортировки
     */
    public void setSorter(ISorterT sorter) {
        this.sorter = sorter;
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

    @Override
    public T[] toArray() {
        Object[] result = new Object[count];
        System.arraycopy(items, 0, result, 0, count);
        return  (T[])result;
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
