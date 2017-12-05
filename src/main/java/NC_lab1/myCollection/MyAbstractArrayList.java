package NC_lab1.myCollection;

import NC_lab1.entity.Person;

import java.util.function.Predicate;

public abstract class MyAbstractArrayList<T> implements IMyList<T> {

    protected Object[] items;
    protected int count = 0;
    protected int capacity = 0;

    @Override
    public int size() {
        return count;
    }

    @Override
    public T get(int index) {
        return (T)items[index];
    }

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

    @Override
    public abstract void remove(T item);

    @Override
    public T find(Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i]))
                return (T)items[i];
        }
        return null;
    }

    @Override
    public boolean contains(T obj) {
        for (int i = 0; i < count; i++) {
            if(((T)items[i]).equals(obj))
                return true;
        }
        return false;
    }
}
