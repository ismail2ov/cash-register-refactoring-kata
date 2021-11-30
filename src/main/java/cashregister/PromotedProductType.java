package cashregister;

public class PromotedProductType extends ProductType {

    @Override
    public int getCredits(int quantity) {
        return quantity;
    }
}
