package cashregister;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
abstract class ProductType {

    public double getAmount(int quantity, double price) {
        return quantity * price;
    }

    public int getCredits(int quantity) {
        return 0;
    }
}
