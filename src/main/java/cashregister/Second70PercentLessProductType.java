package cashregister;

public class Second70PercentLessProductType extends ProductType {

    @Override
    public double getAmount(int quantity, double price) {

        if (quantity < 2) {
            return quantity * price;
        }

        int itemsToDiscount = quantity / 2;
        double thisDiscount = itemsToDiscount * price * 0.7;
        return quantity * price - thisDiscount;

    }
}
