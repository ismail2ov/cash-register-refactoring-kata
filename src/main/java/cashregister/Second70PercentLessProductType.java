package cashregister;

public class Second70PercentLessProductType extends ProductType {
    @Override
    public int getProductType() {
        return Product.SECOND_70_PERCENT_LESS;
    }

    @Override
    public double getAmount(int quantity, double price) {

        double result;
        if (quantity >= 2) {
            int itemsToDiscount = quantity / 2;
            double thisDiscount = itemsToDiscount * price * 0.7;
            result = quantity * price - thisDiscount;
        } else {
            result = quantity * price;
        }
        
        return result;
    }
}
