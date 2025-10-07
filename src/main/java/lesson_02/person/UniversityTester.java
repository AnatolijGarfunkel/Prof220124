package lesson_02.person;

public class UniversityTester {

    public static void main(String[] args) {
        Person john = new Person("John", 23);
        Person vasilisa = new Student("Vasilisa", 25, 3, "music");
        Person alex = new Staff("Alex", 37, 23500);

        Person [] person = {john, vasilisa, alex};
        for (int i = 0; i < person.length; i ++) {
            person[i].introduce();
        }
    }
}
