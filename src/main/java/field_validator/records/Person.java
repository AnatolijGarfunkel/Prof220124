package field_validator.records;

public record Person(String name, String age) {

    public void print() {
        System.out.println("\n" + name() + " " + age());
    }
}
