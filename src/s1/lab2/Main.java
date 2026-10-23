package s1.lab2;//package s1.lab2;

import s1.lab2.invoice.InvoiceCalculator;
import s1.lab2.invoice.InvoiceData;
import s1.lab2.invoice.InvoiceFormatter;
import s1.lab2.invoice.InvoiceService;

import s1.lab2.messagesender.EmailSender;
import s1.lab2.messagesender.Sender;
import s1.lab2.messagesender.WhatsAppSender;

import s1.lab2.storage.DatabaseStorage;
import s1.lab2.storage.FileStorage;

public class Main {

    public static void main(String[] args) {

        // Shared stateless dependencies
        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoiceFormatter formatter = new InvoiceFormatter();


        // Storage implementations
        DatabaseStorage databaseStorage = new DatabaseStorage();
        FileStorage fileStorage = new FileStorage();


        // Sender implementations
        Sender emailSender = new EmailSender();
        Sender whatsAppSender = new WhatsAppSender();


        // Invoice data
        InvoiceData invoice1 =
                new InvoiceData("INV-1", "ali@gmail.com");

        InvoiceData invoice2 =
                new InvoiceData("INV-2", "ahmad@gmail.com");


        invoice1.addItem("Bag", 100, 2);
        invoice1.addItem("Pen", 50, 3);

        invoice2.addItem("Computer", 500, 1);
        invoice2.addItem("Keyboard", 75, 2);


        // Service configurations
        InvoiceService databaseEmailService =
                new InvoiceService(
                        calculator,
                        formatter,
                        databaseStorage,
                        emailSender
                );

        InvoiceService fileEmailService =
                new InvoiceService(
                        calculator,
                        formatter,
                        fileStorage,
                        emailSender
                );

        InvoiceService databaseWhatsAppService =
                new InvoiceService(
                        calculator,
                        formatter,
                        databaseStorage,
                        whatsAppSender
                );

        InvoiceService fileWhatsAppService =
                new InvoiceService(
                        calculator,
                        formatter,
                        fileStorage,
                        whatsAppSender
                );


        // -----------------------------
        // Print invoices
        // -----------------------------

        databaseEmailService.printInvoice(invoice1);
        System.out.println();

        fileEmailService.printInvoice(invoice2);
        System.out.println();


        // -----------------------------
        // Save using both storage types
        // -----------------------------

        databaseEmailService.saveInvoice(invoice1);
        fileEmailService.saveInvoice(invoice2);


        // -----------------------------
        // Print stored records
        // -----------------------------

        System.out.println(databaseStorage.getDatabaseRecords());
        System.out.println(fileStorage.getFilesRecords());


        // -----------------------------
        // Send Email
        // -----------------------------

        databaseEmailService.sendInvoice(invoice1);
        fileEmailService.sendInvoice(invoice2);


        // -----------------------------
        // Send WhatsApp
        // -----------------------------

        databaseWhatsAppService.sendInvoice(invoice1);
        fileWhatsAppService.sendInvoice(invoice2);


        // -----------------------------
        // Print totals
        // -----------------------------

        System.out.println(
                databaseEmailService.calculateTotal(invoice1)
        );

        System.out.println(
                fileEmailService.calculateTotal(invoice2)
        );
    }
}