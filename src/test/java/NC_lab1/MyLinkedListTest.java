package NC_lab1;

import NC_lab1.entity.Person;
import NC_lab1.myCollection.MyArrayList;
import NC_lab1.myCollection.MyLinkedList;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<Person> list;

    private void initListWithDefaultValues() {
        list.add(new Person(new LocalDate(2010, 10, 20), "Artik"));
        list.add(new Person(new LocalDate(2000, 10, 20), "Julia"));
        list.add(new Person(new LocalDate(1990, 10, 20), "Ann"));
        list.add(new Person(new LocalDate(2013, 10, 20), "Fedos"));
    }

    @Before
    public void setUp() throws Exception {
        list = new MyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void get() throws Exception {
        initListWithDefaultValues();
        Person p = list.get(1);
        assertEquals("Julia", p.getSurname());
    }

    @Test
    public void getFirst() throws Exception {
        initListWithDefaultValues();
        Person p = list.getFirst();
        assertEquals("Artik", p.getSurname());
    }

    @Test
    public void getLast() throws Exception {
        initListWithDefaultValues();
        Person p = list.getLast();
        assertEquals("Fedos", p.getSurname());
    }

    @Test
    public void add() throws Exception {
        initListWithDefaultValues();
        Person p = Person.CreateRandPerson();
        list.add(p);
        assertEquals(p, list.getLast());
    }

    @Test
    public void size() throws Exception {
        initListWithDefaultValues();
        assertEquals(4, list.size());
    }

    @Test
    public void clear() throws Exception {
        initListWithDefaultValues();
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(list.isEmpty());
        initListWithDefaultValues();
        assertFalse(list.isEmpty());
    }

    @Test
    public void remove() throws Exception {
        initListWithDefaultValues();
        Person p = list.find((o1)->o1.getSurname().equals("Ann"));
        assertTrue(list.contains(p));
        list.remove(p);
        assertFalse(list.contains(p));
    }

    @Test
    public void contains() throws Exception {
        initListWithDefaultValues();
        Person p = Person.CreateRandPerson();
        list.add(p);
        assertTrue(list.contains(p));
    }

    @Test
    public void toArray() throws Exception {
        Person[] expected = {
                new Person(new LocalDate(2010, 10, 20), "Artik"),
                new Person(new LocalDate(2000, 10, 20), "Julia"),
                new Person(new LocalDate(1990, 10, 20), "Ann"),
                new Person(new LocalDate(2013, 10, 20), "Fedos")
        };
        for (Person p : expected) {
            list.add(p);
        }
        
        assertArrayEquals(expected, list.toArray());
    }

}