package s1.lab2.invoice;

import s1.lab2.model.InvoiceData;

import s1.lab2.messagesender.Sender;
import s1.lab2.storage.Storage;

public class InvoiceService {

    private final InvoiceCalculator invoiceCalculator;
    private final InvoiceFormatter invoiceFormatter;
    private final Storage storage;
    private final Sender sender;

    public InvoiceService(
            InvoiceCalculator invoiceCalculator,
            InvoiceFormatter invoiceFormatter,
            Storage storage,
            Sender sender
    ) {
        this.invoiceCalculator = invoiceCalculator;
        this.invoiceFormatter = invoiceFormatter;
        this.storage = storage;
        this.sender = sender;
    }


    public double calculateTotal(InvoiceData invoiceData) {
        return invoiceCalculator.calculateTotal(invoiceData);
    }


    public String printInvoice(InvoiceData invoiceData) {
        double total = invoiceCalculator.calculateTotal(invoiceData);

        String formattedInvoice =
                invoiceFormatter.formatInvoice(invoiceData, total);

        System.out.print(formattedInvoice);

        return formattedInvoice;
    }


    public void saveInvoice(InvoiceData invoiceData) {
        double total = invoiceCalculator.calculateTotal(invoiceData);

        storage.save(invoiceData, total);
    }


    public String sendInvoice(InvoiceData invoiceData) {
//        double total = invoiceCalculator.calculateTotal(invoiceData);
//
//        String formattedInvoice =
//                invoiceFormatter.formatInvoice(invoiceData, total);
//
//        // Preserve the behavior of the old version:
//        // sending also prints the invoice first.

        String formattedInvoice = printInvoice(invoiceData);

        return sender.send(invoiceData, formattedInvoice);
    }
}