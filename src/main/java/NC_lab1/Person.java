package NC_lab1;

import org.joda.time.*;

import java.util.Random;
import java.util.UUID;

public class Person {
    private LocalDate birthday;
    private String surname;
    private UUID id;

    public Person(LocalDate date, String surname) {
        this.birthday = date;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }

    public static Person CreateRandPerson() {
        Random rand = new Random();

        int nameLength = rand.nextInt(6) + 3;
        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            newName.append((char)(rand.nextInt(24) + 97));
        }
        newName.setCharAt(0, (char)((int)newName.charAt(0) - 32));

        return new Person(new LocalDate(rand.nextInt(80) + 1930,
                                        rand.nextInt(11) + 1, rand.nextInt(26) + 1),
                                        newName.toString());
    }

    public int getAge() {
        return new DateTime().getYear() - birthday.getYear();
    }
    public String getId() {
        return id.toString();
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

    public void print() {
        System.out.println(this.toString());
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
