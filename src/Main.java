package s1.lab1;

public class Main
{
    public static void main(String[] args)
    {
        Invoice invoice1 = new Invoice("INV-1", "ali@gmail.com");
        Invoice invoice2 = new Invoice("INV-2", "ahmad@gmail.com");


        invoice1.addItem("Bag", 100, 2);
        invoice1.addItem("Pen", 50, 3);

        invoice2.addItem("Computer", 500, 1);
        invoice2.addItem("Keyboard", 75, 2);


        // Print invoices
        invoice1.printInvoice();
        System.out.println();

        invoice2.printInvoice();
        System.out.println();


        // Save using both storage types
        invoice1.saveToDatabase("DATABASE");
        invoice2.saveToDatabase("FILES");


        // Print stored data
        System.out.println(Invoice.getDATABASE());
        System.out.println(Invoice.getFILES());


        // Send email
        invoice1.sendEmail();
        invoice2.sendEmail();


        // Send WhatsApp
        invoice1.sendwhatsapp();
        invoice2.sendwhatsapp();


        // Print totals
        System.out.println(invoice1.calculateTotal());
        System.out.println(invoice2.calculateTotal());
    }
}