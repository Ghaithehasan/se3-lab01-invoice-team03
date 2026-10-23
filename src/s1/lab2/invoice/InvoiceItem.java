package s1.lab2.invoice;

public class InvoiceItem {



    private String name;
    private double price;
    private int qty;

    public InvoiceItem( String name , double price, int qty) {
        this.price = price;
        this.qty = qty;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
