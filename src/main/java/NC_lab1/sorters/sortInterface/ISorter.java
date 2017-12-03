package NC_lab1.sorters.sortInterface;

import NC_lab1.entity.Person;
import NC_lab1.myUtil.MyComparator;

import java.util.Comparator;

public interface ISorter {
    public void sort(MyComparator comparator, Person[] items, int count);
}
