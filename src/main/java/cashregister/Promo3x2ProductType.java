package cashregister;

public class Promo3x2ProductType extends ProductType {
    @Override
    public int getProductType() {
        return Product.PROMO_3x2;
    }

    @Override
    public double getAmount(int quantity, double price) {
        if (quantity < 3) {
            return quantity * price;
        }

        int itemsToDiscount = quantity / 3;
        double thisDiscount = itemsToDiscount * price;

        return quantity * price - thisDiscount;
    }
}
