package NC_lab1.sorters.sorter;

import NC_lab1.entity.Person;
import NC_lab1.sorters.sortInterface.ISorterT;

import java.util.Comparator;

public class BubbleSorterT<T> implements ISorterT {
    @Override
    public void sort(Comparator comparator, Object[] arr, int count) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare((T)arr[j], (T)arr[j + 1]) >= 1) {
                    Object t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
