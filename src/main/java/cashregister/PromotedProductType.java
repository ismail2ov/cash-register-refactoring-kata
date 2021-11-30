package cashregister;

public class PromotedProductType extends ProductType {
    @Override
    public int getProductType() {
        return Product.PROMOTED;
    }

    @Override
    public int getCredits(int quantity) {
        return quantity;
    }
}
