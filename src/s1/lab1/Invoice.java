package s1.lab1;

import java.util.ArrayList;
import java.util.List;

public class Invoice
{
    private String number;
    private String customerEmail;
    private List<InvoiceItem> items = new ArrayList<>();
    private static List<String> FILES = new ArrayList<>();
    private static List<String> DATABASE = new ArrayList<>();


    public  Invoice(String number , String customerEmail)
    {
        this.customerEmail = customerEmail;
        this.number = number;
    }




    public void addItem(String name,double price,int qty)
    {
        this.items.add(new InvoiceItem(name , price , qty));
    }



    public List<InvoiceItem> getItems() {
        return items;
    }


    public double calculateTotal()
    {
        double subTotal = 0;

        for (InvoiceItem item : items)
        {
            subTotal +=item.getPrice() * item.getQty();
        }

        if (subTotal > 1000)
        {
            subTotal -= ((double) 5/100*subTotal);
        }
            subTotal += ((double) 15/100*subTotal);

        return subTotal;
    }

    public String printInvoice() {
        String invoiceNumber = "INVOICE " + this.number + "\n";
        StringBuilder itemsToPrint = new StringBuilder(invoiceNumber);

        for (InvoiceItem item : items) {
            String productName = item.getName();
            int qty = item.getQty();
            double price = item.getPrice();

            double itemTotal = qty * price;
            String line = String.format("%s x%d = %.2f\n", productName, qty, itemTotal);

            itemsToPrint.append(line);
        }

        double total = calculateTotal();
        itemsToPrint.append(String.format("TOTAL: %.2f", total));


        System.out.print(itemsToPrint);
        return itemsToPrint.toString();
    }



    public void saveToDatabase(String type)
    {
        String invoiceNumber = this.number;
        String customerEmail = this.customerEmail;
        double total = calculateTotal();

        String result = invoiceNumber + ";" +
                customerEmail + ";" +
                String.format("%.2f", total);


        if(type.equals("DATABASE"))
        {
            Invoice.DATABASE.add(result);
        }
        else
        {
            Invoice.FILES.add(result);
        }
    }



    public String sendEmail()
    {
        String invoiceText = printInvoice();

        String message =
                "To: " + customerEmail + "\n" +
                        "Subject: Invoice " + number + "\n\n" +
                        invoiceText;

        System.out.println("\nSending email...");

        return message;
    }




    public String sendwhatsapp()
    {
        String invoiceText = printInvoice();

        String message =
                "To: sendwhatsapp\n" +
                        "Subject: Invoice " + number + "\n\n" +
                        invoiceText;

        System.out.println("\nSending sendwhatsapp...");

        return message;
    }


    public static List<String> getDATABASE() {
        return DATABASE;
    }

    public static List<String> getFILES() {
        return FILES;
    }
}


/*



لازم يكون داخل Invoice بيانات أساسية للفاتورة:
- رقم الفاتورة number
- إيميل الزبون customerEmail
- قائمة البنود items


وكمان قائمتين ثابتتين DATABASE و FILES حتى تحاكي التخزين

* */