package cashregister;

public class RegularProductType extends ProductType {

    @Override
    public int getCredits(int quantity) {
        return (quantity > 10) ? 1 : 0;
    }
}
