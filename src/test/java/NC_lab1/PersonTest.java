package NC_lab1;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person(new LocalDate(2010, 10, 20), "Artik");
    }

    @After
    public void tearDown() throws Exception {
        person = null;
    }

    @Test
    public void getAge() throws Exception {
        assertEquals(8, person.getAge());
    }

    @Test
    public void getBirthday() throws Exception {
        assertEquals(new LocalDate(2010, 10, 20), person.getBirthday());
    }

    @Test
    public void getSurname() throws Exception {
        assertEquals("Artik",person.getSurname());
    }

}