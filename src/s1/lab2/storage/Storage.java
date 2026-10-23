package s1.lab2.storage;

import s1.lab2.model.InvoiceData;

public interface Storage {
    public void save(InvoiceData invoiceData , double total);
}
