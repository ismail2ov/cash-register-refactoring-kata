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
        return this.type.getAmount(quantity, this.getPrice());
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