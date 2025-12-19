package stream_basics.person;

public class Person {

    private final String name;

    private final int age;

    private final String city;

    private final double income;

    public Person(String name, int age, String city, double income) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public double getIncome() {
        return income;
    }
}

/*
List<Person> people = List.of(
        new Person("Anna", 25, "Berlin",   3200),
        new Person("Bernd", 17, "Hamburg", 0),
        new Person("Clara", 32, "Berlin",  4500),
        new Person("Dirk", 15, "München",  0),
        new Person("Eva", 40, "Hamburg",   5100),
        new Person("Fritz", 29, "Berlin",  3800)
);
 */