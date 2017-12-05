package NC_lab1.sorters.sortInterface;

import NC_lab1.entity.Person;

import java.util.Comparator;

public interface ISorterT<T> {
    public void sort(Comparator<T> comparator, T[] items, int count);
}
