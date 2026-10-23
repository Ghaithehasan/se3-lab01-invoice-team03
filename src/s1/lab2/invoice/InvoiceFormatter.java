package s1.lab2.invoice;

public class InvoiceFormatter {


    public String formatInvoice(InvoiceData invoiceData , double total) {
        String invoiceNumber = "INVOICE " + invoiceData.getNumber() + "\n";
        StringBuilder itemsToPrint = new StringBuilder(invoiceNumber);

        for (InvoiceItem item : invoiceData.getItems()) {
            String productName = item.getName();
            int qty = item.getQty();
            double price = item.getPrice();

            double itemTotal = qty * price;
            String line = String.format("%s x%d = %.2f\n", productName, qty, itemTotal);

            itemsToPrint.append(line);
        }

        itemsToPrint.append(String.format("TOTAL: %.2f", total));

        return itemsToPrint.toString();
    }

}
