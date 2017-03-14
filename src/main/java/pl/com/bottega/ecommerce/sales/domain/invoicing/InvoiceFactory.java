package pl.com.bottega.ecommerce.sales.domain.invoicing;


import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class InvoiceFactory implements InvoiceImplement {
    public Invoice create(ClientData client) {
        return new Invoice(Id.generate(), client);
    }
}
