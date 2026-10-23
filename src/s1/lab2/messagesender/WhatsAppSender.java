package s1.lab2.messagesender;

import s1.lab2.invoice.InvoiceData;

public class WhatsAppSender implements Sender{

    @Override
    public String send(InvoiceData invoiceData, String formattedMessage) {

        String message =
                "To: sendwhatsapp\n" +
                        "Subject: Invoice " + invoiceData.getNumber() + "\n\n" +
                        formattedMessage;

        System.out.println("\nSending sendwhatsapp...");

        return message;
    }
}
