package cashregister;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerShould {

    @Test
    void printStatementInTextFormat() {
        Customer customer = new Customer("John Doe");

        customer.addProduct(new Product("Dodot Sensitive Wipes", 2.30d, Product.REGULAR), 6);
        customer.addProduct(new Product("Pants Dodot size 4", 24.70d, Product.PROMO_3x2), 2);
        customer.addProduct(new Product("Chicco Soft Silicone Pacifier", 5.99d, Product.PROMO_3x2), 1);
        customer.addProduct(new Product("Johnson's Baby Shampoo", 4.09, Product.PROMOTED), 2);
        customer.addProduct(new Product("Blevit Plus Multigrain porridge", 12.27d, Product.SECOND_70_PERCENT_LESS), 1);
        customer.addProduct(new Product("Hero Baby Puree, vegetables with chicken", 6.05d, Product.SECOND_70_PERCENT_LESS), 1);
        customer.addProduct(new Product("Puleva infant milk", 1.45, Product.REGULAR), 12);

        customer.addProduct(new Product("Pants Dodot size 4", 24.70d, Product.PROMO_3x2), 1);
        customer.addProduct(new Product("Blevit Plus Multigrain porridge", 12.27d, Product.SECOND_70_PERCENT_LESS), 1);


        String expected = "Statement for John Doe\n" +
                "\t Dodot Sensitive Wipes: 6 x 2,30 = 13,80 €\n" +
                "\t Pants Dodot size 4: 3 x 24,70 = 49,40 €\n" +
                "\t Chicco Soft Silicone Pacifier: 1 x 5,99 = 5,99 €\n" +
                "\t Johnson's Baby Shampoo: 2 x 4,09 = 8,18 €\n" +
                "\t Blevit Plus Multigrain porridge: 2 x 12,27 = 15,95 €\n" +
                "\t Hero Baby Puree, vegetables with chicken: 1 x 6,05 = 6,05 €\n" +
                "\t Puleva infant milk: 12 x 1,45 = 17,40 €\n" +
                "---\n" +
                "Number of items: 27\n" +
                "---\n" +
                "Credits accumulated in this purchase: 3\n" +
                "---\n" +
                "Total amount: 116,77 €\n";

        String actual = customer.statement();

        assertEquals(expected, actual);
    }
}