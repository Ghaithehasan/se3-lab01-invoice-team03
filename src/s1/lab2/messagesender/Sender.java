package s1.lab2.messagesender;

import s1.lab2.invoice.InvoiceData;

public interface Sender {

    public String send(InvoiceData invoiceData , String formattedMessage);

}
