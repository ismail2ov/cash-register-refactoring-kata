package cashregister;

import lombok.Value;

@Value
public class Product {

    String name;
    double price;
    ProductType type;

    double amountFor(int quantity) {
        return this.type.getAmount(quantity, this.getPrice());
    }

    int creditsFor(int quantity) {
        return this.type.getCredits(quantity);
    }
}