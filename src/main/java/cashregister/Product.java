package cashregister;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Type;

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

    public Product(String name, double price, int type) {
        this.name = name;
        this.price = price;
        setType(type);
    }

    private void setType(int type) {
        switch (type) {
            case REGULAR:
                this.type = new RegularProductType();
                break;
            case PROMOTED:
                this.type = new PromotedProductType();
                break;
            case SECOND_70_PERCENT_LESS:
                this.type = new Second70PercentLessProductType();
                break;
            case PROMO_3x2:
                this.type = new Promo3x2ProductType();
                break;
        }
    }

    public int getType() {
        return type.getProductType();
    }

    double amountFor(int quantity) {
        double result = 0;
        double thisDiscount;
        // determine amounts for orderLine order line
        switch (this.getType()) {
            case REGULAR:
                result = quantity * this.getPrice();
                break;
            case PROMOTED:
                result = quantity * this.getPrice();
                break;
            case SECOND_70_PERCENT_LESS:
                if (quantity >= 2) {
                    int itemsToDiscount = quantity / 2;
                    thisDiscount = itemsToDiscount * this.getPrice() * 0.7;
                    result = quantity * this.getPrice() - thisDiscount;
                } else {
                    result = quantity * this.getPrice();
                }
                break;
            case PROMO_3x2:
                if (quantity >= 3) {
                    int itemsToDiscount = quantity / 3;
                    thisDiscount = itemsToDiscount * this.getPrice();
                    result = quantity * this.getPrice() - thisDiscount;
                } else {
                    result = quantity * this.getPrice();
                }
                break;
        }

        return result;
    }

    int creditsFor(int quantity) {
        int accumulatedCredits = 0;
        // add credits for purchasing more than 10 units of regular products
        if ((this.getType() == REGULAR) && quantity > 10) {
            accumulatedCredits++;
        }
        // add extra credit for every promoted product purchased
        if (this.getType() == PROMOTED) {
            accumulatedCredits += quantity;
        }
        return accumulatedCredits;
    }
}