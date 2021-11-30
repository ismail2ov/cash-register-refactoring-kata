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

    public double amountFor() {
        int quantity = getQuantity();
        return product.amountFor(quantity);
    }

    int creditsFor() {
        int accumulatedCredits = 0;
        // add credits for purchasing more than 10 units of regular products
        if ((getProduct().getType() == Product.REGULAR) && getQuantity() > 10) {
            accumulatedCredits++;
        }
        // add extra credit for every promoted product purchased
        if (getProduct().getType() == Product.PROMOTED) {
            accumulatedCredits += getQuantity();
        }
        return accumulatedCredits;
    }
}