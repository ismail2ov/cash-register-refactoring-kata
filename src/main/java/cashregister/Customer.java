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

        for (OrderLine orderLine : orderLines) {
            double thisAmount = 0;
            double thisDiscount = 0;

            thisAmount = amountFor(orderLine);

            // add credits for purchasing more than 10 units of regular products
            if ((orderLine.getProduct().getType() == Product.REGULAR) && orderLine.getQuantity() > 10)
                accumulatedCredits++;
            // add extra credit for every promoted product purchased
            if (orderLine.getProduct().getType() == Product.PROMOTED)
                accumulatedCredits += orderLine.getQuantity();

            // show figures for orderLine order line
            result += String.format("\t %s: %d x %.2f = %.2f €\n", orderLine.getProduct().getName(), orderLine.getQuantity(), orderLine.getProduct().getPrice(), thisAmount);
            numItems += orderLine.getQuantity();
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

    private double amountFor(OrderLine orderLine) {
        double thisAmount = 0;
        double thisDiscount;
        // determine amounts for orderLine order line
        switch (orderLine.getProduct().getType()) {
            case Product.REGULAR:
                thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice();
                break;
            case Product.PROMOTED:
                thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice();
                break;
            case Product.SECOND_70_PERCENT_LESS:
                if (orderLine.getQuantity() >= 2) {
                    int itemsToDiscount = orderLine.getQuantity() / 2;
                    thisDiscount = itemsToDiscount * orderLine.getProduct().getPrice() * 0.7;
                    thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice() - thisDiscount;
                } else {
                    thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice();
                }
                break;
            case Product.PROMO_3x2:
                if (orderLine.getQuantity() >= 3) {
                    int itemsToDiscount = orderLine.getQuantity() / 3;
                    thisDiscount = itemsToDiscount * orderLine.getProduct().getPrice();
                    thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice() - thisDiscount;
                } else {
                    thisAmount = orderLine.getQuantity() * orderLine.getProduct().getPrice();
                }
                break;
        }

        return thisAmount;
    }
}