package NC_lab1.myCollection;

import NC_lab1.entity.Car;
import NC_lab1.entity.Person;
import NC_lab1.sorters.sorter.BubbleSorterT;

public class CarsRepository extends MyAbstractArrayList<Car> {

    public CarsRepository(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        sorter = new BubbleSorterT();
    }

    public Car[] findAllByModel(String model) {
        return findAll((o1)->o1.getModel().equals(model));
    }
    public Car[] findAllByAge(int age) {
        return findAll((o1)->o1.getYear() == age);
    }

    public void sortByYear() {
        sort((o1, o2)->o1.getYear() - o2.getYear());
    }

}
