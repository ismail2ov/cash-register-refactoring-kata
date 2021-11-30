package cashregister;

public class HtmlStatementPrinter implements StatementPrinter {
    @Override
    public String printOrderLineFigures(OrderLine orderLine, double orderLineAmount) {
        return String.format("\t <b>%s:</b> %d x %.2f = <b>%.2f €</b><br />\n", orderLine.getProduct().getName(), orderLine.getQuantity(), orderLine.getProduct().getPrice(), orderLineAmount);
    }

    @Override
    public String printFooter(double totalAmount, int accumulatedCredits, int numItems) {
        String result ="---<br />\n";
        result+=String.format("<b>Number of items:</b> %d<br />\n", numItems);
        result+="---<br />\n";
        result+=String.format("<b>Credits accumulated in this purchase:</b> %d<br />\n", accumulatedCredits);
        result+="---<br />\n";
        result+=String.format("<b>Total amount:</b> %.2f €<br />\n", totalAmount);

        return result;
    }

    @Override
    public String printHeader(String name) {
        return "Statement for <b>" + name + "</b><br />\n";
    }
}
