package lesson_15;

import lesson_15.basefi.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> moreThan0 = (a) -> a > 0;
        System.out.println(moreThan0.test(10));
        System.out.println(moreThan0.test(-3));

        List<Product> products = Arrays.asList(
                new Product("Apple", 70, true),
                new Product("Banana", 30, false),
                new Product("Lemon", 45, true),
                new Product("Pineapple", 60, true),
                new Product("Watermelon", 40, true),
                new Product("Carrot", 55, false)
        );

        Predicate<Product> moreThan = product -> product.getPrice() > 50;
        Predicate<Product> inStock = Product::isInStock;
        Predicate<Product> startsWithA = product -> product.getTitle().startsWith("A");

        List<Predicate<Product>> predicates = Arrays.asList(
                moreThan,
                inStock,
                startsWithA
        );

        List<Product> filterPrice = filter(products, moreThan);
        List<Product> isInStock = filter(products, inStock);
        List<Product> beginsWithA = filter(products, startsWithA);

        System.out.println("more than 2000: " + filterPrice);
        System.out.println("in Stock: " + isInStock);
        System.out.println("starts with A: " + beginsWithA);

        List<Product> filtered = filter(products, predicates);

        System.out.println("filtered: " + filtered);

    }

    public static List<Product> filter(List<Product> products, Predicate<Product> predicate) {
        List<Product> filteredProducts = new ArrayList<>();

        for (Product product : products)
            if (predicate.test(product))
                filteredProducts.add(product);

        return filteredProducts;
    }

    public static List<Product>  filter(List<Product> products, List<Predicate<Product>> predicates) {
        List<Product> filteredProducts = new ArrayList<>();

        Predicate<Product> predicate = predicates.stream()
                .reduce(Predicate::and)
                .orElse(product ->  false);

        for (Product product : products)
            if (predicate.test(product))
                filteredProducts.add(product);

        return filteredProducts;
    }
}














































