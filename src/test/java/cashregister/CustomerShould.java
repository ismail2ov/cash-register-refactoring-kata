package cashregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerShould {

    private CashRegister cashRegister;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer("John Doe");
        this.cashRegister = new CashRegister(customer);

        cashRegister.addProduct(new Product("Dodot Sensitive Wipes", 2.30d, getRegularProductType()), 6);
        cashRegister.addProduct(new Product("Pants Dodot size 4", 24.70d, getPromo3x2ProductType()), 2);
        cashRegister.addProduct(new Product("Chicco Soft Silicone Pacifier", 5.99d, getPromo3x2ProductType()), 1);
        cashRegister.addProduct(new Product("Johnson's Baby Shampoo", 4.09, getPromotedProductType()), 2);
        cashRegister.addProduct(new Product("Blevit Plus Multigrain porridge", 12.27d, getSecond70PercentLessProductType()), 1);
        cashRegister.addProduct(new Product("Hero Baby Puree, vegetables with chicken", 6.05d, getSecond70PercentLessProductType()), 1);
        cashRegister.addProduct(new Product("Puleva infant milk", 1.45, getRegularProductType()), 12);

        cashRegister.addProduct(new Product("Pants Dodot size 4", 24.70d, getPromo3x2ProductType()), 1);
        cashRegister.addProduct(new Product("Blevit Plus Multigrain porridge", 12.27d, getSecond70PercentLessProductType()), 1);
    }

    @Test
    void printStatementInTextFormat() {
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

        StatementPrinter printer = new TextStatementPrinter();

        String actual = cashRegister.statement(printer);

        assertEquals(expected, actual);
    }

    @Test
    void printStatementInHtmlFormat() {
        String expected = "Statement for <b>John Doe</b><br />\n" +
                "\t <b>Dodot Sensitive Wipes:</b> 6 x 2,30 = <b>13,80 €</b><br />\n" +
                "\t <b>Pants Dodot size 4:</b> 3 x 24,70 = <b>49,40 €</b><br />\n" +
                "\t <b>Chicco Soft Silicone Pacifier:</b> 1 x 5,99 = <b>5,99 €</b><br />\n" +
                "\t <b>Johnson's Baby Shampoo:</b> 2 x 4,09 = <b>8,18 €</b><br />\n" +
                "\t <b>Blevit Plus Multigrain porridge:</b> 2 x 12,27 = <b>15,95 €</b><br />\n" +
                "\t <b>Hero Baby Puree, vegetables with chicken:</b> 1 x 6,05 = <b>6,05 €</b><br />\n" +
                "\t <b>Puleva infant milk:</b> 12 x 1,45 = <b>17,40 €</b><br />\n" +
                "---<br />\n" +
                "<b>Number of items:</b> 27<br />\n" +
                "---<br />\n" +
                "<b>Credits accumulated in this purchase:</b> 3<br />\n" +
                "---<br />\n" +
                "<b>Total amount:</b> 116,77 €<br />\n";

        StatementPrinter printer = new HtmlStatementPrinter();

        String actual = cashRegister.statement(printer);

        assertEquals(expected, actual);
    }

    private Second70PercentLessProductType getSecond70PercentLessProductType() {
        return new Second70PercentLessProductType();
    }

    private PromotedProductType getPromotedProductType() {
        return new PromotedProductType();
    }

    private Promo3x2ProductType getPromo3x2ProductType() {
        return new Promo3x2ProductType();
    }

    private RegularProductType getRegularProductType() {
        return new RegularProductType();
    }
}