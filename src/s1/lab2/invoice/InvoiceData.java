package s1.lab2.invoice;


import java.util.ArrayList;
import java.util.List;

public class InvoiceData {
    private String number;
    private String customerEmail;
    private List<InvoiceItem> items = new ArrayList<>();
    public  InvoiceData(String number , String customerEmail)
    {
        this.customerEmail = customerEmail;
        this.number = number;
    }


    public void addItem(String name,double price,int qty)
    {
        this.items.add(new InvoiceItem(name , price , qty));
    }

    public String getNumber() {
        return number;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<InvoiceItem> getItems() {
        return items;
    }
}
