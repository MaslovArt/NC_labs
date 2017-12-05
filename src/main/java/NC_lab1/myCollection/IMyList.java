package NC_lab1.myCollection;

import java.util.function.Predicate;

public interface IMyList<T> {

    public int size();
    public T get(int index);

    public void add(T item);
    public void remove(T item);
    public T find(Predicate<T> predicate);
    public boolean contains(T obj);
}
