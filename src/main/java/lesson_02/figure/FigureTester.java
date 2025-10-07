package lesson_02.figure;

public class FigureTester {

    public static void main(String[] args) {
        Figure[] figures = {
                new Rectangle(1, 2),
                new Rectangle(2, 3),
                new Circle(1)
        };

        double area = calculateArea(figures);

        System.out.println("area: " + area);

    }

    public static double calculateArea(Figure[] figures) {
        double area = 0;

        for (int i = 0; i < figures.length; i ++) {
            area += figures[i].area();
        }
        return area;
    }
}
