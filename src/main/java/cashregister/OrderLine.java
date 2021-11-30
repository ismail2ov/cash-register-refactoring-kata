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
        double result = 0;
        double thisDiscount;
        // determine amounts for orderLine order line
        switch (getProduct().getType()) {
            case Product.REGULAR:
                result = getQuantity() * getProduct().getPrice();
                break;
            case Product.PROMOTED:
                result = getQuantity() * getProduct().getPrice();
                break;
            case Product.SECOND_70_PERCENT_LESS:
                if (getQuantity() >= 2) {
                    int itemsToDiscount = getQuantity() / 2;
                    thisDiscount = itemsToDiscount * getProduct().getPrice() * 0.7;
                    result = getQuantity() * getProduct().getPrice() - thisDiscount;
                } else {
                    result = getQuantity() * getProduct().getPrice();
                }
                break;
            case Product.PROMO_3x2:
                if (getQuantity() >= 3) {
                    int itemsToDiscount = getQuantity() / 3;
                    thisDiscount = itemsToDiscount * getProduct().getPrice();
                    result = getQuantity() * getProduct().getPrice() - thisDiscount;
                } else {
                    result = getQuantity() * getProduct().getPrice();
                }
                break;
        }

        return result;
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