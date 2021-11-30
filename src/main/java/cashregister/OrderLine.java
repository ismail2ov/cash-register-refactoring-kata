package cashregister;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLine {

    private Product product;
    private int quantity;

    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}