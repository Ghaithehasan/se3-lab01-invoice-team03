package s1.lab2.messagesender;

import s1.lab2.model.InvoiceData;

public class EmailSender implements Sender{


    @Override
    public String send(InvoiceData invoiceData, String formattedMessage) {

        String message =
                "To: " + invoiceData.getCustomerEmail() + "\n" +
                        "Subject: Invoice " + invoiceData.getNumber() + "\n\n" +
                        formattedMessage;
        System.out.println("\nSending email...");

        return message;
    }



}
