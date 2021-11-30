package cashregister;

abstract class ProductType {
    public abstract int getProductType();

    public double getAmount(int quantity, double price) {
        return quantity * price;
    }
}
