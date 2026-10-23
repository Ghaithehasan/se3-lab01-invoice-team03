package s1.lab2.invoice;

import java.util.List;

public class InvoiceCalculator {


    public InvoiceCalculator() {
    }

    public double calculateTotal(InvoiceData invoiceData) {
        double subTotal = 0;

        List<InvoiceItem> items = invoiceData.getItems();

        for (InvoiceItem item : items) {
            subTotal += item.getPrice() * item.getQty();
        }

        if (subTotal > 1000) {
            subTotal -= (5.0 / 100 * subTotal);
        }

        subTotal += (15.0 / 100 * subTotal);

        return subTotal;
    }
}
