package cashregister;

public class TextStatementPrinter implements StatementPrinter {
    @Override
    public String printOrderLineFigures(OrderLine orderLine, double orderLineAmount) {
        return String.format("\t %s: %d x %.2f = %.2f €\n", orderLine.getProduct().getName(), orderLine.getQuantity(), orderLine.getProduct().getPrice(), orderLineAmount);
    }

    @Override
    public String printFooter(double totalAmount, int accumulatedCredits, int numItems) {
        String result ="---\n";
        result+=String.format("Number of items: %d\n", numItems);
        result+="---\n";
        result+=String.format("Credits accumulated in this purchase: %d\n", accumulatedCredits);
        result+="---\n";
        result+=String.format("Total amount: %.2f €\n", totalAmount);

        return result;
    }

    @Override
    public String printHeader(String name) {
        return "Statement for " + name + "\n";
    }
}
