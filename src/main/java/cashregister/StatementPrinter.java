package cashregister;

public interface StatementPrinter {
    String printOrderLineFigures(OrderLine orderLine, double orderLineAmount);

    String printFooter(double totalAmount, int accumulatedCredits, int numItems);

    String printHeader(String name);
}
