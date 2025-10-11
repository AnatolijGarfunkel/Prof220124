package lesson_06;

import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        Person p1 = new Person(
                "Max Kotkov",
                28,
                new ArrayList<>(
                        List.of(
                                new Address("zelenaya", "12"),
                                new Address("krasnaya", "33")
                        )
                )
        );

        Person p2 = new Person(
                "Masha Semenova",
                31,
                new ArrayList<>(
                        List.of(
                                new Address("sinaya", "44")
                        )
                )
        );

        List<Person> people = List.of(p1, p2);

        List<Address> addressList = getAddresses(people);

        for (Address data: addressList)
            System.out.println(data);
    }

    public static List<Address> getAddresses(List<Person> personList) {
        List<Address> result = new ArrayList<>();

        for (Person data: personList) {
            List<Address> list = data.getAddresses();
            result.addAll(list);
        }

        return result;
    }
}















































