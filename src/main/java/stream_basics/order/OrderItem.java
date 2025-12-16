package stream_basics.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderItem { // позиция в чеке
    private String title;
    private int quantity;
    private double unitPrice;
}
