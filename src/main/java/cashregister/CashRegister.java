package cashregister;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CashRegister {
    private final Customer customer;

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

    public String statement(StatementPrinter printer) {
        double totalAmount = 0;
        int accumulatedCredits = 0;
        int numItems = 0;
        StringBuilder result = new StringBuilder(printer.printHeader(customer.getName()));

        for (OrderLine orderLine : orderLines) {
            double orderLineAmount = orderLine.amountFor();
            accumulatedCredits += orderLine.creditsFor();

            result.append(printer.printOrderLineFigures(orderLine, orderLineAmount));
            numItems += orderLine.getQuantity();
            totalAmount += orderLineAmount;
        }

        result.append(printer.printFooter(totalAmount, accumulatedCredits, numItems));

        return result.toString();
    }
}
