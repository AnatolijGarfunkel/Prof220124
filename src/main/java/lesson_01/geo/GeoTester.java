package lesson_01.geo;

public class GeoTester {

    public static void main(String[] args) {

//        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(7, 7));
//        double area = rectangle.area();

        Point sw = new Point(1, 1);
        Point ne = new Point(7, 7);
        Rectangle r = new Rectangle(sw, ne);

        double area = r.area();

        System.out.println("area: " + area);
    }
}
