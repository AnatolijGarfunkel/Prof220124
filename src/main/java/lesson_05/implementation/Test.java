package lesson_05.implementation;

public class Test {

    public static void main(String[] args) {

        int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        TestArrayList list = new TestArrayList(array);

        list.add(11, 23);



        System.out.println("size(position): " + list.size());
        System.out.println("array.length: " + list.getArrayLength());
        System.out.println(list);

    }
}
