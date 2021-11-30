package cashregister;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class Customer {

    @Getter
    private final String name;

    private List<OrderLine> orderLines = new ArrayList<>();

    public void addProduct(Product arg1, int arg2) {
        for (OrderLine orderLine : orderLines) {
            if (orderLine.getProduct().equals(arg1)) {
                orderLine.increaseQuantity(arg2);
                return;
            }
        }

        orderLines.add(new OrderLine(arg1, arg2));
    }

    public String statement() {
        double totalAmount = 0;
        int accumulatedCredits = 0;
        int numItems = 0;
        String result = "Statement for " + getName() + "\n";

        for (OrderLine each : orderLines) {
            double thisAmount = 0;
            double thisDiscount = 0;

            // determine amounts for each order line
            switch (each.getProduct().getType()) {
                case Product.REGULAR:
                    thisAmount = each.getQuantity() * each.getProduct().getPrice();
                    break;
                case Product.PROMOTED:
                    thisAmount = each.getQuantity() * each.getProduct().getPrice();
                    break;
                case Product.SECOND_70_PERCENT_LESS:
                    if (each.getQuantity() >= 2) {
                        int itemsToDiscount = each.getQuantity() / 2;
                        thisDiscount = itemsToDiscount * each.getProduct().getPrice() * 0.7;
                        thisAmount = each.getQuantity() * each.getProduct().getPrice() - thisDiscount;
                    } else {
                        thisAmount = each.getQuantity() * each.getProduct().getPrice();
                    }
                    break;
                case Product.PROMO_3x2:
                    if (each.getQuantity() >= 3) {
                        int itemsToDiscount = each.getQuantity() / 3;
                        thisDiscount = itemsToDiscount * each.getProduct().getPrice();
                        thisAmount = each.getQuantity() * each.getProduct().getPrice() - thisDiscount;
                    } else {
                        thisAmount = each.getQuantity() * each.getProduct().getPrice();
                    }
                    break;
            }

            // add credits for purchasing more than 10 units of regular products
            if ((each.getProduct().getType() == Product.REGULAR) && each.getQuantity() > 10)
                accumulatedCredits++;
            // add extra credit for every promoted product purchased
            if (each.getProduct().getType() == Product.PROMOTED)
                accumulatedCredits += each.getQuantity();

            // show figures for each order line
            result += String.format("\t %s: %d x %.2f = %.2f €\n", each.getProduct().getName(), each.getQuantity(), each.getProduct().getPrice(), thisAmount);
            numItems += each.getQuantity();
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "---\n";
        result += String.format("Number of items: %d\n", numItems);
        result += "---\n";
        result += String.format("Credits accumulated in this purchase: %d\n", accumulatedCredits);
        result += "---\n";
        result += String.format("Total amount: %.2f €\n", totalAmount);

        return result;
    }
}