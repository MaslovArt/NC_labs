package NC_lab1;

import org.joda.time.*;

public class Person {
    private LocalDate birthday;
    private String surname;
    private int id;
    private static int maxID = 0;

    public Person(LocalDate date, String surname) {
        this.birthday = date;
        this.surname = surname;
        maxID++;
        this.id = maxID;
    }

    public int getAge() {
        return new DateTime().getYear() - birthday.getYear();
    }
    public int getId() {
        return id;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [Id - " + id + ", Surname - " + surname + ", birthday - " + birthday.toString() + "]";
    }
}
