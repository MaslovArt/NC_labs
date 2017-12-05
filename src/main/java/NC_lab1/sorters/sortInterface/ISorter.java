package NC_lab1.sorters.sortInterface;

import NC_lab1.entity.Person;
import NC_lab1.myUtil.function.MyComparator;

public interface ISorter {
    public void sort(MyComparator comparator, Person[] items, int count);
}
