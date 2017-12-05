package NC_lab1.sorters.sorter;

import NC_lab1.myUtil.function.MyComparator;
import NC_lab1.sorters.sortInterface.ISorter;
import NC_lab1.entity.Person;

public class BubbleSorter implements ISorter {
    @Override
    public void sort(MyComparator comparator, Person[] arr, int count) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) >= 1) {
                    Person t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
}
