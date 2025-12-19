package stream_basics.order;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public Order(OrderItem ... items) {
        this.items.addAll(Arrays.asList(items));
    }
}
