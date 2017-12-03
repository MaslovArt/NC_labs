package NC_lab1.myCollection;

import NC_lab1.sorters.sortInterface.ISorter;
import NC_lab1.entity.Person;

import java.util.Comparator;
import java.util.function.Predicate;

public class MyArrayListT<T> {
    private Object[] items;
    private ISorter sorter;
    /**
     * Кол-во элементов в коллекции
     */
    private int count = 0;
    /**
     * Емкость коллекции
     */
    private int capacity = 0;

    public <T> MyArrayListT(int capacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
    }

    public int size() {
        return count;
    }
    public T get(int index) {
        return (T)items[index];
    }

    public void setSorter(ISorter sorter) {
        this.sorter = sorter;
    }

    public boolean contains(T item) {
        for (int i = 0; i < count; i++) {
            if(((T)items[i]).equals(item))
                return true;
        }
        return false;
    }
    /**
     * Добавление в коллекцию
     * @param pers новый объект
     */
    public void add(T pers) {
        if (count == capacity) {
            Person[] newArr = new Person[capacity * 2];
            capacity = capacity * 2;
            System.arraycopy(items, 0, newArr , 0, items.length);
            items = newArr;
        }
        items[count++] = pers;
    }
    /**
     * Удаление из коллекции по индексу
     * @param index Индекс
     */
    public void removeAt(int index){
        Object[] newArr = new Object[capacity - 1];
        System.arraycopy(items, 0, newArr, 0, items.length - index - 1);
        System.arraycopy(items, index + 1, newArr, index, items.length - index - 1 );
        items = newArr;
        count--;
        capacity--;
    }

    /**
     * Удаляет первый элемент, удовлетворяющий условиям указанного предиката
     * @param predicate Условие поиска
     */
    public void remove(Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i])) {
                removeAt(i);
                return;
            }
        }
    }

    /**
     * Находит первый элемент, удовлетворяющий условиям указанного предиката
     * @param predicate Условие поиска
     */
    public T find(Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test((T)items[i]))
                return (T)items[i];
        }
        return null;
    }

    /**
     * Сортирует по заданному условию
     * @param compare Правило сравнения
     * @param param Вид сортировки: 0 - пузырьком, 1 - шейкерная
     * @return Возвращает отсортированный массив
     */
    public T[] sort(Comparator<T> compare, int param) {
        switch (param) {
            case 0: bubbleSortT((T[])items, compare); break;
            case 1: shakerSortT((T[])items, compare); break;
            default: return (T[])items;
        }
        return (T[])items;
    }

    private <T> void bubbleSortT(T[] arr, Comparator<T> compare) {
        for (int i = count - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (compare.compare(arr[j], arr[j + 1]) >= 1) {
                    T t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }
    private <T> void shakerSortT(T[] mas, Comparator<T> comp){
        boolean wasSwapped;
        T temp;
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

    public Person[] toArray() {
        Person[] result = new Person[count];
        System.arraycopy(items, 0, result, 0, count);

        return  result;
    }

    @Override
    public String toString() {
        return capacity + " " + count;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println((T)items[i].toString());
        }
    }
}
