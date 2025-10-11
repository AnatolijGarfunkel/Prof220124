package lesson_06;

import java.util.List;

public class Person {

    private String name;

    private int age;

    private List<Address> addresses;

    public Person(String name, int age, List<Address> addresses) {
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
