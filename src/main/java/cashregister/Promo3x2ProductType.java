package cashregister;

public class Promo3x2ProductType extends ProductType {
    @Override
    public int getProductType() {
        return Product.PROMO_3x2;
    }

    @Override
    public double getAmount(int quantity, double price) {
        double result;
        if (quantity >= 3) {
            int itemsToDiscount = quantity / 3;
            double thisDiscount = itemsToDiscount * price;
            result = quantity * price - thisDiscount;
        } else {
            result = quantity * price;
        }

        return result;
    }
}
