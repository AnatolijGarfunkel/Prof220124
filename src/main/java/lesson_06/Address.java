package lesson_06;

public class Address {

    private String street;

    private String house;

    public Address(String street, String house) {
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}
