package NC_lab1.sorters.sorter;

import NC_lab1.myUtil.MyComparator;
import NC_lab1.sorters.sortInterface.ISorter;
import NC_lab1.entity.Person;

import java.util.Comparator;

public class ShakerSorter implements ISorter {
    @Override
    public void sort(MyComparator comp, Person[] mas, int count) {
        boolean wasSwapped;
        Person temp;
        do {
            wasSwapped=false;
            for (int i = 0; i < count - 2; i++) {
                if (comp.compare(mas[i], mas[i + 1])>=1) {
                    temp = mas[i];
                    mas[i]=mas[i+1];
                    mas[i+1]=temp;
                    wasSwapped=true;
                }
            }

            if(!wasSwapped) break;

            wasSwapped=false;
            for (int j = count-2; j >= 0; j--) {
                if(comp.compare(mas[j],mas[j+1])>=1){
                    temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]=temp;
                    wasSwapped=true;
                }
            }

        } while(wasSwapped);
    }
}
