package lesson_04.animals.one_dimensional;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayTester {

    public static void main(String[] args) {

        int[][] c = new int[][]{
                {1, 3, 5},
                {4},
                {-10, 20, -40, 5}
        };

        print(c);
    }

    public static void print(int [][] array) {
        for (int i = 0; i < array.length; i ++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }





    public static int max(int[][] array) {

        if (array == null)
            return Integer.MIN_VALUE;

        int result = 0;

        for (int i = 0; i < array.length; i ++) {
            if (array[i] == null)
                continue;
            else {
                for (int j = 0; j < array[i].length; j ++) {
                    if (array[i][j] > result) {
                        result = array[i][j];
                    }
                }
            }
        }

        return result;
    }










    public static int[] flatten(int[][] a) {

        int position = 0;
        int length = 0;

        for (int i = 0; i < a.length; i++) {
            length += a[i].length;
        }

        int[] result = new int[length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[position++] = a[i][j];
            }
        }

        return result;
    }

    public static int sum(int[][] a) {

        int s = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                s += a[i][j];
            }
        }
        return s;
    }
}
