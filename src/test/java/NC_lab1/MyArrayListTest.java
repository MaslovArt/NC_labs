package NC_lab1;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    private MyArrayList<Person> people;
    private void initListWithDefaultValues() {
        people.add(new Person(new LocalDate(2010, 10, 20), "Artik"));
        people.add(new Person(new LocalDate(2000, 10, 20), "Julia"));
        people.add(new Person(new LocalDate(1990, 10, 20), "Ann"));
        people.add(new Person(new LocalDate(2013, 10, 20), "Fedos"));
    }

    @Before
    public void setUp() throws Exception {
        people = new MyArrayList<>(8);
    }

    @After
    public void tearDown() throws Exception {
        people = null;
    }

    @Test
    public void сount() throws Exception {
        int expectedCount = 4;
        initListWithDefaultValues();
        assertEquals(expectedCount, people.сount());
    }

    @Test
    public void get() throws Exception {
        initListWithDefaultValues();

        String expectedName1 = "Ann";
        String expectedName2 = "Julia";

        assertEquals(expectedName1, people.get(2).getSurname());
        assertEquals(expectedName2, people.get(1).getSurname());
    }

    @Test
    public void add() throws Exception {
        people.add(new Person(new LocalDate(2010, 10, 20), "Julia1"));
        assertEquals(1,people.сount());

        people.add(new Person(new LocalDate(2010, 10, 20), "Julia2"));
        assertEquals(2,people.сount());
        assertEquals("Julia2", people.get(1).getSurname());
        assertEquals("Julia1", people.get(0).getSurname());

        people.add(new Person(new LocalDate(2010, 10, 20), "Julia3"));
        assertEquals(3,people.сount());
        assertEquals("Julia3", people.get(2).getSurname());
        assertEquals("Julia2", people.get(1).getSurname());
        assertEquals("Julia1", people.get(0).getSurname());
    }

    @Test
    public void removeAt() throws Exception {
        initListWithDefaultValues();

        assertEquals(4,people.сount());
        assertEquals("Julia", people.get(1).getSurname());

        people.removeAt(1);
        assertEquals(3,people.сount());
        assertEquals("Ann", people.get(1).getSurname());
    }

    @Test
    public void remove() throws Exception {
        initListWithDefaultValues();

        assertEquals(4,people.сount());
        assertEquals("Julia", people.get(1).getSurname());

        people.remove((o1)->o1.getSurname().equals("Julia"));
        assertEquals(3,people.сount());
        assertEquals("Ann", people.get(1).getSurname());
    }

    @Test
    public void find() throws Exception {
        initListWithDefaultValues();

        Person expextedPerson = new Person(new LocalDate(2010, 10, 20), "Julia2");
        people.add(expextedPerson);
        Person actual = people.find((o1)->o1.getSurname().equals("Julia2"));
        assertEquals(expextedPerson, actual);
    }

    @Test
    public void sort() throws Exception {
        initListWithDefaultValues();

        people.sort((p1, p2)->p1.getAge()- p2.getAge(), 0);
        assertEquals("Ann", people.get(3).getSurname());
        assertEquals("Julia", people.get(2).getSurname());
        assertEquals("Artik", people.get(1).getSurname());
        assertEquals("Fedos", people.get(0).getSurname());
    }

    @Test
    public void contains() throws Exception {
        initListWithDefaultValues();

        Person p1 = new Person(new LocalDate(2010, 10, 20), "Julia2");
        Boolean actual = people.contains(p1);
        assertFalse(actual);

        people.add(p1);
        actual = people.contains(p1);
        assertTrue(actual);
    }

}