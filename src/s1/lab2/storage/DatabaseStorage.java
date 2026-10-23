package s1.lab2.storage;

import s1.lab2.model.InvoiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DatabaseStorage implements Storage {

    private final List<String> databaseRecords = new ArrayList<>();

    @Override
    public void save(InvoiceData invoiceData, double total) {

        String result =
                invoiceData.getNumber() + ";" +
                        invoiceData.getCustomerEmail() + ";" +
                        String.format(Locale.US, "%.2f", total);

        databaseRecords.add(result);
    }

    public List<String> getDatabaseRecords() {
        return Collections.unmodifiableList(databaseRecords);
    }
}