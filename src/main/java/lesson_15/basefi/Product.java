package lesson_15.basefi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {

    private String title;
    private double price;
    private boolean inStock;
}
