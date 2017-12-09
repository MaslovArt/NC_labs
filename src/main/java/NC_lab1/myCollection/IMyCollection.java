package NC_lab1.myCollection;

import java.util.function.Predicate;

public interface IMyCollection<T> {
    public int size();
    public void clear();
    public boolean isEmpty();
    public void add(T item);
    public boolean remove(T item);
    public boolean contains(T obj);
    public T[] toArray();
}
