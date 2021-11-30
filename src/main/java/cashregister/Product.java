package cashregister;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    public static final int PROMO_3x2 = 3;
    public static final int SECOND_70_PERCENT_LESS = 2;
    public static final int PROMOTED = 1;
    public static final int REGULAR = 0;

    private String name;
    private double price;
    private ProductType type;

    double amountFor(int quantity) {
        return this.type.getAmount(quantity, this.getPrice());
    }

    int creditsFor(int quantity) {
        return this.type.getCredits(quantity);
    }
}