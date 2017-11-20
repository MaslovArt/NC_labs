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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Person))return false;

        Person other = (Person)obj;
        return other.id == this.id ? true : false;
    }
}
