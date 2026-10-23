package s1.lab2.storage;

import s1.lab2.model.InvoiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FileStorage implements Storage{

    private final List<String> filesRecords = new ArrayList<>();

    @Override
    public void save(InvoiceData invoiceData, double total) {

        String result =
                invoiceData.getNumber() + ";" +
                        invoiceData.getCustomerEmail() + ";" +
                        String.format(Locale.US, "%.2f", total);

        filesRecords.add(result);
    }

    public List<String> getFilesRecords() {
        return Collections.unmodifiableList(filesRecords);
    }
}
