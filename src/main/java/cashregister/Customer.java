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
            double orderLineAmount = orderLine.amountFor();
            accumulatedCredits += orderLine.creditsFor();

            // show figures for orderLine order line
            result += String.format("\t %s: %d x %.2f = %.2f €\n", orderLine.getProduct().getName(), orderLine.getQuantity(), orderLine.getProduct().getPrice(), orderLineAmount);
            numItems += orderLine.getQuantity();
            totalAmount += orderLineAmount;
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